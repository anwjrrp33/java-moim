package com.youth.moim.member.dto;

import com.youth.moim.member.domain.Gender;
import com.youth.moim.member.domain.Member;
import com.youth.moim.member.domain.ParticipantInfo;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

public class JoinParticipantMemberRequest {

    private String name;

    private LocalDate birthDate;

    private Gender gender;

    private String memberId;

    private String password;

    private String email;

    private String foodAllergy;

    private String info;

    public JoinParticipantMemberRequest() {
    }

    public JoinParticipantMemberRequest(String name, LocalDate birthDate, Gender gender, String memberId, String password, String email, String foodAllergy, String info) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.memberId = memberId;
        this.password = password;
        this.email = email;
        this.foodAllergy = foodAllergy;
        this.info = info;
    }

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.of(
                name,
                birthDate,
                gender,
                memberId,
                passwordEncoder.encode(password),
                email,
                new ParticipantInfo(foodAllergy, info));
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

    public String getFoodAllergy() {
        return foodAllergy;
    }

    public String getInfo() {
        return info;
    }
}
