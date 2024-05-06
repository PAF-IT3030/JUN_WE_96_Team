package com.paf.socialmedia.mapper;

import com.paf.socialmedia.dto.MediaEntityDTO;
import com.paf.socialmedia.dto.MediaResponseDTO;
import com.paf.socialmedia.entity.MediaEntity;
import com.paf.socialmedia.exception.ReferenceNotFoundException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class MediaMapper {
    public MediaResponseDTO domainToDto(MediaEntity domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The WorkoutStatus should not be null");
        }
        MediaResponseDTO dto = new MediaResponseDTO();
        dto.setId(domain.getId());
        dto.setFileName(domain.getFileName());
        dto.setContentType(domain.getContentType());
        dto.setDescription(domain.getDescription());
        return dto;
    }

    public MediaEntityDTO convertToDto(MediaEntity mediaEntity) {
        MediaEntityDTO dto = new MediaEntityDTO();
        dto.setId(mediaEntity.getId());
        dto.setFileName(mediaEntity.getFileName());
        dto.setDescription(mediaEntity.getDescription());
        dto.setContentType(mediaEntity.getContentType());
        String base64Encoded = Base64.encodeBase64String(mediaEntity.getData());
        dto.setData("data:" + mediaEntity.getContentType() + ";base64," + base64Encoded);
        return dto;
    }
}
