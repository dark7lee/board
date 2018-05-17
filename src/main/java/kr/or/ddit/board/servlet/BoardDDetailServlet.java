package kr.or.ddit.board.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.FileVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/boardDDetail")
public class BoardDDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private BoardServiceInf service;
	
	@Override
	public void init() throws ServletException {
		service = new BoardService();		
	}
	
    public BoardDDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		//test
		System.out.println("잘 오셨습니다.");
		
		Integer board_seq = Integer.parseInt(request.getParameter("board_seq"));
		System.out.println("board_seq >>> " + board_seq);
		
		//board_seq session에 담기
		session.setAttribute("board_seq", request.getParameter("board_seq"));
		
		BoardVO boardVO = service.getBoardAll(board_seq);
		
		session.setAttribute("boardVO", boardVO);
		
		//////////////////////////////////////////////////////////////
		//FileVO를 화면에 업로드
//		String file_path = (String) request.getAttribute("file_path");
		String file_path = (String) session.getAttribute("file_path");
		
		FileVO fileVO = service.getFile(file_path);
		
		session.setAttribute("fileVO", fileVO);
		
		//////////////////////////////////////////////////////////////
		
		RequestDispatcher rd = request.getRequestDispatcher("/boardModify.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
