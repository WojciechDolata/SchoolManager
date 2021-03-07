package ad.school.planner.inner.repositories;

import ad.school.planner.inner.entities.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
}
