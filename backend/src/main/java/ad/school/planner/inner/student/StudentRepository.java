package ad.school.planner.inner.student;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.UUID;

interface StudentRepository extends CrudRepository<Student, UUID> {
    @Query(value = "SELECT s FROM Student s WHERE " +
            "lower(s.firstName) like lower(concat('%', ?1,'%')) " +
            "OR lower(s.description) like lower(concat('%', ?1,'%')) " +
            "OR lower(s.lastName) like lower(concat('%', ?1,'%'))" +
            "OR lower(s.city) like lower(concat('%', ?1,'%'))" +
            "OR lower(s.nick) like lower(concat('%', ?1,'%'))"
    )
    Collection<Student> findAllBy(String queryString);
}
