package Model;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
    private String user = "Users";
    private String pass = "bekzod0407";
    private String url = "jdbc:mysql://localhost:8888/SocialMedia";
    private Statement statement;

    public DataBase(){
        try{
            Connection connection = DriverManager.getConnection(url,user,pass);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Statement getStatement(){
        return statement;
    }
}
