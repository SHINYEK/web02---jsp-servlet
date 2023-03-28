package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PostDAO;
import model.PostVO;


@WebServlet(value={"/posts","/posts/insert","/posts/update","/posts/delete","/posts/read"})
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostDAO dao = new PostDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
		
		switch(request.getServletPath()) {
		case "/posts":
			request.setAttribute("list",dao.list());
			request.setAttribute("pageName", "/posts/list.jsp");
			dis.forward(request, response);
			break;
		case "/posts/insert" :
			request.setAttribute("pageName", "/posts/insert.jsp");
			dis.forward(request, response);
			break;
		case "/posts/read" :
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("post", dao.read(id));
			request.setAttribute("pageName", "/posts/read.jsp");
			dis.forward(request, response);
			break;
		case "/posts/update" :
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("post", dao.read(id));
			request.setAttribute("pageName", "/posts/update.jsp");
			dis.forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PostVO vo = new PostVO();
		switch(request.getServletPath()){
			case "/posts/insert":
				vo.setTitle(request.getParameter("title"));
				vo.setWriter(request.getParameter("writer"));
				vo.setBody(request.getParameter("body"));
//				System.out.println(vo.toString());
				dao.insert(vo);
				response.sendRedirect("/posts");
				break;
			case "/posts/delete":
				int id = Integer.parseInt(request.getParameter("id"));
				dao.delete(id);
				break;
			case "/posts/update":
				vo.setId(Integer.parseInt(request.getParameter("id")));
				vo.setTitle(request.getParameter("title"));
				vo.setWriter(request.getParameter("writer"));
				vo.setBody(request.getParameter("body"));
//				System.out.println(vo.toString());
				dao.update(vo);
				response.sendRedirect("/posts");
				break;
				
		}
	}

}
