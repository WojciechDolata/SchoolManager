package ad.school.planner.inner.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    private final SchoolRepository repository;

    @Autowired
    public SchoolService(SchoolRepository repository) {
        this.repository = repository;
    }

    public School add(SchoolRequest request) {
        return repository.save(
                School.builder()
                        .ofRequest(request)
                        .build()
        );
    }
}
