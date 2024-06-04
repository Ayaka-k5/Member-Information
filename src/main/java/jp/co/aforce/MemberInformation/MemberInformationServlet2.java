//package jp.co.aforce.MemberInformation;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import jp.co.aforce.beans.MemberInformation;
//import jp.co.aforce.dao.MemberInformationDAO;
//
//@WebServlet("/memberInformationServlet")
//public class MemberInformationServlet extends HttpServlet {
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		try {
//			HttpSession session = request.getSession();
//
//			String username = request.getParameter("username");
//			String password = request.getParameter("password");
//
//			MemberInformationDAO dao = new MemberInformationDAO();
//			MemberInformation memberInformation = dao.search(username, password);
//
//			if (memberInformation != null) {
//				session.setAttribute("memberInformation", memberInformation);
//				request.getRequestDispatcher("/jsp/regist.jsp").forward(request, response);
//			}
////			else {
////				request.getRequestDispatcher("/jsp/login-error.jsp").forward(request, response);
////			}
//		} catch (Exception e) {
//			e.printStackTrace(out);
//		}
//	}
//}