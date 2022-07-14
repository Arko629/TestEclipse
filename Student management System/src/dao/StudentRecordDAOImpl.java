package dao;

import java.sql.*;
import java.util.Scanner;

import Model.Record;

public class StudentRecordDAOImpl {

	final private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	final private String userName = "system";
	final private String password = "arko";
	
	private Connection connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn;
			conn = DriverManager.getConnection(url,userName,password);
			if(conn!=null) {
				return conn;
			}
		}
		catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void add(Record r) {
		Connection conn = connect();
		if(!find(r.getRoll_no())) {
			try {
				String insert = "insert into student values(?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(insert);
				System.out.println(r.getMobile());
				ps.setInt(1,r.getRoll_no());
				ps.setString(2, r.getName());
				ps.setString(3, r.getMobile());
				ps.setDate(4, Date.valueOf(r.getDoj()));
				
				int rows = ps.executeUpdate();
				
				if(rows>0) {
					System.out.println("Data inserted successfully!");
				}
				
				conn.close();
			}
			catch(SQLException e) {
				System.out.println(e);
			}
		}
		else {
            System.out.println(
                "Record already exists in the Record list");
		}
	}
	
	public boolean find(int roll_no) {
		Connection conn = connect();
		
		try {
			String selectRoll = "select * from student";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(selectRoll);
			
			while(rs.next()) {
				if(roll_no == rs.getInt("roll_no")) {
					System.out.println(rs.getInt("roll_no") +" "+rs.getString("name")+" "+rs.getInt("mobile")+" "+rs.getDate("doj").toString());
					conn.close();
					return true;
				}
			}
			
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return false;
		
	}
	
	public Record findRecord(int roll_no)
    {
 
        // Iterate Record list
		Connection conn = connect();
		
		try {
			String selectRoll = "select * from student";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(selectRoll);
			
			while(rs.next()) {
				if(roll_no == rs.getInt("roll_no")) {
					
					return new Record(rs.getInt("roll_no"),rs.getString("name"),rs.getString("mobile"),rs.getDate("doj").toString());
				}
			}
			conn.close();
			
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return null;
    }
	
	   public void display()
	    {
	        Connection conn = connect();
			
			try {
				String selectRoll = "select * from student";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(selectRoll);
				
					while(rs.next()) {
						System.out.println(rs.getInt("roll_no") +" "+rs.getString("name")+" "+rs.getInt("mobile")+" "+rs.getDate("doj").toString());
					}
				
				
				conn.close();
				
			}
			catch(SQLException e) {
				System.out.println(e);
			}   
	    }
	   
	   public void update(int id, Scanner input)
	    {
		   Connection conn = connect();
			
			try {
				if (find(id)) {
		 
		            // Display message only
		            System.out.print(
		                "What is the new Student id Number ? ");
		            int idNumber = input.nextInt();
		 
		            // Display message only
		            System.out.print(
		                "What is the new Student contact Number? ");
		            int contactNumber = input.nextInt();
		            input.nextLine();
		 
		            // Display message only
		            System.out.print(
		                "What is the new Student Name ? ");
		            String name = input.nextLine();
		            
		            System.out.print(
			                "What is the new Student Joining Date(YYYY-MM-DD) ? ");
		            String d = input.nextLine(); 
		            
		            String updateQuery = "update student set roll_no=?, name=?,mobile=?,doj=? where roll_no=?";
		            PreparedStatement ps = conn.prepareStatement(updateQuery);
					ps.setInt(1,idNumber);
					ps.setString(2, name);
					ps.setString(3, String.valueOf(contactNumber));
					ps.setDate(4, Date.valueOf(d));
					ps.setInt(5,id);
		            
		            int rows = ps.executeUpdate();
		            if(rows>0) {
		            	System.out.println(
				                "Record Updated Successfully");
		            }
		            
		            conn.close();
		        }
		        else {
		 
		            // Print statement
		            System.out.println(
		                "Record Not Found in the Student list");
		        }
				
				
				conn.close();
				
			}
			catch(SQLException e) {
				System.out.println(e);
			} 
	 
	        
	    }
	   public void delete(int recIdNumber)
	    {
	        
	        Record recordDel = findRecord(recIdNumber);
	        if(recordDel==null) {
	        	System.out.println("Invalid Record ID!");
	        }
	        else {
	        	Connection conn = connect();
				
				try {
					String delete = "delete from student where roll_no=?";
					PreparedStatement st3 = conn.prepareStatement(delete);
					st3.setInt(1,recIdNumber);
					
					int rows2 = st3.executeUpdate();
					if(rows2>0) {
						System.out.println("Deleted info");
					}
					conn.close();
					
				}
				catch(SQLException e) {
					System.out.println(e);
				}
	        }
	    }
	
}
