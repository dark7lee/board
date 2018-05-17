package kr.or.ddit.board.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.TBoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/boadDetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BoardServiceInf service;
	
	@Override
	public void init() throws ServletException {
		service = new BoardService();		
	}
	
    public BoardDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(request.getParameter("tboard_seq"));
		int tboard_seq = Integer.parseInt(request.getParameter("tboard_seq"));
		
		System.out.println("tboard_seq : " + tboard_seq);
		
		//tboard_seq를 session에 담기
		session.setAttribute("tboard_seq", request.getParameter("tboard_seq"));
		
		List<BoardVO> boardVO = new ArrayList<BoardVO>();
		boardVO = (List<BoardVO>) service.getBoard(tboard_seq);
		
		session.setAttribute("boardVO", boardVO);
		
		
		//getBoardPageList?page=1&pageSize=10;
		//getBoardPageList
		//page 파라미터가 없을 경우 --> 1page
		//pageSize 파라미터가 없을 경우 --> 10
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		
		String pageSizeString = request.getParameter("pageSize");
		int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
		
		Map<String, Object> resultMap = service.getBoardPageList(page, pageSize, tboard_seq);
		
		
		session.setAttribute("pageNav", resultMap.get("pageNav"));
//		request.setAttribute("boardList", resultMap.get("boardList"));
//		request.setAttribute("pageNav", resultMap.get("pageNav"));
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/boardDetail.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
