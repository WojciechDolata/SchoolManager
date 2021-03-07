package ad.school.planner.inner.repositories;

import ad.school.planner.inner.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student findStudentById(Integer id);
}
