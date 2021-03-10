package ad.school.planner.inner.parent;

import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
public class ParentRequest {
    public final String firstName;
    public final String lastName;
    public final String city;
    public final String phoneNumber;
    public final String email;
    public final String facebook;
    public final String whatsapp;
    public final Date birthDate;
    public final Date nameDay;
    public final String description;
    public final UUID studentId;
}
