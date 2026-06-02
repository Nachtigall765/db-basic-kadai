package kadai_004;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Employees_Chapter04 {

	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/challenge_java";
        String user = "root";
        String password = "7n08432Gsou1";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("データベース接続成功：" + con);

            Statement stmt = con.createStatement();

            String sql =
                    "CREATE TABLE employees (" +
                    "id INT(11) NOT NULL AUTO_INCREMENT," +
                    "name VARCHAR(60) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "age INT(11)," +
                    "address VARCHAR(255)," +
                    "PRIMARY KEY(id)" +
                    ")";

            int result = stmt.executeUpdate(sql);

            System.out.println("社員テーブルを作成しました：更新レコード数=" + result);

            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


