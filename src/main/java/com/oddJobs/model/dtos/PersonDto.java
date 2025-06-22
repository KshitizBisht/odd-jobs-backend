package com.oddJobs.model.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto {

    private String username;
    private String firstName;
    private String lastName;
    private String address;
}
