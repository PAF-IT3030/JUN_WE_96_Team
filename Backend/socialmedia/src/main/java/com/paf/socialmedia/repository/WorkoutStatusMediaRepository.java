package com.paf.socialmedia.repository;

import com.paf.socialmedia.entity.WorkoutStatusMedia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkoutStatusMediaRepository extends MongoRepository<WorkoutStatusMedia, String> {
}
