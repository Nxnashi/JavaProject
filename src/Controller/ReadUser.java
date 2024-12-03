package Controller;
import Model.DataBase;
import Model.User;
import View.Alert;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadUser {

    private boolean loggedIn;
    private User user;
    public ReadUser(String email, String password, DataBase database){
        String select = "SELECT * FROM `Users` WHERE `Email` = '"+email+ "' AND `Password` = '"+password+"';";
        try{
            ResultSet rs = database.getStatement().executeQuery(select);
            loggedIn = rs.next();
            if (loggedIn){
                user = new User();
                user.setID(rs.getInt("ID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
            }
        }catch (SQLException e ){
            new Alert(e.getMessage(), null);
        }
    }

    public boolean loggedIn(){
            return loggedIn;
    }

    public User getUser(){
        return user;
    }
}
