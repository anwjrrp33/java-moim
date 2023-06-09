package com.youth.moim.member.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class OrganizerInfo {

    private String team;

    protected OrganizerInfo() {
    }

    public OrganizerInfo(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }
}
