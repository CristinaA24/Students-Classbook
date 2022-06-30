package studentsClassbook.persistence.repositories;

import studentsClassbook.domain.curriculum.Curriculum;
import studentsClassbook.domain.person.student.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static studentsClassbook.persistence.util.DatabaseConnectionUtils.getDatabaseConnection;

public class CurriculumRepository {

    private final Connection connection;

    private static volatile CurriculumRepository instance;

    private CurriculumRepository() {
        this.connection = getDatabaseConnection();
    }

    public static CurriculumRepository getInstance() {
        if (instance == null) {
            synchronized (CurriculumRepository.class) {
                if (instance == null) {
                    instance = new CurriculumRepository();
                }
            }
        }
        return instance;
    }


    public Curriculum save(Curriculum curriculum) {
        String query = "insert into curriculum values (?, ?)";


        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, curriculum.getMajor());
            preparedStatement.setInt(2, curriculum.getReqCredits());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return curriculum;
    }


    public List<Curriculum> findAll() {
        List<Curriculum> curriculum = new ArrayList<>();
        String query = "select * from curriculum";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String major = resultSet.getString("major");
                int reqCredits = resultSet.getInt("req_credits");

                curriculum.add(new Curriculum(major, reqCredits));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return curriculum;
    }

    public void update(Curriculum curriculum) {
        String query = "update curriculum set major=?, req_credits=? where major=?";


        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, curriculum.getMajor());
            preparedStatement.setInt(2, curriculum.getReqCredits());
            preparedStatement.setString(3, curriculum.getMajor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Curriculum curriculum) {
        String query = "delete from curriculum where major=?";


        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, curriculum.getMajor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
