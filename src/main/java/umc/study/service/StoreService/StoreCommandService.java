package umc.study.service.StoreService;

import umc.study.domain.Review;
import umc.study.web.dto.StoreRequestDTO.ReviewDTO;

public interface StoreCommandService {

    Review createReview(Long memberId, Long storeId, ReviewDTO request);
}
