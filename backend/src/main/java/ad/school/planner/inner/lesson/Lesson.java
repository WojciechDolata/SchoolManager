package ad.school.planner.inner.lesson;

import ad.school.planner.inner.student.Student;
import ad.school.planner.inner.subject.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Lesson {

    @Id
    @Column
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column
    @CreationTimestamp
    private LocalDateTime creationTimestamp;

    @Column
    private LocalDateTime beginningDate;

    @Column
    private LocalDateTime endDate;

    @Column
    private Integer price;

    @Column
    private String description;

    @Column
    private String topic;

    @ManyToOne
    private Subject subject;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "lessons_students",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    @JsonIgnore
    private Set<Student> students;

    static class LessonBuilder {
        public Lesson.LessonBuilder ofRequest(LessonRequest request) {
            beginningDate = request.beginningDate;
            endDate = request.endDate;
            price = request.price;
            description = request.description;
            topic = request.topic;
            return this;
        }
    }

    protected void update(LessonRequest lessonRequest) {
        beginningDate = lessonRequest.beginningDate;
        endDate = lessonRequest.endDate;
        topic = lessonRequest.topic;
        price = lessonRequest.price;
        description = lessonRequest.description;
    }

    protected void addStudent(Student student) {
        students.add(student);
    }

    protected boolean hasStudent(Student student) {
        return students.contains(student);
    }
}
