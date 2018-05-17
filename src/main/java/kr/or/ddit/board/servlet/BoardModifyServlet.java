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
import javax.servlet.http.Part;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/boardModify")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private BoardServiceInf service;
	
	@Override
	public void init() throws ServletException {
		service = new BoardService();		
	}
	
    public BoardModifyServlet() {
        super();
    }

    //게시글 수정 폼 요청
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		HttpSession session = request.getSession();
  		
  		int board_seq = Integer.parseInt((String) session.getAttribute("board_seq"));
  		
  		//서비스 객체를 통해서 getUser 호출
  		BoardVO boardVO = (BoardVO) service.getBoardAll(board_seq);
  		
  		//request 객체에 boardVO 정보를 setAttribute
		session.setAttribute("boardVO", boardVO);
  		
  		//foward
  		RequestDispatcher rd = request.getRequestDispatcher("/boardMModify.jsp");
  		rd.forward(request, response);
  		
  	}

  	//게시글 정보 수정
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		request.setCharacterEncoding("utf-8");
  		
  		HttpSession session = request.getSession();
  		
  		int board_seq = Integer.parseInt((String) session.getAttribute("board_seq"));
  		String board_title = request.getParameter("board_title");
  		String board_content = request.getParameter("board_content");
  		
  		//사용자 정보 수정
  		BoardVO boardVO = new BoardVO(board_seq, board_title, board_content);
  		int updatetCnt = service.updateBoard(boardVO);
  		
  		//테스트
  		System.out.println("updatetCnt --->>> " + updatetCnt);
  		
  		//정상적으로 수정된 경우
  		if(updatetCnt == 1){
  			String board_seq2 = (String) session.getAttribute("board_seq");
  			session.setAttribute("board_seq", board_seq2);
  			System.out.println("board_seq2 --->>> " + board_seq2);
  			
  	  		response.sendRedirect(request.getContextPath() + "/boardDDetail?board_seq=" + board_seq2);
  	  	//정상적으로 수정되지 않은 경우
  		}else{
  			RequestDispatcher rd = request.getRequestDispatcher("/boardMModify.jsp");
  	  		rd.forward(request, response);
  		}
  		
  	}

}
