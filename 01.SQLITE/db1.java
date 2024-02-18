package sqllitedemo;
import java.sql.*;
import java.util.*;
public class db1 {

	public static void main(String[] args) throws Exception {
		
		while(true) {
			Class.forName("org.sqlite.JDBC");
			Connection con=DriverManager.getConnection("jdbc:sqlite:/c:\\Users\\balaganapathi\\OneDrive\\Documents\\bala\\sql\\bala.db\\");
			
			Statement stmt=con.createStatement();
			
			PreparedStatement st;
			int id,age,c;
			String name,city;
			System.out.print("1.create\n");
			System.out.print("2.read\n");
			System.out.print("3.update\n");
			System.out.println("4.Delete");
			System.out.print("5.Exit");
			Scanner sc=new Scanner(System.in);
			Scanner t=new Scanner(System.in);
			c=sc.nextInt();
			ResultSet r ;
		switch(c){
		
		case 1:
			System.out.print("name");
			name=t.nextLine();
			System.out.print("age");
			age=sc.nextInt();
			System.out.print("city");
			city=t.nextLine();
			String qu="insert into user(NAME,AGE,CITY) values(?,?,?)";
			st=con.prepareStatement(qu);
			st.setString(1, name);
			st.setInt(2,age);
			st.setString(3, city);
			st.executeUpdate();
			System.out.print("created successfully\n");
			break;
		case 2:
			String qur="SELECT ID,NAME,AGE,CITY From user";
			r=stmt.executeQuery(qur);
			while(r.next()) {
				
				id=r.getInt("ID");
				name=r.getString("NAME");
				age=r.getInt("AGE");
				city=r.getString("CITY");
				System.out.print("----------------------------------\n");			
				System.out.print(id+" ");
				System.out.print(name+" ");
				System.out.print(age+" ");
				System.out.println(city+" ");

				
			}
			System.out.print("----------------------------------\n");
			System.out.print("selected succesfully\n");
			break;
		case 3:
			System.out.print("ID");
			id=sc.nextInt();
			System.out.print("name");
			name=t.nextLine();
			System.out.print("age");
			age=sc.nextInt();
			System.out.print("city");
			city=t.nextLine();
			String q="update user set NAME=?,AGE=?,CITY=? where ID=?";
			st=con.prepareStatement(q);
			st.setString(1, name);
			st.setInt(2,age);
			st.setString(3, city);
			st.setInt(4,id);
			st.executeUpdate();
			System.out.print("updated succesfully");
			break;
		case 4:
			System.out.print("ID");
			id=sc.nextInt();
			st=con.prepareStatement("DELETE FROM USER WHERE id=?");
			st.setInt(1,id);
			st.executeUpdate();
			System.out.println("deleted succesfully");
			break;
		case 5:
			System.exit(0);
		default:
			System.out.print("enter crct value\n");
			break;
		}

		stmt.close();
		con.close();
		}
		
		
		
	}

}
