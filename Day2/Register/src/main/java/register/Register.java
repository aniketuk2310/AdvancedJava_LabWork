// JDBC ==> INSERTING and selecting from TABLE 

package register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//requesting parameters from the browser
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		long mobno = Integer.parseInt(request.getParameter("mobno"));
		String username = request.getParameter("uname");
//		String password = request.getParameter("pass");
		
//											Assignment Question 1	(Day2)
		
		//encoding and decoding the password and ==> storing encoded password to the database

		String password = request.getParameter("pass");
		String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		System.out.println(encodedPassword);// printed encoded password
		
		byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
		String decodedPassword = new String(decodedBytes);
		System.out.println(decodedPassword);// printed decoded password
		

		PrintWriter out = response.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	//searching for the driver of mysql
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wpj", "root", "cdac");	//making connection with mysql database

			boolean checked = checkEmail(email, username);	//checking if email and password already exists into the database(peventing duplicates)
			
			if (!checked) {	//if false(if no duplicates) then insert into table
				PreparedStatement st = conn.prepareStatement("insert into customer(name,email,mobile_number,username,password) values(?,?,?,?,?)");
				st.setString(1, name);
				st.setString(2, email);
				st.setLong(3, mobno);
				st.setString(4, username);
//				st.setString(5, password);
				st.setString(5, encodedPassword);
				st.executeUpdate();
				conn.close();

				out.write("<html><body>");
				out.write("<h1>Inserted Successfully..!!</h1>");
				out.write("</body></html>");
			} 
			else {	//if true then cannot insert into table
				out.write("<html><body>");
				out.write("<h1>Insertion Failed..Invalid data!!</h1>");
				out.write("</body></html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
//											Assignment question 2	(Day 2)
	
	private boolean checkEmail(String email, String username) throws ClassNotFoundException {
//		System.out.println("checkEmail called1");
		
		String sql = "select email, username, password from customer";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wpj", "root", "cdac");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
//				System.out.println("checkEmail called2");
				if (rs.getString("email").equals(email) || rs.getString("username").equals(username)) {
//					System.out.println("checkEmail called3");

					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
