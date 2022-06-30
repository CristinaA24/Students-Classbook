package studentsClassbook.service;

import studentsClassbook.domain.person.student.Student;
import studentsClassbook.exceptions.CustomException;
import studentsClassbook.persistence.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;


public class StudentService {

    private final StudentRepository studentRepository = StudentRepository.getInstance();

    public Student registerNewStudent(String cnp, String firstName, String lastName, int age, String studentEmail, String phoneNumber, int year, int semester)
            throws CustomException {
        if (cnp == null || cnp.length() != 13 || cnp.chars().anyMatch(asciiCode -> (asciiCode < 48 || asciiCode > 57))) {
            throw new CustomException("Invalid national identification number: " + cnp);
        }
        if (firstName == null || firstName.isEmpty()) {
            throw new CustomException("Invalid student's firstname: " + firstName);
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new CustomException("Invalid student's lastname: " + lastName);
        }
        if (age <= 18 || age >= 70) {
            throw new CustomException("Invalid student age: " + age);
        }
        if (phoneNumber == null || phoneNumber.length() != 10)
            throw new CustomException("Invalid phone number: " + phoneNumber);
        if (semester == 0 || semester >= 3)
            throw new CustomException("Invalid number of semester: " + semester);
        Student student = new Student(cnp, firstName, lastName, age, studentEmail, phoneNumber, year, semester);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

//    public Student getStudentByCnp(String cnp) throws CustomException {
//        Optional<Student> student = studentRepository.findById(cnp);
//        return student.orElseThrow(() -> new CustomException("Cannot find a student having the provided cnp: " + cnp));
//    }


    public void updateDetailsForStudent(Student student) throws CustomException {
        studentRepository.update(student);
    }

    public void removeStudent(Student student) throws CustomException {
        studentRepository.delete(student);
    }
}