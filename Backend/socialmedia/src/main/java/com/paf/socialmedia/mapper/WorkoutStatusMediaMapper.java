package com.paf.socialmedia.mapper;

import com.paf.socialmedia.dto.MediaResponseDTO;
import com.paf.socialmedia.dto.WorkoutStatusMediaDTO;
import com.paf.socialmedia.dto.WorkoutStatusRequestDTO;
import com.paf.socialmedia.dto.WorkoutStatusResponseDTO;
import com.paf.socialmedia.entity.MediaEntity;
import com.paf.socialmedia.entity.WorkoutStatus;
import com.paf.socialmedia.entity.WorkoutStatusMedia;
import com.paf.socialmedia.entity.authentication.User;
import com.paf.socialmedia.exception.ReferenceNotFoundException;
import com.paf.socialmedia.repository.authentication.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class WorkoutStatusMediaMapper {
    private final UserRepository userRepository;
    private final MediaMapper mediaMapper;
    public WorkoutStatusMedia dtoToDomain(WorkoutStatusRequestDTO dto, MultipartFile file, WorkoutStatusMedia domain) throws IOException {
        if (dto == null) {
            throw new ReferenceNotFoundException("The WorkoutStatusRequestDTO should not be null");
        }
        User user = userRepository.findUserByUserIdIgnoreCase(dto.getUserId()).orElse(new User());
        domain.setUser(user);
        domain.setDistance(dto.getDistance());
        domain.setPushUp(dto.getPushUp());
        domain.setWeightLifted(dto.getWeightLifted());
        domain.setDescription(dto.getDescription());
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        MediaEntity mediaEntity = new MediaEntity();
        mediaEntity.setData(file.getBytes());
        mediaEntity.setFileName(fileName);
        mediaEntity.setContentType(file.getContentType());
        mediaEntity.setDescription(dto.getDescription());
        domain.setMediaEntity(mediaEntity);
        return domain;
    }

    public WorkoutStatusMediaDTO domainToDto(WorkoutStatusMedia domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The WorkoutStatus should not be null");
        }
        WorkoutStatusMediaDTO dto = new WorkoutStatusMediaDTO();
        dto.setId(domain.getId());
        dto.setDistance(domain.getDistance());
        dto.setPushUp(domain.getPushUp());
        dto.setWeightLifted(domain.getWeightLifted());
        dto.setDescription(domain.getDescription());
        dto.setMediaEntityDTO(mediaMapper.convertToDto(domain.getMediaEntity()));
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

    public MediaEntity updateMediaEntity(MediaEntity mediaEntity, MultipartFile file, String description) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        mediaEntity.setData(file.getBytes());
        mediaEntity.setFileName(fileName);
        mediaEntity.setDescription(description);
        mediaEntity.setContentType(file.getContentType());
        return mediaEntity;
    }
}
