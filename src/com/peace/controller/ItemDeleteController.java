package com.peace.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.peace.bean.Item;
import com.peace.bean.User;
import com.peace.repository.ItemRepository;

/**
 * Servlet implementation class ItemDeleteController
 */
@WebServlet("/item/delete")
public class ItemDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemRepository repo = new ItemRepository();
		repo.setConnection(getServletContext().getAttribute("connection"));
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Item item = (Item) session.getAttribute("item");
		
		int id = Integer.valueOf(request.getParameter("id"));
		if (user.getId().equals(item.getUserId())) {
			if (item.getId() == id) {
				if (repo.removeItem(id)) {
					System.out.println("게시물 잘 지워짐 : " + id);
					response.sendRedirect(request.getContextPath() + "/");
					return;
				} else {
					
				}
			}
		}
		
		request.setAttribute("error", "게시물이 삭제되지 않았습니다.");
		response.sendRedirect(request.getContextPath() + "/update");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
