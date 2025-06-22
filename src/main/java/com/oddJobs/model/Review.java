package com.oddJobs.model;

import com.oddJobs.model.dtos.ReviewDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Review")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    private ObjectId id;

    @Field("title")
    private String title;

    @Field("description")
    private String description;

    @Field("review_by")
    private String reviewBy;

    @Field("review_for")
    private String reviewFor;

    public ReviewDto toReviewDto(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .title(review.getTitle())
                .description(review.getDescription())
                .reviewBy(review.getReviewBy())
                .reviewFor(review.getReviewFor())
                .build();
    }

    public Review fromReviewDto(ReviewDto reviewDto) {
        return Review.builder()
                .id(reviewDto.getId())
                .title(reviewDto.getTitle())
                .description(reviewDto.getDescription())
                .reviewBy(reviewDto.getReviewBy())
                .reviewFor(reviewDto.getReviewFor())
                .build();
    }
}
