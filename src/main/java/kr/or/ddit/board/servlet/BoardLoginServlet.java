package kr.or.ddit.board.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BUserVO;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.TBoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/boardLogin")
public class BoardLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private BoardServiceInf service;
	
	@Override
	public void init() throws ServletException {
		service = new BoardService();		
	}
	
    public BoardLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파라미터 확인(mem_id, mem_pass)
		String mem_id = request.getParameter("userId");
		String mem_pass = request.getParameter("password");
		
		//사용자로부터 입력 받은 id, pass에 해당하는 사용자가 있는지 확인
		Map<String, String> memVo = new HashMap<String, String>();
		memVo.put("mem_id", mem_id);
		memVo.put("mem_pass", mem_pass);
		
		BUserVO resultLogin = service.loginCheck(memVo);
		
		//성공 -main.jsp
		if(resultLogin != null){
			HttpSession session = request.getSession();
			session.setAttribute("mem_name", resultLogin.getMem_name());
			session.setAttribute("mem_id", resultLogin.getMem_id());
			session.setAttribute("mem_pass", resultLogin.getMem_pass());
			
			////////////////////
			//게시판 가져와서 left.jsp로 보내기
			List<TBoardVO> boardList = new ArrayList<TBoardVO>();
			boardList = (List<TBoardVO>) service.getTBoard();
			
			session.setAttribute("boardList", boardList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/boardManage.jsp");
			rd.forward(request, response);
		//실패 -boardLogin.jsp
		}else{
			request.setAttribute("mem_id", mem_id);
			RequestDispatcher rd = request.getRequestDispatcher("/boardLogin.jsp");
			rd.forward(request, response);
			
		}
	}
}
