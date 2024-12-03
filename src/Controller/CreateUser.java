package Controller;

import Model.DataBase;
import Model.User;
import View.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreateUser {
    private User u;
    private DataBase database;

    public CreateUser(User u, DataBase database){
        this.u = u;
        this.database = database;
    }

    public void create(){
        String insert = "INSERT INTO `Users`(`ID`, `FirstName`, `LastName`, `Email`, " +
                "`Password`) VALUES ('"+u.getFirstName()+"','"+u.getLastName()+"'," +
                "'"+u.getEmail()+"','"+u.getPassword()+"');";
        try{
            database.getStatement().execute(insert);
        }catch(SQLException e){
            new Alert(e.getMessage(),null);
        }
    }

    public boolean isEmailUsed(){
        String select = "SELECT * FROM `Users` WHERE `Email` = '"+u.getEmail()+"';";
        boolean used = false;
        try{
            ResultSet rs = database.getStatement().executeQuery(select);
            used = rs.next();
        }catch (SQLException e){
            new Alert(e.getMessage(), null);
        }
        return used;
    }

    public User getUser(){
        u.setComments(new ArrayList<>());
        u.setFriends(new ArrayList<>());
        u.setLikes(new ArrayList<>());
        u.setPosts(new ArrayList<>());
        String select = "SELECT `ID` FROM `Users` WHERE `Email` = '"+u.getEmail()+"' AND `Pssword` = '"+u.getPassword()+"';";
        try{
            ResultSet rs = database.getStatement().executeQuery(select);
            rs.next();
            u.setID(rs.getInt("ID"));
        }catch (SQLException e){
            new Alert(e.getMessage(), null);
        }
        return u;
    }
}
