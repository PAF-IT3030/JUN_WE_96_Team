package com.paf.socialmedia.repository;

import com.paf.socialmedia.entity.WorkoutStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkoutStatusRepository extends MongoRepository<WorkoutStatus, String> {
}
