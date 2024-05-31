package umc.study.service.memberService;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;

import java.util.Optional;
import umc.study.domain.mapping.MemberMission;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

    Page<MemberMission> getMemberChallengingMissionList(Long memberId, Integer page);
}
