package ad.school.planner.services;

import ad.school.planner.entities.Lesson;
import ad.school.planner.entities.Student;
import ad.school.planner.repositories.LessonRepository;
import ad.school.planner.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Collection<Student> getAll() {
        return (Collection<Student>) studentRepository.findAll();
    }

    public Student add(Student student) {
        return studentRepository.save(student);
    }
}
