package studentsClassbook.persistence.repositories;

import studentsClassbook.domain.person.professor.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static studentsClassbook.persistence.util.DatabaseConnectionUtils.getDatabaseConnection;

public class ProfessorRepository {

    //private final Map<String, Professor> storage = new HashMap<>();

    private final Connection connection;

    private static volatile ProfessorRepository instance;

    private ProfessorRepository() {
        this.connection = getDatabaseConnection();
    }

    public static ProfessorRepository getInstance() {
        if (instance == null) {
            synchronized (ProfessorRepository.class) {
                if (instance == null) {
                    instance = new ProfessorRepository();
                }
            }
        }
        return instance;
    }


    public Professor save(Professor professor) {
        String query = "insert into professor values (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, professor.getCnp());
            preparedStatement.setString(2, professor.getFirstName());
            preparedStatement.setString(3, professor.getLastName());
            preparedStatement.setString(4, professor.getProfessorEmail());
            preparedStatement.setString(5, professor.getAcademicRank());
            preparedStatement.setInt(6, professor.getSalary());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return professor;
    }


    public List<Professor> findAll() {
        List<Professor> professors = new ArrayList<>();
        String query = "select * from professor";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String cnp = resultSet.getString("cnp");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String professorEmail = resultSet.getString("professor_email");
                String academicRank = resultSet.getString("academic_rank");
                int salary = resultSet.getInt("salary");

                professors.add(new Professor(cnp, firstName, lastName, professorEmail, academicRank, salary));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professors;
    }


    public void update(Professor professor) {
        String query = "update professor set cnp=?, first_name=?, last_name=?, professor_email=?, academic_rank=?, salary=? where cnp=?";


        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, professor.getCnp());
            preparedStatement.setString(2, professor.getFirstName());
            preparedStatement.setString(3, professor.getLastName());
            preparedStatement.setString(4, professor.getProfessorEmail());
            preparedStatement.setString(5, professor.getAcademicRank());
            preparedStatement.setInt(6, professor.getSalary());
            preparedStatement.setString(7, professor.getCnp());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Professor professor) {
        String query = "delete from professor where cnp=?";


        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, professor.getCnp());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public Optional<Professor> findById(String id) {
//        return Optional.ofNullable(storage.get(id));
//    }


//    public void update(Professor entity) {
//        storage.put(entity.getCnp(), entity);
//    }
//
//
//    public void delete(Professor entity) {
//        storage.remove(entity.getCnp());
//    }
}