package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession(false);
		httpSession.removeAttribute("userid");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.jsp");
		modelAndView.setRedirect(true);
		
		return modelAndView;
	}
}