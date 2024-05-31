package umc.study.service.reviewService;

import java.util.Optional;
import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.Store;

public interface ReviewQueryService {
    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long storeId, Integer page);

    Page<Review> getPersonalReviewList(Long memberId, Integer page);

}
