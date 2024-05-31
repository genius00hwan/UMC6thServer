package umc.study.converter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.MissionResponseDTO.storeMissionPreviewDto;

public class MissionConverter {
    public static MissionResponseDTO.CreateMissionResultDto toCreateMissionDto(Mission mission) {
        return MissionResponseDTO.CreateMissionResultDto.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.CreateMissionDto request) {
        LocalDate deadline = LocalDate.now().plusDays(7);

        return Mission.builder()
                .reward(request.getReward())
                .deadline(deadline)
                .missionSpec(request.getMissionSpec())
                .store(null)
                .memberMissionList(new ArrayList<>())
                .build();
    }

    public static MissionResponseDTO.storeMissionPreviewDto storeMissionPreviewDto(Mission mission) {
        return MissionResponseDTO.storeMissionPreviewDto.builder()
                .reward(mission.getReward())
                .deadLine(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.storeMissionPreviewListDto storeMissionPreviewListDto(
            Page<Mission> storeMissionPreviewList) {

        List<storeMissionPreviewDto> storeMissionPreviewDtoList = storeMissionPreviewList.stream()
                .map(MissionConverter::storeMissionPreviewDto).collect(Collectors.toList());

        return MissionResponseDTO.storeMissionPreviewListDto.builder()
                .isLast(storeMissionPreviewList.isLast())
                .isFirst(storeMissionPreviewList.isFirst())
                .listSize(storeMissionPreviewDtoList.size())
                .totalElements(storeMissionPreviewList.getTotalElements())
                .totalPage(storeMissionPreviewList.getTotalPages())
                .storeMissionPreviewList(storeMissionPreviewDtoList)
                .build();
    }

}
