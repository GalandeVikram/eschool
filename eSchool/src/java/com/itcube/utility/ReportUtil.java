/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.utility;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.JRXmlExporterParameter;

/**
 *
 * @author Pramod
 */
    public class ReportUtil {

    private static ReportUtil reportUtil = null;
    public static final String REPORT_DIRECTORY = "C:";

    private ReportUtil() {
    }

    public static ReportUtil getInstance() {
        if (null == reportUtil) {
            reportUtil = new ReportUtil();

        }
        return reportUtil;
    }

    public void exportToPdf(JasperPrint jasperPrint, ServletOutputStream servletOutputStream, String pdfFileName) {
        try {

            JRPdfExporter jRPdfExporter = new JRPdfExporter();
            jRPdfExporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
            jRPdfExporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, servletOutputStream);
            jRPdfExporter.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
            jRPdfExporter.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME,pdfFileName);	
            jRPdfExporter.exportReport();
        } catch (Exception ex) {
            if (servletOutputStream != null) {
                try {
                    servletOutputStream.flush();
                    servletOutputStream.close();
                } catch (IOException ex1) {
                    Logger.getLogger(ReportUtil.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }

            throw new RuntimeException(ex);
        }
    }

    public void exportToRTF(JasperPrint jasperPrint, ServletOutputStream servletOutputStream) throws Exception {
        try {
            JRRtfExporter jRrtfExporter = new JRRtfExporter();
            jRrtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            jRrtfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
            jRrtfExporter.exportReport();
        } catch (Exception ex) {
            if (servletOutputStream != null) {
                try {
                    servletOutputStream.flush();
                    servletOutputStream.close();
                } catch (IOException ex1) {
                    Logger.getLogger(ReportUtil.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            throw new RuntimeException(ex);
        }
    }

    public void exportToTXT(JasperPrint jasperPrint, ServletOutputStream servletOutputStream, String reportName,int width) throws Exception {
        try {
            JRTextExporter textExporter = new JRTextExporter();
            textExporter.setParameter(JRExporterParameter.JASPER_PRINT,
                    jasperPrint);
            textExporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, servletOutputStream);
            textExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
                    REPORT_DIRECTORY + "/" + reportName + ".txt");
            textExporter.setParameter(JRTextExporterParameter.CHARACTER_WIDTH,
                    new Integer(width));

            textExporter.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT, new Integer(7));
            System.out.println("Exporting report...");
            textExporter.exportReport();
        } catch (Exception ex) {
            if (servletOutputStream != null) {
                try {
                    servletOutputStream.flush();
                    servletOutputStream.close();
                } catch (IOException ex1) {
                    Logger.getLogger(ReportUtil.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            throw new RuntimeException(ex);
        }
    }

    public void exportToXml(JasperPrint jasperPrint, ServletOutputStream servletOutputStream) throws Exception {
        try {
            JRXmlExporter exporter = new JRXmlExporter();
            exporter.setParameter(JRXmlExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRXmlExporterParameter.OUTPUT_STREAM, servletOutputStream);
            exporter.setParameter(JRXmlExporterParameter.CHARACTER_ENCODING, "UTF-8");
            exporter.exportReport();
        } catch (Exception ex) {
            if (servletOutputStream != null) {
                try {
                    servletOutputStream.flush();
                    servletOutputStream.close();
                } catch (IOException ex1) {
                    Logger.getLogger(ReportUtil.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            throw new RuntimeException(ex);
        }
    }

    public void exportToCsv(JasperPrint jasperPrint, ServletOutputStream servletOutputStream) throws Exception {
        try {
            JRCsvExporter csvExporter = new JRCsvExporter();
            csvExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            csvExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
            csvExporter.setParameter(JRCsvExporterParameter.CHARACTER_ENCODING, "UTF-8");
            csvExporter.setParameter(JRCsvExporterParameter.IGNORE_PAGE_MARGINS, "false");
            csvExporter.exportReport();
        } catch (Exception ex) {
            if (servletOutputStream != null) {
                try {
                    servletOutputStream.flush();
                    servletOutputStream.close();
                } catch (IOException ex1) {
                    Logger.getLogger(ReportUtil.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            throw new RuntimeException(ex);
        }
    }
 
}
