package ad.school.planner.inner;

import ad.school.planner.inner.lesson.Lesson;
import ad.school.planner.inner.lesson.LessonRequest;
import ad.school.planner.inner.lesson.LessonService;
import ad.school.planner.inner.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LessonAPI {
    private final LessonService lessonService;
    private final StudentService studentService;

    public Lesson add(LessonRequest lessonRequest) {
        var students = studentService.getByIds(lessonRequest.studentIds);
        return lessonService.add(lessonRequest, students);
    }

    public Lesson getById(UUID id) {
        return lessonService.getById(id).orElseThrow();
    }
}
