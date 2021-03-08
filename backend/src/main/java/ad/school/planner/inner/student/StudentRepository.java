package ad.school.planner.inner.student;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface StudentRepository extends CrudRepository<Student, UUID> {

    Student findStudentById(UUID id);
}
