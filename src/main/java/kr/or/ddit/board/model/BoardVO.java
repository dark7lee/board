package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVO {

	private Integer board_seq;
	private Integer board_p_seq;
	private Integer board_tboard_seq;
	private Integer board_group_seq;
	private String board_title;
	private String board_content;
	private Date board_reg_dt;
	private String board_del_yn;
	private String board_mem_id;
	
	public BoardVO(){
		
	}

//	public BoardVO(Integer board_seq, String board_title, Date board_reg_dt, String board_mem_id) {
//		this.board_seq = board_seq;
//		this.board_title = board_title;
//		this.board_reg_dt = board_reg_dt;
//		this.board_mem_id = board_mem_id;
//	}
	public BoardVO(int board_seq, String board_title, String board_content) {
		this.board_seq = board_seq;
		this.board_title = board_title;
		this.board_content = board_content;
	}

	public Integer getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(Integer board_seq) {
		this.board_seq = board_seq;
	}

	public Integer getBoard_p_seq() {
		return board_p_seq;
	}

	public void setBoard_p_seq(Integer board_p_seq) {
		this.board_p_seq = board_p_seq;
	}

	public Integer getBoard_tboard_seq() {
		return board_tboard_seq;
	}

	public void setBoard_tboard_seq(Integer board_tboard_seq) {
		this.board_tboard_seq = board_tboard_seq;
	}

	public Integer getBoard_group_seq() {
		return board_group_seq;
	}

	public void setBoard_group_seq(Integer board_group_seq) {
		this.board_group_seq = board_group_seq;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public Date getBoard_reg_dt() {
		return board_reg_dt;
	}

	public void setBoard_reg_dt(Date board_reg_dt) {
		this.board_reg_dt = board_reg_dt;
	}

	public String getBoard_del_yn() {
		return board_del_yn;
	}

	public void setBoard_del_yn(String board_del_yn) {
		this.board_del_yn = board_del_yn;
	}

	public String getBoard_mem_id() {
		return board_mem_id;
	}

	public void setBoard_mem_id(String board_mem_id) {
		this.board_mem_id = board_mem_id;
	}
	
	
}
