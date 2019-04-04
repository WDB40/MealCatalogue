package catalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import catalogue.model.Vegetable;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

}
