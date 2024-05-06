package com.paf.socialmedia.repository;

import com.paf.socialmedia.entity.Routine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoutineRepository extends MongoRepository<Routine, String> {
}
