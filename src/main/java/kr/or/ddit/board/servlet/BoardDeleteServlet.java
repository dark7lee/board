package kr.or.ddit.board.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private BoardServiceInf service;
	
	@Override
	public void init() throws ServletException {
		service = new BoardService();		
	}
	
    public BoardDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int board_seq = Integer.parseInt((String) session.getAttribute("board_seq"));
		int board_tboard_seq = Integer.parseInt(request.getParameter("board_tboard_seq"));
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_seq(board_seq);
		boardVO.setBoard_tboard_seq(board_tboard_seq);
		
		int DeleteCnt = service.deleteBoard(boardVO);
		
		//정상적으로 게시글이 삭제된 경우
		if(DeleteCnt == 1){
//			String board_seq2 = (String) session.getAttribute("board_seq");
//  			request.setAttribute("tboard_seq", board_seq2);
  			
//  			RequestDispatcher rd = request.getRequestDispatcher("/boadDetail");
//  	  		rd.forward(request, response);
  	  		
			response.sendRedirect(request.getContextPath() + "/boadDetail?tboard_seq=" + board_tboard_seq);
		//정상적으로 게시글이 삭제 안 된 경우
		}else{
			String board_seq2 = (String) session.getAttribute("board_seq");
  			request.setAttribute("tboard_seq", board_seq2);
			
			response.sendRedirect(request.getContextPath() + "/boardDDetail?board_seq=" + board_seq2);
		}
		
	}

}
