package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BUserVO;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.FileVO;
import kr.or.ddit.board.model.TBoardVO;

public class BoardService implements BoardServiceInf {
	
	private BoardDaoInf dao;
	
	public BoardService(){
		dao = new BoardDao();
	}
	
	/**
	 * 
		 * 
		* Method : loginProcess
		* 최초작성일 : 
		* 작성자 : "L.C.M"
		* 변경이력 :
		* @param userVO
		* @return
		* Method 설명 : 회원 로그인
	 */
	@Override
	public BUserVO loginCheck(Map<String, String> buserVO) {
		return dao.loginCheck(buserVO);
	}

	/**
	 * 
		 * 
		* Method : loginProcess
		* 최초작성일 : 
		* 작성자 : "L.C.M"
		* 변경이력 :
		* @param userVO
		* @return
		* Method 설명 : 게시판 가져오기
	 */
	@Override
	public List<TBoardVO> getTBoard() {
		return dao.getTBoard();
	}

	/**
	 * 
	* Method : getUser
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "L.C.M"
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 게시판 리스트
	 */
	@Override
	public List<BoardVO> getBoard(int tboard_seq) {
		return dao.getBoard(tboard_seq);
	}

	/**
	 * 
		 * 
		* Method : loginProcess
		* 최초작성일 : 
		* 작성자 : "L.C.M"
		* 변경이력 :
		* @param userVO
		* @return
		* Method 설명 : 게시판 생성하기
	 */
	@Override
	public int insertTBoard(Map<String, String> tBoardVO) {
		return dao.insertTBoard(tBoardVO);
	}

	/**
	 * 
	* Method : insertUser
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "L.C.M"
	* 변경이력 :
	* @param tBoardVO
	* @return
	* Method 설명 : 게시글 생성하기
	 */
	@Override
	public int insertBoard(Map<String, String> boardVO) {
		return dao.insertBoard(boardVO);
	}

	/**
	 * 
		 * 
		* Method : loginProcess
		* 최초작성일 : 
		* 작성자 : "L.C.M"
		* 변경이력 :
		* @param userVO
		* @return
		* Method 설명 : 게시글 내용 가져오기
	 */
	@Override
	public BoardVO getBoardAll(int board_seq) {
		return dao.getBoardAll(board_seq);
	}

	/**
	 * 
		 * 
		* Method : loginProcess
		* 최초작성일 : 
		* 작성자 : "L.C.M"
		* 변경이력 :
		* @param userVO
		* @return
		* Method 설명 : 게시글 수정 업데이트
	 */
	@Override
	public int updateBoard(BoardVO boardVO) {
		return dao.updateBoard(boardVO);
	}

	/**
	 * 
		 * 
		* Method : deleteBoard
		* 최초작성일 : 
		* 작성자 : "L.C.M"
		* 변경이력 :
		* @param boardVO
		* @return
		* Method 설명 : 게시글 삭제
	 */
	@Override
	public int deleteBoard(BoardVO boardVO) {
		return dao.deleteBoard(boardVO);
	}

	/**
	 * 
	* Method : getBoardPageList
	* 최초작성일 : 2018. 5. 3.
	* 작성자 : L.C.M
	* 변경이력 :
	* @param page
	* @param pageSize
	* @return
	* Method 설명 : 게시글 페이지 list 조회
	 */
	@Override
	public Map<String, Object> getBoardPageList(int page, int pageSize, int tboard_seq) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<BoardVO> boardList = dao.getBoardPageList(page, pageSize, tboard_seq); 

		String pageNav = makePageNav(page, dao.getBoardTotalCnt());

		resultMap.put("boardList", boardList);
		resultMap.put("pageNav", pageNav);
//		resultMap.put("tboard_seq", tboard_seq);

		return resultMap;
	}

	/** 
	 * Method   : makePageNav
	 * 최초작성일  : 2018. 5. 4. 
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @param page
	 * @param boardTotalCnt 
	 * Method 설명 : 페이지 내비게이션 생성
	 */
	private String makePageNav(int page, int boardTotalCnt) {
		
		int pageTotalCnt = (int)Math.ceil((double)boardTotalCnt / 10);
		
		StringBuffer pageNav = new StringBuffer();
		
		pageNav.append("<nav");
		pageNav.append("	<ul class=\"pagination\">");
		pageNav.append("		<li>");
		pageNav.append("		<a href=\"boadDetail?page=1&pageSize=10\" aria-label=\"Previous\">");
		pageNav.append("		<span aria-hidden=\"true\">&laquo;</span>");
		pageNav.append("		</a>");
		pageNav.append("		</li>");
		
		
		//pageTotalCnt
		//pageTotalCnt만큼 루프를 돌리고 싶을 때
		for(int i=1; i<=pageTotalCnt; i++){
			if(i==page)
				pageNav.append("		<li class=\"active\"><a href=\"boadDetail?page="+i+"&pageSize=10\">"+i+"</a></li>");
			else
				pageNav.append("		<li><a href=\"boadDetail?page="+i+"&pageSize=10\">" + i + "</a></li>");
		}
		
		pageNav.append("		<li>");
		pageNav.append("		<a href=\"boadDetail?page="+pageTotalCnt+"&pageSize=10\" aria-label=\"Next\">");
		pageNav.append("		<span aria-hidden=\"true\">&raquo;</span>");
		pageNav.append("		</a>");
		pageNav.append("		</li>");
		pageNav.append("		</ul>");
		pageNav.append("		</nav>");
		
		return pageNav.toString();
		
	}

	/**
	 * 
		 * 
		* Method : loginProcess
		* 최초작성일 : 
		* 작성자 : "L.C.M"
		* 변경이력 :
		* @param file_path
		* @return
		* Method 설명 : 파일 업로드
	 */
	@Override
	public int insertFile(String file_path) {
		return dao.insertFile(file_path);
	}

	/**
	 * 
		 * 
		* Method : loginProcess
		* 최초작성일 : 
		* 작성자 : "L.C.M"
		* 변경이력 :
		* @param file_path
		* @return
		* Method 설명 : 게시 파일 가져오기
	 */
	@Override
	public FileVO getFile(String file_path) {
		return dao.getFile(file_path);
	}

}
