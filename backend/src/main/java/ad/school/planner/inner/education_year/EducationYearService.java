package ad.school.planner.inner.education_year;

import ad.school.planner.inner.school.School;
import ad.school.planner.inner.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationYearService {
    private final EducationYearRepository repository;

    @Autowired
    public EducationYearService(EducationYearRepository repository) {
        this.repository = repository;
    }

    public EducationYear add(EducationYearRequest request, School school, Student student) {
        return repository.save(
                EducationYear.builder()
                        .ofRequest(request)
                        .school(school)
                        .student(student)
                        .build()
        );
    }
}
