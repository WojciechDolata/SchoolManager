package ad.school.planner.inner;

import ad.school.planner.inner.entities.Student;
import ad.school.planner.inner.request.StudentRequest;
import ad.school.planner.inner.services.LessonService;
import ad.school.planner.inner.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class PlannerFacade {
    private StudentService studentService;
    private LessonService lessonService;

    @Autowired
    public PlannerFacade(StudentService studentService, LessonService lessonService) {
        this.studentService = studentService;
        this.lessonService = lessonService;
    }

    public Collection<Student> showAllStudents() {
        return studentService.getAll();
    }

    public Student updateStudent(Integer id, StudentRequest updatedStudent) {
        return studentService.update(id, updatedStudent);
    }

    public Student addStudent(StudentRequest request) {
        return studentService.add(request);
    }
}
