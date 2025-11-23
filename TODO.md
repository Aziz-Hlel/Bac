# Add on Cascade logic to some tables

-- some tables actually needs on cascade logic for better data integrity, for example if a school is deleted, all its majors, classes, class units,teachers etc should be deleted too
-- if a class unit is deleted, all exams scheduled in that class (ExamSchool table) should be deleted too
-- if a school major is deleted, all scheduling in school classes for that major should be deleted too
-- if a optional subject is deleted, all scheduling in school classes for that optional subject should be deleted too

# Add targeted, computed indexes to improve query performance, especially on the ExamSchool table
