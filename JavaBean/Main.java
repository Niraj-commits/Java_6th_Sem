package JavaBean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Create the input frame
        JFrame inputFrame = new JFrame("Enter Email Address");
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputFrame.setLayout(new FlowLayout());
        // Create the input field and submit button
        JTextField emailField = new JTextField(20);
        JButton submitButton = new JButton("Submit");
        // Add ActionListener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                // Create an instance of EmployeeBean
                EmployeeBean employeeBean = new EmployeeBean();
                employeeBean.setEmail(email);
                // Retrieve the employee information from the database
                employeeBean.retrieveEmployeeInformation();
                // Show the employee information in a table using another JFrame
                showEmployeeInformation(employeeBean);
            }
        });
        // Add components to the input frame
        inputFrame.add(new JLabel("Enter Email Address: "));
        inputFrame.add(emailField);
        inputFrame.add(submitButton);
        inputFrame.pack();
        inputFrame.setLocationRelativeTo(null);
        inputFrame.setVisible(true);
    }

    // Method to display employee information in a new JFrame
    private static void showEmployeeInformation(EmployeeBean employeeBean) {
        // Create the table model with the data
        Object[][] data = {
                { employeeBean.getId(), employeeBean.getName(), employeeBean.getEmail(),
                        employeeBean.getAddress() } };
        // Create column names for the table
        String[] columnNames = { "ID", "Name", "Email", "Address" };
        // Create the JTable with the data and column names
        JTable table = new JTable(data, columnNames);
        // Set table properties
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Create a scroll pane to hold the table
        JScrollPane scrollPane = new JScrollPane(table);
        // Create the main frame
        JFrame frame = new JFrame("Employee Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}