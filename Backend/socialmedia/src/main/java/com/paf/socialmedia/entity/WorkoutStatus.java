package com.paf.socialmedia.entity;

import com.paf.socialmedia.entity.authentication.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class WorkoutStatus {
    @Id
    private String id;
    @DBRef
    private User user;
    @Field
    private Double distance;
    @Field
    private Integer pushUp;
    @Field
    private Double weightLifted;
    @Field
    private String description;
}
