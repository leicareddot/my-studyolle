package com.atoz_develop.mystudyolle.domain;

import lombok.*;

import java.time.LocalDateTime;

// ---------------- Lombok 애노테이션 ----------------
@Getter @Setter @EqualsAndHashCode(of = "id") @Builder @AllArgsConstructor @NoArgsConstructor
// ---------------- Lombok 애노테이션 ----------------
public class Account {

    private Long id;

    // ---------------- 회원가입/로그인 필드 ----------------
    private String email;
    private String nickName;
    private String password;
    // ---------------- 회원가입/로그인 필드 ----------------

    // ---------------- 이메일 인증 ----------------
    private boolean emailVerified;
    private String emailCheckToken;
    // ---------------- 이메일 인증 ----------------

    // ---------------- 프로필 ----------------
    private LocalDateTime joinedAt; // 가입 날짜(이메일 인증 날짜와 동일)
    private String bio;
    private String url;
    private String occupation;      // 직업
    private String location;        // 지역
    private String profileImage;    // 프로필 이미지
    // ---------------- 프로필 ----------------

    // ---------------- 알림 수신 여부 ----------------
    private boolean studyCreatedByEmail;    // 스터디 개설 이메일 알림 수신 여부
    private boolean studyCreatedByWeb;      // 스터디 개설 웹 알림 수신 여부
    private boolean studyEnrollmentResultByEmail;   // 스터디 가입 신청 결과 이메일 알림 수신 여부
    private boolean studyEnrollmentResultByWeb;     // 스터디 가입 신청 결과 웹 알림 수신 여부
    private boolean studyUpdatedByEmail;    // 스터디 갱신 정보 이메일 알림 수신 여부
    private boolean studyUpdatedByWeb;    // 스터디 갱신 정보 웹 알림 수신 여부
    // ---------------- 알림 수신 여부 ----------------
}
