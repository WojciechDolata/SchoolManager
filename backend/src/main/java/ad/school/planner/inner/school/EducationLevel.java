package ad.school.planner.inner.school;

import com.fasterxml.jackson.annotation.JsonProperty;

enum EducationLevel {
    @JsonProperty("Liceum")
    HIGH_SCHOOL("Liceum"),
    @JsonProperty("Szkoła podstawowa")
    PRIMARY_SCHOOL("Szkoła podstawowa"),
    @JsonProperty("Studia")
    UNIVERSITY("Studia");

    String name;

    EducationLevel(String name) {
        this.name = name;
    }
}
