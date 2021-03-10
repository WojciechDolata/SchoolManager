package ad.school.planner.inner.student;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class StudentRequest {

    public final String nick;
    public final String firstName;
    public final String lastName;
    public final String city;
    public final String phoneNumber;
    public final String email;
    public final String facebook;
    public final String whatsapp;
    public final Date birthDate;
    public final Date nameDay;
    public final Date since;
    public final String description;
}
