package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.MemberInformation;

public class MemberInformationDAO extends DAO2 {
	public MemberInformation search(String last_name, String password, String first_name,
			String sex, int birth_year, int birth_month, int birth_day, String phone_number,
			String mail_address, String job)
			throws Exception {
		MemberInformation memberInformation = null;

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement(
				"SELECT * FROM Login JOIN MEMBER_INFO"
						+ "ON Login.username = MEMBER_INFO.LOGIN_ID"
						+ "INSERT INTO MEMBER_INFO (LOGIN_ID, LAST_NAME,"
						+ "FIRST_NAME, SEX, BIRTH_YEAR, BIRTH_MONTH, BIRTH_DAY,"
						+ "JOB, PHONE_NUMBER, MAIL_ADDRESS) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		st.setString(1, last_name);
		st.setString(2, first_name);
		st.setString(3, sex);
		st.setInt(4, birth_year);
		st.setInt(5, birth_month);
		st.setInt(6, birth_day);
		st.setString(7, phone_number);
		st.setString(8, mail_address);
		st.setString(9, job);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			memberInformation = new MemberInformation();
			memberInformation.setLast_name(rs.getString("last_name"));
			memberInformation.setFirst_name(rs.getString("first_name"));
			memberInformation.setSex(rs.getString("sex"));
			memberInformation.setBirth_year(rs.getInt("birth_year"));
			memberInformation.setBirth_month(rs.getInt("birth_month"));
			memberInformation.setBirth_day(rs.getInt("birth_day"));
			memberInformation.setPhone_number(rs.getString("phone_number"));
			memberInformation.setMail_address(rs.getString("mail_address"));
			memberInformation.setJob(rs.getString("job"));
		}

		st.close();
		con.close();
		return memberInformation;
	}

}