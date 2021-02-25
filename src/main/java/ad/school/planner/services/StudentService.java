package ad.school.planner.services;

import ad.school.planner.entities.Student;
import ad.school.planner.repositories.StudentRepository;
import ad.school.planner.request.StudentRequest;
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
        var student = Student.builder()
                .description(studentRequest.description)
                .email(studentRequest.email)
                .firstName(studentRequest.firstName)
                .lastName(studentRequest.lastName)
                .phoneNumber(studentRequest.phoneNumber)
                .build();
        return studentRepository.save(student);
    }

    public Student update(Integer id, StudentRequest updatedStudent) {
        var student = studentRepository.findStudentById(id);
        student.update(updatedStudent);
        studentRepository.save(student);
        return student;
    }
}
