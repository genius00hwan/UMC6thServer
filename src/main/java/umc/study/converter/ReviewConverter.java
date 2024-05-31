package umc.study.converter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;
import umc.study.web.dto.ReviewResponseDTO.ReviewPreviewDto;

public class ReviewConverter {
    public static ReviewResponseDTO.LeaveReviewResultDto toLeaveReviewResultDTO (Review review) {
        return ReviewResponseDTO.LeaveReviewResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review leaveReview(ReviewRequestDTO.LeaveReviewDto request) {
        return Review.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .score(request.getScore())
                .store(null)
                .member(null)
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewDto reviewPreviewDto(Review review) {
        return ReviewResponseDTO.ReviewPreviewDto.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewListDto reviewPreviewListDto(Page<Review> reviewList) {

        List<ReviewPreviewDto> reviewPreviewDtoList = reviewList.stream()
                .map(ReviewConverter::reviewPreviewDto).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreviewListDto.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDtoList.size())
                .reviewList(reviewPreviewDtoList)
                .build();
    }

    public static ReviewResponseDTO.PersonalReviewPreviewDto personalReviewPreviewDto(Review review) {
        return ReviewResponseDTO.PersonalReviewPreviewDto.builder()
                .storeName(review.getStore().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static ReviewResponseDTO.PersonalReviewPreviewListDto personalReviewPreviewListDto(Page<Review> personalReviewList) {

        List<ReviewResponseDTO.PersonalReviewPreviewDto> personalReviewPreviewDtoList = personalReviewList.stream()
                .map(ReviewConverter::personalReviewPreviewDto).collect(Collectors.toList());

        return ReviewResponseDTO.PersonalReviewPreviewListDto.builder()
                .isLast(personalReviewList.isLast())
                .isFirst(personalReviewList.isFirst())
                .listSize(personalReviewPreviewDtoList.size())
                .totalPage(personalReviewList.getTotalPages())
                .totalElements(personalReviewList.getTotalElements())
                .personalReviewList(personalReviewPreviewDtoList)
                .build();
    }

}
