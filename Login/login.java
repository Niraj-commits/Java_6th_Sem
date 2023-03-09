package Login;

import javax.swing.*;

public class login {

    public login(){
        JFrame f = new JFrame("Login");
        JLabel user = new JLabel("Username");

        user.setBounds(20,20,150,25);
        f.add(user);

        JTextField userInput = new JTextField();
        userInput.setBounds(180,20,150,25);
        f.add(userInput);

        JLabel pass = new JLabel("Password");
        pass.setBounds(20,55,150,25);
        f.add(pass);
        
        JTextField passField = new JTextField();
        passField.setBounds(180,55,150,25);
        f.add(passField);

        JButton b1 = new JButton();
        b1.setText("Login");
        b1.setBounds(180,90,150,25);
        f.add(b1);

        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new login();
    }
}