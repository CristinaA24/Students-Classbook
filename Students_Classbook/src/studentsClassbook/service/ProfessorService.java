package studentsClassbook.service;

import studentsClassbook.domain.person.professor.Professor;
import studentsClassbook.domain.person.student.Student;
import studentsClassbook.exceptions.CustomException;
import studentsClassbook.persistence.repositories.ProfessorRepository;
import studentsClassbook.persistence.repositories.StudentRepository;

import java.util.List;

public class ProfessorService {

    private final ProfessorRepository professorRepository = ProfessorRepository.getInstance();

    public Professor registerNewProfessor(String cnp, String firstName, String lastName, String professorEmail, String academicRank, int salary)
            throws CustomException {
        if (cnp == null || cnp.length() != 13 || cnp.chars().anyMatch(asciiCode -> (asciiCode < 48 || asciiCode > 57))) {
            throw new CustomException("Invalid national identification number: " + cnp);
        }
        if (firstName == null || firstName.isEmpty()) {
            throw new CustomException("Invalid student's firstname: " + firstName);
        }
        Professor professor = new Professor(cnp, firstName, lastName, professorEmail, academicRank, salary);
        return professorRepository.save(professor);
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }


    public void updateDetailsForProfessor(Professor professor) throws CustomException {
        professorRepository.update(professor);
    }

    public void removeProfessor(Professor professor) throws CustomException {
        professorRepository.delete(professor);
    }



}
