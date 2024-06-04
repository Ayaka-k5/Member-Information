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
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String last_name = request.getParameter("last_name");
			String first_name = request.getParameter("first_name");
			String sexParam = request.getParameter("sex");
			int sex = 0;
			String birthYearParam = request.getParameter("birth_year");
			int birth_year = 0;
			String birthMonthParam = request.getParameter("birth_month");
			int birth_month = 0;
			String birthDayParam = request.getParameter("birth_day");
			int birth_day = 0;
			String phone_number = request.getParameter("phone_number");
			String mail_address = request.getParameter("mail_address");
			String jobParam = request.getParameter("job");
			int job = 0;

			if ("男".equals(sexParam)) {
				sex = 1;
			} else if ("女".equals(sexParam)) {
				sex = 2;
			}

			try {
				birth_year = Integer.parseInt(birthYearParam);
			} catch (NumberFormatException e) {
				return;
			}

			try {
				birth_month = Integer.parseInt(birthMonthParam);
			} catch (NumberFormatException e) {
				return;
			}

			try {
				birth_day = Integer.parseInt(birthDayParam);
			} catch (NumberFormatException e) {
				return;
			}

			if ("officeworker".equals(jobParam)) {
				job = 100;
			} else if ("freelance".equals(jobParam)) {
				job = 200;
			} else if ("student".equals(jobParam)) {
				job = 300;
			} else if ("other".equals(jobParam)) {
				job = 400;
			}

			/* SQLの生成、実行
			 * "insert into product values (?)"の?に入れる値を指定する
			 */
			PreparedStatement st = con
					.prepareStatement("insert into MEMBER_INFO values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, username);
			st.setString(2, password);
			st.setString(3, last_name);
			st.setString(4, first_name);
			st.setInt(5, sex);
			st.setInt(6, birth_year);
			st.setInt(7, birth_month);
			st.setInt(8, birth_day);
			st.setString(9, phone_number);
			st.setString(10, mail_address);
			st.setInt(11, job);
			int line = st.executeUpdate();

			/* 結果の取得、処理
			 * 一行でも追加できた場合
			 */
			if (line > 0) {
				//out.println(username);
			}

			//データベースの切断
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}

}