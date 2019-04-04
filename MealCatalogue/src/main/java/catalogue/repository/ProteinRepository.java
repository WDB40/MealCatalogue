package catalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import catalogue.model.Protein;

@Repository
public interface ProteinRepository extends JpaRepository<Protein, Long> {

}
