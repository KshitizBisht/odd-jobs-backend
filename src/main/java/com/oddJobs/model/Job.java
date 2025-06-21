package com.oddJobs.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "Jobs")
public class Job {

    @Id
    private ObjectId id;

    @Field("title")
    private String title;

    @Field("reward")
    private int reward;

    @Field("description")
    private int description;

    @Field("tags")
    private List<String> tags;

    @Field("posted_by")
    private String postedBy;

    @Field("accepted_by")
    private String acceptedBy;
}
