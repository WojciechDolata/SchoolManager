package ad.school.planner.inner.education_year;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

interface EducationYearRepository extends CrudRepository<EducationYear, UUID> {

    @Query(value = "SELECT e FROM EducationYear e WHERE e.student.id =:studentId")
    List<EducationYear> getEducationYearByStudentId(UUID studentId);
}
