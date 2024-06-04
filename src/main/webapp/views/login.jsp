<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<%-- 
フォーム全体
ここでフォームを開始している。
action属性にあるURL「/Login/loginServlet」は、フォームのデータが
送信されたときにどのサーブレットが処理するのかを決めるもの。
method="post"は、送信方法がPOSTリクエストであることを示している。
 --%>
<form action="/MemberInformation/loginServlet" method="post">
	<%-- 
	ユーザーID入力欄
	ここではユーザーIDを入力するためのテキスト入力フィールド。
	<input type="text">でテキストボックスが作られて、
	name="username"で、この入力フィールドの名前が「username」として
	フォームデータに含まれるようになる。
	 --%>
	<p>
		ユーザーID<input type="text" name="username">
	</p>
	<%-- 
	パスワード入力欄
	次にパスワード入力フィールド。
	<input type="password">でパスワードボックスが作られて、
	入力した文字が見えないようにしてある。
	name="password"でこのフィールドの名前が「password」になる。
	 --%>
	<p>
		パスワード<input type="password" name="password">
	</p>
	<%-- 
	送信ボタン
	最後に送信ボタン。
	<input type="submit">でボタンが作成されて、
	value="ログイン"でボタンに「ログイン」というテキストが表示される。
	 --%>
	<p>
		<input type="submit" value="ログイン">
	</p>
	
	<%-- <p>
		<input type="submit" value="新規会員登録">
	</p> --%>
</form>

<%@include file="../footer.html"%>