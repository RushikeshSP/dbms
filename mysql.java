package com.mysql;

import java.sql.*;
import java.util.Scanner;

public class DBMS {

	public static void main(String[] args) {
		try {
			// Create a Connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/dbms";
			String user = "root";
			String pass = "Rushi";
			Connection conn = DriverManager.getConnection(url, user, pass);

			// Create Queries
			int ch;
			String query;
			String name;
			String newName;
			int rollno;
			Scanner sc = new Scanner(System.in);

			// Create Statement
			Statement s = conn.createStatement();

			do {
				System.out.print("Enter Your Choice:\n0. For Exit\n1. For Insert\n2. For Select\n3. "
						+ "For Update\n4. For Delete\nChoice = ");
				ch = sc.nextInt();

				switch (ch) {
				case 0:
					System.out.println("Thank You !!!");
					break;
				case 1:
					System.out.print("Enter Student Name: ");
					sc.nextLine();
					name = sc.nextLine();
					
					System.out.print("Enter Student Roll No: ");
					rollno = sc.nextInt();
					
					query = "insert into student values ('" + name + "', " + rollno + ")";
					s.executeUpdate(query);
					
					System.out.println("Record Inserted Successfully.");
					break;
				case 2:
					System.out.println("All the Records From student table are: ");
					
					query = "select * from student";
					ResultSet rs = s.executeQuery(query);
					
					System.out.println("Name\tRollno");
					while (rs.next()) {
						System.out.println(rs.getString("name") + "\t" + rs.getInt("rollno"));
					}
					break;
				case 3:
					System.out.println("Enter Name Which You Want to Update: ");
					sc.nextLine();
					name = sc.nextLine();
					
					System.out.println("Enter new Name: ");
					newName = sc.nextLine();
					
					query = "update student set name = '" + newName + "' where name = '" + name + "'";
					s.executeUpdate(query);
					
					System.out.println("Record Updated Successfully.");
					break;
				case 4:
					System.out.println("Enter Name Which You Want to Delete: ");
					sc.nextLine();
					name = sc.nextLine();
					
					query = "delete from student where name = '" + name + "'";
					s.executeUpdate(query);
					
					System.out.println("Record Deleted Successfully.");
					break;
				default:
					System.out.println("Please Enter a valid Choice.");
					break;
				}

			} while (ch != 0);

			// Close Connection
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
