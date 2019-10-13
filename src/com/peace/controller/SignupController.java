package com.peace.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peace.bean.User;
import com.peace.repository.UserRepository;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/signup")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user = new User();
		user.setId(request.getParameter("id"));
		user.setPassword(request.getParameter("password"));
		user.setNickName(request.getParameter("nick-name"));
		user.setEmail(request.getParameter("email"));
		
		UserRepository repo = new UserRepository();
		repo.setConnection(getServletContext().getAttribute("connection"));
		
		if (repo.addUser(user)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		} else {
			request.setAttribute("user", user);
			request.setAttribute("error", "가입에 실패하였습니다. ");
			request.getRequestDispatcher("/WEB-INF/view/signup.jsp").forward(request, response);
		}
		
		
		
	}

}
