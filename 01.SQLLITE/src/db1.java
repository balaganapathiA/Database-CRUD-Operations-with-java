
import java.sql.*;
import java.util.*;
public class db1 {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		Scanner t=new Scanner(System.in);
		while(true) {
			Class.forName("org.sqlite.JDBC");
			Connection con=DriverManager.getConnection("jdbc:sqlite:/c:\\Users\\balaganapathi\\OneDrive\\Documents\\bala\\sql\\bala.db\\");
			
			Statement stmt=con.createStatement();
			
			PreparedStatement st;
			int id,age,c;
			String name,city;
			System.out.print("1.Create\n");
			System.out.print("2.Read\n");
			System.out.print("3.Update\n");
			System.out.println("4.Delete");
			System.out.print("5.Exit\n");
			System.out.print("Enter your choice(1-5):");
			c=sc.nextInt();
			ResultSet r ;
			System.out.print("----------------------------------\n");			
		switch(c){
		
		case 1:
			System.out.print("Enter the Name: ");
			name=t.nextLine();
			System.out.print("Enter the Age: ");
			age=sc.nextInt();
			System.out.print("Enter the City: ");
			city=t.nextLine();
			String qu="insert into user(NAME,AGE,CITY) values(?,?,?)";
			st=con.prepareStatement(qu);
			st.setString(1, name);
			st.setInt(2,age);
			st.setString(3, city);
			st.executeUpdate();
			System.out.print("\n");
			System.out.print("created successfully..\n");
			break;
		case 2:
			String qur="SELECT ID,NAME,AGE,CITY From user";
			r=stmt.executeQuery(qur);
			while(r.next()) {
				
				id=r.getInt("ID");
				name=r.getString("NAME");
				age=r.getInt("AGE");
				city=r.getString("CITY");
				System.out.print(id+" ");
				System.out.print(name+" ");
				System.out.print(age+" ");
				System.out.println(city+" ");

				System.out.print("\n");
				
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
			String q="update user set NAME=?,AGE=?,CITY=? where ID=?";
			st=con.prepareStatement(q);
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
			st=con.prepareStatement("DELETE FROM USER WHERE id=?");
			st.setInt(1,id);
			st.executeUpdate();
			System.out.print("deleted succesfully..\n");
			break;
		case 5:
			System.out.println("Thank You..\n");
			sc.close();
			t.close();
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
