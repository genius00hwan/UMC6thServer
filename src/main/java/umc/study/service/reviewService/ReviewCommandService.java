package umc.study.service.reviewService;

import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review leaveReview(ReviewRequestDTO.LeaveReviewDto request);

}
