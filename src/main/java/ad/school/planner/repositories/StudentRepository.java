package ad.school.planner.repositories;

import ad.school.planner.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student findStudentById(Integer id);
}
