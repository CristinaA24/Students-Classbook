package studentsClassbook.view;

import studentsClassbook.domain.curriculum.Curriculum;
import studentsClassbook.domain.person.professor.Professor;
import studentsClassbook.domain.person.student.Student;
import studentsClassbook.domain.subject.Subject;
import studentsClassbook.exceptions.CustomException;
import studentsClassbook.service.CurriculumService;
import studentsClassbook.service.ProfessorService;
import studentsClassbook.service.StudentService;
import studentsClassbook.service.SubjectService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    private final StudentService studentService = new StudentService();
    private final ProfessorService professorService = new ProfessorService();
    private final SubjectService subjectService = new SubjectService();
    private final CurriculumService curriculumService = new CurriculumService();

    public static void main(String[] args) {
        Main main = new Main();
        while (true) {
            main.showMenu();
            int option = main.readOption();
            main.execute(option);
        }
    }

    private void showMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Welcome to your online classbook!");
        System.out.println("Please choose the envinronment: sql(type sql) ");
        String workMode = scanner.next();

        if (workMode.equals("sql")) {
            System.out.println("Select option:");
            System.out.println("1. add student");
            System.out.println("2. show all students");
            System.out.println("3. update student details");
            System.out.println("4. remove student");
            System.out.println("5. add professor");
            System.out.println("6. show all professors");
            System.out.println("7. update professor");
            System.out.println("8. delete professor");
            System.out.println("9. add subject");
            System.out.println("10. show all subjects");
            System.out.println("11. update subject");
            System.out.println("12. delete subject");
            System.out.println("0. exit");
        }

    }

        private void execute (int option){
            switch (option) {
                case 1: {
                    // add student
                    addStudent();
                    break;
                }
                case 2: {
                    // list all students
                    showStudents();
                    break;
                }
                case 3: {
                    // find student by cnp
                    updateStudent();
                    break;
                }
                case 4: {
                    // update student details
                    removeStudent();
                    break;
                }
                case 5: {
                    //add professor
                    addProfessor();
                    break;
                }
                case 6: {
                    //show all professors
                    showProfessors();
                    break;
                }
                case 7: {
                    updateProfessor();
                    break;
                }
                case 8: {
                    removeProfessor();
                    break;
                }
                case 9: {
                    //add subject
                    addSubject();
                    break;
                }
                case 10: {
                    //show all subjects
                    showSubjects();
                    break;
                }
                case 11: {
                    updateSubject();
                    break;
                }
                case 12: {
                    removeSubject();
                    break;
                }
                case 13: {
                    //add curriculum
                    addCurriculum();
                    break;
                }
                case 14: {
                    //show curriculums
                    showCurricula();
                    break;
                }
                case 15: {
                    updateCurriculum();
                    break;
                }
                case 16: {
                    removeCurriculum();
                    break;
                }

                case 0: {
                    scanner.close();
                    System.exit(0);
                }
            }
        }

        //CRUD actions and implementations for Student

        private void removeStudent () {
            Student student = readStudentDetails();
            try {
                studentService.removeStudent(student);
                System.out.println("Removed employee: " + student);
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
        }

        private void updateStudent () {
            Student student = readStudentDetails();
            try {
                studentService.updateDetailsForStudent(student);
                System.out.println("Updated student: " + student);
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
        }

        private void showStudents () {
            System.out.println("Currently registered students: ");
            List<Student> students = studentService.getAllStudents();
            if (students.isEmpty()) {
                System.out.println("No employees registered yet!");
            } else {
                students.forEach(System.out::println);
            }
        }

        private void addStudent () {
            Student student = readStudentDetails();
            try {
                studentService.registerNewStudent(student.getCnp(), student.getFirstName(), student.getLastName(), student.getAge(), student.getStudentEmail(),
                        student.getPhoneNumber(), student.getYear(), student.getSemester());
                System.out.println("Registered new Student: " + student);
            } catch (CustomException customException) {
                System.out.println(customException.getMessage());
            }
        }


        private Student readStudentDetails () {
            System.out.print("Student CNP: ");
            String cnp = scanner.next();
            System.out.print("Student first name: ");
            String firstName = scanner.next();
            System.out.print("Student last name: ");
            String lastName = scanner.next();
            System.out.println("Student age: ");
            int age = readAge();
            System.out.println("Student email: ");
            String studentEmail = scanner.next();
            System.out.println("Student phone number: ");
            String phoneNumber = scanner.next();
            System.out.println("Student's year of study: ");
            int year = scanner.nextInt();
            System.out.println("Semester: ");
            int semester = scanner.nextInt();
            return new Student(cnp, firstName, lastName, age, studentEmail, phoneNumber, year, semester);
        }

        private int readAge () {
            int age = -1;
            do {
                try {
                    age = readInt();
                } catch (CustomException exception) {
                    System.out.println("Invalid input for student age! Try again!");
                }
            } while (age < 0);
            return age;
        }



        //CRUD actions for professor

        private void addProfessor () {
            Professor professor = readProfessorDetails();
            try {
                professorService.registerNewProfessor(professor.getCnp(), professor.getFirstName(), professor.getLastName(), professor.getProfessorEmail(),
                        professor.getAcademicRank(), professor.getSalary());
                System.out.println("Registered new professor: " + professor);
            } catch (CustomException customException) {
                System.out.println(customException.getMessage());
            }
        }

        private Professor readProfessorDetails () {
            System.out.print("Professor CNP: ");
            String cnp = scanner.next();
            System.out.print("Professor first name: ");
            String firstName = scanner.next();
            System.out.print("Professor last name: ");
            String lastName = scanner.next();
            System.out.println("Professor email: ");
            String professorEmail = scanner.next();
            System.out.println("Professor's academic rank: ");
            String academicRank = scanner.next();
            System.out.println("Salary: ");
            int salary = scanner.nextInt();
            return new Professor(cnp, firstName, lastName, professorEmail, academicRank, salary);
    }

        private void showProfessors() {
            System.out.println("Currently registered professors: ");
            List<Professor> professors = professorService.getAllProfessors();
            if (professors.isEmpty()) {
                System.out.println("No professors registered yet!");
            } else {
                professors.forEach(System.out::println);
            }
        }

    private void updateProfessor () {
        Professor professor = readProfessorDetails();
        try {
            professorService.updateDetailsForProfessor(professor);
            System.out.println("Updated professor: " + professor);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeProfessor () {
        Professor professor = readProfessorDetails();
        try {
            professorService.removeProfessor(professor);
            System.out.println("Removed professor: " + professor);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }


    //CRUD actions for subject

    private void addSubject () {
        Subject subject = readSubjectDetails();
        try {
            subjectService.registerNewSubject(subject.getSubjectName(), subject.getPassGrade(), subject.getCredits());
            System.out.println("Registered new subject: " + subject);
        } catch (CustomException customException) {
            System.out.println(customException.getMessage());
        }
    }

    private Subject readSubjectDetails () {
        System.out.print("Subject name: ");
        String subjectName = scanner.next();
        System.out.print("Subject's pass grade: ");
        int passGrade = scanner.nextInt();
        System.out.print("Subject's credits: ");
        int credits = scanner.nextInt();
        return new Subject(subjectName, passGrade, credits);
    }

    private void showSubjects() {
        System.out.println("Currently registered subjects: ");
        List<Subject> subjects = subjectService.getAllSubjects();
        if (subjects.isEmpty()) {
            System.out.println("No subjects registered yet!");
        } else {
            subjects.forEach(System.out::println);
        }
    }

    private void updateSubject () {
        Subject subject = readSubjectDetails();
        try {
            subjectService.updateDetailsForSubject(subject);
            System.out.println("Updated subject: " + subject);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeSubject () {
        Subject subject = readSubjectDetails();
        try {
            subjectService.removeSubject(subject);
            System.out.println("Removed subject: " + subject);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    //CRUD actions for curriculum

    private void addCurriculum () {
        Curriculum curriculum = readCurriculumDetails();
        try {
            curriculumService.registerNewCurriculum(curriculum.getMajor(), curriculum.getReqCredits());
            System.out.println("Registered new curriculum: " + curriculum);
        } catch (CustomException customException) {
            System.out.println(customException.getMessage());
        }
    }

    private Curriculum readCurriculumDetails() {
        System.out.print("Major name: ");
        String major = scanner.next();
        System.out.print("Curriculum's number of credits: ");
        int reqCredits = scanner.nextInt();
        return new Curriculum(major, reqCredits);
    }

    private void showCurricula() {
        System.out.println("Currently registered curricula: ");
        List<Curriculum> curricula = curriculumService.getAllCurricula();
        if (curricula.isEmpty()) {
            System.out.println("No curricula registered yet!");
        } else {
            curricula.forEach(System.out::println);
        }
    }

    private void updateCurriculum () {
        Curriculum curriculum = readCurriculumDetails();
        try {
            curriculumService.updateDetailsForCurriculum(curriculum);
            System.out.println("Updated curriculum: " + curriculum);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeCurriculum () {
        Curriculum curriculum = readCurriculumDetails();
        try {
            curriculumService.removeCurriculum(curriculum);
            System.out.println("Removed curriculum: " + curriculum);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }









    private int readOption() {
            int option = -1;
            do {
                try {
                    option = readInt();
                } catch (CustomException exception) {
                    System.out.println("Invalid option! Try again!");
                }
            } while (option < 0 || option > 12);
            return option;
        }

        private int readInt () throws CustomException {
            String line = scanner.next();
            if (line.matches("^\\d+$")) {
                return Integer.parseInt(line);
            } else {
                throw new CustomException("Invalid number");
            }
        }
    }

