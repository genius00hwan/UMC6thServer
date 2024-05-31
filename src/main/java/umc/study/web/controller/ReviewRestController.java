package umc.study.web.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.reviewService.ReviewCommandService;
import umc.study.service.reviewService.ReviewQueryService;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;
import umc.study.web.dto.ReviewResponseDTO.LeaveReviewResultDto;

@RestController
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping("/stores/{storeId}/reviews")
    public ApiResponse<LeaveReviewResultDto> join(@RequestBody @Valid ReviewRequestDTO.LeaveReviewDto request, @PathVariable Long storeId) {
        request.setStoreId(storeId);
        Review review = reviewCommandService.leaveReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toLeaveReviewResultDTO(review));
    }

    @GetMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDto> getReviewList(@PathVariable("storeId") Long storeId, @RequestParam("page") Integer page) {
        Page<Review> reviewList = reviewQueryService.getReviewList(storeId, page);

        return ApiResponse.onSuccess(ReviewConverter.reviewPreviewListDto(reviewList));
    }

    @GetMapping("{memberId}/reviews")
    public ApiResponse<ReviewResponseDTO.PersonalReviewPreviewListDto> getPersonalReviewList(@PathVariable("memberId") Long memberId, @RequestParam("page") Integer page) {
        Page<Review> personalReviewList = reviewQueryService.getPersonalReviewList(memberId, page);

        return ApiResponse.onSuccess(ReviewConverter.personalReviewPreviewListDto(personalReviewList));
    }
}
