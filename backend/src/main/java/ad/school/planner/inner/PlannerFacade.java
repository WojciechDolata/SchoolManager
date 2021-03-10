package ad.school.planner.inner;

import ad.school.planner.inner.education_plan.EducationPlan;
import ad.school.planner.inner.education_plan.EducationPlanRequest;
import ad.school.planner.inner.education_plan.EducationPlanService;
import ad.school.planner.inner.education_year.EducationYear;
import ad.school.planner.inner.education_year.EducationYearRequest;
import ad.school.planner.inner.education_year.EducationYearService;
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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PlannerFacade {
    private final StudentService studentService;
    private final SchoolService schoolService;
    private final LessonService lessonService;
    private final SubjectService subjectService;
    private final EducationYearService educationYearService;
    private final EducationPlanService educationPlanService;

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

    public EducationYear addEducationYear(EducationYearRequest request) {
        var student = studentService.getById(request.studentId).orElseThrow();
        var school = schoolService.getById(request.schoolId).orElseThrow();
        return educationYearService.add(request, school, student);
    }

    public EducationPlan addEducationPlan(EducationPlanRequest request) {
        var educationYear = educationYearService.getById(request.educationYearId).orElseThrow();
        var subject = subjectService.getById(request.subjectId).orElseThrow();
        return educationPlanService.add(request, educationYear, subject);
    }
}
