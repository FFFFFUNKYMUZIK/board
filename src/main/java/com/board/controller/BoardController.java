package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVO;
import com.board.domain.ReplyVO;

import com.board.domain.Page;

import com.board.service.BoardService;
import com.board.service.ReplyService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	BoardService service;
	
	@Inject
	ReplyService replyService;

/* List of Posts */
	
 @RequestMapping(value = "/list", method = RequestMethod.GET)
 public void getList(Model model) throws Exception {
  
	 List<BoardVO> list = null;
	 list = service.list();
   
	 model.addAttribute("list", list);
	 
 }
 
 /* Write Posts */
 
 @RequestMapping(value = "/write", method = RequestMethod.GET)
 public void getWrite(Model model) throws Exception {
	 /* nop */
 }
 
 @RequestMapping(value = "/write", method = RequestMethod.POST)
 public String postWrite(BoardVO vo) throws Exception{
	 service.write(vo);
	 
	 return "redirect:/board/list";
 }
 
 /* view Post */
 
 @RequestMapping(value = "/view", method = RequestMethod.GET)
 public void getView(@RequestParam("bno") int bno, Model model) throws Exception {
	 BoardVO vo = service.get(bno, true /* view */);
	 model.addAttribute("view", vo);
	 
	 List<ReplyVO> reply = null;
	 reply = replyService.list(bno);
	 model.addAttribute("reply", reply);
 }
 
 /* modify Post */
 
 @RequestMapping(value = "/modify", method = RequestMethod.GET)
 public void getModify(@RequestParam("bno") int bno, Model model) throws Exception{
	 BoardVO vo = service.get(bno, false /* view */);
	 model.addAttribute("view", vo);
 }
 
 @RequestMapping(value = "/modify", method = RequestMethod.POST)
 public String postModify(BoardVO vo) throws Exception{
	 service.modify(vo);
	 
	 return "redirect:/board/view?bno=" + vo.getBno();
 }
 
 /* delete Post */

 @RequestMapping(value = "/delete", method = RequestMethod.GET)
 public String getDelete(@RequestParam("bno") int bno, Model model) throws Exception{
	 service.delete(bno);
	 
	 return "redirect:/board/listPageSearch?num=1";
 }
 
 /* paging */
 @RequestMapping(value = "/listPage", method = RequestMethod.GET)
 public void getListPage(Model model, @RequestParam("num") int num) throws Exception{
	 
	 Page page = new Page();
	 
	 page.setCount(service.count());
	 page.setNum(num);
	 /*
	  * page.setPageNumCnt(num);
	  * page.setPostNum(num);
	  */
	 
	 page.setPageNumCnt(5);
	 page.setPostNum(30);
	 	 
	 page.calculate();
	 
	// 시작 및 끝 번호
	 model.addAttribute("startPageNum", page.getStartPageNum());
	 model.addAttribute("endPageNum", page.getEndPageNum());

	 // 이전 및 다음 
	 model.addAttribute("prev", page.isPrev());
	 model.addAttribute("next", page.isNext());
	 
	List<BoardVO> list = null;
	list = service.listPage(page.getDisplayPost(), page.getPostNum());
	model.addAttribute("list", list);
	model.addAttribute("select", num);
 }
 

 /* searching & paging */
 @RequestMapping(value = "/listPageSearch", method = RequestMethod.GET)
 public void getListPageSearch(Model model, @RequestParam("num") int num, 
		 @RequestParam(value = "searchType",required = false, defaultValue = "title") String searchType,
		   @RequestParam(value = "keyword",required = false, defaultValue = "") String keyword) throws Exception{
	 
	 Page page = new Page();
	 
	 page.setCount(service.searchCount(searchType, keyword));
	 page.setNum(num);
	 /*
	  * page.setPageNumCnt(num);
	  * page.setPostNum(num);
	  */
	 
	 page.setPageNumCnt(5);
	 page.setPostNum(30);
	 
	// 검색 타입과 검색어
	 page.setSearchType(searchType);
	 page.setKeyword(keyword);
	 	 
	 page.calculate();
	 
	List<BoardVO> list = null;
	list = service.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
	model.addAttribute("list", list);
	model.addAttribute("select", num);
	model.addAttribute("page", page);

 }
 
}