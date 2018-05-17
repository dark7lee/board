package kr.or.ddit.board.model;

public class FileVO {

	private Integer file_seq;
	private Integer file_board_seq;
	private String file_path;
	
	public FileVO(){
		
	}

	public FileVO(String file_path) {
		this.file_path = file_path;
	}



	public Integer getFile_seq() {
		return file_seq;
	}

	public void setFile_seq(Integer file_seq) {
		this.file_seq = file_seq;
	}

	public Integer getFile_board_seq() {
		return file_board_seq;
	}

	public void setFile_board_seq(Integer file_board_seq) {
		this.file_board_seq = file_board_seq;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	
	
}
