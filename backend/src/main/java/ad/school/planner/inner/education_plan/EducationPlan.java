package ad.school.planner.inner.education_plan;

import ad.school.planner.inner.education_year.EducationYear;
import ad.school.planner.inner.subject.Subject;
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
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class EducationPlan {
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
    private String topic;

    @ManyToOne
    private EducationYear educationYear;

    @ManyToOne
    private Subject subject;

    static class EducationPlanBuilder {
        EducationPlan.EducationPlanBuilder ofRequest(EducationPlanRequest request) {
            topic = request.topic;
            return this;
        }
    }
}
