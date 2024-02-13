package com.example.olebackend.converter;

import com.example.olebackend.domain.File;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.mapping.LectureTeacher;
import com.example.olebackend.web.dto.LessonResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LessonConverter {

    public static LessonResponse.getTeacherNameDTO toTeacherNameDTO(LectureTeacher teacher) {

        return LessonResponse.getTeacherNameDTO.builder()
                .name(teacher.getTeacher().getName())
                .build();
    }

    public static LessonResponse.getLessonDetailDTO toLessonDetailDTO(Optional<Lesson> lesson) {

        List<LectureTeacher> teacherList = lesson.get().getLectureTeacherList();

        List<LessonResponse.getTeacherNameDTO> lessonTeacherList = teacherList.stream()
                .map(LessonConverter::toTeacherNameDTO).collect(Collectors.toList());

        return LessonResponse.getLessonDetailDTO.builder()
                .title(lesson.get().getTitle())
                .description(lesson.get().getDescription())
                .lessonType(lesson.get().getLessonType().toString())
                .supplies(lesson.get().getSupplies())
                .price(lesson.get().getPrice())
                .refund(lesson.get().getRefund())
                .place(lesson.get().getPlace())
                .lessonStartDate(lesson.get().getLessonStartDate())
                .lessonEndDate(lesson.get().getLessonEndDate())
                .lectureWeekDay(lesson.get().getLectureWeekDay().toString())
                .lessonStartTime(lesson.get().getLessonStartTime())
                .lessonEndTime(lesson.get().getLessonEndTime())
                .approved(lesson.get().getApproved().toString())
                .gatherStartDate(lesson.get().getGatherStartDate())
                .gatherEndDate(lesson.get().getGatherEndDate())
                .limitCount(lesson.get().getLimitCount())
                .currentCount(lesson.get().getCurrentCount())
                .lessonTeacherList(lessonTeacherList)
                .build();
    }


    public static LessonResponse.getLessonPreviewDTO toLessonPreviewDTO(Lesson lesson) {
        return LessonResponse.getLessonPreviewDTO.builder()
                .lessonId(lesson.getId())
                .title(lesson.getTitle())
                .lessonStartDate(lesson.getLessonStartDate())
                .lessonEndDate(lesson.getLessonEndDate())
                .lessonStartTime(lesson.getLessonStartTime())
                .lessonEndTime(lesson.getLessonEndTime())
                .gatherEndDate(lesson.getGatherEndDate())
                .imageUrl(lesson.getImageUrl())
                .description(lesson.getDescription())
                .place(lesson.getPlace())
                .build();
    }
    public static LessonResponse.getLessonListDTO toLessonListDTO(Page<Lesson> lessonList){
        List<LessonResponse.getLessonPreviewDTO> lessonListPreviewDTOList = lessonList.stream()
                .map(LessonConverter::toLessonPreviewDTO).collect(Collectors.toList());

        return LessonResponse.getLessonListDTO.builder()
                .isLast(lessonList.isLast())
                .isFirst(lessonList.isFirst())
                .totalPage(lessonList.getTotalPages())
                .totalElements(lessonList.getTotalElements())
                .listSize(lessonListPreviewDTOList.size())
                .lessonPreviewDTOList(lessonListPreviewDTOList)
                .build();
    }

    public static LessonResponse.getLessonByCategoryAndSearchDTO toLessonByCategoryAndSearchDTO(Lesson lesson) {
        return LessonResponse.getLessonByCategoryAndSearchDTO.builder()
                .lessonId(lesson.getId())
                .title(lesson.getTitle())
                .gatherStartDate(lesson.getGatherStartDate())
                .gatherEndDate(lesson.getGatherEndDate())
                .gatherStatus(lesson.getGatherStatus())
                .lessonStartDate(lesson.getLessonStartDate())
                .lessonEndDate(lesson.getLessonEndDate())
                .lectureWeekDay(lesson.getLectureWeekDay().toString())
                .lessonStartTime(lesson.getLessonStartTime())
                .lessonEndTime(lesson.getLessonEndTime())
                .price(lesson.getPrice())
                .place(lesson.getPlace())
                .limitCount(lesson.getLimitCount())
                .currentCount(lesson.getCurrentCount())
                .build();
    }

    public static LessonResponse.getLessonListByCategoryAndSearchDTO toLessonListByCategoryAndSearchDTO(Page<Lesson> lessonList) {
        List<LessonResponse.getLessonByCategoryAndSearchDTO> lessonListPreviewDTOList = lessonList.stream()
                .map(LessonConverter::toLessonByCategoryAndSearchDTO).collect(Collectors.toList());

        return LessonResponse.getLessonListByCategoryAndSearchDTO.builder()
                .isLast(lessonList.isLast())
                .isFirst(lessonList.isFirst())
                .totalPage(lessonList.getTotalPages())
                .totalElements(lessonList.getTotalElements())
                .listSize(lessonListPreviewDTOList.size())
                .lessonList(lessonListPreviewDTOList)
                .build();
    }

    public static LessonResponse.getLessonOrderByCriteriaDTO toLessonOrderByCriteriaDTO(Lesson lesson) {

        List<File> fileList = lesson.getFileList();

        String filePath = null;

        File file = fileList.stream()
                .filter(File::isRepresent)
                .findFirst()
                .orElse(null);

        if (file != null) {
            filePath = file.getPath();
        }

        return LessonResponse.getLessonOrderByCriteriaDTO.builder()
                .title(lesson.getTitle())
                .currentCount(lesson.getCurrentCount())
                .place(lesson.getPlace())
                .filePath(filePath)
                .build();
    }

    public static LessonResponse.getLessonListOrderByCriteriaDTO toLessonListOrderByCriteriaDTO(List<Lesson> lessonList) {

        List<LessonResponse.getLessonOrderByCriteriaDTO> lessonListOrderByCriteriaDTOList = lessonList.stream()
                .map(LessonConverter::toLessonOrderByCriteriaDTO).collect(Collectors.toList());
        return LessonResponse.getLessonListOrderByCriteriaDTO.builder()
                .lessonList(lessonListOrderByCriteriaDTOList)
                .build();
    }

}
