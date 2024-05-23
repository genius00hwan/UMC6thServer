package umc.spring.web.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.web.dto.MemberRequest;
import umc.spring.web.dto.MemberResponse;
import umc.spring.web.dto.MemberResponse.JoinResultDTO;

import umc.spring.service.memberService.MemberCommandService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/members")

public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<JoinResultDTO> join(@RequestBody @Valid MemberRequest.Join request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
