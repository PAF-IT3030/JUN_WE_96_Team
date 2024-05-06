package com.paf.socialmedia.mapper;

import com.paf.socialmedia.dto.MealPlanDTO;
import com.paf.socialmedia.dto.RecipeDTO;
import com.paf.socialmedia.entity.MealPlan;
import com.paf.socialmedia.entity.Recipe;
import com.paf.socialmedia.entity.authentication.User;
import com.paf.socialmedia.exception.ReferenceNotFoundException;
import com.paf.socialmedia.repository.RecipeRepository;
import com.paf.socialmedia.repository.authentication.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MealPlanMapper {
    private final UserRepository userRepository;
    private final RecipeMapper recipeMapper;
    private final RecipeRepository recipeRepository;

    public MealPlan dtoToDomain(MealPlanDTO dto, MealPlan domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The MealPlanDTO should not be null");
        }
        User user = userRepository.findUserByUserIdIgnoreCase(dto.getUserId()).orElse(new User());
        domain.setUser(user);
        domain.setName(dto.getName());
        domain.setDescription(dto.getDescription());
        domain.setCreatedDate(dto.getCreatedDate());
        domain.setLastUpdatedDate(dto.getLastUpdatedDate());
        List<Recipe> recipeList = new ArrayList<>();
        dto.getRecipes().forEach(recipeDTO -> recipeList.add(recipeMapper.dtoToDomain(recipeDTO, new Recipe())));
        recipeList.forEach(recipe -> recipe.setUserId(user.getUserId()));
        List<Recipe> savedRecipeList = recipeRepository.saveAll(recipeList);
        domain.setRecipes(savedRecipeList);
        return domain;
    }

    public MealPlanDTO domainToDto(MealPlan domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The MealPlan should not be null");
        }
        MealPlanDTO dto = new MealPlanDTO();
        dto.setMealPlanId(domain.getMealPlanId());
        dto.setUserId(domain.getUser().getUserId());
        dto.setName(domain.getName());
        dto.setDescription(domain.getDescription());
        dto.setCreatedDate(domain.getCreatedDate());
        dto.setLastUpdatedDate(domain.getLastUpdatedDate());
        List<RecipeDTO> recipeDTOList = new ArrayList<>();
        domain.getRecipes().forEach(recipe -> recipeDTOList.add(recipeMapper.domainToDto(recipe)));
        dto.setRecipes(recipeDTOList);
        return dto;
    }
}
