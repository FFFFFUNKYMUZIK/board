package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}
	
	@Override
	public void write(BoardVO vo) throws Exception{
		dao.write(vo);
	}
	
	@Override
	public BoardVO get(int bno, boolean view) throws Exception{
		return dao.get(bno, view);
	}
	
	@Override
	public void modify(BoardVO vo) throws Exception{
		dao.modify(vo);
	}
	
	@Override
	public void delete(int bno) throws Exception{
		dao.delete(bno);
	}

	@Override
	public int count() throws Exception{
		return dao.count();
	}
	
	@Override
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception{
		return dao.listPage(displayPost, postNum);
	}
	
	// 게시물 목록 + 페이징 + 검색
	@Override
	public List<BoardVO> listPageSearch(
	  int displayPost, int postNum, String searchType, String keyword) throws Exception {
	 return  dao.listPageSearch(displayPost, postNum, searchType, keyword);
	}
	
	// 게시물 총 갯수
	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
	 return dao.searchCount(searchType, keyword);
	}
	
}
