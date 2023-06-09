package com.youth.moim.member.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class ParticipantInfo {

    private String foodAllergy;

    private String info;

    protected ParticipantInfo() {
    }

    public ParticipantInfo(String foodAllergy, String info) {
        this.foodAllergy = foodAllergy;
        this.info = info;
    }

    public String getFoodAllergy() {
        return foodAllergy;
    }

    public String getInfo() {
        return info;
    }
}
