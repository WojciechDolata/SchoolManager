package ad.school.planner.controllers;

import ad.school.planner.inner.StudentAPI;
import ad.school.planner.inner.education_year.EducationYear;
import ad.school.planner.inner.education_year.EducationYearRequest;
import ad.school.planner.inner.parent.Parent;
import ad.school.planner.inner.parent.ParentRequest;
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

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentAPI studentAPI;

    @Autowired
    public StudentController(StudentAPI studentAPI) {
        this.studentAPI = studentAPI;
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return ResponseEntity.ok(studentAPI.showAllStudents());
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<Collection<Student>> addStudent(@PathParam(value = "queryString") String queryString) {
        return ResponseEntity.ok(studentAPI.getStudentBy(queryString));
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<Student> addStudent(@RequestBody StudentRequest student) {
        return ResponseEntity.ok(studentAPI.addStudent(student));
    }

    @PutMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Student> updateStudent(@PathVariable("id") UUID id,
                                                 @RequestBody StudentRequest updatedStudent) {
        return ResponseEntity.ok(studentAPI.updateStudent(id, updatedStudent));
    }

    @PostMapping(value = "/parent", produces = {"application/json"})
    public ResponseEntity<Parent> addParent(@RequestBody ParentRequest request) {
        return ResponseEntity.ok(studentAPI.addParent(request));
    }

    @PostMapping(value = "/educationYear", produces = {"application/json"})
    public ResponseEntity<EducationYear> addEducationYear(@RequestBody EducationYearRequest request) {
        return ResponseEntity.ok(studentAPI.addEducationYear(request));
    }

    @GetMapping(value = "/{id}/educationYear", produces = {"application/json"})
    public ResponseEntity<List<EducationYear>> getEducationYearsForStudent(@PathVariable String id) {
        return ResponseEntity.ok(studentAPI.getEducationYearsForStudent(UUID.fromString(id)));
    }
}
