

import java.sql.*;
import java.util.*;
public class mysql {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
      
		
		while(true) {
			  Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/bala?characterEncoding=utf8";
				String username="root"; 
				String pass="bala@123";
				Connection con = DriverManager.getConnection(url,username,pass);
				
				Statement stmt=con.createStatement();
				ResultSet r ;
				PreparedStatement st;
				
				int id,age,c;
				String name,city;
			Scanner sc=new Scanner(System.in);
			Scanner t=new Scanner(System.in);
			System.out.print("1.Create\n");
			System.out.print("2.Read\n");
			System.out.print("3.Update\n");
			System.out.println("4.Delete");
			System.out.println("5.Exit");
			System.out.print("Enter your choice(1-5):");
			c=sc.nextInt();
			System.out.print("----------------------------------\n");	
		switch(c){
		
		case 1:
			System.out.print("Enter the Name: ");
			name=t.nextLine();
			System.out.print("Enter the Age: ");
			age=sc.nextInt();
			System.out.print("Enter the City: ");
			city=t.nextLine();
			String q="insert into users(NAM,AGE,CITY) values(?,?,?)";
			st=con.prepareStatement(q);
			st.setString(1, name);
			st.setInt(2,age);
			st.setString(3, city);
			st.executeUpdate();
			System.out.print("\n");
			System.out.print("created successfully..\n");
			break;
		case 2:
			String qur="SELECT ID,NAM,AGE,CITY From users";
			r=stmt.executeQuery(qur);
			while(r.next()) {
				
				id=r.getInt("ID");
				name=r.getString("NAM");
				age=r.getInt("AGE");
				city=r.getString("CITY");
						
				System.out.print(id+" ");
				System.out.print(name+" ");
				System.out.print(age+" ");
				System.out.println(city+" ");
				System.out.println(" ");

				
			}
			System.out.print("selected succesfully..\n");
			break;
		case 3:
			System.out.print("Enter the ID you want to update: ");
			id=sc.nextInt();
			System.out.print("Enter the Name: ");
			name=t.nextLine();
			System.out.print("Enter the Age: ");
			age=sc.nextInt();
			System.out.print("Enter the City: ");
			city=t.nextLine();
			st=con.prepareStatement("update users set NAM=?,AGE=?,CITY=? where ID=?");
			st.setString(1, name);
			st.setInt(2,age);
			st.setString(3, city);
			st.setInt(4,id);
			st.executeUpdate();
			System.out.print("\n");
			System.out.print("updated succesfully..\n");
			break;
		case 4:
			System.out.print("Enter the ID you want to Delete: ");
			id=sc.nextInt();
			st=con.prepareStatement("DELETE FROM USERS WHERE id=?");
			st.setInt(1,id);
			st.executeUpdate();
			System.out.println("\n");
			System.out.println("deleted succesfully..\n");
			break;
		case 5:
			System.out.println("Thank You..\n");
			System.exit(0);
		default:
			System.out.print("Enter your choice From(1-5)\n");
			break;
		}
		System.out.print("----------------------------------\n");

		stmt.close();
		con.close();
		
		}
	}

}
