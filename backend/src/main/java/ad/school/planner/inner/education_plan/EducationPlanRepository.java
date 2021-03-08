package ad.school.planner.inner.education_plan;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface EducationPlanRepository extends CrudRepository<EducationPlan, UUID> {
}
