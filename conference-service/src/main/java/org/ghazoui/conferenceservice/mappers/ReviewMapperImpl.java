package org.ghazoui.conferenceservice.mappers;

import org.ghazoui.conferenceservice.dtos.ReviewDTO;
import org.ghazoui.conferenceservice.entities.Review;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ReviewMapperImpl {

    public ReviewDTO fromReview(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        BeanUtils.copyProperties(review, reviewDTO);
        return reviewDTO;
    }

    public Review fromReviewDTO(ReviewDTO reviewDTO) {
        Review review = new Review();
        BeanUtils.copyProperties(reviewDTO, review);
        return review;
    }
}
