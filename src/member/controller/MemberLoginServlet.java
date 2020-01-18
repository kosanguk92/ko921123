package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.Memberservice;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/member/login") //web.xml 대신등록해줌
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.인코딩
		//void javax.servlet.ServletRequest.setCharacterEncoding(String env) throws UnsupportedEncodingException
		request.setCharacterEncoding("utf-8");
		//2. 파라미터 처리 // name 속성값 key전달
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		System.out.println("memberId@servlet="+memberId);
		System.out.println("password@servlet="+password);
		
		//3. 업무로직
		//1.로그인성공 : 올바른 아이디와 비밀번호
		//2 로그인실패 : 비밀번호가 틀린경우
		//3.로그인실패 : 존재하지 않는 아이디
		
		//Db에서 memberId로 member 객체 조회
		//1.조회된 member객체가 있는경우
		// 비밀번호가 정확한 경우 : 1. 로그인 성공
		// 비밀번호가 틀린경우 : 2. 로그인실패
		//2.조회된 member객체가 없는경우 : 3.로그인실패
		
		Member m = new Memberservice().selectOne(memberId);
		System.out.println("member@controller="+m);
		
		String msg ="";
		String loc = "/";
		
		//1.memberId로 조회된 회원이 있는경우
		if(m != null) {
			
			//1.로그인 성공
			if(password.equals(m.getPassword())) {
				msg = "로그인성공!";

				
				//로그인한 사용자를 session객체에 memberLoggedIn속성을 저장

				
				HttpSession session = request.getSession();
				String sessionId = session.getId();
				System.out.println("sessionId@servlet="+sessionId);
				
				Member memberLoggedIn = m;
				session.setAttribute("memberLoggedIn", memberLoggedIn);
				
//				RequestDispatcher reqDispatcher 
//					= request.getRequestDispatcher("/index.jsp");
//				reqDispatcher.forward(request,response);
				
				//로그인후 인덱스페이지로 리아디렉트 처리
				//클라이언트로 하여금 이 url(/mvc)로 다시 요청하도록 함.
				response.sendRedirect(request.getContextPath());
				return;
			}
			//2.로그인실패 : 비밀번호가 틀린경우
			else {
				msg = "비밀번호가 틀렸습니다.";
			}
			
		}
		//2.memberId가 존재하지 않는경우
		else {
			msg = "아이디가 존재하지 않습니다.";
		}
		System.out.println("msg="+msg);
		//4. view단 처리 forwarding
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		reqDispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
