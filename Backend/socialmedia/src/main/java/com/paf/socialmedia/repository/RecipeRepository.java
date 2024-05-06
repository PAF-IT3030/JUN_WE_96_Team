package com.paf.socialmedia.repository;

import com.paf.socialmedia.entity.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
}
