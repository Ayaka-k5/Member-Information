<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<%-- 
loginオブジェクト:
これは事前にJavaのコードとかサーブレットとかでセットされたオブジェクト
を指してる。
この場合、「login」はLoginクラスのインスタンス。
usernameフィールド:
これは「login」オブジェクトの中のユーザー名を示すフィールド。
 --%>
こんにちは、${login.username}さん。

<%@include file="../footer.html"%>