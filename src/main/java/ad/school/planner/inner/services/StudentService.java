package ad.school.planner.inner.services;

import ad.school.planner.inner.entities.Student;
import ad.school.planner.inner.repositories.StudentRepository;
import ad.school.planner.inner.request.StudentRequest;
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

    public Student add(StudentRequest studentRequest) {
        var student = Student.ofRequest(studentRequest);
        return studentRepository.save(student);
    }

    public Student update(Integer id, StudentRequest updatedStudent) {
        var student = studentRepository.findStudentById(id);
        student.update(updatedStudent);
        return studentRepository.save(student);
    }
}
