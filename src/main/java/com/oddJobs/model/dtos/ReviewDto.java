package com.oddJobs.model.dtos;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;

// could possibly change this to be different for person and gig
@Data
@Builder
public class ReviewDto {
    private ObjectId id;
    private String title;
    private String description;
    private String reviewBy;
    private String reviewFor;
}
