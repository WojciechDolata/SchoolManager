package ad.school.planner.services;

import ad.school.planner.entities.Lesson;
import ad.school.planner.repositories.LessonRepository;
import ad.school.planner.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository, StudentRepository studentRepository) {
        this.lessonRepository = lessonRepository;
        this.studentRepository = studentRepository;
    }

    public Collection<Lesson> getAll() {
        return (Collection<Lesson>) lessonRepository.findAll();
    }

    public Lesson add(Lesson lesson, Integer studentId) {
        // znajdz studenciaka po id
        // dodaj go do lekcji
        var student = studentRepository.findStudentById(studentId);
        lesson.addStudent(student);
        return lessonRepository.save(lesson);
    }
}
