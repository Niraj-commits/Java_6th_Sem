package Register;

import javax.swing.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class register implements ActionListener {

    JTextField userInput;
    JPasswordField passField;
    JFrame f;

    public register() {
        f = new JFrame("Register");
        JLabel user = new JLabel("Username");

        user.setBounds(20, 20, 150, 25);
        f.add(user);

        userInput = new JTextField();
        userInput.setBounds(180, 20, 150, 25);
        f.add(userInput);

        JLabel pass = new JLabel("Password");
        pass.setBounds(20, 55, 150, 25);
        f.add(pass);

        passField = new JPasswordField();
        passField.setBounds(180, 55, 150, 25);
        f.add(passField);

        JButton b1 = new JButton();
        b1.setText("Register");
        b1.setBounds(180, 90, 150, 25);
        b1.addActionListener(this);
        f.add(b1);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String user = userInput.getText();
        String pass = passField.getText();

        String db = "jdbc:mysql://localhost:3306/db1?useSSL=false";
        String dbUser = "root";
        String dbPass = "";

        try (Connection conn = DriverManager.getConnection(db, dbUser, dbPass)) {
            String query = ("insert INTO user (username,password) values ('" + user + "','" + pass + "')");
            Statement stmt = conn.createStatement();
            int res = stmt.executeUpdate(query);

            if (res > 0) {

                JDialog dialog = new JDialog(f, "Authenticated Successfully", true);
                dialog.setLocationRelativeTo(dialog);
                dialog.setSize(400, 400);
                dialog.setVisible(true);
            }
            conn.close();
            userInput.setText("");
            passField.setText("");
        } catch (Exception se) {
            System.out.println(se.getMessage());
        }
    }

    public static void main(String[] args) {
        new register();
    }
}