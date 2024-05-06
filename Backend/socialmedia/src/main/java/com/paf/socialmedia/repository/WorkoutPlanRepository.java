package com.paf.socialmedia.repository;

import com.paf.socialmedia.entity.WorkoutPlan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkoutPlanRepository extends MongoRepository<WorkoutPlan, String> {
}
