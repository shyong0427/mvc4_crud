package kr.co.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.model.UserDto;
import kr.co.model.UserManager;

public class ListAction implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 모델에서 전체자료 읽어오기
		ArrayList<UserDto> list = UserManager.instance().getUserAll();
		
		request.setAttribute("list", list);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list.jsp");
		modelAndView.setRedirect(false);
		
		return modelAndView;
	}
}
