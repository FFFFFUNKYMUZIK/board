package com.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.board.mappers.board";
	
	@Override
	public List<BoardVO> list() throws Exception {
		return sql.selectList(namespace + ".list");
	}
	
	@Override
	public void write(BoardVO vo) throws Exception{
		sql.insert(namespace + ".write", vo);
	}
		
	@Override
	public BoardVO get(int bno, boolean view) throws Exception{
		if (view){/* update viewcnt */
			sql.update(namespace + ".inc_vcnt", bno);
		}
		return sql.selectOne(namespace + ".view", bno);
	}
	
	@Override
	public void modify(BoardVO vo) throws Exception{
		sql.update(namespace + ".modify", vo);
	}
	
	@Override
	public void delete(int bno) throws Exception{
		sql.delete(namespace + ".delete", bno);
	}
	
	@Override
	public int count() throws Exception{
		return sql.selectOne(namespace+".count");		
	}
	
	@Override
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception{
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		return sql.selectList(namespace + ".listPage", data);
	}
	
}
