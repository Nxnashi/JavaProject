package View;

import Controller.ReadUser;
import Model.DataBase;
import Model.User;

import javax.swing.*;
import javax.swing.JTextField;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Login {

    public Login(DataBase database){
        JFrame frame = new JFrame();

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(115,0,182,0));

        JLabel title = new JLabel("Login", 40, GUIconstants.blue, Font.BOLD);
        title.setHorizontalAlignment(JLabel.CENTER);
        panel.add(title, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(3,1,10,10));
        center.setBackground(null);
        center.setBorder(BorderFactory.createEmptyBorder(34,315,17,315));
        JTextField email = new JTextField("Email");
        center.add(email);
        JTextField password = new JTextField("Password");
        center.add(password);
        JButton login = new JButton("Login", 45,20);
        login.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(email.getText().isEmpty()){
                    new Alert("Email can not be empty",frame);
                    return;
                }
                if (password.getText().isEmpty()){
                    new Alert("Password can not be empty", frame);
                    return;
                }
                ReadUser read = new ReadUser(email.getText(), password.getText(), database);
                if (read.loggedIn()){
                    User user = read.getUser();
                    new Alert("Logged in successfully, ID: " + user.getID(), frame);
                }else {
                    new Alert("Incorrect email or password", frame);
                }
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
        center.add(login);

        panel.add(center,BorderLayout.CENTER);

        JLabel createAcc = new JLabel("Do not have an account? Create new one", 20, GUIconstants.black,Font.BOLD);
        createAcc.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Welcome(database);
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
        createAcc.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createAcc.setHorizontalAlignment(JLabel.CENTER);
        panel.add(createAcc,BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.requestFocus();

    }
}
