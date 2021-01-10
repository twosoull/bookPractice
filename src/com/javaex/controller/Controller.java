package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.PersonVo;


@WebServlet("/pbc")
public class Controller extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		PhoneDao phonedao =null;
		if("list".equals(action)) {
			System.out.println("리스트");
			
			phonedao = new PhoneDao();
			List<PersonVo> personList = phonedao.getPersonList();
			
			//어트리뷰트
			request.setAttribute("personList",personList);
			
			//웹유틸 포워드 사용
			WebUtil.forward(request, response, "./WEB-INF/list.jsp");
		}else if("insert".equals(action)) {
			System.out.println("생성");
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			phonedao = new PhoneDao();
			phonedao.personInsert(new PersonVo(name,hp,company));
			
			//리다이렉트 빈페이지에서 한번 다시 url로 보냄
			WebUtil.redirect(request, response, "/phonebook001/pbc?action=list");
			
		}else if("insertform".equals(action)) {
			System.out.println("인서트폼");
			
			WebUtil.forward(request, response, "./WEB-INF/insertform.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
