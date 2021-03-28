package ad.school.planner.inner.lesson;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class LessonResponse {
    private final LocalDateTime beginningDate;
    private final LocalDateTime endDate;
    private final String description;
    private final Integer price;
    private final String topic;
    private final String subjectName;
    private final List<String> studentNames;

    public static LessonResponse ofLesson(Lesson lesson) {
        return new LessonResponse(
                lesson.getBeginningDate(),
                lesson.getEndDate(),
                lesson.getDescription(),
                lesson.getPrice(),
                lesson.getTopic(),
                lesson.getSubject() == null ? null : lesson.getSubject().getName(),
                lesson.getStudents().stream()
                        .map(student ->
                                student.getFirstName() + " " + student.getLastName()
                        )
                        .collect(Collectors.toList())
        );
    }
}
