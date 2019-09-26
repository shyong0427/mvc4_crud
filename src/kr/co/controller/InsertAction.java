package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.model.UserManager;

public class InsertAction implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		UserForm userForm = new UserForm();
		userForm.setUserid(request.getParameter("userid"));
		userForm.setPassword(request.getParameter("password"));
		userForm.setName(request.getParameter("name"));
		userForm.setEmail(request.getParameter("email"));
		
		// 모델과 통신
		int re = UserManager.instance().insert(userForm);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(re > 0 ) { // Servlet만나기 위해 Redirect
			modelAndView.setViewName("list.m2"); // "xxx" 요청명
		} else {
			modelAndView.setViewName("fail.html");
		}
		
		return modelAndView;
	}
}