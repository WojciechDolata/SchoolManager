package ad.school.planner.inner.education_plan;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

interface EducationPlanRepository extends CrudRepository<EducationPlan, UUID> {
    @Query(value = "SELECT e FROM EducationPlan e WHERE e.educationYear.id =:yearId")
    List<EducationPlan> getEducationPlansByEducationYearId(UUID yearId);
}
