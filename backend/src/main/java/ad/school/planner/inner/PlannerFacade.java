package ad.school.planner.inner;

import ad.school.planner.inner.entities.School;
import ad.school.planner.inner.entities.Student;
import ad.school.planner.inner.request.SchoolRequest;
import ad.school.planner.inner.request.StudentRequest;
import ad.school.planner.inner.services.LessonService;
import ad.school.planner.inner.services.SchoolService;
import ad.school.planner.inner.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class PlannerFacade {
    private final StudentService studentService;
    private final SchoolService schoolService;
    private final LessonService lessonService;

    @Autowired
    public PlannerFacade(StudentService studentService, SchoolService schoolService, LessonService lessonService) {
        this.studentService = studentService;
        this.schoolService = schoolService;
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

    public School addSchool(SchoolRequest request) {
        return schoolService.add(request);
    }
}
