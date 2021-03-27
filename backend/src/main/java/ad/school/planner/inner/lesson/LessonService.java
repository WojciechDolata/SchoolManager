package ad.school.planner.inner.lesson;

import ad.school.planner.inner.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Page<Lesson> getAllBy(String query, Pageable pageable) {
        return lessonRepository.findAll(pageable);
    }

    public Collection<Lesson> getAll() {
        return (Collection<Lesson>) lessonRepository.findAll();
    }

    public Optional<Lesson> getById(UUID id) {
        return lessonRepository.findById(id);
    }

    public Lesson add(LessonRequest lessonRequest, List<Student> students) {
        return this.lessonRepository.save(
                Lesson.builder()
                    .ofRequest(lessonRequest)
                    .students(students)
                    .build()
        );
    }
}
