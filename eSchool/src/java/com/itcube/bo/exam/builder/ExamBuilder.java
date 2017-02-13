/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.bo.exam.builder;

import com.itcube.bo.configuration.pojo.ClassRoomPOJO;
import com.itcube.bo.exam.pojo.ExamPOJO;
import com.itcube.hibernate.dto.ClassRoomDTO;
import com.itcube.hibernate.dto.ExamDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vikram.galande
 */
public class ExamBuilder {

    public static List<ClassRoomPOJO> convertClassRoomDtoToPojo(List<ClassRoomDTO> classRoomDtoList) {
        List<ClassRoomPOJO> classRoomList = new ArrayList<ClassRoomPOJO>();
        if (null != classRoomDtoList) {
            for (ClassRoomDTO dto : classRoomDtoList) {
                if (null != dto) {
                    ClassRoomPOJO pojo = new ClassRoomPOJO();
                    pojo.setClassRoomID(String.valueOf(dto.getClassRoomID()));
                    pojo.setClassRoomName(dto.getClassRoomName());
                    classRoomList.add(pojo);
                }
            }
        }
        return classRoomList;
    }

    public static List<ExamPOJO> convertExamDetailDtoToPojo(List<ExamDTO> examDtoList) {
        List<ExamPOJO> examList = new ArrayList<ExamPOJO>();
        if (null != examDtoList) {
            for (ExamDTO dto : examDtoList) {
                if (null != dto) {
                    ExamPOJO pojo = new ExamPOJO();
                    pojo.setExamID(String.valueOf(dto.getExamDetailID()));
                    pojo.setExamName(dto.getExamDetailName());
                    examList.add(pojo);
                }
            }
        }
        return examList;
    }
}
