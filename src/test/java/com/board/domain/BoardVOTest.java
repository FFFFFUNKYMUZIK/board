package com.board.domain;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class BoardVOTest {

	@Test
	public void test() {
		BoardVO boardVO = new BoardVO();
		
		int bno = 1;
		String title = "test-title";
		String content = "test-content";
		String writer = "test-writer";
		/* Date is auto-generated in DB */
		Date date = new Date();
		int viewCnt = 2;
		
		/* set member variables input to VO */ 
		boardVO.setBno(bno);
		boardVO.setTitle(title);
		boardVO.setContent(content);
		boardVO.setWriter(writer);
		boardVO.setRegDate(date);
		boardVO.setViewCnt(viewCnt);
		
		/* compare value with returned value by getter */ 
		
		assertEquals(bno, boardVO.getBno());
		/* assertEquals call object.equlas() method, so can be applied to object which implements this
		 * but assertSame compare two arguments using '==' operand, so not applicable to object type 
		 */
		assertEquals(title, boardVO.getTitle());
		assertEquals(content, boardVO.getContent());
		assertEquals(writer, boardVO.getWriter());
		assertEquals(date, boardVO.getRegDate());
		assertEquals(viewCnt, boardVO.getViewCnt());
		
		
	}

}
