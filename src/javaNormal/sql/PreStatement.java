package javaNormal.sql;

import java.sql.*;

public class PreStatement {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql = "INSERT INTO test VALUES(\"1\",\"1\") ";
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8","root", "admin");
            Statement s = c.createStatement();
            PreparedStatement ps = c.prepareStatement(sql);){
            for(int i = 0; i < 1000; i++){
                s.execute(sql);
            }
        }catch (SQLException e){
            e.getErrorCode();
            e.printStackTrace();
        }
    }
}
