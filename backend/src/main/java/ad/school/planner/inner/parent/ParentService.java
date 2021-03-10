package ad.school.planner.inner.parent;

import ad.school.planner.inner.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {

    private final ParentRepository repository;

    @Autowired
    public ParentService(ParentRepository repository) {
        this.repository = repository;
    }

    public Parent add(ParentRequest request, Student student) {
        return repository.save(
                Parent.builder()
                        .ofRequest(request)
                        .children(List.of(student))
                        .build()
        );
    }
}
