package ad.school.planner.inner.repositories;

import ad.school.planner.inner.entities.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {
}
