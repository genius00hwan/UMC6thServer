package umc.study.web.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class CreateMissionDto {
        @NotNull
        Integer reward;
        @NotNull
        String missionSpec;
    }

    @Getter
    public static class ChallengeMissionDto {
        @NotNull
        Long memberId;
    }
}
