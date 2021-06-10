package com.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.domain.BoardVO;
import com.board.service.BoardService;

import java.util.List;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	BoardService service;

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
	 
	 return "redirect:/board/list";
 }
 
 /* paging */
 @RequestMapping(value = "/listPage", method = RequestMethod.GET)
 public void getListPage(Model model, @RequestParam("num") int num) throws Exception{
	 
	 int count = service.count();
	 
	 int postNum = 10;
	 int pageNum = (int)Math.ceil((double)count/postNum);
	 int displayPost = (num-1)*postNum;
	 
	 int pageNum_cnt = 10;
	 int endPageNum = (((int)Math.ceil((double)num/(double)pageNum_cnt))*pageNum_cnt);
	 int startPageNum = endPageNum - (pageNum_cnt - 1);

	 if (endPageNum > count) {
		 endPageNum = count;
	 }
	 
	 boolean prev = startPageNum == 1 ? false : true;
	 boolean next = endPageNum >= count ? false : true;
	 
	// 시작 및 끝 번호
	 model.addAttribute("startPageNum", startPageNum);
	 model.addAttribute("endPageNum", endPageNum);

	 // 이전 및 다음 
	 model.addAttribute("prev", prev);
	 model.addAttribute("next", next);
	 
	List<BoardVO> list = null;
	list = service.listPage(displayPost, postNum);
	model.addAttribute("list", list);
	model.addAttribute("pageNum", pageNum);
	model.addAttribute("select", num);
 }
 
}