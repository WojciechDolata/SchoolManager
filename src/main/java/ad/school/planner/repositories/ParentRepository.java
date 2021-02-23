package ad.school.planner.repositories;

import ad.school.planner.entities.Lesson;
import ad.school.planner.entities.Parent;
import org.springframework.data.repository.CrudRepository;

public interface ParentRepository extends CrudRepository<Parent, Integer> {
}
