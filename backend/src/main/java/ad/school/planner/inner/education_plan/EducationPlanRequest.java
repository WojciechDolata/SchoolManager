package ad.school.planner.inner.education_plan;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class EducationPlanRequest {
    public final String topic;
    public final UUID educationYearId;
    public final UUID subjectId;
}
