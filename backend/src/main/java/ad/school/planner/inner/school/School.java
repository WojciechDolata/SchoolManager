package ad.school.planner.inner.school;

import lombok.AccessLevel;
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
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Column(unique = true)
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

    static class SchoolBuilder {
        School.SchoolBuilder ofRequest(SchoolRequest request) {
            name = request.name;
            city = request.city;
            level = request.level;
            street = request.street;
            return this;
        }
    }
}
