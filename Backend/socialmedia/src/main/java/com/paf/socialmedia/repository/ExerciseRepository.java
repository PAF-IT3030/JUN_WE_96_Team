package com.paf.socialmedia.repository;

import com.paf.socialmedia.entity.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExerciseRepository extends MongoRepository<Exercise, String> {
}
