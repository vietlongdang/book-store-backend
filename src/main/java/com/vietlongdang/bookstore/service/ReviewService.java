package com.vietlongdang.bookstore.service;

import com.vietlongdang.bookstore.dao.ReviewRepository;
import com.vietlongdang.bookstore.entity.Review;
import com.vietlongdang.bookstore.requestModels.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

@Service
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void postReview(String userEmail, ReviewRequest reviewRequest) throws Exception {
        Review review = reviewRepository.findByUserEmailAndBookId(userEmail, reviewRequest.getBookId());
        if (review != null) {
            throw new Exception("Review already created");
        }

        Review newReview = new Review();
        newReview.setBookId(reviewRequest.getBookId());
        newReview.setRating(reviewRequest.getRating());
        newReview.setUserEmail(userEmail);
        if (reviewRequest.getReviewDescription().isPresent()) {
            newReview.setReviewDescription(reviewRequest.getReviewDescription().map(
                    Object::toString
            ).orElse(null));
        }
        newReview.setDate(Date.valueOf(LocalDate.now()));
        reviewRepository.save(newReview);
    }

    public Boolean userReviewListed(String userEmail, Long bookId) {
        Review review = reviewRepository.findByUserEmailAndBookId(userEmail, bookId);
        return review != null;
    }
}
