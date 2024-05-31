package umc.study.converter;

import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.StoreJoinResultDto toJoinResultDto(Store store) {
        return StoreResponseDTO.StoreJoinResultDto.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.StoreJoinDto request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(null)
                .build();
    }
}
