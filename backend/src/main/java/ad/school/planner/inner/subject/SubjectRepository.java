package ad.school.planner.inner.subject;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface SubjectRepository extends CrudRepository<Subject, UUID> {
}
