package JavaBean;

import java.sql.*;
import java.io.Serializable;

public class EmployeeBean implements Serializable {
    private int id;
    private String email;
    private String name;
    private String address;

    public EmployeeBean() {
    }

    // Setter and Getter methods for email
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Setter and Getter methods for email
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    // Setter and Getter methods for name
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Setter and Getter methods for address
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void retrieveEmployeeInformation() {
        String dburl = "jdbc:mysql://localhost:3306/adv_java_Lab?useSSL=false";
        String dbusername = "root";
        String dbpassword = "";
        try (Connection conn = DriverManager.getConnection(dburl, dbusername,
                dbpassword)) {
            // Use a PreparedStatement to avoid SQL injection
            String sqlQuery = "SELECT * FROM employees WHERE email = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                address = resultSet.getString("address");
            } else {
                name = null;
                address = null;
            }
            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}