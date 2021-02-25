package ad.school.planner.services;

import ad.school.planner.entities.Lesson;
import ad.school.planner.repositories.LessonRepository;
import ad.school.planner.repositories.StudentRepository;
import ad.school.planner.request.LessonRequest;
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

    public Lesson add(LessonRequest lessonRequest, Integer studentId) {
        var student = studentRepository.findStudentById(studentId);
        var lesson = Lesson.builder()
                .description(lessonRequest.description)
                .beginningDate(lessonRequest.beginningDate)
                .endDate(lessonRequest.endDate)
                .topic(lessonRequest.topic)
                .build();
        lesson.addStudent(student);
        return lessonRepository.save(lesson);
    }
}
