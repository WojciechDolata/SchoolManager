package ad.school.planner.inner.subject;

import com.fasterxml.jackson.annotation.JsonCreator;

public class SubjectRequest {
    public final String name;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public SubjectRequest(String name) {
        this.name = name;
    }
}
