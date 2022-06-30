package studentsClassbook.service;

import studentsClassbook.domain.subject.Subject;
import studentsClassbook.exceptions.CustomException;
import studentsClassbook.persistence.repositories.SubjectRepository;

import java.util.List;

public class SubjectService {

    private final SubjectRepository subjectRepository = SubjectRepository.getInstance();

    public Subject registerNewSubject(String subjectName, int passGrade, int credits)
            throws CustomException {
        if (passGrade < 5) {
            throw new CustomException("The student has not passed : " + passGrade);
        }

        Subject subject = new Subject(subjectName, passGrade, credits);
        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }


    public void updateDetailsForSubject(Subject subject) throws CustomException {
        subjectRepository.update(subject);
    }

    public void removeSubject(Subject subject) throws CustomException {
        subjectRepository.delete(subject);
    }
}
