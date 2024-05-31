package umc.study.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class ReviewRequestDTO {
    @Getter
    public static class LeaveReviewDto {
        @Size(max = 500)
        String body;
        @NotNull
        String title;
        @NotNull
        Float score;
        @Setter
        Long storeId;
        @NotNull
        Long memberId;

    }
}
