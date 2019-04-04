package catalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import catalogue.model.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

}
