package ad.school.planner.inner;

import ad.school.planner.inner.lesson.Lesson;
import ad.school.planner.inner.lesson.LessonRequest;
import ad.school.planner.inner.lesson.LessonResponse;
import ad.school.planner.inner.lesson.LessonService;
import ad.school.planner.inner.student.StudentService;
import ad.school.planner.inner.subject.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LessonAPI {
    private final LessonService lessonService;
    private final StudentService studentService;
    private final SubjectService subjectService;

    public Lesson add(LessonRequest lessonRequest) {
        var subject = subjectService.getById(lessonRequest.subjectId).orElseThrow();
        return lessonService.add(lessonRequest, subject);
    }

    public Lesson addStudentToLesson(UUID lessonId, UUID studentId) {
        var student = studentService.getById(studentId).orElseThrow();
        return lessonService.addStudentIfNotExists(lessonId, student);
    }

    public Lesson update(UUID id, LessonRequest lessonRequest) {
        var subject = this.subjectService.getById(lessonRequest.subjectId).orElseThrow();
        return lessonService.update(id, lessonRequest, subject);
    }

    public LessonResponse getById(UUID id) {
        return lessonService.getById(id).orElseThrow();
    }

    public Page<LessonResponse> getLessonsBy(String query, Pageable pageable) {
        return lessonService.getAllBy(query, pageable);
    }
}
