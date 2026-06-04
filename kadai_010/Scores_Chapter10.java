package kadai_010;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Scores_Chapter10 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/challenge_java";
        String user = "root";
        String password = "7n08432Gsou1";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("データベース接続成功：" + con);

            Statement stmt = con.createStatement();

            System.out.println("レコード更新を実行します");

            String updateSql =
                    "UPDATE scores SET score_math = 95, score_english = 80 WHERE id = 5";

            int result = stmt.executeUpdate(updateSql);

            System.out.println(result + "件のレコードが更新されました");

            String selectSql =
                    "SELECT id, name, score_math, score_english FROM scores "
                    + "ORDER BY score_math DESC, score_english DESC";

            ResultSet rs = stmt.executeQuery(selectSql);

            System.out.println("数学・英語の点数が高い順に並べ替えました");

            int count = 1;

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int scoreMath = rs.getInt("score_math");
                int scoreEnglish = rs.getInt("score_english");

                System.out.println(count + "件目：生徒ID=" + id
                        + "/氏名=" + name
                        + "/数学=" + scoreMath
                        + "/英語=" + scoreEnglish);

                count++;
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}