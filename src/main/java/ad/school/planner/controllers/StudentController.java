package ad.school.planner.controllers;

import ad.school.planner.entities.Student;
import ad.school.planner.request.StudentRequest;
import ad.school.planner.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<Student> addStudent(@RequestBody StudentRequest student) {
        return ResponseEntity.ok(studentService.add(student));
    }

    @PutMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id,
                                                 @RequestBody StudentRequest updatedStudent) {
        return ResponseEntity.ok(studentService.update(id, updatedStudent));
    }
}
