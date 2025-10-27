import java.sql.*;

public class Program {
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        String username = "postgres";
        String password = "password";
        String url = "jdbc:postgresql://localhost:5432/tracker";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
