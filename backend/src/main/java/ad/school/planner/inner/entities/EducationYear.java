package ad.school.planner.inner.entities;

import ad.school.planner.inner.request.EducationYearRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EducationYear {
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
    private String schoolYear;

    @Column
    private Integer classNumber;

    @Column
    private String description;

    @ManyToOne
    private School school;

    @ManyToOne
    private Student student;

    @OneToMany
    private List<EducationPlan> educationPlans;

    public static class EducationYearBuilder {
        public EducationYearBuilder ofRequest(EducationYearRequest request) {
            schoolYear = request.schoolYear;
            description = request.description;
            classNumber = request.classNumber;
            return this;
        }
    }
}
