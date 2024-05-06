package com.paf.socialmedia.repository;

import com.paf.socialmedia.entity.MediaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MediaRepository extends MongoRepository<MediaEntity, String> {
}
