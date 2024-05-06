package com.paf.socialmedia.mapper;

import com.paf.socialmedia.dto.WorkoutStatusRequestDTO;
import com.paf.socialmedia.dto.WorkoutStatusResponseDTO;
import com.paf.socialmedia.entity.WorkoutStatus;
import com.paf.socialmedia.entity.authentication.User;
import com.paf.socialmedia.exception.ReferenceNotFoundException;
import com.paf.socialmedia.repository.authentication.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WorkoutStatusMapper {
    private final UserRepository userRepository;
    public WorkoutStatus dtoToDomain(WorkoutStatusRequestDTO dto, WorkoutStatus domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The WorkoutStatusRequestDTO should not be null");
        }
        User user = userRepository.findUserByUserIdIgnoreCase(dto.getUserId()).orElse(new User());
        domain.setUser(user);
        domain.setDistance(dto.getDistance());
        domain.setPushUp(dto.getPushUp());
        domain.setWeightLifted(dto.getWeightLifted());
        domain.setDescription(dto.getDescription());
        return domain;
    }

    public WorkoutStatusRequestDTO domainToDto(WorkoutStatus domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The WorkoutStatus should not be null");
        }
        WorkoutStatusRequestDTO dto = new WorkoutStatusRequestDTO();
        dto.setId(domain.getId());
        dto.setDistance(domain.getDistance());
        dto.setPushUp(domain.getPushUp());
        dto.setWeightLifted(domain.getWeightLifted());
        dto.setDescription(domain.getDescription());
        return dto;
    }

    public WorkoutStatusResponseDTO domainToResponseDto(WorkoutStatus domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The enrolment should not be null");
        }
        WorkoutStatusResponseDTO dto = new WorkoutStatusResponseDTO();
        dto.setId(domain.getId());
        dto.setUser(domain.getUser());
        dto.setDistance(domain.getDistance());
        dto.setPushUp(domain.getPushUp());
        dto.setWeightLifted(domain.getWeightLifted());
        dto.setDescription(domain.getDescription());
        return dto;
    }
}
