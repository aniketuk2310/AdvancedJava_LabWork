package DBS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DB_servlet")
public class DB_servlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wpj","root","cdac");
//			PreparedStatement st = conn.prepareStatement("select * from customer");
			PreparedStatement st = conn.prepareStatement("select * from DBCServlet");
			ResultSet results = st.executeQuery();
			while(results.next()) {
				int id = results.getInt(1);
				String username = results.getString("username");
				String password = results.getString("password");
				System.out.println("ROW : "+id+ ", Username : "+username+", Password : "+password);
			}
//			DBTablePrinter.printTable(conn,"customer");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}


/*
ROW : 1, Username : Aniket, Password : Kale
ROW : 2, Username : Sanket, Password : Kale
 * */
