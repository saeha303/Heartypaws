package server;
import java.sql.*;
public class OracleConnect {
    private Connection connection;
    private static final String host = "localhost";
    private static final String dbname = "orcl";
    private static final String username = "hearty_paws";
    private static final String password = "hearty_paws";
    private static final String port = "1539";

    public OracleConnect() throws Exception {
//        Class.forName("oracle.jdbc.driver.OracleDriver");
//        String url = "jdbc:oracle:thin:@//" + host + ":" + port + "/" + dbname;
//        System.out.println(url);
        this.connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/orcl",username,password);

//        System.out.println("Connected");
    }

    public int updateDB(String query) throws Exception {
        Statement statement = this.connection.createStatement();
        return statement.executeUpdate(query);
    }

    public ResultSet searchDB(String query) throws Exception {
        Statement statement = this.connection.createStatement();
        return statement.executeQuery(query);
    }

    public void close() throws Exception {
        this.connection.close();
    }
}