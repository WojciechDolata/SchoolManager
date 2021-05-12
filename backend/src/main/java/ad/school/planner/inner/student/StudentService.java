package ad.school.planner.inner.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Page<Student> getAllBy(String query, Pageable pageable) {
        return query == null ?
                studentRepository.findAll(pageable) : studentRepository.findAllBy(query, pageable);
    }

    public Optional<Student> getById(UUID id) {
        return studentRepository.findById(id);
    }

    public Set<Student> getByIds(Set<UUID> ids) {
        return studentRepository.findByIdIn(ids);
    }

    public Student add(StudentRequest studentRequest) {
        var student = Student.builder()
                .ofRequest(studentRequest)
                .build();
        return studentRepository.save(student);
    }

    public Student update(UUID id, StudentRequest studentUpdateRequest) {
        var student = studentRepository.findById(id).orElseThrow();
        student.update(studentUpdateRequest);
        return studentRepository.save(student);
    }
}
