package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.model.UserManager;

public class LoginAction implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("userid");
		String pwd = request.getParameter("password");
//		System.out.println(id + "\n" + pwd);

		// 모델과 통신
		UserManager manager = UserManager.instance();
		boolean isSucess = manager.login(id, pwd);
		ModelAndView modelAndView = new ModelAndView();
		
		if(isSucess) {
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("userid", id);
			
			modelAndView.setViewName("list.m2"); // 로그인 후 회원목록 보기 예정, 확장자가 m2이기 때문에 Servlet을 통한다
		} else {
			modelAndView.setViewName("loginfail.html");
		}
		modelAndView.setRedirect(true); // 호출방식 결정
		
		return modelAndView;
	}
}