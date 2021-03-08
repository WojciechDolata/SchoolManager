package ad.school.planner.inner.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

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

    public Student add(StudentRequest studentRequest) {
        var student = Student.builder()
                .ofRequest(studentRequest)
                .build();
        return studentRepository.save(student);
    }

    public Student update(UUID id, StudentRequest updatedStudent) {
        var student = studentRepository.findStudentById(id);
        student.update(updatedStudent);
        return studentRepository.save(student);
    }
}
