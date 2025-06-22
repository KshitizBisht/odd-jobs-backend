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

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "Jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {

    @Id
    private ObjectId id;

    @Field("job_id")
    private String jobId;

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

    @Field("reward")
    private int reward;

    @Field("tags")
    private List<String> tags;

    @Field("posted_on")
    private LocalDateTime postedOn;


    public static JobDto convertToJobDto(Job job) {
        return JobDto.builder()
                .jobId(job.getJobId())
                .title(job.getTitle())
                .duration(job.getDuration())
                .description(job.getDescription())
                .location(job.getLocation())
                .acceptedBy(job.getAcceptedBy() != null ? job.getAcceptedBy() : "")
                .postedBy(job.getPostedBy())
                .completed(job.getCompleted())
                .difficultyLevel(job.getDifficultyLevel().toString())
                .reward(job.getReward())
                .tags(job.tags)
                .postedOn(job.postedOn)
                .build();
    }

    public static Job convertFromJobDto(JobDto jobDto) {
        return Job.builder()
                .jobId(jobDto.getJobId())
                .title(jobDto.getTitle())
                .duration(jobDto.getDuration())
                .description(jobDto.getDescription())
                .location(jobDto.getLocation())
                .acceptedBy(jobDto.getAcceptedBy() != null ? jobDto.getAcceptedBy() : "")
                .postedBy(jobDto.getPostedBy())
                .completed(jobDto.getCompleted())
                .difficultyLevel(DifficultyLevel.valueOf(jobDto.getDifficultyLevel().toUpperCase()))
                .reward(jobDto.getReward())
                .tags(jobDto.getTags())
                .postedOn(jobDto.getPostedOn())
                .build();
    }
}
