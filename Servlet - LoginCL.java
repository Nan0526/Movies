package com.movie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.movie.model.Users;
import com.movie.model.UsersBO;

@WebServlet("/LoginCL")
public class LoginCL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String type=request.getParameter("type");
		UsersBO ubo=new UsersBO();
		String u=request.getParameter("username");
		String p=request.getParameter("password");
		if(type.equals("login")){
			//login
			if(ubo.checkUser(u, p)){
				//save to session
				Users ub=ubo.getUsers(u);
				//request.getSession().setAttribute("userInfo", ub);
				request.getSession().setAttribute("username", ub.getUsername());
				request.getSession().setAttribute("nick", ub.getNick());
				//now time
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		        String strDate = format.format(new Date());
		        request.getSession().setAttribute("date", strDate);
				request.getRequestDispatcher("homepage.jsp").forward(request, response);
			}else{
				request.setAttribute("loginError", "The user does not exist !");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else{
			//sign up
			String repassword=request.getParameter("repassword");
			String name=request.getParameter("name");
			String age=request.getParameter("age");
			String nick=request.getParameter("nick");
			String phone=request.getParameter("phone");
			if(u.equals("")||p.equals("")||repassword.equals("")||
					name.equals("")||age.equals("")||nick.equals("")||phone.equals("")){
				request.setAttribute("signRet", "All inputs cannot be empty !");
				request.getRequestDispatcher("signUp.jsp").forward(request, response);
				return ;
			}
			if(!p.equals(repassword)){
				request.setAttribute("signRet", "Two password entries are inconsistent !");
				request.getRequestDispatcher("signUp.jsp").forward(request, response);
				return ;
			}
			String ret = ubo.addUser(u, p, name, nick, Integer.parseInt(age), phone);
			if(ret.equals("true"))ret="add success!";
			else if(ret.equals("false"))ret="add fail!";
			else ret=" !";
			request.setAttribute("signRet", ret);
			request.getRequestDispatcher("signUp.jsp").forward(request, response);
		
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
