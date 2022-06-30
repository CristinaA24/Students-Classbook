package studentsClassbook.service;

import studentsClassbook.domain.curriculum.Curriculum;
import studentsClassbook.exceptions.CustomException;
import studentsClassbook.persistence.repositories.CurriculumRepository;


import java.util.List;

public class CurriculumService {

    private final CurriculumRepository curriculumRepository = CurriculumRepository.getInstance();

    public Curriculum registerNewCurriculum(String major, int reqCredits)
            throws CustomException {
        if (reqCredits < 1) {
            throw new CustomException("the number of credits must be higher than 1: " + reqCredits);
        }
        Curriculum curriculum = new Curriculum(major, reqCredits);
        return curriculumRepository.save(curriculum);
    }

    public List<Curriculum> getAllCurricula() {
        return curriculumRepository.findAll();
    }

//    public Student getStudentByCnp(String cnp) throws CustomException {
//        Optional<Student> student = studentRepository.findById(cnp);
//        return student.orElseThrow(() -> new CustomException("Cannot find a student having the provided cnp: " + cnp));
//    }


    public void updateDetailsForCurriculum(Curriculum curriculum) throws CustomException {
        curriculumRepository.update(curriculum);
    }

    public void removeCurriculum(Curriculum curriculum) throws CustomException {
        curriculumRepository.delete(curriculum);
    }
}
