package ad.school.planner.inner.education_plan;

import ad.school.planner.inner.education_year.EducationYear;
import ad.school.planner.inner.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EducationPlanService {
    private final EducationPlanRepository repository;

    @Autowired
    public EducationPlanService(EducationPlanRepository repository) {
        this.repository = repository;
    }

    public EducationPlan add(EducationPlanRequest request,
                             EducationYear educationYear,
                             Subject subject) {
        return repository.save(
                EducationPlan.builder()
                        .ofRequest(request)
                        .educationYear(educationYear)
                        .subject(subject)
                        .build()
        );
    }

    public List<EducationPlan> getAllByYearId(UUID yearId) {
        return repository.getEducationPlansByEducationYearId(yearId);
    }
}
