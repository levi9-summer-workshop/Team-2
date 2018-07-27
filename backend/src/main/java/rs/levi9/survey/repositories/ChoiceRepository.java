package rs.levi9.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.levi9.survey.domain.Choice;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {
}