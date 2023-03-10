package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuGu
 */
/*
 gugu.html에서 <form action="GuGu">는 @WebServlet("/GuGu")를 보고 찾아옴
 따라서 @WebServlet("/GuGu") 주석 처리하면 404 에러 발생 → URL을 인지하는 주소와 같은 역할을 함
 */
@WebServlet("/GuGu")   
public class GuGu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuGu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		response.setContentType("text/html;charset=utf-8"); 
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h1>구구단 " + num + "단</h1>");
		
		for(int i=1; i<=9; i++) {
			out.printf("%d * %d = %d<br>", num, i, (num*i));
		}
		
		out.print("</body><html>");
		out.close();
		
		
		//한글을 받지 않고 숫자만 받았기 때문에 request.setCharacterEncoding("utf-8");을 생략하였음
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
