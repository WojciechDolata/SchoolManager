package ad.school.planner.inner.entities;

import ad.school.planner.inner.enums.EducationLevel;
import ad.school.planner.inner.request.SchoolRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class School {

    @Id
    @Column
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

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
    private EducationLevel level;

    @OneToMany
    private List<EducationYear> educationYears;

    public static class SchoolBuilder {
        public School.SchoolBuilder ofRequest(SchoolRequest request) {
            name = request.name;
            city = request.city;
            level = request.level;
            street = request.street;
            return this;
        }
    }
}
