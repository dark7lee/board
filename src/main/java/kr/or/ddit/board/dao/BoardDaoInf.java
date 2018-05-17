package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BUserVO;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.FileVO;
import kr.or.ddit.board.model.TBoardVO;


public interface BoardDaoInf {

	/**
	 * 
	* Method : loginCheck
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "L.C.M"
	* 변경이력 :
	* @param buserVO
	* @return
	* Method 설명 : 회원 로그인
	 */
	public BUserVO loginCheck(Map<String, String> buserVO);

	/**
	 * 
	* Method : getBoard
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "L.C.M"
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 게시판 리스트
	 */
	public List<BoardVO> getBoard(int tboard_seq);
	
	/**
	 * 
	* Method : getTBoard
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "L.C.M"
	* 변경이력 :
	* @param tboardVO
	* @return
	* Method 설명 : 게시판 가져오기
	 */
	public List<TBoardVO> getTBoard();
	
	/**
	 * 
	* Method : insertTBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "L.C.M"
	* 변경이력 :
	* @param tBoardVO
	* @return
	* Method 설명 : 게시판 생성하기
	 */
	public int insertTBoard(Map<String, String> tBoardVO);
	
	/**
	 * 
	* Method : insertBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "L.C.M"
	* 변경이력 :
	* @param tBoardVO
	* @return
	* Method 설명 : 게시글 생성하기
	 */
	public int insertBoard(Map<String, String> boardVO);
	
	/**
	 * 
	* Method : getBoardAll
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "L.C.M"
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 게시글 내용 가져오기
	 */
	public BoardVO getBoardAll(int board_seq);
	
	/**
	 * 
	* Method : updateBoard
	* 최초작성일 : 2018. 5. 11.
	* 작성자 : "L.C.M"
	* 변경이력 :
	* @param userVO
	* @return
	* Method 설명 : 게시글 수정 업데이트
	 */
	public int updateBoard(BoardVO boardVO);
	
	/**
	 * 
	* Method : deleteBoard
	* 최초작성일 : 2018. 5. 11.
	* 작성자 : "L.C.M"
	* 변경이력 :
	* @param userVO
	* @return
	* Method 설명 : 게시글 삭제 
	 */
	public int deleteBoard(BoardVO boardVO);
	
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
	public List<BoardVO> getBoardPageList(int page, int pageSize, int tboard_seq);
	
	/**
	 * 
	* Method : getUserTotalCnt
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "L.C.M"
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 페이지 건수 조회
	 */
	public int getBoardTotalCnt();
	
	/**
	 * 
	* Method : insertFile
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "L.C.M"
	* 변경이력 :
	* @param FileVO
	* @return
	* Method 설명 : 파일 업로드
	 */
	public int insertFile(String file_path);
	
	/**
	 * 
	* Method : getFile
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "L.C.M"
	* 변경이력 :
	* @param file_path
	* @return
	* Method 설명 : 게시 파일 가져오기
	 */
	public FileVO getFile(String file_path);
	
}
