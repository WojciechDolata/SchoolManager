package ad.school.planner.inner.student;

import ad.school.planner.inner.education_year.EducationYear;
import ad.school.planner.inner.lesson.Lesson;
import ad.school.planner.inner.parent.Parent;
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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Student {

    @Id
    @Column
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column
    @CreationTimestamp
    private LocalDateTime creationTimestamp;

    @Column
    private String nick;

    @Column
    @NonNull
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String city;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @Column
    private String facebook;

    @Column
    private String whatsapp;

    @Column
    private Date birthDate;

    @Column
    private Date nameDay;

    @Column
    @NonNull
    private Date since;

    @Column
    private String description;

    @ManyToMany(
            mappedBy = "children",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<Parent> parents;

    @ManyToMany(
            mappedBy = "students",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<Lesson> lessons;

    @OneToMany(
            mappedBy = "student",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<EducationYear> educationYears;

    static class StudentBuilder {
        Student.StudentBuilder ofRequest(StudentRequest request) {
            nick = request.nick;
            if (request.firstName == null)
                throw new IllegalArgumentException("First name cannot be null");
            firstName = request.firstName;
            lastName = request.lastName;
            city = request.city;
            phoneNumber = request.phoneNumber;
            email = request.email;
            facebook = request.facebook;
            whatsapp = request.whatsapp;
            birthDate = request.birthDate;
            nameDay = request.nameDay;
            since = request.since == null ? new Date() : request.since;
            description = request.description;
            return this;
        }
    }

    void update(StudentRequest updatedStudent) {
        if (updatedStudent.nick != null)
            setNick(updatedStudent.nick);
        if (updatedStudent.firstName != null)
            setFirstName(updatedStudent.firstName);
        if (updatedStudent.lastName != null)
            setLastName(updatedStudent.lastName);
        if (updatedStudent.city != null)
            setCity(updatedStudent.city);
        if (updatedStudent.phoneNumber != null)
            setPhoneNumber(updatedStudent.phoneNumber);
        if (updatedStudent.email != null)
            setEmail(updatedStudent.email);
        if (updatedStudent.facebook != null)
            setFacebook(updatedStudent.facebook);
        if (updatedStudent.whatsapp != null)
            setWhatsapp(updatedStudent.whatsapp);
        if (updatedStudent.birthDate != null)
            setBirthDate(updatedStudent.birthDate);
        if (updatedStudent.nameDay != null)
            setNameDay(updatedStudent.nameDay);
        if (updatedStudent.since != null)
            setSince(updatedStudent.since);
        if (updatedStudent.description != null)
            setDescription(updatedStudent.description);
    }
}
