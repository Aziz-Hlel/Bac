# Add on Cascade logic to some tables

-- some tables actually needs on cascade logic for better data integrity, for example if a school is deleted, all its majors, classes, class units,teachers etc should be deleted too
-- if a class unit is deleted, all exams scheduled in that class (ExamSchool table) should be deleted too
-- if a school major is deleted, all scheduling in school classes for that major should be deleted too
-- if a optional subject is deleted, all scheduling in school classes for that optional subject should be deleted too

-- the update,delete for schoolClasses for example and i bet bunch of ever modules are not compatible now for superadmin, you get the school id from the authentification utils that s why , and if you ll take it from the path variable you gotta ensure it equals to the school id from the claims

-- if user is superadmin schoolId would be null , so when updating or something and gettin the school id from authentification utils it ll throw an error

-- for the school exams , and how would the user input them but based on seesion , you can add to the flow you re doing right ,ow the attribute seesion , so if seesion is retake and school doesnt have record in optionalschool exams and school majors with the session retake then it ll give back the onboarding complte as false , and for the front end based on the session it ll show the same interface but with slightly diff text for retake and principal so that user would diffrentiate and knows this one now is for retake

-- you can add an upload teacher feature as part of the onboarding so that users if having an excel would have easier time inputing the teachers data

-- add a download teachers data too so that would only input it on your app and can get it anytime without the need to saisie it bunch of times elsewhere f they had too

# Add targeted, computed indexes to improve query performance, especially on the ExamSchool table

## FrontEnd

-- you dont have a component for school details , the intial though is just add it in the superadmin for convinience as code and to users

-- make it so that if a user tried to login with google and they dont already have an account to throw an error and not create the account , the same goes for the register since all account registration is better held on the super admin side , specially since you gon add the school too to skip the first on boarding form
