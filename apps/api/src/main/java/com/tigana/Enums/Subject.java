package com.tigana.Enums;

public enum Subject {

    MATH(SubjectType.REQUIRED),
    SCIENCE(SubjectType.REQUIRED),
    ENGLISH(SubjectType.REQUIRED),
    FRENCH(SubjectType.REQUIRED),
    HISTORY(SubjectType.REQUIRED),
    GEOGRAPHY(SubjectType.REQUIRED),
    BIOLOGY(SubjectType.REQUIRED),
    CHEMISTRY(SubjectType.REQUIRED),
    PHYSICS(SubjectType.REQUIRED),

    SPANISH(SubjectType.OPTIONAL),
    ITALIAN(SubjectType.OPTIONAL),
    GERMAN(SubjectType.OPTIONAL);

    private final SubjectType type;

    Subject(SubjectType type) {
        this.type = type;
    }

    public SubjectType getType() {
        return type;
    }

}
