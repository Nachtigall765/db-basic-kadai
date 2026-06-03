package kadai_007;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Posts_Chapter07 {

	public static void main(String[] args) {
		
			String url = "jdbc:mysql://localhost:3306/challenge_java";
	        String user = "root";
	        String password = "7n08432Gsou1";

	        try {
	            Connection con = DriverManager.getConnection(url, user, password);

	            System.out.println("データベース接続成功：" + con);

	            Statement stmt = con.createStatement();

	            String insertSql =
	            		"INSERT INTO posts(user_id, posted_at, post_content, likes) VALUES "
	            		+ "(1003,'2023-02-08','昨日の夜は徹夜でした・・',13),"
	            		+ "(1002,'2023-02-08','お疲れ様です！',12),"
	            		+ "(1003,'2023-02-09','今日も頑張ります！',18),"
	            		+ "(1001,'2023-02-09','無理は禁物ですよ！',17),"
	            		+ "(1002,'2023-02-10','明日から連休ですね！',20)";
	                    
	            int result = stmt.executeUpdate(insertSql);

	            System.out.println("レコード追加を実行します");
	            System.out.println(result + "件のレコードが追加されました");
	            
	            String selectSql =
	            	    "SELECT posted_at, post_content, likes FROM posts WHERE user_id = 1002";

	            	ResultSet rs = stmt.executeQuery(selectSql);

	            	System.out.println("ユーザーIDが1002のレコードを検索しました");

	            	int count = 1;

	            	while (rs.next()) {
	            	    Date postedAt = rs.getDate("posted_at");
	            	    String postContent = rs.getString("post_content");
	            	    int likes = rs.getInt("likes");

	            	    System.out.println(count + "件目：投稿日=" + postedAt
	            	            + "/投稿内容=" + postContent
	            	            + "/いいね数=" + likes);

	            	    count++;
	            	}

	            stmt.close();
	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    

	}

}
