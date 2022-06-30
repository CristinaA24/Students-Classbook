package studentsClassbook.persistence.repositories;

import studentsClassbook.domain.person.student.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

import static studentsClassbook.persistence.util.DatabaseConnectionUtils.getDatabaseConnection;

public class StudentRepository  {

    //private final Map<String, Student> studentMap = new HashMap<>();
    private final Connection connection;

    private static volatile StudentRepository instance;

    private StudentRepository() {
        this.connection = getDatabaseConnection();
    }

    public static StudentRepository getInstance() {
        if (instance == null) {
            synchronized (StudentRepository.class) {
                if (instance == null) {
                    instance = new StudentRepository();
                }
            }
        }
        return instance;
    }


    public Student save(Student student) {
        String query = "insert into student values (?, ?, ?, ?, ?, ?, ?, ?)";


        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, student.getCnp());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setInt(4, student.getAge());
            preparedStatement.setString(5, student.getStudentEmail());
            preparedStatement.setString(6, student.getPhoneNumber());
            preparedStatement.setInt(7, student.getYear());
            preparedStatement.setInt(8, student.getSemester());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }


    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String query = "select * from student";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String cnp = resultSet.getString("cnp");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                String studentEmail = resultSet.getString("student_email");
                String phoneNumber = resultSet.getString("phone_number");
                int year = resultSet.getInt("year");
                int semester = resultSet.getInt("semester");

                students.add(new Student(cnp,firstName,lastName,age,studentEmail,phoneNumber,year,semester));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void update(Student student) {
        String query = "update student set cnp=?, first_name=?, last_name=?, age=?, student_email=?, phone_number=?, year=?, semester=? where cnp=?";


        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, student.getCnp());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setInt(4, student.getAge());
            preparedStatement.setString(5, student.getStudentEmail());
            preparedStatement.setString(6, student.getPhoneNumber());
            preparedStatement.setInt(7, student.getYear());
            preparedStatement.setInt(8, student.getSemester());
            preparedStatement.setString(9, student.getCnp());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Student student) {
        String query = "delete from student where cnp=?";


        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, student.getCnp());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public List<Student> findAll() {
//        return new ArrayList<>(storage.values());
//    }

//    public Optional<Student> findById(String cnp) {
//        return Optional.ofNullable(storage.get(cnp));
//    }
   }

