package ad.school.planner.entities;

import ad.school.planner.request.StudentRequest;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Student {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @CreationTimestamp
    private LocalDateTime creationTimestamp;

    @Column
    @NonNull
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String description;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @ManyToMany
    private List<Parent> parents;

    @ManyToMany
    private List<Lesson> lessons;

    public void update(StudentRequest updatedStudent) {
        setPhoneNumber(updatedStudent.phoneNumber);
        setFirstName(updatedStudent.firstName);
        setLastName(updatedStudent.lastName);
        setEmail(updatedStudent.email);
        setDescription(updatedStudent.description);
    }
}
