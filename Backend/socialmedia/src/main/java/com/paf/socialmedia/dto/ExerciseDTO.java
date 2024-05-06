package com.paf.socialmedia.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ExerciseDTO {
    private String exerciseId;
    private String name;
    private Integer sets;
    private Integer repetitions;
}
