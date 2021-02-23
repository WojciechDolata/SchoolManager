package ad.school.planner.services;

import ad.school.planner.entities.Lesson;
import ad.school.planner.repositories.LessonRepository;
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

    public Lesson add(Lesson lesson) {
        return lessonRepository.save(lesson);
    }
}
