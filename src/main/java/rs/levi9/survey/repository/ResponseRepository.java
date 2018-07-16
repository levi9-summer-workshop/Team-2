package rs.levi9.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.levi9.survey.domain.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
}
