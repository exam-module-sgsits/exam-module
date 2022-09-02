package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	final String url = "jdbc:mysql://localhost:3306/exam_module";
    final String uname = "root";
    final String pass = "";
    final String query = "SELECT `id`, `password`, `name`, `role` FROM `users` WHERE id = ? AND password = ?;"; 
	public boolean check(int id,String password,String nameNrole[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				nameNrole[0] = rs.getString("name");
				nameNrole[1] = rs.getString("role");
				return true;
			}
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
        return false;
	}
}
