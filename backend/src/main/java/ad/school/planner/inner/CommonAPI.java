package ad.school.planner.inner;

import ad.school.planner.inner.school.School;
import ad.school.planner.inner.school.SchoolRequest;
import ad.school.planner.inner.school.SchoolService;
import ad.school.planner.inner.subject.Subject;
import ad.school.planner.inner.subject.SubjectRequest;
import ad.school.planner.inner.subject.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CommonAPI {
    private final SchoolService schoolService;
    private final SubjectService subjectService;

    public School addSchool(SchoolRequest request) {
        return schoolService.add(request);
    }

    public List<School> getAllSchools() {
        return schoolService.getAll();
    }

    public Subject addSubject(SubjectRequest request) {
        return subjectService.add(request);
    }

    public List<Subject> getAllSubjects() {
        return subjectService.getAll();
    }
}
