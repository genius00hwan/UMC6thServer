package umc.study.web.dto;

import javax.validation.constraints.Size;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StoreRequestDTO {

    @Getter
    public static class StoreJoinDto {
        @NotBlank
        String name;
        @Size(min = 5, max = 12)
        String address;
        @NotNull
        Long regionId;
    }
}
