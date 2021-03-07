package ad.school.planner.inner.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class School {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @CreationTimestamp
    private LocalDateTime creationTimestamp;

    @Column
    @NonNull
    private String name;

    @Column
    private String street;

    @Column
    @NonNull
    private String city;

    @Column(name = "school_level")
    @NonNull
    private String level;

    @OneToMany
    private List<EducationYear> educationYears;
}
