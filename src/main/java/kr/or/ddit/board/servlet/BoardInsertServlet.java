package kr.or.ddit.board.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import util.FileUtil;
import kr.or.ddit.board.model.BUserVO;
import kr.or.ddit.board.model.FileVO;
import kr.or.ddit.board.model.TBoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/boardInsert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private BoardServiceInf service;
	
	@Override
	public void init() throws ServletException {
		service = new BoardService();		
	}
	
    public BoardInsertServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		String tboard_title = request.getParameter("tboard_title");
		String tboard_mem_id = (String) session.getAttribute("mem_id");
		
		//test
		System.out.println("-->boardInsert : " + tboard_title);
		System.out.println("-->" + tboard_mem_id);
		
		Map<String, String> tBoardVO = new HashMap<String, String>();
		tBoardVO.put("tboard_title", tboard_title);
		tBoardVO.put("tboard_mem_id", tboard_mem_id);
		
		int insertCnt = service.insertTBoard(tBoardVO);
		
		//정상적으로 게시판 입력된 경우 : 게시판 리스트 페이지로 이동
		if(insertCnt == 1){
			response.sendRedirect(request.getContextPath() + "/boardList");
		//정상적으로 게시판 입력이 안 된 경우 : 게시판 입력 페이지로 이동
		}else{
			response.sendRedirect(request.getContextPath() + "/boardInsert.jsp");
		}
		
	}
	
}
