package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.RecipeMapper;
import com.example.entity.Recipe;

@Service
public class RecipeService {
  
  @Autowired
  private RecipeMapper recipeMapper;
  
  public List<Recipe> getRecipeOrderByCreatedDateLimitFive() {
    return recipeMapper.getRecipeOrderByCreatedDateLimitFive();
  }

}
