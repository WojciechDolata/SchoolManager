package ad.school.planner.inner;

import ad.school.planner.inner.education_plan.EducationPlan;
import ad.school.planner.inner.education_plan.EducationPlanRequest;
import ad.school.planner.inner.education_plan.EducationPlanService;
import ad.school.planner.inner.education_year.EducationYear;
import ad.school.planner.inner.education_year.EducationYearRequest;
import ad.school.planner.inner.education_year.EducationYearService;
import ad.school.planner.inner.parent.Parent;
import ad.school.planner.inner.parent.ParentRequest;
import ad.school.planner.inner.parent.ParentService;
import ad.school.planner.inner.school.SchoolService;
import ad.school.planner.inner.student.Student;
import ad.school.planner.inner.student.StudentRequest;
import ad.school.planner.inner.student.StudentService;
import ad.school.planner.inner.subject.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentAPI {
    private final StudentService studentService;
    private final SchoolService schoolService;
    private final SubjectService subjectService;
    private final EducationYearService educationYearService;
    private final EducationPlanService educationPlanService;
    private final ParentService parentService;

    public Page<Student> getStudentsBy(String query, Pageable pageable) {
        return studentService.getAllBy(query, pageable);
    }

    public Student getStudentById(UUID id) {
        return studentService.getById(id).orElseThrow();
    }

    public Student updateStudent(UUID id, StudentRequest updatedStudent) {
        return studentService.update(id, updatedStudent);
    }

    public Student addStudent(StudentRequest request) {
        return studentService.add(request);
    }

    public EducationYear addEducationYear(EducationYearRequest request) {
        var student = studentService.getById(request.studentId).orElseThrow();
        var school = schoolService.getById(request.schoolId).orElseThrow();
        return educationYearService.add(request, school, student);
    }

    public List<EducationYear> getEducationYearsForStudent(UUID studentId) {
        return educationYearService.getAllByStudentId(studentId);
    }

    public EducationPlan addEducationPlan(EducationPlanRequest request) {
        var educationYear = educationYearService.getById(request.educationYearId).orElseThrow();
        var subject = subjectService.getById(request.subjectId).orElseThrow();
        return educationPlanService.add(request, educationYear, subject);
    }

    public List<EducationPlan> getEducationPlansForYear(UUID educationYearId) {
        return this.educationPlanService.getAllByYearId(educationYearId);
    }

    public Parent addParent(ParentRequest request) {
        var student = studentService.getById(request.studentId).orElseThrow();
        return parentService.add(request, student);
    }
}
