package ad.school.planner.inner.enums;

public enum EducationLevel {
    LICEUM("Liceum"),
    SZKOLA_PODSTAWOWA("Szkoła podstawowa"),
    STUDIA("Studia");

    String name;

    EducationLevel(String name) {
        this.name = name;
    }
}
