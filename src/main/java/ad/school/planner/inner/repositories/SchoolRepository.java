package ad.school.planner.inner.repositories;

import ad.school.planner.inner.entities.School;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends CrudRepository<School, Integer> {
}
