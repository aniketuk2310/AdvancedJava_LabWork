package com.cdac.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("carParts2")
public class CarPartsInventoryImpl2 implements CarPartsInventory {

	@Override
	public void addnewPart(CarPart carPart) {
		
		Connection conn  = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			long t1 = System.currentTimeMillis();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajava","root","cdac");
			long t2 = System.currentTimeMillis();
			System.out.println("approx. time taken to obtain connection from Connection pool : "+(t2-t1));
			
			PreparedStatement st = conn.prepareStatement("insert into carparts(part_name,car_model,price,quantity) values(?,?,?,?)");
			st.setString(1, carPart.getPartName());
			st.setString(2, carPart.getCarModel());
			st.setDouble(3, carPart.getPrice());
			st.setInt(4, carPart.getQuantity());
			st.execute();
		}catch(Exception e) {
			try {
				conn.close();
			}catch(Exception e1) {}
		}
		
	}

	@Override
	public List<CarPart> getAvailableParts() {
		
		return null;
	}

}


/*
implementation-2

select * from carparts;
+--------+-------------+------------+-------+----------+
| partno | part_name   | car_model  | price | quantity |
+--------+-------------+------------+-------+----------+
|      1 | Wheels      | HONDA City |   100 |        5 |
|      2 | Mirrors     | HONDA City |    50 |        4 |
|      3 | Doors       | HONDA City |   500 |        4 |
|      6 | engine      | Altroz     |  1000 |        1 |
|      7 | seatcovers  | Altroz     |   800 |       10 |
|      8 | Head Lights | Altroz     |  1200 |       50 |
+--------+-------------+------------+-------+----------+

//before

1)first part

approx. time taken to obtain connection from Connection pool : 744
Total time taken executing Query : 960 milliSeconds approx.

//after

2)2nd part

approx. time taken to obtain connection from Connection pool : 108
Total time taken executing Query : 255 milliSeconds approx.

3)3rd part

approx. time taken to obtain connection from Connection pool : 39
Total time taken executing Query : 216 milliSeconds approx.

*/