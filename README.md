# Students-Classbook
A student's class book where you can find any piece of information needed regarding a student's academic record. 


    I designed a student's classbook using the Java concepts as follows:

    -package 'domain': contains the implementation of objects we are going to use in our program
            *class 'Curriculum': contains the name of the major and the required number of credits
            *class 'Group': contains the name of the group, a group ID and the list of students that are part of it
            *class 'Person': contains the data of a person: cnp, first name, last name and age
            *class 'Student' extends 'Person': contains the current year, current semester,the phone number and the student's email
            *class 'Professor' extends 'Person': contains the salary, the current academic rank and the professor's email
            *class 'Series': contains an ID, the name of the series and the groups that are part of it
            *class 'Subject': contains the name of the subject, the minimum grade in order to pass and the subject's number of credits
            *class 'OptionalSubject' extends 'Subject': contains only a boolean variable that tells us if the optional subject is mandatory or not
    -package 'exceptions': contains class 'CustomExeption' that is a class created for my own exeption
    -package 'service': contains the actions' implementation of four objects 
    -package 'persistence': 
              *package 'repositories': contains the CRUD actions' implementations for four objects 
              *package 'util': contains the class 'DatabaseConnectionUtils' that implements the specific actions for connectig the app to a local database
    -package 'view': contains the 'Main' class where the user interacts with the app

    This app is connected to a local database(I chose MySQL) and can make the CRUD actions on four objects.
