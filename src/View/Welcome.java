package View;

import Controller.CreateUser;
import Model.User;
import Model.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextField;

public class Welcome {
    public Welcome(DataBase database){
        JFrame frame = new JFrame();

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(53,84,76,84));
        panel.add(new JLabel("Welcome to QUICK LETTER Platform", 40, GUIconstants.blue, Font.BOLD), BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(6, 1, 10, 10));
        center.setBackground(null);
        center.setBorder(BorderFactory.createEmptyBorder(22, 231, 17, 231));
        JTextField firstName = new View.JTextField("First Name");
        center.add(firstName);
        JTextField lastName = new View.JTextField("Last Name");
        center.add(lastName);
        JTextField email = new View.JTextField("E-Mail");
        center.add(email);
        JTextField password = new View.JTextField("Password");
        center.add(password);
        JTextField confirmPassword = new View.JTextField("Confirm Password");
        center.add(confirmPassword);
        JButton createACC = new JButton("Create Account", 45, 20);

        createACC.addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                if (firstName.getText().isEmpty()) {
                    new Alert("First Name cannot be empty", frame);
                    return;
                }
                if (lastName.getText().isEmpty()) {
                    new Alert("Last Name cannot be empty", frame);
                    return;
                }
                if (email.getText().isEmpty()) {
                    new Alert("E-mail cannot be empty", frame);
                    return;
                }
                if (password.getText().isEmpty()) {
                    new Alert("Password cannot be empty", frame);
                    return;
                }
                if (password.getText().length() < 6) {
                    new Alert("Password must contain at least 6 characters", frame);
                    return;
                }
                if (confirmPassword.getText().isEmpty()) {
                    new Alert("Please, confirm password", frame);
                    return;
                }
                if (!password.getText().equals(confirmPassword.getText())) {
                    new Alert("Password does not match", frame);
                    return;
                }
                User u = new User();
                u.setFirstName(firstName.getText());
                u.setLastName(lastName.getText());
                u.setEmail(email.getText());
                u.setPassword(password.getText());
                CreateUser create = new CreateUser(u, database);
                if(!create.isEmailUsed()){
                    create.create();
                    u = create.getUser();
                    new Alert("Account created successfully, ID: "+ u.getID(), frame);
                }else {
                    new Alert("This email has been used before", frame);
                }
            }
        });

        center.add(createACC);

        panel.add(center, BorderLayout.CENTER);

        JLabel login = new JLabel ("Already have an account? Login", 20, GUIconstants.black, Font.BOLD);
        login.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Login(database);
                frame.dispose();
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.setHorizontalAlignment(JLabel.CENTER);
        panel.add(login, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);

        frame.setVisible(true);
        frame.requestFocus();




    }
}
