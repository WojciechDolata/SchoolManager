package ad.school.planner.inner.lesson;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface LessonRepository extends CrudRepository<Lesson, UUID> {
}