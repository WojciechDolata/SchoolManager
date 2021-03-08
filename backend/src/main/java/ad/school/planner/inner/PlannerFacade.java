package ad.school.planner.inner;

import ad.school.planner.inner.lesson.LessonService;
import ad.school.planner.inner.school.School;
import ad.school.planner.inner.school.SchoolRequest;
import ad.school.planner.inner.school.SchoolService;
import ad.school.planner.inner.student.Student;
import ad.school.planner.inner.student.StudentRequest;
import ad.school.planner.inner.student.StudentService;
import ad.school.planner.inner.subject.Subject;
import ad.school.planner.inner.subject.SubjectRequest;
import ad.school.planner.inner.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

@Component
public class PlannerFacade {
    private final StudentService studentService;
    private final SchoolService schoolService;
    private final LessonService lessonService;
    private final SubjectService subjectService;

    @Autowired
    public PlannerFacade(StudentService studentService, SchoolService schoolService, LessonService lessonService, SubjectService subjectService) {
        this.studentService = studentService;
        this.schoolService = schoolService;
        this.lessonService = lessonService;
        this.subjectService = subjectService;
    }

    public Collection<Student> showAllStudents() {
        return studentService.getAll();
    }

    public Student updateStudent(UUID id, StudentRequest updatedStudent) {
        return studentService.update(id, updatedStudent);
    }

    public Student addStudent(StudentRequest request) {
        return studentService.add(request);
    }

    public School addSchool(SchoolRequest request) {
        return schoolService.add(request);
    }

    public Subject addSubject(SubjectRequest request) {
        return subjectService.add(request);
    }
}
