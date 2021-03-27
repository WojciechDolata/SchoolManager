package ad.school.planner.controllers;


import ad.school.planner.inner.LessonAPI;
import ad.school.planner.inner.lesson.Lesson;
import ad.school.planner.inner.lesson.LessonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;
import java.util.UUID;

@CrossOrigin
@Controller
@RequestMapping(value = "/lesson")
public class LessonController {
    private final LessonAPI lessonAPI;

    @Autowired
    public LessonController(LessonAPI lessonAPI) {
        this.lessonAPI = lessonAPI;
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<Lesson> add(@RequestBody LessonRequest request) {
        return ResponseEntity.ok(lessonAPI.add(request));
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Lesson> getById(@PathVariable String id) {
        return ResponseEntity.ok(lessonAPI.getById(UUID.fromString(id)));
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<Page<Lesson>> getAllLessonsBy(
            @PathParam(value = "query") String query,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(lessonAPI.getLessonsBy(query, pageable));
    }

}
