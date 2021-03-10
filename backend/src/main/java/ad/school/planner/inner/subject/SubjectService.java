package ad.school.planner.inner.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SubjectService {

    private final SubjectRepository repository;

    @Autowired
    public SubjectService(SubjectRepository repository) {
        this.repository = repository;
    }

    public Subject add(SubjectRequest request) {
        return repository.save(
                Subject.builder()
                        .ofRequest(request)
                        .build()
        );
    }

    public Optional<Subject> getById(UUID id) {
        return repository.findById(id);
    }

    public List<Subject> getAll() {
        return (List<Subject>) repository.findAll();
    }
}
