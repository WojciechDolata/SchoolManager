package ad.school.planner.controllers;

import ad.school.planner.entities.Lesson;
import ad.school.planner.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/lesson")
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    ResponseEntity<Collection<Lesson>> getAllLessons() {
        return ResponseEntity.ok(lessonService.getAll());
    }

    @PostMapping(produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    ResponseEntity<Lesson> addLesson(@RequestBody Lesson lesson) {
        return ResponseEntity.ok(lessonService.add(lesson));
    }
}
