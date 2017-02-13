/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.controller.master;

import com.itcube.bo.interfaces.ResultInterface;
import com.itcube.bo.result.pojo.ResultPOJO;
import com.itcube.utility.ReportUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author vikram.galande
 */
@Controller
@RequestMapping("/result.htm")
@SessionAttributes("result")
public class ResultController {

    public static final String REPORT_DIRECTORY = "reports";
    private ResultInterface resultInterface;
    private ServletOutputStream servletOutputStream;

    @Autowired
    public void setResultInterface(ResultInterface resultInterface) {
        this.resultInterface = resultInterface;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showUserForm(ModelMap model) {
        ResultPOJO result = new ResultPOJO();
        model.addAttribute("result", result);
        return "master/result";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void onSubmit(@ModelAttribute("result") ResultPOJO result, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResultPOJO pojo = new ResultPOJO();
        pojo = resultInterface.getResult(Integer.parseInt(result.getSeatNumber()));
        result.setStudentName(pojo.getStudentName());
        result.setExamName(pojo.getExamName());
        result.setStandardName(pojo.getStandardName());
        result.setRollNumber(pojo.getRollNumber());
        result.setDivision(pojo.getDivision());
        result.setSeatNumber(pojo.getSeatNumber());
        result.setSubjectList(pojo.getSubjectList());
        result.setResult(pojo.getResult());
        result.setPercentage(pojo.getPercentage() + " %");
        result.setResultDate(pojo.getResultDate());
        result.setTotalMarksObtained(pojo.getTotalMarksObtained());
        result.setPlace("PUNE");

        String reportName = "Template";

        try {
            servletOutputStream = response.getOutputStream();
            ServletContext servletContext = request.getSession().getServletContext();
//            String reportPath = servletContext.getRealPath(REPORT_DIRECTORY + "/"
//				+ reportName + ".jasper");
            String reportPath = servletContext.getRealPath(REPORT_DIRECTORY + "/"
                    + reportName + ".jrxml");
            JasperDesign jasperDesign = JasperManager.loadXmlDesign(reportPath);
            JasperReport jasperReport = JasperManager.compileReport(jasperDesign);

//            JasperDesign jasperDesign = JasperManager.loadXmlDesign("E:\\CurrentWork\\SampleSchoolProject\\school1\\web\\reports\\sample.jrxml");
//            JasperReport jasperReport = JasperManager.compileReport(jasperDesign);

//            String reportPath = "E:\\CurrentWork\\SampleSchoolProject\\school1\\web\\reports\\sample.jasper";
//            File file = new File(reportPath);
//            JasperReport js = (JasperReport) JRLoader.loadObject(file);
            //JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), new JREmptyDataSource());            
            
            Map parameters = new HashMap();
            parameters.put("examName", result.getExamName());
            parameters.put("studName", result.getStudentName());
            parameters.put("totalMarksObtained", result.getTotalMarksObtained());
            parameters.put("seatNumber", result.getSeatNumber());
            parameters.put("rollNumber", result.getRollNumber());
            parameters.put("standardName", result.getStandardName()+"-"+result.getDivision());
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(result.getSubjectList()));
            ReportUtil reportUtil = ReportUtil.getInstance();
            String pdfFileName = servletContext.getRealPath(REPORT_DIRECTORY + "/" + reportName + ".pdf");
            reportUtil.exportToPdf(jasperPrint, servletOutputStream, pdfFileName);

//            File tmpFile = new File(pdfFileName);
//            int fSize = (int) tmpFile.length();
//            System.out.println("fSize ==>" + fSize);
//            if (fSize > 0) {
//                BufferedInputStream in = new BufferedInputStream(
//                        new FileInputStream(tmpFile));
//                response.setBufferSize(fSize);
//                response.setContentType("application/pdf");
//                response.setHeader("Content-Disposition", "attachment; filename=\"" + reportName + ".pdf\"");
//                response.setContentLength(fSize);
//                ServletOutputStream fOut = response.getOutputStream();
//                FileCopyUtils.copy(in, fOut);
//                in.close();
//                fOut.flush();
//                fOut.close();
//                System.out.println("onSubmit Closed..");
//            }
        } catch (JRException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            ex.printStackTrace(printWriter);
            response.setContentType("text/plain");
            response.getOutputStream().print(stringWriter.toString());
        }
    }

//    public void exportToPdf(JasperPrint jasperPrint, ServletOutputStream servletOutputStream) {
//        JRPdfExporter jRPdfExporter = new JRPdfExporter();
//        try {
//
//            
//            jRPdfExporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
//            jRPdfExporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, servletOutputStream);
//            jRPdfExporter.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
//            jRPdfExporter.exportReport();
//        } catch (Exception ex) {
//            if (servletOutputStream != null) {
//                try {
//                    servletOutputStream.flush();
//                    servletOutputStream.close();
//                } catch (IOException ex1) {
//                    System.out.println(ex1);
//                }
//            }
//
//            throw new RuntimeException(ex);
//        }
//    }
    public ServletOutputStream getServletOutputStream() {
        return servletOutputStream;
    }

    public void setServletOutputStream(ServletOutputStream servletOutputStream) {
        this.servletOutputStream = servletOutputStream;
    }
}
