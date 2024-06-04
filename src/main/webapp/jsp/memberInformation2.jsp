<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<%-- 
フォーム全体
ここでフォームを開始している。
action属性にあるURL「/Login/loginServlet」は、フォームのデータが
送信されたときにどのサーブレットが処理するのかを決めるもの。
method="post"は、送信方法がPOSTリクエストであることを示している。
 --%>
<p>会員情報登録</p>

<form action="/MemberInformation/memberInformationServlet" method="post">
	<p>
		■ユーザーID<br>　<input type="text" name="username">
	</p>
	<p>
		■パスワード<br>　<input type="password" name="password">
	</p>
	<p>
		■名前<br>　姓　<input type="text" name="last_name">　名　<input
			type="text" name="first_name">
	</p>
	<p>
		■性別<br>　<input type="radio" name="sex" value="男" checked>男
		<input type="radio" name="sex" value="女">女
	</p>
	<p>
		■生年月日<br>　<select name="birth_year">
			<%
			int startYear = 1920;
			int endYear = 2020;
			for (int year = startYear; year <= endYear; year++) {
			%>
			<option value="<%=year%>"><%=year%></option>
			<%
			}
			%>
		</select>年<select name="birth_month">
			<%
			int startMonth = 1;
			int endMonth = 12;
			for (int month = startMonth; month <= endMonth; month++) {
			%>
			<option value="<%=month%>"><%=month%></option>
			<%
			}
			%>
		</select>月<select name="birth_day">
			<%
			int startDay = 1;
			int endDay = 31;
			for (int day = startDay; day <= endDay; day++) {
			%>
			<option value="<%=day%>"><%=day%></option>
			<%
			}
			%>
		</select>日
	</p>
	<p>
		■電話番号<br> <input type="text" name="phone_number">
	</p>
	<p>
		■メールアドレス<br>　<input type="text" name="mail_address">
	</p>
	<p>
		■職業<br>　<select name="job">
			<option value="officeworker">会社員</option>
			<option value="freelance">自営業</option>
			<option value="student">学生</option>
			<option value="other">その他</option>
		</select>
	</p>
	<p>
		<input type="submit" name="regist" value="登録">
		　<input type="submit" name="reset" value="リセット">
		　<input type="submit" name="back" value="戻る">
	</p>
</form>

<%@include file="../footer.html"%>