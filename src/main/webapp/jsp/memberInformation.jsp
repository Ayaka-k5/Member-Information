<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<p>会員情報登録</p>
<form action="/MemberInformation/memberInformation" method="post">
	<p>■ユーザーID<br>　
	<input type="text" name="name"></p>
	<%-- 価格<input type="text"　name="price"> --%>
	<p>
	<input type="submit" value="登録"></p>
</form>

<%@include file="../footer.html"%>