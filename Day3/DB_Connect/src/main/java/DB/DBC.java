package DB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DBC")
public class DBC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		String pressed = request.getParameter("button");
		PrintWriter out = response.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wpj", "root", "cdac");
			DBC c = new DBC();

			// selecting data

			if (pressed.equals("Select")) {
				PreparedStatement st = con
						.prepareStatement("select username,password from DBC where username=? and password=?");
				st.setString(1, username);
				st.setString(2, password);
				st.execute();
//				String sql = "select username,password from DBC";
//				Statement st = con.createStatement();
//				ResultSet rs = st.executeQuery(sql);
//				while(rs.next()) {
//						System.out.println(rs.getString("username"));
//				}

				boolean result = c.check(username, password);
				if (result)
					out.write("<h1>Exists</h1>");
				else
					out.println("<h1>Not Exists</h1>");
			}

			// inserting data

			if (pressed.equals("Insert")) {
				boolean result = c.check(username, password);
				if (result) {
					out.write("<h1>Cannot insert..!!</h1>");
				} else {
					PreparedStatement st = con.prepareStatement("insert into DBC ( username , password )values(?,?)");
					st.setString(1, username);
					st.setString(2, password);
					st.execute();

					out.write("<h1>Inserted Sucessfully..!!</h1>");
				}
			}

			// updating data

			if (pressed.equals("Update")) {
				boolean result = c.checkUsername(username);
				if (result) {
					PreparedStatement st = con.prepareStatement("update DBC set password=? where username = ?");
					st.setString(1, password);
					st.setString(2, username);
					st.execute();

					out.write("<h1>Updated Sucessfully..!!</h1>");
				} else {
					out.write("<h1>Cannot update..!!</h1>");
				}
			}

			// deleting data

			if (pressed.equals("Delete")) {
				boolean result = c.check(username, password);
				if (result) {
					PreparedStatement st = con.prepareStatement("delete from DBC where username = ? and password = ?");
					st.setString(1, username);
					st.setString(2, password);
					st.execute();

					out.write("<h1>Deleted Sucessfully..!!</h1>");
				} else {
					out.write("<h1>Cannot Deleted..!!</h1>");
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

//	checking if username really exists or not for updating the data

	private boolean checkUsername(String username) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wpj", "root", "cdac");

			String sql = "select username,password from DBC";
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery(sql);

			while (rs.next()) {
				if (rs.getString("username").equals(username)) {
//					System.out.println(rs.getString("username"));
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

//	checking if username and password really exists or not for selecting,inserting,deleting the data

	private boolean check(String username, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wpj", "root", "cdac");

			String sql = "select username,password from DBC";
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery(sql);

			while (rs.next()) {
				if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
//					System.out.println(rs.getString("username"));
//					System.out.println(rs.getString("password"));
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
