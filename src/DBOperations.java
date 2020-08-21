import java.sql.*;

public class DBOperations {
		private final static String url="jdbc:mysql://localhost/hrms2";
		private final static String dbdriver="com.mysql.cj.jdbc.Driver";
		private final static String user="root";
		private final static String password="root@123";
public void SaveStaff(String name,double salary,String email,String address,String phone) {//Create
	try {
		Connection con;
		Class.forName(dbdriver);
		con=DriverManager.getConnection(url, user, password);
		System.out.println("create db conneciton!!");
		if(con!=null) {
			String sql="insert into Staff(Name,Salary,Email,Address,Phone) values(?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setDouble(2, salary);
			pstmt.setString(3, email);
			pstmt.setString(4, address);
			pstmt.setString(5, phone);
			
			int savedRecrod=pstmt.executeUpdate();
			if(savedRecrod>0) {
				System.out.println("new Staff record save successfully!!!");
			}else {
				System.out.println("can't save ,something wrong in your sql query.");
			}
			pstmt.close();
			con.close();
		}
	}catch(Exception e) {
		System.out.println("Error"+e.getMessage());
	}
}
public void SelectStaff() {//Reterive
	try {
		Connection con;
		Class.forName(dbdriver);
		con=DriverManager.getConnection(url, user, password);
		System.out.println("connection create.");
		if(con!=null) {
			String sql="select * from Staff";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			System.out.println("Staff Recrod Here..");
			System.out.println("==============================");
			while(rs.next()) {
				System.out.println("Staff Id:"+rs.getString(1));
				System.out.println("Staff Name:"+rs.getString(2));
				System.out.println("Staff Salary:"+rs.getDouble(3));
				System.out.println("Staff Email:"+rs.getString(4));
				System.out.println("Staff Address:"+rs.getString(5));
				System.out.println("Staff Phone:"+rs.getString(6));
				System.out.println("==============================");
			}
			
			rs.close();
			stmt.close();
			con.close();
		}
	}catch(Exception e) {
		
	}
}
public void UpdateStaff(String name,double salary,String email,String address,String phone,int StaffId) {//Update
	try {
		Class.forName(dbdriver);
		Connection con;
		con=DriverManager.getConnection(url,user,password);
		System.out.println("creat db conneciton");
		if(con!=null) {
			String sql="Update Staff SET Name=?,Salary=?,Email=?,Address=?,Phone=? where StaffId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setDouble(2, salary);
			pstmt.setString(3, email);
			pstmt.setString(4, address);
			pstmt.setString(5, phone);
			pstmt.setInt(6, StaffId);
			int UpdateRecrod=pstmt.executeUpdate();
			if(UpdateRecrod>0) {
				System.out.println("Staff record Update successfully!!!");
			}else {
				System.out.println("can't Update ,something wrong in your sql query.");
			}
			pstmt.close();
			con.close();
		}
			
	}catch(Exception e) {
		System.out.println("Error>>"+e.getMessage());
	}
}


public void DeleteStaff(int StaffId) {//Delete
	try {
		Class.forName(dbdriver);
		Connection con;
		con=DriverManager.getConnection(url,user,password);
		System.out.println("creat db conneciton");
		if(con!=null) {
			String sql="Delete from Staff where StaffId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);		
			pstmt.setInt(1, StaffId);
			int DeleteRecrod=pstmt.executeUpdate();
			if(DeleteRecrod>0) {
				System.out.println("Staff record Delete successfully!!!");
			}else {
				System.out.println("can't Delete ,something wrong in your sql query.");
			}
			pstmt.close();
			con.close();
		}
			
	}catch(Exception e) {
		System.out.println("Error>>"+e.getMessage());
	}
}

}
