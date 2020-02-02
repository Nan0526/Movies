package com.movie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.movie.model.CinemaState;
import com.movie.model.Cinemas;
import com.movie.model.CinemasBO;
import com.movie.model.OrderInfoBO;
import com.movie.model.Users;
import com.movie.model.UsersBO;


@WebServlet("/OrderCL")
public class OrderCL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String type=request.getParameter("type");
		
		if(type.equals("buy")){
			String username=(String)request.getSession().getAttribute("username");
			String date=request.getParameter("date");
			String cinema=request.getParameter("cinemaId");
			String time=request.getParameter("times");
			String buy=request.getParameter("buy");
			String movieId=request.getParameter("movieId");
			String price=request.getParameter("price");
			String[] buyArr=buy.split(",");
			float money=(buyArr.length-1)*Float.parseFloat(price);
			UsersBO ubo=new UsersBO();
			Users user=ubo.getUsers(username);
			if(user.getMoney()<money){
				//error
				request.setAttribute("buyError", "You don't have enough money !");
				request.setAttribute("id", movieId);
				request.getRequestDispatcher("buyRet.jsp").forward(request, response);
			}else{
				float newMoney=user.getMoney()-money;
				ubo.updateUser(username, newMoney);
				//now time
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd mm:ss");
		        String orderTime = format.format(new Date());
				OrderInfoBO oib=new OrderInfoBO();
				buy=buy.substring(2);
				oib.addOrder(Integer.parseInt(cinema), Integer.parseInt(movieId), date,
						time, username, orderTime, buy, money);
				CinemaState cState=oib.getOrderState(cinema, movieId, date, time);
				//seat
				if(cState==null){
					//0:no;1:Ordered
					StringBuffer  seats=new StringBuffer("00000000000000000000000000000000000000000000000000");
					for(int i=1;i<buyArr.length;i++){
						int bTempInt=Integer.parseInt(buyArr[i]);
						seats.replace(bTempInt-1, bTempInt,"1");
					}
					oib.addCinemaState(Integer.parseInt(cinema), 
							Integer.parseInt(movieId), date, time,seats.toString());
				}else{
					StringBuffer  seats=new StringBuffer(cState.getSeats());
					for(int i=1;i<buyArr.length;i++){
						int bTempInt=Integer.parseInt(buyArr[i]);
						seats.replace(bTempInt-1, bTempInt,"1");
					}
					oib.updateCinemaState(cState.getId(),seats.toString());
				}
				
				request.setAttribute("buyError", "Purchase success !");
				request.setAttribute("id", movieId);
				request.getRequestDispatcher("buyRet.jsp").forward(request, response);
			}
		}else if(type.equals("toBuyPage")){
			
			CinemasBO cbo=new CinemasBO();
			ArrayList<Cinemas> al_cine= cbo.getCinemas();
			request.setAttribute("id", request.getParameter("id"));
			request.setAttribute("times", 10+"");
			request.setAttribute("cinemaId", al_cine.get(0).getId()+"");
			request.setAttribute("nowDate", request.getSession().getAttribute("date"));
			request.getRequestDispatcher("buy.jsp").forward(request, response);
		}else if(type.equals("reBuyPage")){
			request.setAttribute("id", request.getParameter("movieId"));
			request.setAttribute("times", request.getParameter("times"));
			request.setAttribute("cinemaId", request.getParameter("cinemaId"));
			request.setAttribute("nowDate", request.getParameter("date"));
			request.getRequestDispatcher("buy.jsp").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
