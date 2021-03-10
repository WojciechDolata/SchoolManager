package ad.school.planner.inner.school;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SchoolRequest {
    public final String name;
    public final String street;
    public final String city;
    public final EducationLevel level;
}
