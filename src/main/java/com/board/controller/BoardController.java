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
	 BoardVO vo = service.view(bno);
	 model.addAttribute("view", vo);
 }
 
 /* modify Post */
 
 @RequestMapping(value = "/modify", method = RequestMethod.GET)
 public void getModify(@RequestParam("bno") int bno, Model model) throws Exception{
	 BoardVO vo = service.view(bno);
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
 
 
 
}