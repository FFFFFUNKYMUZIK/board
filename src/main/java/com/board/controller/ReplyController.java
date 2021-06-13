package com.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.service.ReplyService;
import com.board.domain.ReplyVO;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

	@Inject
	ReplyService replyService;
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(ReplyVO vo) throws Exception {
			
		replyService.write(vo);
		
		return "redirect:/board/view?bno=" + vo.getBno();
	}
	
}
