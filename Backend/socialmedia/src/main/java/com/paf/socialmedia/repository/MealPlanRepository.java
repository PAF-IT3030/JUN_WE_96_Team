package com.paf.socialmedia.repository;

import com.paf.socialmedia.entity.MealPlan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MealPlanRepository extends MongoRepository<MealPlan, String> {
}
