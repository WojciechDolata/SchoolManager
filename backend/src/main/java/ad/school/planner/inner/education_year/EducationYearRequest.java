package ad.school.planner.inner.education_year;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class EducationYearRequest {
    public final String schoolYear;
    public final Integer classNumber;
    public final String description;
    public final UUID schoolId;
    public final UUID studentId;
}
