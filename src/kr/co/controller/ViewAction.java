package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.model.UserDto;
import kr.co.model.UserManager;

public class ViewAction implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 상세보기 작업
		request.setCharacterEncoding("utf-8");
		
		String userid = request.getParameter("userid");
		
		// 모델과 통신
		UserDto dto = UserManager.instance().findUser(userid);
		// JSP 뿌리기
		request.setAttribute("user", dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view.jsp");
		modelAndView.setRedirect(false);
		
		return modelAndView;
	}
}