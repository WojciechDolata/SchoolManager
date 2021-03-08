package ad.school.planner.inner.education_year;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface EducationYearRepository extends CrudRepository<EducationYear, UUID> {
}
