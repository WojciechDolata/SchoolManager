package ad.school.planner.controllers;

import ad.school.planner.inner.CommonAPI;
import ad.school.planner.inner.school.School;
import ad.school.planner.inner.school.SchoolRequest;
import ad.school.planner.inner.subject.Subject;
import ad.school.planner.inner.subject.SubjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/common")
public class CommonController {
    private final CommonAPI commonAPI;

    @Autowired
    public CommonController(CommonAPI commonAPI) {
        this.commonAPI = commonAPI;
    }

    @PostMapping(value = "/school", produces = {"application/json"})
    public ResponseEntity<School> addSchools(@RequestBody SchoolRequest request) {
        return ResponseEntity.ok(commonAPI.addSchool(request));
    }

    @GetMapping(value = "/school", produces = {"application/json"})
    public ResponseEntity<List<School>> getAllSchools() {
        return ResponseEntity.ok(commonAPI.getAllSchools());
    }

    @PostMapping(value = "/subject", produces = {"application/json"})
    public ResponseEntity<Subject> addSubject(@RequestBody SubjectRequest request) {
        return ResponseEntity.ok(commonAPI.addSubject(request));
    }

    @GetMapping(value = "/subject", produces = {"application/json"})
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return ResponseEntity.ok(commonAPI.getAllSubjects());
    }
}
