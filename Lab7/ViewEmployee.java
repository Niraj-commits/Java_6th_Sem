package Lab7;

import javax.swing.*;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewEmployee {
    ViewEmployee() {
        String dburl = "jdbc:mysql://localhost:3306/adv_java_Lab?useSSL=false";
        String dbusername = "root";
        String dbpassword = "";
        try (Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)) {
            Statement statement = conn.createStatement();
            ResultSet countSet = statement.executeQuery("SELECT count(*) as count FROM employees");
            countSet.next();
            int count = countSet.getInt("count");
            String sqlQuery = "SELECT * FROM employees";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            Object[][] data = new Object[count][4];
            int rowCount = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                data[rowCount][0] = id;
                data[rowCount][1] = name;
                data[rowCount][2] = email;
                data[rowCount][3] = address;
                rowCount++;
            }
            resultSet.close();
            statement.close();
            conn.close();
            String[] columnNames = { "ID", "Name", "Email", "Address" };
            JTable table = new JTable(data, columnNames);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane scrollPane = new JScrollPane(table);
            JFrame frame = new JFrame("Employee Information");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}