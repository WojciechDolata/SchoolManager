package ad.school.planner.inner.entities;

import ad.school.planner.inner.request.StudentRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Student {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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

    @ManyToMany
    private List<Parent> parents;

    @ManyToMany
    private List<Lesson> lessons;

    public static Student ofRequest(StudentRequest request) {
        return Student.builder()
                .nick(request.nick)
                .firstName(request.firstName)
                .lastName(request.lastName)
                .city(request.city)
                .phoneNumber(request.phoneNumber)
                .email(request.email)
                .facebook(request.facebook)
                .whatsapp(request.whatsapp)
                .birthDate(request.birthDate)
                .nameDay(request.nameDay)
                .since(request.since)
                .description(request.description)
                .build();
    }

    public void update(StudentRequest updatedStudent) {
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
