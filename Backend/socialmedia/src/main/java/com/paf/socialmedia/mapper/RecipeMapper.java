package com.paf.socialmedia.mapper;

import com.paf.socialmedia.dto.RecipeDTO;
import com.paf.socialmedia.entity.Ingredient;
import com.paf.socialmedia.entity.Recipe;
import com.paf.socialmedia.exception.ReferenceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RecipeMapper {
    public Recipe dtoToDomain(RecipeDTO dto, Recipe domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The RecipeDTO should not be null");
        }
        domain.setName(dto.getName());
        domain.setIngredients(dto.getIngredients());
        domain.setInstructions(dto.getInstructions());
        domain.setPhotoUrl(dto.getPhotoUrl());
        domain.setNutrition(dto.getNutrition());
        domain.setPortionSize(dto.getPortionSize());
        domain.setDietaryPreferences(dto.getDietaryPreferences());
        return domain;
    }

    public RecipeDTO domainToDto(Recipe domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The Recipe should not be null");
        }
        RecipeDTO dto = new RecipeDTO();
        dto.setRecipeId(domain.getRecipeId());
        dto.setUserId(domain.getUserId());
        dto.setName(domain.getName());
        dto.setIngredients(domain.getIngredients());
        dto.setInstructions(domain.getInstructions());
        dto.setPhotoUrl(domain.getPhotoUrl());
        dto.setNutrition(domain.getNutrition());
        dto.setPortionSize(domain.getPortionSize());
        dto.setDietaryPreferences(domain.getDietaryPreferences());
        return dto;
    }
}
