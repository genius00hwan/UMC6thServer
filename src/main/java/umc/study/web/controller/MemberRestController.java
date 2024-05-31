package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.memberService.MemberCommandService;
import umc.study.service.memberService.MemberQueryService;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    private final MemberQueryService memberQueryService;

    private final MemberMissionConverter memberMissionConverter;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{memberId}/missions")
    public ApiResponse<MemberResponseDTO.MemberChallengingMissionListDto> getMemberChallengingMissionList(@PathVariable("memberId") Long memberId, @RequestParam("page") Integer page) {

        Page<MemberMission> memberChallengingMissionList = memberQueryService.getMemberChallengingMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberMissionConverter.getMemberChallengingMissionListDto(memberChallengingMissionList));
    }
    @PatchMapping("/{memberId}/missions/{missionId}")
    public ApiResponse<MemberResponseDTO.MemberCompleteMissionDto> completeMission(@PathVariable("memberId") Long memberId, @PathVariable("missionId") Long missionId) {
        MemberMission memberMission = memberCommandService.completeMission(memberId, missionId);

        return ApiResponse.onSuccess(MemberMissionConverter.completeMissionDto(memberMission));
    }
}
