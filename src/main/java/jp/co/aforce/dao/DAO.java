package jp.co.aforce.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	/* フィールド宣言
	 * ここでは静的（static）な「DataSource」という変数「ds」
	 * が宣言されている。
	 * 静的だから、このクラスの全インスタンスで共有される。
	 */
	static DataSource ds;

	/* getConnection メソッド
	 * 「getConnection」メソッド。
	 * データベースとの接続を取得するためのメソッド。
	 */
	public Connection getConnection() throws Exception {
		/* 最初に「ds」がnullかどうかをチェックしている。
		 * 初めてこのメソッドが呼ばれたときは「ds」はまだ何も
		 * 持ってないからnull。
		 */
		if (ds == null) {
			/* 次に、新しい「InitialContext」オブジェクトを
			 * 作成している。
			 * これはJNDI（Java Naming and Directory Interface）
			 * の一部で、特定のリソース（この場合はデータベース接続）
			 * への参照を取得するときに使う。
			 */
			InitialContext ic = new InitialContext();
			/* コンテクストを使って、JNDIの名前
			 * 「java:/comp/env/jdbc/login_db」で登録されている
			 * データソースを探して、それを「ds」に保存してる。
			 */
			ds = (DataSource) ic.lookup("java:/comp/env/jdbc/login_db");
		}
		/* 最後にその「ds」からデータベースとの接続を取得して、
		 * それを返してる。
		 */
		return ds.getConnection();
	}

}