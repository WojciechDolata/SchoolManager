package ad.school.planner.inner.lesson;

import ad.school.planner.inner.student.Student;
import ad.school.planner.inner.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Page<LessonResponse> getAllBy(String query, Pageable pageable) {
        return lessonRepository.findAll(pageable).map(LessonResponse::ofLesson);
    }

    public Optional<Lesson> getById(UUID id) {
        return lessonRepository.findById(id);
    }

    public Lesson add(LessonRequest lessonRequest, List<Student> students, Subject subject) {
        return this.lessonRepository.save(
                Lesson.builder()
                    .ofRequest(lessonRequest)
                    .students(students)
                    .subject(subject)
                    .build()
        );
    }
}
