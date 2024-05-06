package com.paf.socialmedia.entity;

import com.paf.socialmedia.entity.authentication.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class MealPlan {
    @Id
    private String mealPlanId;
    private User user;
    private String name;
    private String description;
    private List<Recipe> recipes;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
}
