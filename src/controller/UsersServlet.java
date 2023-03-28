package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDAO;
import model.UserVO;

@WebServlet(value= {"/users","/login","/logout"})
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO dao = new UserDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		HttpSession session = request.getSession();
		switch(request.getServletPath()) {
		case "/login":
			request.setAttribute("pageName", "/users/login.jsp");
			dis.forward(request, response);
			break;
		case "/logout":
			session.invalidate();
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//out은 브라우저 객체 - > 이를 통해 브라우저에 출력한다.
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		switch(request.getServletPath()) {
		case "/login":
			String uid = request.getParameter("uid");
			String upass = request.getParameter("upass");
			UserVO vo = dao.read(uid);
			System.out.println(vo.toString());
			int result = 0;
			if(vo.getUid() != null) {
				if(vo.getUpass().equals(upass)) { //값 비교는 equals로 
					result = 1;
					session.setAttribute("uid", uid);
				}else {
					result = 2;
				}
			}
			out.print(result);
			break;
		}
	}

}
