package ad.school.planner.inner.lesson;

import ad.school.planner.inner.student.Student;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    private String description;

    @Column
    private String topic;

    @ManyToMany
    private List<Student> students;

    void addStudent(Student student) {
        if (students == null) {
            students = new LinkedList<>();
        }
        students.add(student);
    }
}
