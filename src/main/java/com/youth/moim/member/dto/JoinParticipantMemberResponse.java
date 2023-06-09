package com.youth.moim.member.dto;

import com.youth.moim.member.domain.Gender;

import java.time.LocalDate;

public class JoinParticipantMemberResponse {

    private Long id;

    private String name;

    private LocalDate birthDate;

    private Gender gender;

    private String memberId;

    private String email;

    private String foodAllergy;

    private String info;

    public JoinParticipantMemberResponse(Long id, String name, LocalDate birthDate, Gender gender, String memberId, String email, String foodAllergy, String info) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.memberId = memberId;
        this.email = email;
        this.foodAllergy = foodAllergy;
        this.info = info;
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

    public String getEmail() {
        return email;
    }

    public String getFoodAllergy() {
        return foodAllergy;
    }

    public String getInfo() {
        return info;
    }
}
