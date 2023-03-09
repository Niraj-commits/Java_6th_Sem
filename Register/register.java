package Register;

import javax.swing.*;

public class register {
   
    public register(){

        JFrame title = new JFrame("Register");

        JLabel userName = new JLabel("Full Name: ");
        userName.setBounds(20,20,150,25);
        title.add(userName);

        JTextField user = new JTextField();
        user.setBounds(180,20,150,25);
        title.add(user);

        JLabel email = new JLabel("Email: ");
        email.setBounds(20,55,150,25);
        title.add(email);

        JTextField emailAdd = new JTextField();
        emailAdd.setBounds(180,55,150,25);
        title.add(emailAdd);
        
        JLabel Pass = new JLabel("Password: ");
        Pass.setBounds(20,85,150,25);
        title.add(Pass);

        JTextField pass = new JTextField();
        pass.setBounds(180,85,150,25);
        title.add(pass);

        JLabel cpass = new JLabel("Confirm Password: ");
        cpass.setBounds(20,115,150,25);
        title.add(cpass);
        
        JTextField cPass = new JTextField();
        cPass.setBounds(180,115,150,25);
        title.add(cPass);

        JButton submit = new JButton("Submit");
        submit.setBounds(190,155,90,35);
        title.add(submit);

        title.setSize(500,500);
        title.setLayout(null);
        title.setVisible(true);
    }
    public static void main (String[] args){
        new register();
    }
}
