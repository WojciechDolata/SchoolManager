package ad.school.planner.inner.school;

enum EducationLevel {
    HIGH_SCHOOL("Liceum"),
    PRIMARY_SCHOOL("Szkoła podstawowa"),
    UNIVERSITY("Studia");

    String name;

    EducationLevel(String name) {
        this.name = name;
    }
}
