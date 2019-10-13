package com.peace.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peace.bean.Item;
import com.peace.repository.ItemRepository;

/**
 * Servlet implementation class ItemUpdateController
 */
@WebServlet("/item/update")
public class ItemUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update get");
		
		request.getRequestDispatcher("/WEB-INF/view/itemupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update post");
		request.setCharacterEncoding("utf-8");
		int id = ((Item) request.getSession().getAttribute("item")).getId();
		
		Item item = new Item();
		item.setId(id);
		item.setTitle(request.getParameter("title"));
		item.setBody(request.getParameter("body"));
		
		ItemRepository repo = new ItemRepository();
		repo.setConnection(getServletContext().getAttribute("connection"));
		if (repo.updateItem(item)) {
			response.sendRedirect(request.getContextPath() + "/item" + "?id=" + id);
			
		} else {
			request.setAttribute("item", item);
			request.setAttribute("error", "수정에 실패하였습니다.");
			request.getRequestDispatcher("/WEB-INF/view/itemupdate.jsp")
			.forward(request, response);;
			System.out.println("update failed.....");
		}
		
		
	}

}
