package ad.school.planner.inner.school;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface SchoolRepository extends CrudRepository<School, UUID> {
}
