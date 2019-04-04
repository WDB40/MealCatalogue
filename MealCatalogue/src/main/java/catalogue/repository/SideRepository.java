package catalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import catalogue.model.Side;

@Repository
public interface SideRepository extends JpaRepository<Side, Long> {

}
