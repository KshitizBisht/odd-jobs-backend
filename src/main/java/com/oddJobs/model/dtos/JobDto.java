package com.oddJobs.model.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class JobDto {
    private String jobId;
    private String title;
    private String duration;
    private String description;
    private String location;
    private String postedBy;
    private String acceptedBy;
    private Boolean completed;
    private String difficultyLevel;
    private int reward;
    private List<String> tags;
    private String postedOn;
}
