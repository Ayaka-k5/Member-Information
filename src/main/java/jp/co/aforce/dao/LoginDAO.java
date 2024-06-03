package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Login;

/* クラス定義
 * これは「DAO」を継承してると宣言してる。
 * これで「DAO」のメソッド、特に「getConnection」メソッドを
 * 使えるようになる。
 */
public class LoginDAO extends DAO {
	/* searchメソッド
	 * このメソッドは、ユーザー名とパスワードを使ってログイン情報を
	 * 探し出すメソッド。
	 * まず、空の「Login」オブジェクトを作っておく。
	 */
	public Login search(String username, String password)
			throws Exception {
		Login login = null;

		/* ここで「getConnection」を使って、データベースとの接続を
		 * 取ってくる。
		 */
		Connection con = getConnection();

		/* まず、プリペアドステートメント（「PreparedStatement」）を
		 * 作る。
		 * これでSQL文を用意する。
		 * 「SELECT * FROM Login WHERE username= ? and password= ?」
		 * というSQL文を準備して、その「?」の部分に引数として
		 * 渡されてきた「username」と「password」をセットする。
		 * このステートメントを実行して「ResultSet」として結果を
		 * もらう。
		 */
		PreparedStatement st;
		st = con.prepareStatement(
				"SELECT * FROM Login WHERE username= ? and password= ?");
		st.setString(1, username);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		/* もし結果があったら、ループの中で新しい
		 * 「Login」オブジェクトを作成して、その中に結果をセットする。
		 * 「rs.getInt("id")」、「rs.getString("username")」、
		 * 「rs.getString("password")」で、それぞれのカラムの値を
		 * 取得して「Login」オブジェクトにセットする。
		 */
		while (rs.next()) {
			login = new Login();
			login.setId(rs.getInt("id"));
			login.setUsername(rs.getString("username"));
			login.setPassword(rs.getString("password"));
		}

		/* 最後に、使ったステートメントと接続を閉じる。
		 * これでリソースをきちんと解放できる。
		 * 「login」オブジェクトを返して、このメソッドは終了。
		 */
		st.close();
		con.close();
		return login;
	}

}