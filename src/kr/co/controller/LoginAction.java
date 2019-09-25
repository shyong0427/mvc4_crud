package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("userid");
		String pwd = request.getParameter("password");
		System.out.println(id + "\n" + pwd);

		// 모델과 통신
		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("list.m2"); // 확장자가 m2이기 때문에 Servlet을 통한다.
		
		return modelAndView;
	}
}