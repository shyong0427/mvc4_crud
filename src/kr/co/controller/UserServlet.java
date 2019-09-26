package kr.co.controller;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.m2")
public class UserServlet extends HttpServlet {
	ModelAndView modelAndView = null;
	Controller controller = null;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		try {
			// 파일명을 요청정보로 사용하기
			String ss = request.getRequestURI();
			int idx = ss.lastIndexOf('/');
			StringTokenizer st = new StringTokenizer(ss.substring(idx+1), ".");
			ss = st.nextToken();
			
//			System.out.println(ss); // /mcv4_crud/login.m2 -> login
			
			String command = ss;
			controller = getAction(command); //login.m2 받아옴
			modelAndView = controller.execute(request, response); // LoginAction 수행
			
			// 파일 호출 방식 선택 후 처리
			if(modelAndView.isRedirect()) { // Redirect 방식
				response.sendRedirect(modelAndView.getViewName());
			} else { // Forwarding 방식
				RequestDispatcher dispatcher = request.getRequestDispatcher(modelAndView.getViewName());
				
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("service err : " + e);
		}
	}
	
	public Controller getAction(String command) throws Exception {
		if(command.equals("login")) controller = new LoginAction();
		else if(command.equals("list")) controller = new ListAction();
		else if(command.equals("logout")) controller = new LogoutAction();
		else if(command.equals("insert")) controller = new InsertAction();
		else if(command.equals("view")) controller = new ViewAction();
		else if(command.equals("updateform")) controller = new UpdateFormAction();
		else if(command.equals("update")) controller = new ListAction();
		else if(command.equals("delete")) controller = new ListAction();
				
		return controller;
	}
}