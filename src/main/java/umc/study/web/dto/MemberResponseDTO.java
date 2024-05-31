package umc.study.web.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import umc.study.domain.enums.MissionStatus;

public class MemberResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{
        Long memberId;
        LocalDateTime createdAt;
    }

    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class MemberChallengingMissionListDto {
        List<MemberChallengingMissionDto> memberChallengingMissionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class MemberChallengingMissionDto {
        String storeName;
        Integer reward;
        String missionSpec;
        LocalDate deadLine;
        MissionStatus status;
    }
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class MemberCompleteMissionDto {
        Long id;
        MissionStatus status;
    }
}
