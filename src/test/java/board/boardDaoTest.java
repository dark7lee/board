package board;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BUserVO;
import kr.or.ddit.board.model.BoardVO;

import org.junit.Test;

public class boardDaoTest {

	@Test
	public void test() {
		/***Given***/
		BoardDaoInf dao = new BoardDao();
		
		Map<String, String> memVo = new HashMap<String, String>();
		memVo.put("mem_id", "1");
		memVo.put("mem_pass", "1");
		
		/***When***/
		BUserVO resultLogin = dao.loginCheck(memVo);
		
		/***Then***/
		//assertEquals(예상값, 실제 결과값)
		assertEquals(memVo.get("mem_id"), resultLogin.getMem_id());
		assertEquals(memVo.get("mem_pass"), resultLogin.getMem_pass());
	}

}
