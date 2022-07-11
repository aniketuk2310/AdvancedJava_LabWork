package com.cdac.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("carParts1")
public class CarPartsInventoryImpl1 implements CarPartsInventory {

	public void addnewPart(CarPart carPart) {
		
		Connection conn = null;
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			long ms1 = System.currentTimeMillis();	//it will give current time
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajava","root","cdac");
			long ms2 = System.currentTimeMillis();
			System.out.println("Total time taken for making connection : "+(ms2 - ms1)+ " milliSeconds approx.");
			
			PreparedStatement st = conn.prepareStatement("insert into CarParts(part_name,car_model,price,quantity) values(?,?,?,?)");
			st.setString(1, carPart.getPartName());
			st.setString(2, carPart.getCarModel());
			st.setDouble(3, carPart.getPrice());
			st.setInt(4, carPart.getQuantity());
			st.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e) {}
		}
	}

	public List<CarPart> getAvailableParts() {
		
		return null;
	}

}

//first implementation ==> calculating the approx. time which system takes to create connection in JDBC and to fire the Query for the same

/*
Total time taken for making connection : 786 milliSeconds approx.
Total time taken executing Query : 908 milliSeconds approx.


select * from carparts;
+--------+-----------+------------+-------+----------+
| partno | part_name | car_model  | price | quantity |
+--------+-----------+------------+-------+----------+
|      1 | Wheels    | HONDA City |   100 |        5 |
|      2 | Mirrors   | HONDA City |    50 |        4 |
|      3 | Doors     | HONDA City |   500 |        4 |
+--------+-----------+------------+-------+----------+

*we have one class called CarPart(entity class) having all the fields(columns) info that we have to set as a car parameters...
*then we have one interface called CarPartsInventory which will give the abstract methods that we have to implement in concrete classes 
*i.e, CarPartsInventoryImpl1 and CarPartsInventoryImpl2... 
*we provided the implemtntation in these classes ==> in it we provided the methods for inserting and fetching the data from table called "carparts"
*i.e, we have the JDBC connection in it 
*we are getting the field(column) details to insert into the table by getters that we have setted in the mainApp class by setters

*/