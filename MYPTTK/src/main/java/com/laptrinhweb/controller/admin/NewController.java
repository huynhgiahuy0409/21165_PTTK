package com.laptrinhweb.controller.admin;

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

@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7753963690669418503L;
	@Inject
	private INewsService newsService;

	@Inject
	private ICategoryService categoryService;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		NewModel model = FormUtil.toModel(NewModel.class, req);
		System.out.println("NewController" + model.getTitle());
		String view = "";
		if (model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(newsService.findAll(pageble));
			System.out.println(model.getListResult());
			model.setTotalItem(newsService.getTotalITem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem()) / model.getMaxPageItem());
			
			view = "views/admin/new/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			System.out.println("EDIT"+model.getListResult());
			if (model.getId() != null) {
				model = newsService.findOne(model.getId());
			} 
			req.setAttribute("categories", categoryService.findAll());
			view = "/views/admin/new/edit.jsp";
		}
		
		if (req.getParameter("message") != null) {
			String messageRespone = ""; //display, text
			String alert = "";
			String message = req.getParameter("message");
			if (message.equals("insert_succes")) {
				messageRespone = "Insert Success";
				alert = "success";
			}else if(message.equals("update_succes")){
				messageRespone = "Insert Success";
				alert = "success";
			}else if(message.equals("delete_succes")){
				messageRespone = "Delete Success";
				alert = "success";
			}else if(message.equals("error_system")){
				messageRespone = "ERROR System";
				alert = "danger";
			}
			req.setAttribute("messageRespone", messageRespone);
			req.setAttribute("alert", alert);
		}
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	}
}
