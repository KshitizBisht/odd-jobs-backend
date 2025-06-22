package com.oddJobs.model.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobDto {
    private String gigId;
    private String title;
    private String duration;
    private String description;
    private String location;
    private String postedBy;
    private String acceptedBy;
    private Boolean completed;
    private String difficultyLevel;
}
