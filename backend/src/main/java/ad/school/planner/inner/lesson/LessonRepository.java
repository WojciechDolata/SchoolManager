package ad.school.planner.inner.lesson;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface LessonRepository extends CrudRepository<Lesson, UUID> {

    @Query(value = "select distinct l.* from lesson l " +
            "join lessons_students ls on l.id = ls.lesson_id " +
            "join student st on st.id = ls.student_id " +
            "join subject su on su.id = l.subject_id " +
            "where lower(su.name) like lower(concat(concat('%', ?1),'%')) " +
            "or lower(st.first_name) like lower(concat(concat('%', ?1),'%')) " +
            "or lower(st.last_name) like lower(concat(concat('%', ?1),'%')) " +
            "or lower(l.description) like lower(concat(concat('%', ?1),'%')) " +
            "or lower(l.topic) like lower(concat(concat('%', ?1),'%'))",
           countQuery = "select distinct count(l.id) from lesson l " +
                   "join lessons_students ls on l.id = ls.lesson_id " +
                   "join student st on st.id = ls.student_id " +
                   "join subject su on su.id = l.subject_id " +
                   "where lower(su.name) like lower(concat(concat('%', ?1),'%')) " +
                   "or lower(st.first_name) like lower(concat(concat('%', ?1),'%')) " +
                   "or lower(st.last_name) like lower(concat(concat('%', ?1),'%')) " +
                   "or lower(l.description) like lower(concat(concat('%', ?1),'%')) " +
                   "or lower(l.topic) like lower(concat(concat('%', ?1),'%'))",
           nativeQuery = true)
    Page<Lesson> findAllBy(String query, Pageable pageable);

    Page<Lesson> findAll(Pageable pageable);
}
