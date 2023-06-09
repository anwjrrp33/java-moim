package com.youth.moim.member.ui;

import com.youth.moim.member.application.MemberService;
import com.youth.moim.member.dto.JoinOrganizerMemberRequest;
import com.youth.moim.member.dto.JoinOrganizerMemberResponse;
import com.youth.moim.member.dto.JoinParticipantMemberRequest;
import com.youth.moim.member.dto.JoinParticipantMemberResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/organizer")
    public ResponseEntity<JoinOrganizerMemberResponse> joinOrganizerMember(@RequestBody JoinOrganizerMemberRequest joinOrganizerMemberRequest) {
        JoinOrganizerMemberResponse joinOrganizerMemberResponse = memberService.joinOrganizerMember(joinOrganizerMemberRequest);
        return ResponseEntity.created(URI.create("/member/" + joinOrganizerMemberResponse.getId())).body(joinOrganizerMemberResponse);
    }

    @PostMapping("/participant")
    public ResponseEntity<JoinParticipantMemberResponse> joinParticipantMember(@RequestBody JoinParticipantMemberRequest joinParticipantMemberRequest) {
        JoinParticipantMemberResponse joinParticipantMemberResponse = memberService.joinParticipantMember(joinParticipantMemberRequest);
        return ResponseEntity.created(URI.create("/member/" + joinParticipantMemberResponse.getId())).body(joinParticipantMemberResponse);
    }
}
