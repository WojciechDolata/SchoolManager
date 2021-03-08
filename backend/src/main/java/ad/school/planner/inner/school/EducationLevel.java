package ad.school.planner.inner.school;

enum EducationLevel {
    LICEUM("Liceum"),
    SZKOLA_PODSTAWOWA("Szkoła podstawowa"),
    STUDIA("Studia");

    String name;

    EducationLevel(String name) {
        this.name = name;
    }
}
