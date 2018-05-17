package kr.or.ddit.board.model;

import java.util.Date;

public class CommentsVO {

	private Integer cmt_seq;
	private Integer cmt_board_seq;
	private String cmt_mem_id;
	private String cmt_content;
	private Date cmt_reg_dt;
	private String cmt_del_yn;
	
	public CommentsVO(){
		
	}
	
	public CommentsVO(Integer cmt_seq, Integer cmt_board_seq,
			String cmt_mem_id, String cmt_content, Date cmt_reg_dt,
			String cmt_del_yn) {
		this.cmt_seq = cmt_seq;
		this.cmt_board_seq = cmt_board_seq;
		this.cmt_mem_id = cmt_mem_id;
		this.cmt_content = cmt_content;
		this.cmt_reg_dt = cmt_reg_dt;
		this.cmt_del_yn = cmt_del_yn;
	}


	public Integer getCmt_seq() {
		return cmt_seq;
	}

	public void setCmt_seq(Integer cmt_seq) {
		this.cmt_seq = cmt_seq;
	}

	public Integer getCmt_board_seq() {
		return cmt_board_seq;
	}

	public void setCmt_board_seq(Integer cmt_board_seq) {
		this.cmt_board_seq = cmt_board_seq;
	}

	public String getCmt_mem_id() {
		return cmt_mem_id;
	}

	public void setCmt_mem_id(String cmt_mem_id) {
		this.cmt_mem_id = cmt_mem_id;
	}

	public String getCmt_content() {
		return cmt_content;
	}

	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}

	public Date getCmt_reg_dt() {
		return cmt_reg_dt;
	}

	public void setCmt_reg_dt(Date cmt_reg_dt) {
		this.cmt_reg_dt = cmt_reg_dt;
	}

	public String getCmt_del_yn() {
		return cmt_del_yn;
	}

	public void setCmt_del_yn(String cmt_del_yn) {
		this.cmt_del_yn = cmt_del_yn;
	}
	
	
}
