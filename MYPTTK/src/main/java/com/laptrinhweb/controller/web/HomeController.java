package com.laptrinhweb.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhweb.model.UserModel;
import com.laptrinhweb.service.ICategoryService;
import com.laptrinhweb.service.IUserService;
import com.laptrinhweb.utils.FormUtil;
import com.laptrinhweb.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/account", "/thoat",
		"/shoes-page", "/collection-page", "/racingBoots-page", "/contact-page", "/search-bar",  })
public class HomeController extends HttpServlet {
	/**
	
	 * 
	 */
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	@Inject
	private ICategoryService categoryService;
	@Inject
	private IUserService userService;

	private static final long serialVersionUID = 7753963690669418503L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String views = "";
		String serverPath = req.getServletPath();
		views = "";
		if (serverPath.equals("/trang-chu")) {
			views = "views/home.jsp";
		}else if(serverPath.equals("/collection-page")) {
			views = "views/web/collection.jsp";
		}else if(serverPath.equals("/racingBoots-page")) {
			views = "views/web/racing boots.jsp";
		}else if(serverPath.equals("/shoes-page")) {
			views = "views/web/shoes.jsp";
		}else if(serverPath.equals("/racingBoots-page")) {
			views = "views/web/racing boots.jsp";
		}else if(serverPath.equals("/contact-page")) {
			views = "views/web/contact.jsp";
		}else if (serverPath.equals("/search-bar")) {
			views = "views/web/search bar.jsp";
		}else if(serverPath.equals("/account")) {
			views = "views/login.jsp";
		}
		
		if (serverPath.equals("/account")) {
			String action ="";
			action = req.getParameter(action);
			if (action != null && action.equals("login")) {
				String message = req.getParameter("message");
				String alert = req.getParameter("alert");
				if (alert != null && message != null) {
					req.setAttribute("message", resourceBundle.getString(message));
					req.setAttribute("alert", alert);
				}
				views = "/views/login.jsp";
			} else if (action != null && action.equals("logout")) {
				SessionUtil.getInstance().removeValue(req, "USERMODEL");
				if (SessionUtil.getInstance().getValue(req, "USERMODEL") == null) {
					System.out.println("REMOVED");
				}
				res.sendRedirect(req.getContextPath() + "/trang-chu");
			}
		}
		RequestDispatcher rq = req.getRequestDispatcher(views);
		rq.forward(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(req.getServletPath().equals("/account")) {
			if (action != null && action.equals("login")) {
				//Maping data từ client qua server
				UserModel model = FormUtil.toModel(UserModel.class, req);
				System.out.println(model.toString());
//				Check Username password
				model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
				if (model != null) {
					SessionUtil.getInstance().putValue(req, "USERMODEL", model);
					if (model.getRole().getCode().equals("USER")) {
						res.sendRedirect(req.getContextPath() + "/trang-chu");
						System.out.println("ROLE USER");
					} else if (model.getRole().getCode().equals("ADMIN")) {
						res.sendRedirect(req.getContextPath() + "/admin-home");
						System.out.println("ROLE ADMIN");
					}
				} else {
					res.sendRedirect(req.getContextPath()
							+ "/account?action=login&message=username_password_invalid&alert=danger");
				}
			}
		}
	}
}
