package ad.school.planner.inner.lesson;

import ad.school.planner.inner.student.Student;
import ad.school.planner.inner.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Page<LessonResponse> getAllBy(String query, Pageable pageable) {
        var page = query == null ?
                lessonRepository.findAll(pageable) : lessonRepository.findAllBy(query, pageable);
        return page.map(LessonResponse::ofLesson);
    }

    public Optional<LessonResponse> getById(UUID id) {
        return lessonRepository.findById(id)
                .map(LessonResponse::ofLesson);
    }

    public Lesson update(UUID id, LessonRequest lessonRequest, Subject subject) {
        var lesson = lessonRepository.findById(id).orElseThrow();
        lesson.update(lessonRequest);
        lesson.setSubject(subject);
        return lessonRepository.save(lesson);
    }

    public Lesson add(LessonRequest lessonRequest, Subject subject) {
        return lessonRepository.save(
                Lesson.builder()
                    .ofRequest(lessonRequest)
                    .subject(subject)
                    .build()
        );
    }

    public Lesson addStudentIfNotExists(UUID lessonId, Student student) {
        var lesson = this.lessonRepository.findById(lessonId).orElseThrow();
        lesson.addStudent(student);
        return lessonRepository.save(lesson);
    }
}
