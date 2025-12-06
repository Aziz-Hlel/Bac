CREATE TABLE schools (
    id UUID PRIMARY KEY,
    public_id VARCHAR(30) NOT NULL,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(20) NOT NULL CONSTRAINT city_check CHECK (city IN ('sousse', 'tunis')),
    address VARCHAR(255) NOT NULL
);

--
CREATE TABLE users (
    id UUID PRIMARY KEY,
    email VARCHAR(255) UNIQUE NULL,
    username VARCHAR(255),
    role VARCHAR(20) NOT NULL CONSTRAINT role_check CHECK (role IN ('ADMIN', 'TEACHER', 'STUDENT')),
    is_delete BOOLEAN DEFAULT FALSE,
    -- 
    school_id UUID NULL,
    FOREIGN KEY (school_id) REFERENCES schools (id) ON DELETE RESTRICT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

--
CREATE TABLE teachers (
    id UUID PRIMARY KEY,
    public_id VARCHAR(30) DEFAULT NULL,
    prefix VARCHAR(20) DEFAULT NULL CONSTRAINT prefix_check CHECK (prefix IN ('MADAME', 'MISS', 'MR', 'SIR')),
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    subject VARCHAR(100) DEFAULT NULL CONSTRAINT subject_check CHECK (
        subject IN (
            'MATH',
            'PHYSICS',
            'CHEMISTRY',
            'BIOLOGY',
            'ENGLISH',
            'FRENCH',
            'HISTORY',
            'GEOGRAPHY'
        )
    ),
    is_teacher BOOLEAN NOT NULL,
    -- 
    school_id UUID NOT NULL,
    user_id UUID NOT NULL,
    FOREIGN KEY (school_id) REFERENCES schools (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

--
CREATE TABLE exams (
    id UUID PRIMARY KEY,
    major VARCHAR(100) NULL CONSTRAINT major_check CHECK (
        major IN (
            'MATH',
            'SCIENCE',
            'LETTRE',
            'TECHNIQUE',
            'ECO',
            'INFORMATIQUE',
            'SPORT'
        )
    ),
    subject VARCHAR(100) NOT NULL CONSTRAINT subject_check CHECK (
        subject IN (
            'MATH',
            'PHYSICS',
            'CHEMISTRY',
            'BIOLOGY',
            'ENGLISH',
            'FRENCH',
            'HISTORY',
            'GEOGRAPHY'
        )
    ),
    session VARCHAR(20) NOT NULL CONSTRAINT session_check CHECK (session IN ('MORNING', 'EVENING')),
    term term_enum NOT NULL,
    duration NUMERIC(3, 2) NOT NULL,
    date DATE NOT NULL
);

--
CREATE TABLE school_majors (
    id UUID PRIMARY KEY,
    school_id UUID NOT NULL,
    major VARCHAR(100) NOT NULL CONSTRAINT major_check CHECK (
        major IN (
            'MATH',
            'SCIENCE',
            'LETTRE',
            'TECHNIQUE',
            'ECO',
            'INFORMATIQUE',
            'SPORT'
        )
    ),
    FOREIGN KEY (school_id) REFERENCES schools (id),
    UNIQUE (school_id, major)
);

--
CREATE TABLE school_optional_subjects (
    id UUID PRIMARY KEY,
    school_id UUID NOT NULL,
    optional_subject VARCHAR(100) NOT NULL CONSTRAINT optional_subject_check CHECK (
        optional_subject IN ('SPANISH', 'MUSIC', 'ITALIAN', 'GERMAN')
    ),
    FOREIGN KEY (school_id) REFERENCES schools (id),
    UNIQUE (school_id, optional_subject)
);

--
CREATE TABLE classes (
    id UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    school_id UUID NOT NULL,
    FOREIGN KEY (school_id) REFERENCES schools (id),
    UNIQUE (name, school_id)
);

--
CREATE TABLE class_exam_schedule (
    id UUID PRIMARY KEY,
    exam_id UUID NOT NULL,
    class_id UUID NOT NULL,
    FOREIGN KEY (exam_id) REFERENCES exams (id) ON DELETE CASCADE,
    FOREIGN KEY (class_id) REFERENCES classes (id) ON DELETE CASCADE,
    UNIQUE (exam_id, class_id)
);

-- 
CREATE TABLE teacher_assignments (
    teacher_id UUID NOT NULL,
    class_exam_schedule_id UUID NOT NULL,
    role VARCHAR(20) NOT NULL CONSTRAINT role_check CHECK (role IN ('PRIMARY', 'SECONDARY')),
    PRIMARY KEY (teacher_id, class_exam_schedule_id),
    --
    FOREIGN KEY (teacher_id) REFERENCES teachers (id) ON DELETE CASCADE,
    FOREIGN KEY (class_exam_schedule_id) REFERENCES class_exam_schedule (id) ON DELETE CASCADE,
    UNIQUE (class_exam_schedule_id, role, teacher_id)
)
