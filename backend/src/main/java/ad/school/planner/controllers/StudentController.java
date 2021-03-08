package ad.school.planner.controllers;

import ad.school.planner.inner.PlannerFacade;
import ad.school.planner.inner.student.Student;
import ad.school.planner.inner.student.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.UUID;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final PlannerFacade plannerFacade;

    @Autowired
    public StudentController(PlannerFacade plannerFacade) {
        this.plannerFacade = plannerFacade;
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return ResponseEntity.ok(plannerFacade.showAllStudents());
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<Student> addStudent(@RequestBody StudentRequest student) {
        return ResponseEntity.ok(plannerFacade.addStudent(student));
    }

    @PutMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Student> updateStudent(@PathVariable("id") UUID id,
                                                 @RequestBody StudentRequest updatedStudent) {
        return ResponseEntity.ok(plannerFacade.updateStudent(id, updatedStudent));
    }
}
