package ad.school.planner.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
