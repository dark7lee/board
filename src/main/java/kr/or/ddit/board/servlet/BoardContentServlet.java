package kr.or.ddit.board.servlet;

import java.io.IOException;
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
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/boardContent")
@MultipartConfig(maxFileSize=1024*1024*15, maxRequestSize=1024*1024*20)
public class BoardContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BoardServiceInf service;
	
	@Override
	public void init() throws ServletException {
		service = new BoardService();		
	}
	
    public BoardContentServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		
		///////////////////////////////////////////////////////////////////////////
		//part에서 file_seq 정보(파일 이름)
		Part profilepart = request.getPart("file_seq");
		
		String contentString = profilepart.getHeader("Content-disposition");
		String fileName = FileUtil.getFileName(contentString);
		
		//정해진 위치(uploadFolder)에 파일저장
		String uploadPath = getServletContext().getRealPath("/uploadFolder");
		String file_path = "/uploadFolder/" + fileName;
		String filePath = uploadPath + java.io.File.separator + fileName;
		profilepart.write(filePath);
		profilepart.delete();
		
		//String --> insert
		String file_paths = file_path;
		int insertFileCnt = service.insertFile(file_paths);
		
//		request.setAttribute("file_path", file_paths);
		session.setAttribute("file_path", file_paths);
		
		System.out.println("insertFileCnt --->>>>>>>>>> " + insertFileCnt);
		///////////////////////////////////////////////////////////////////////////
		
		
		String board_tboard_seq = (String) session.getAttribute("tboard_seq");
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		String board_mem_id = (String) session.getAttribute("mem_id");
		
		////////////////////////////////////////////////////////////
		//test
		System.out.println("board_tboard_seq --> " + board_tboard_seq);
		System.out.println("board_title --> " + board_title);
		System.out.println("board_content --> " + board_content);
		System.out.println("board_mem_id --> " + board_mem_id);
		////////////////////////////////////////////////////////////
		
		Map<String, String> boardVO = new HashMap<String, String>();
		
		boardVO.put("board_tboard_seq", board_tboard_seq);
		boardVO.put("board_title", board_title);
		boardVO.put("board_content", board_content);
		boardVO.put("board_mem_id", board_mem_id);
		
		int insertCnt = service.insertBoard(boardVO);
		
		//get방식으로 보낼 board_tboard_seq 변수 설정하기
		int i = Integer.parseInt(board_tboard_seq);
		
		//정상적으로 게시판 입력된 경우 : 게시판 리스트 페이지로 이동
		if(insertCnt == 1){
			response.sendRedirect(request.getContextPath() + "/boadDetail?tboard_seq=" + i);
		//정상적으로 게시판 입력이 안 된 경우 : 게시판 입력 페이지로 이동
		}else{
			response.sendRedirect(request.getContextPath() + "/boardContent.jsp");
		}
		
	}

}
