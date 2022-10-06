import java.sql.*;
import java.util.Scanner;

public class JDBC {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        try {
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-lab", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while(resultSet.next()) {
                System.out.print(resultSet.getInt("sid")+" ");
                System.out.print(resultSet.getString("name")+" ");
                System.out.print(resultSet.getString("dept")+ " ");
                System.out.println();
            }
            System.out.println("-----------------------------------");

            PreparedStatement preparedStatement;
            for(int i = 0; i < 1; ++i) {
                System.out.println("Please enter your name");
                String name = sc.nextLine();
                System.out.println("Please enter your department");
                String dept = sc.nextLine();
                String s = "insert into student(name, dept) VALUES (?, ?)";
                preparedStatement = connection.prepareStatement(s);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, dept);
                preparedStatement.executeUpdate();
            }

            resultSet = statement.executeQuery("select * from student");

            while(resultSet.next()) {
                System.out.print(resultSet.getInt("sid")+" ");
                System.out.print(resultSet.getString("name")+" ");
                System.out.print(resultSet.getString("dept")+ " ");
                System.out.println();
            }
            connection.close();
        }
        catch (Exception e) {
             System.out.println(e);
        }

    }
}
