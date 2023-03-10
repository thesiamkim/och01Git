package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3")         //주소
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {         //생성자
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */  //파라미터가 아래의 request에 묻어감
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1부터 num까지의 합을 전달
		int num = Integer.parseInt(request.getParameter("num"));   //파라미터 : num, loc, 파라미터로 넘어갈 땐 string 타입이므로 형변환 필요
		String loc = request.getParameter("Loc");
		System.out.println("Add3 num : " + num);
		int sum = 0;
		for(int i=1; i<=num; i++) {
			sum += i;
		}
		System.out.println("Add3 sum : " + sum);
		
		request.setCharacterEncoding("utf-8");   //생략 시 한글이 깨짐
		response.setContentType("text/html;charset=utf-8");
		//사용자 browser에 보여주는 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>");             //out 객체의 println, printf은 사용자 브라우저에 response하여 내용을 출력시킴
		out.printf("<h1>1부터 %d까지 합계</h1>", num);
		out.printf("<h4>LOC --> %s</h4>", loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
