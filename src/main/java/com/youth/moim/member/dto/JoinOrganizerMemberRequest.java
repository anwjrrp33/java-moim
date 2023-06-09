package com.youth.moim.member.dto;

import com.youth.moim.member.domain.Gender;
import com.youth.moim.member.domain.Member;
import com.youth.moim.member.domain.OrganizerInfo;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

public class JoinOrganizerMemberRequest {

    private String name;

    private LocalDate birthDate;

    private Gender gender;

    private String memberId;

    private String password;

    private String email;

    private String teamName;

    public JoinOrganizerMemberRequest() {
    }

    public JoinOrganizerMemberRequest(String name, LocalDate birthDate, Gender gender, String memberId, String password, String email, String teamName) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.memberId = memberId;
        this.password = password;
        this.email = email;
        this.teamName = teamName;
    }

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.of(
                name,
                birthDate,
                gender,
                memberId,
                passwordEncoder.encode(password),
                email,
                new OrganizerInfo(teamName));
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

    public String getTeamName() {
        return teamName;
    }
}
