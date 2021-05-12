package ad.school.planner.inner.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;
import java.util.UUID;

interface StudentRepository extends CrudRepository<Student, UUID> {

    @Query(value = "SELECT * FROM student WHERE " +
            "lower(LAST_NAME) like lower(concat(concat('%', ?1),'%')) " +
            "OR lower(DESCRIPTION) like lower(concat(concat('%', ?1),'%')) " +
            "OR lower(FIRST_NAME) like lower(concat(concat('%', ?1),'%'))" +
            "OR lower(EMAIL) like lower(concat(concat('%', ?1),'%'))" +
            "OR lower(CITY) like lower(concat(concat('%', ?1),'%'))" +
            "OR lower(NICK) like lower(concat(concat('%', ?1),'%'))",
            countQuery = "SELECT count(*) FROM student WHERE " +
                    "            lower(LAST_NAME) like lower(concat(concat('%', ?1),'%'))  " +
                    "            OR lower(DESCRIPTION) like lower(concat(concat('%', ?1),'%')) "  +
                    "            OR lower(FIRST_NAME) like lower(concat(concat('%', ?1),'%')) " +
                    "            OR lower(EMAIL) like lower(concat(concat('%', ?1),'%')) " +
                    "            OR lower(CITY) like lower(concat(concat('%', ?1),'%')) " +
                    "            OR lower(NICK) like lower(concat(concat('%', ?1),'%'))",
            nativeQuery = true
    )
    Page<Student> findAllBy(String queryString, Pageable pageable);

    Page<Student> findAll(Pageable pageable);

    Set<Student> findByIdIn(Set<UUID> ids);

}
