package com.youth.moim.member.domain;

import jakarta.persistence.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Entity
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String memberId;

    private String password;

    private String email;

    @Embedded
    private OrganizerInfo organizerInfo;

    @Embedded
    private ParticipantInfo participantInfo;

    protected Member() {
    }

    private Member(Long id, String name, LocalDate birthDate, Gender gender, String memberId, String password, String email, OrganizerInfo organizerInfo, ParticipantInfo participantInfo) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.memberId = memberId;
        this.password = password;
        this.email = email;
        this.organizerInfo = organizerInfo;
        this.participantInfo = participantInfo;
    }

    public static Member of(String name, LocalDate birthDate, Gender gender, String memberId, String password, String email, OrganizerInfo organizerInfo) {
        return new Member(null, name, birthDate, gender, memberId, password, email, organizerInfo, null);
    }

    public static Member of(Long id, String name, LocalDate birthDate, Gender gender, String memberId, String password, String email, OrganizerInfo organizerInfo) {
        return new Member(id, name, birthDate, gender, memberId, password, email, organizerInfo, null);
    }

    public static Member of(String name, LocalDate birthDate, Gender gender, String memberId, String password, String email, ParticipantInfo participantInfo) {
        return new Member(null, name, birthDate, gender, memberId, password, email, null, participantInfo);
    }

    public static Member of(Long id, String name, LocalDate birthDate, Gender gender, String memberId, String password, String email, ParticipantInfo participantInfo) {
        return new Member(id, name, birthDate, gender, memberId, password, email, null, participantInfo);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return organizerInfo != null ? organizerInfo.getTeam() : null;
    }

    public String getFoodAllergy() {
        return participantInfo != null ? participantInfo.getFoodAllergy() : null;
    }

    public String getInfo() {
        return participantInfo != null ? participantInfo.getInfo() : null;
    }

    public void checkPassword(PasswordEncoder passwordEncoder, String password) {
        if (this.password.equals(passwordEncoder.encode(password))) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}
