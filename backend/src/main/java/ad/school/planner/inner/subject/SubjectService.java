package ad.school.planner.inner.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
