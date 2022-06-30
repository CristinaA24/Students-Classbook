package studentsClassbook.persistence.repositories;

import studentsClassbook.domain.subject.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static studentsClassbook.persistence.util.DatabaseConnectionUtils.getDatabaseConnection;

public class SubjectRepository {

    private final Connection connection;

    private static volatile SubjectRepository instance;

    private SubjectRepository() {
        this.connection = getDatabaseConnection();
    }

    public static SubjectRepository getInstance() {
        if (instance == null) {
            synchronized (SubjectRepository.class) {
                if (instance == null) {
                    instance = new SubjectRepository();
                }
            }
        }
        return instance;
    }


    public Subject save(Subject subject) {
        String query = "insert into subject values (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, subject.getSubjectName());
            preparedStatement.setInt(2, subject.getPassGrade());
            preparedStatement.setInt(3, subject.getCredits());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return subject;
    }


    public List<Subject> findAll() {
        List<Subject> subjects = new ArrayList<>();
        String query = "select * from subject";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String subjectName = resultSet.getString("subject_name");
                int passGrade = resultSet.getInt("pass_garde");
                int credits = resultSet.getInt("credits");

                subjects.add(new Subject(subjectName, passGrade, credits));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjects;
    }


    public void update(Subject subject) {
        String query = "update subject set name_subject=?, pass_grade=?, credits=? where name_subject=?";


        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, subject.getSubjectName());
            preparedStatement.setInt(2, subject.getPassGrade());
            preparedStatement.setInt(3, subject.getCredits());
            preparedStatement.setString(4, subject.getSubjectName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Subject subject) {
        String query = "delete from subject where subject_name=?";


        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, subject.getSubjectName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
