package kr.or.ddit.board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;





import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.board.model.BUserVO;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.FileVO;
import kr.or.ddit.board.model.TBoardVO;

public class BoardDao implements BoardDaoInf {

	private SqlSessionFactory SqlSessionFactory;
	
	public BoardDao(){
		String resource = "db/mybatis/mybatisConfig.xml";
		InputStream inputStream = null;		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		
		SqlSession sqlSession = SqlSessionFactory.openSession();
		
		BUserVO resultBuserVO = null;
		resultBuserVO = (BUserVO) sqlSession.selectOne("buser.getLogin", buserVO);
		
		sqlSession.close();
		
		return resultBuserVO;
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
	public List<TBoardVO> getTBoard(){
		List<TBoardVO> resultTBoardVO = new ArrayList<TBoardVO>();
		
		SqlSession sqlSession = SqlSessionFactory.openSession();
		
		resultTBoardVO = sqlSession.selectList("tBoard.getTBoard");
		
		sqlSession.close();
		
		return resultTBoardVO;
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
		List<BoardVO> resultBoardVO = new ArrayList<BoardVO>();
			
		SqlSession sqlSession = SqlSessionFactory.openSession();
		
		resultBoardVO = sqlSession.selectList("boards.getBoard", tboard_seq);
		
		sqlSession.close();
		
		return resultBoardVO;
	}

	/**
	 * 
	* Method : insertUser
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "L.C.M"
	* 변경이력 :
	* @param tBoardVO
	* @return
	* Method 설명 : 게시판 생성하기
	 */
	@Override
	public int insertTBoard(Map<String, String> tBoardVO) {
		
		int resultInsert = 0;
		SqlSession sqlSession = SqlSessionFactory.openSession();
		
		try {
			resultInsert = sqlSession.insert("tBoard.insertTBoard", tBoardVO);
			
			sqlSession.commit();
			sqlSession.close();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			sqlSession.close();
		}
		return resultInsert;
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
		
		int insertResult = 0;
		SqlSession sqlSession = SqlSessionFactory.openSession();
		
		try {
			insertResult = sqlSession.insert("boards.insertBoard", boardVO);
			
			sqlSession.commit();
			sqlSession.close();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			sqlSession.close();
		}
		return insertResult;
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
		
		SqlSession sqlSession = SqlSessionFactory.openSession();
		BoardVO resultBoardAll = sqlSession.selectOne("boards.getBoardAll", board_seq);	
		sqlSession.close();
		
		return resultBoardAll;
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
		
		SqlSession sqlSession = SqlSessionFactory.openSession();
		int updateCnt = 0;
		
		updateCnt = sqlSession.update("boards.updateBoard", boardVO);
		
		sqlSession.commit();
		sqlSession.close();
		
		return updateCnt;
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
		* Method 설명 : 게시글 삭제
	 */
	@Override
	public int deleteBoard(BoardVO boardVO) {
		
		SqlSession sqlSession = SqlSessionFactory.openSession();
		
		int deleteCnt = 0;
		deleteCnt = sqlSession.delete("boards.deleteBoard", boardVO);
		
		sqlSession.commit();
		sqlSession.close();
		
		return deleteCnt;
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
	public List<BoardVO> getBoardPageList(int page, int pageSize, int tboard_seq) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("tboard_seq", tboard_seq);

		SqlSession sqlSession = SqlSessionFactory.openSession();
		List<BoardVO> boardList = sqlSession.selectList("buser.getBoardPageList", paramMap);
		sqlSession.close();
		
		return boardList;
	}

	/**
	 * 
	* Method : getUserTotalCnt
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "L.C.M"
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 페이지 건수 조회
	 */
	@Override
	public int getBoardTotalCnt() {
		SqlSession sqlSession = SqlSessionFactory.openSession();
		int boardTotalCnt = sqlSession.selectOne("buser.getBoardTotalCnt");
		sqlSession.close();
		
		return boardTotalCnt;
	}

	/**
	 * 
		 * 
		* Method : insertFile
		* 최초작성일 : 
		* 작성자 : "L.C.M"
		* 변경이력 :
		* @param fileVO
		* @return
		* Method 설명 : 파일 업로드
	 */
	@Override
	public int insertFile(String file_path) {
		SqlSession sqlSession = SqlSessionFactory.openSession();
		int insertResult = 0;
		
		try {
			insertResult = sqlSession.insert("boards.insertFile", file_path);
			
			sqlSession.commit();
			sqlSession.close();			
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			sqlSession.close();
		}
		
		return insertResult;
	}

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
	@Override
	public FileVO getFile(String file_path) {
		SqlSession sqlSession = SqlSessionFactory.openSession();
		
		FileVO resultFile = sqlSession.selectOne("boards.getFile", file_path);	
		sqlSession.close();
		
		return resultFile;
	}
	
}
