package jp.co.aforce.beans;

import java.io.Serializable;

/* クラス定義
 * 「Login」クラスは「Serializable」インターフェースを実装している
 * から、シリアライズできる。
 * これを使うと、このクラスのオブジェクトをネットワークとかファイルに
 * 保存しやすくなる。
 */
public class Login implements Serializable {
	/* フィールド（変数）宣言
	 * このクラスは3つのフィールドを持っている。
	 * 「id」（整数）、ユーザー名「username」、パスワード「password」。
	 */
	private int id;
	private String username;
	private String password;

	/* ゲッター（取得）メソッド
	 * このメソッドたちは外部からそれぞれのフィールドの値を
	 * 取得するためのもの。
	 * 例えば、「getId()」は「id」の値を返す。
	 */
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	/* セッター（設定）メソッド
	 * このセットメソッドたちは外部からフィールドの値を設定する
	 * ためのもの。
	 * 「setId(int id)」で「id」の値を更新することができる。
	 */
	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}