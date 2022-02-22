package com.example.demo.MealItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MealItemRepository extends JpaRepository<MealItem, UUID> {

    @Query("FROM MealItem AS meal WHERE meal.profileID=?1 AND meal.mealID=?2 AND meal.date=?3")
    Optional<List<MealItem>> findMealItemByID(String profileID, Integer mealID, LocalDate date);

}
