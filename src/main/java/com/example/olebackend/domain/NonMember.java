package com.example.olebackend.domain;

import com.example.olebackend.domain.common.BaseEntity;
import com.example.olebackend.domain.enums.ApplicationStatus;
import com.example.olebackend.domain.enums.Completed;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class NonMember extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Column(nullable = false,length = 40)
    private String name; //비회원 이름

    @Column(length = 40)
    private String email; //비회원 이메일

    @Column(nullable = false,length = 40)
    private String phoneNum; //비회원 전화번호

    @Enumerated(EnumType.STRING)
    private Completed attendanceStatus ; //비회원 수강 상태

    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus ; //비회원 신청 상태



}
