package jp.co.aforce.loginServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.beans.Login;
import jp.co.aforce.dao.LoginDAO;

/* アノテーション
 * これで、このサーブレットが「/loginServlet」というURLで
 * アクセスできるようになっている。
 */
@WebServlet("/loginServlet")
/* クラス定義
 * これは「HttpServlet」を継承してるから、
 * このクラスはサーブレットとして機能する。
 */
public class LoginServlet extends HttpServlet {
	/* doPostメソッド
	 * 「doPost」メソッドはPOSTリクエストが来たときに呼ばれるメソッド。
	 * ここでログイン処理を行う。
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* レスポンスを書き込むための「PrintWriter」オブジェクトを
		 * 取得して、セッションも「request.getSession()」で取得してる。
		 */
		PrintWriter out = response.getWriter();
		try {
			HttpSession session = request.getSession();

			/* リクエストから「username」と「password」を取り出す。
			 * これはログインフォームから送られてきたデータ。
			 */
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			/* 「LoginDAO」オブジェクトを作成して、
			 * 「search」メソッドでユーザー名とパスワードを使って
			 * ログイン情報を検索する。
			 */
			LoginDAO dao = new LoginDAO();
			Login login = dao.search(username, password);

			/* もし「login」が見つかったら、セッションに
			 * 「login」オブジェクトをセットして、成功時のページ
			 * 「/jsp/login-out.jsp」にフォワードする。
			 * ログインが失敗したら、
			 * エラーページ「/jsp/login-error.jsp」
			 * にフォワードする。
			 */
			if (login != null) {
				session.setAttribute("login", login);
				request.getRequestDispatcher("/views/login-out.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/views/login-error.jsp").forward(request, response);
			}
			/* 実行中に例外が発生した場合、そのスタックトレースが
			 * 「PrintWriter」を使って出力される。
			 */
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}
}