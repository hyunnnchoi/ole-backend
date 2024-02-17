package com.example.olebackend.converter;

import com.example.olebackend.domain.*;
import com.example.olebackend.web.dto.MemberResponse;

public class MemberConverter {
    public static MemberResponse.getJoinResultDTO toJoinResultDTO(Long memberId){
        return MemberResponse.getJoinResultDTO.builder()
                .memberId(memberId)
                .build();
    }
    public static MemberResponse.getLoginResultDTO toLoginResultDTO(Long memberId, String name){
        return MemberResponse.getLoginResultDTO.builder()
                .memberId(memberId)
                .name(name)
                .build();
    }
    public static MemberResponse.getLoginResultDTO toLoginResultDTO(){
        return MemberResponse.getLoginResultDTO.builder()
                .build();
    }

    public static MemberResponse.getMemberDetailDTO toMemberDetailDTO(Member member) {
        return MemberResponse.getMemberDetailDTO.builder()
                .email(member.getEmail())
                .name(member.getName())
                .birthYear(member.getBirthYear())
                .phoneNum(member.getPhoneNum())
                .address(member.getAddress())
                .gender(member.getGender())
                .mailAgree(member.isMailAgree())
                .smsAgree(member.isSmsAgree())
                .build();
    }
    /*
            String id;
        String email;
        String name;
        Long birthYear;
        String phoneNum;
        String address;
        Gender gender;
        Boolean mailAgree;
        Boolean smsAgree;

     */

    /*
        public static LessonResponse.getLessonDetailDTO toLessonDetailDTO(Optional<Lesson> lesson, Boolean likeStatus, Boolean applyStatus) {

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
                .categoryId(lesson.get().getSubCategory().getCategory().getId())
                .likeStatus(likeStatus)
                .applyStatus(applyStatus)
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

     */
}
