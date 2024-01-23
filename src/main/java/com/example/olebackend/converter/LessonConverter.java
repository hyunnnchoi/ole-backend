package com.example.olebackend.converter;

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

    public static LessonResponse.getLessonListByCategoryPreviewlDTO toLessonListByCategoryPreviewlDTO(Lesson lesson) {
        return LessonResponse.getLessonListByCategoryPreviewlDTO.builder()
                .lessonId(lesson.getId())
                .title(lesson.getTitle())
                .gatherStartDate(lesson.getGatherStartDate())
                .gatherEndDate(lesson.getGatherEndDate())
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

    public static LessonResponse.getLessonListByCategoryListlDTO toLessonListByCategoryDTO(Page<Lesson> lessonList) {
        List<LessonResponse.getLessonListByCategoryPreviewlDTO> lessonListPreviewDTOList = lessonList.stream()
                .map(LessonConverter::toLessonListByCategoryPreviewlDTO).collect(Collectors.toList());

        return LessonResponse.getLessonListByCategoryListlDTO.builder()
                .isLast(lessonList.isLast())
                .isFirst(lessonList.isFirst())
                .totalPage(lessonList.getTotalPages())
                .totalElements(lessonList.getTotalElements())
                .listSize(lessonListPreviewDTOList.size())
                .lessonList(lessonListPreviewDTOList)
                .build();
    }

    public static LessonResponse.getLessonOrderByCriteriaDTO toLessonOrderByCriteriaDTO(Lesson lesson) {

        return LessonResponse.getLessonOrderByCriteriaDTO.builder()
                .title(lesson.getTitle())
                .currentCount(lesson.getCurrentCount())
                .place(lesson.getPlace())
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
