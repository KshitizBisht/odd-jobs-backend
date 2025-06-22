package com.oddJobs.model;

import com.oddJobs.model.dtos.PersonDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.List;

@Document("Person")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    private ObjectId id;

    @Field("username")
    private String username;

    @Field("first_name")
    private String firstName;

    @Field("last_name")
    private String lastName;

    @Field("address_name")
    private String address;

    @Field("gigs_posted")
    private List<String> gigPosted;

    @Field("gigs_accepted")
    private List<String> gigAccepted;

    public static PersonDto convertToPersonDto(Person person) {
        return PersonDto.builder()
                .username(person.getUsername())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .address(person.getAddress())
                .build();
    }

    public static Person convertFromPersonDto(PersonDto personDto) {
        return Person.builder()
                .username(personDto.getUsername())
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .address(personDto.getAddress())
                .build();
    }
}
