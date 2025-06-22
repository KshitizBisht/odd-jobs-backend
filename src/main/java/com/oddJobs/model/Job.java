package com.oddJobs.model;

import com.oddJobs.model.dtos.JobDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Gigs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {

    @Id
    private ObjectId id;

    @Field("gig_id")
    private String gigId;

    @Field("title")
    private String title;

    @Field("duration")
    private String duration;

    @Field("description")
    private String description;

    @Field("location")
    private String location;

    @Field("posted_by")
    private String postedBy;

    @Field("accepted_by")
    private String acceptedBy;

    @Field("completed")
    private Boolean completed;

    @Field("difficulty_level")
    private DifficultyLevel difficultyLevel;


    public static JobDto convertToGigDto(Job job) {
        return JobDto.builder()
                .gigId(job.getGigId())
                .title(job.getTitle())
                .duration(job.getDuration())
                .description(job.getDescription())
                .location(job.getLocation())
                .acceptedBy(job.getAcceptedBy() != null ? job.getAcceptedBy() : "")
                .postedBy(job.getPostedBy())
                .completed(job.getCompleted())
                .difficultyLevel(job.getDifficultyLevel().toString())
                .build();
    }

    public static Job convertFromGigDto(JobDto jobDto) {
        return Job.builder()
                .gigId(jobDto.getGigId())
                .title(jobDto.getTitle())
                .duration(jobDto.getDuration())
                .description(jobDto.getDescription())
                .location(jobDto.getLocation())
                .acceptedBy(jobDto.getAcceptedBy() != null ? jobDto.getAcceptedBy() : "")
                .postedBy(jobDto.getPostedBy())
                .completed(jobDto.getCompleted())
                .difficultyLevel(DifficultyLevel.valueOf(jobDto.getDifficultyLevel().toUpperCase()))
                .build();
    }
}
