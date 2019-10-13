package com.peace.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peace.bean.Item;
import com.peace.bean.User;
import com.peace.repository.ItemRepository;

/**
 * Servlet implementation class ItemInsertController
 */
@WebServlet("/item/insert")
public class ItemInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/iteminsert.jsp")
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		Item item = new Item();
		item.setTitle(request.getParameter("title"));
		item.setBody(request.getParameter("body"));
		item.setUserId(user.getId());
		
		ItemRepository repo = new ItemRepository();
		repo.setConnection(getServletContext().getAttribute("connection"));
		if (repo.addItem(item)) {
			System.out.println("good insert item");
		} else {
			System.out.println("bad insert item");
			request.setAttribute("error", "등록에 실패하였습니다. ");
		}

		response.sendRedirect(request.getContextPath() + "/");
	}

}
