package com.board.dao;

import java.util.List;

import com.board.domain.BoardVO;

public interface BoardDAO {
	
	public List<BoardVO> list() throws Exception;
	
	public void write(BoardVO vo) throws Exception;
	
	public BoardVO get(int bno, boolean view) throws Exception;

	public void modify(BoardVO vo) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public int count() throws Exception;
	
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception;
	
	// 게시물 총 갯수 + 검색 적용
		public int searchCount(String searchType, String keyword) throws Exception;
	
	public List<BoardVO> listPageSearch(
			   int displayPost, int postNum, String searchType, String keyword) throws Exception;
	
}
