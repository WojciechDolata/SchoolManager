package ad.school.planner.inner.parent;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface ParentRepository extends CrudRepository<Parent, UUID> {
}
