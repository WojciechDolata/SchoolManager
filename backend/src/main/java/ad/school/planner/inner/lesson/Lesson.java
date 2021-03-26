package ad.school.planner.inner.lesson;

import ad.school.planner.inner.parent.Parent;
import ad.school.planner.inner.parent.ParentRequest;
import ad.school.planner.inner.student.Student;
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
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
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

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "lessons_students",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    @JsonIgnore
    private List<Student> students;

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
}
