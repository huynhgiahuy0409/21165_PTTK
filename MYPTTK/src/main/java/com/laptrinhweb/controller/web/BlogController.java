package com.laptrinhweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhweb.constant.SystemConstant;
import com.laptrinhweb.controller.sort.Sorter;
import com.laptrinhweb.model.NewModel;
import com.laptrinhweb.paging.PageRequest;
import com.laptrinhweb.paging.Pageble;
import com.laptrinhweb.service.ICategoryService;
import com.laptrinhweb.service.INewsService;
import com.laptrinhweb.utils.FormUtil;
import com.laptrinhweb.utils.MessageUtil;

@WebServlet(urlPatterns = { "/blog-page" })
public class BlogController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7753963690669418503L;
	@Inject
	private INewsService newsService;

	@Inject
	private ICategoryService categoryService;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String views = "";
		String serverPath = req.getServletPath();
		views = "";
		if (serverPath.equals("/blog-page")) {
			views = "views/web/blog.jsp";
			NewModel model = FormUtil.toModel(NewModel.class, req);
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(newsService.findAll(pageble));
			System.out.println(model.getListResult());
			model.setTotalItem(newsService.getTotalITem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem()) / model.getMaxPageItem());
			MessageUtil.showMessage(req);
			req.setAttribute(SystemConstant.MODEL, model);
		}
		RequestDispatcher rd = req.getRequestDispatcher(views);
		rd.forward(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	}
}
