package com.student;

import java.sql.*;
import java.util.*;

public class StudentDao {
    private Connection con;

    public StudentDao() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "system";
        String password = "system";

        con = DriverManager.getConnection(url, username, password);
    }

    public void addStudent(Student s) {
        String sql = "INSERT INTO STUDENTED (ID, NAME, AGE, COURSE) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, s.id);
            ps.setString(2, s.name);
            ps.setInt(3, s.age);
            ps.setString(4, s.course);
            ps.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: A student with ID " + s.id + " already exists.");
        } catch (SQLException e) {
            System.out.println("Failed to add student: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM STUDENTED";

        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Student(rs.getInt("ID"), rs.getString("NAME"),
                                     rs.getInt("AGE"), rs.getString("COURSE")));
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch students: " + e.getMessage());
        }

        return list;
    }

    
    public void deleteStudent(int id) {
        String sql = "DELETE FROM STUDENTED WHERE ID=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("No student found with ID " + id);
            }
        } catch (SQLException e) {
            System.out.println(" Failed to delete student: " + e.getMessage());
        }
    }

	
	public void updateStudent(Student s) {
		String sql = "UPDATE STUDENTED SET NAME=?, AGE=?, COURSE=? WHERE ID=?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, s.name);
			ps.setInt(2, s.age);
			ps.setString(3, s.course);
			ps.setInt(4, s.id);
			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("Student updated successfully.");
			} else {
				System.out.println(" No student found with ID " + s.id);
			}
		} catch (SQLException e) {
			System.out.println("Failed to update student: " + e.getMessage());
		}
	}
}
