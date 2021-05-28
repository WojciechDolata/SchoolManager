package ad.school.planner.inner.lesson;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
public class LessonRequest {
    public final LocalDateTime beginningDate;
    public final LocalDateTime endDate;
    public final String description;
    public final Integer price;
    public final String topic;
    public final UUID subjectId;
}
