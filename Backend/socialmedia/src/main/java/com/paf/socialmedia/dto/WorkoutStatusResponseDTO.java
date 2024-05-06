package com.paf.socialmedia.dto;

import com.paf.socialmedia.entity.authentication.User;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class WorkoutStatusResponseDTO {
    private String id;
    private User user;
    private Double distance;
    private Integer pushUp;
    private Double weightLifted;
    private String description;
}
