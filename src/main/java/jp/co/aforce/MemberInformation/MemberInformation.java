package jp.co.aforce.MemberInformation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/memberInformation")
public class MemberInformation extends HttpServlet {

	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			//データベースの接続
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/member_information");
			Connection con = ds.getConnection();

			//リクエストパラメータの取得
			String name = request.getParameter("name");
			//int price = Integer.parseInt(request.getParameter("price"));

			//SQLの生成、実行
			PreparedStatement st = con.prepareStatement("insert into MEMBER_INFO values (?)");
			//上の"insert into product values (?)"の?に入れる値を指定する
			st.setString(1, name);
			//st.setInt(2, price);
			int line = st.executeUpdate();

			//結果の取得、処理
			//一行でも追加できた場合
			if (line > 0) {
				out.println(name);
			}

			//データベースの切断
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}

}
