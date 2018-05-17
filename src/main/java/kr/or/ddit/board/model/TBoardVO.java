package kr.or.ddit.board.model;

import java.util.Date;

public class TBoardVO {

	private Integer tboard_seq;
	private String tboard_title;
	private Date tboard_reg_dt;
	private String tboard_del_yn;
	private String tboard_mem_id;
	
	public TBoardVO(){
		
	}
	
	public TBoardVO(Integer tboard_seq, String tboard_title,
			Date tboard_reg_dt, String tboard_del_yn, String tboard_mem_id) {
		this.tboard_seq = tboard_seq;
		this.tboard_title = tboard_title;
		this.tboard_reg_dt = tboard_reg_dt;
		this.tboard_del_yn = tboard_del_yn;
		this.tboard_mem_id = tboard_mem_id;
	}



	public Integer getTboard_seq() {
		return tboard_seq;
	}

	public void setTboard_seq(Integer tboard_seq) {
		this.tboard_seq = tboard_seq;
	}

	public String getTboard_title() {
		return tboard_title;
	}

	public void setTboard_title(String tboard_title) {
		this.tboard_title = tboard_title;
	}

	public Date getTboard_reg_dt() {
		return tboard_reg_dt;
	}

	public void setTboard_reg_dt(Date tboard_reg_dt) {
		this.tboard_reg_dt = tboard_reg_dt;
	}

	public String getTboard_del_yn() {
		return tboard_del_yn;
	}

	public void setTboard_del_yn(String tboard_del_yn) {
		this.tboard_del_yn = tboard_del_yn;
	}

	public String getTboard_mem_id() {
		return tboard_mem_id;
	}

	public void setTboard_mem_id(String tboard_mem_id) {
		this.tboard_mem_id = tboard_mem_id;
	}
	
	
	
}
