package ad.school.planner.inner.services;

import ad.school.planner.inner.entities.Lesson;
import ad.school.planner.inner.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Collection<Lesson> getAll() {
        return (Collection<Lesson>) lessonRepository.findAll();
    }
}
