package ad.school.planner.inner.education_year;

import ad.school.planner.inner.education_plan.EducationPlan;
import ad.school.planner.inner.school.School;
import ad.school.planner.inner.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    @JsonIgnore
    private Student student;

    @OneToMany(mappedBy = "educationYear",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EducationPlan> educationPlans;

    static class EducationYearBuilder {
        EducationYearBuilder ofRequest(EducationYearRequest request) {
            schoolYear = request.schoolYear;
            description = request.description;
            classNumber = request.classNumber;
            return this;
        }
    }
}
