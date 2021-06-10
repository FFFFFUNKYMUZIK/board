package com.board.domain;

public class Page {

	// 현재 페이지 번호
	private int num;

	// 게시물 총 갯수
	private int count;

	// 한 페이지에 출력할 게시물 갯수
	private int postNum = 10;

	// 총 페이지 수
	private int pageNum;

	// 현재 페이지의 첫 게시물 번호
	private int displayPost;

	// 한번에 표시할 페이징 번호의 갯수
	private int pageNumCnt = 10;

	// 표시되는 페이지 번호 중 마지막 번호
	private int endPageNum;

	// 표시되는 페이지 번호 중 첫번째 번호
	private int startPageNum;

	// 다음/이전 표시 여부
	private boolean prev;
	private boolean next;
	
	public void setNum(int num) {
		this.num = num;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	
	public int getDisplayPost() {
		return displayPost;
	}

	public int getPageNumCnt() {
		return pageNumCnt;
	}
	public void setPageNumCnt(int pageNumCnt) {
		this.pageNumCnt = pageNumCnt;
	}
	
	public int getEndPageNum() {
		return endPageNum;
	}
	
	public int getStartPageNum() {
		return startPageNum;
	}
	
	public boolean isPrev() {
		return prev;
	}
	
	public boolean isNext() {
		return next;
	}
	
	public void calculate() {
		 
		 pageNum = (int)Math.ceil((double)count/postNum);
		 displayPost = (num-1)*postNum;
		 
		 endPageNum = (((int)Math.ceil((double)num/(double)pageNumCnt))*pageNumCnt);
		 startPageNum = endPageNum - (pageNumCnt - 1);

		 if (endPageNum > pageNum) {
			 endPageNum = pageNum;
		 }
		 
		 prev = startPageNum == 1 ? false : true;
		 next = endPageNum == pageNum ? false : true;
		
	}
	

	public String getSearchTypeKeyword() {

		if(searchType.equals("") || keyword.equals("")) {
			return ""; 
		} else {
			return "&searchType=" + searchType + "&keyword=" + keyword; 
		}
	}

	private String searchType;
	private String keyword; 

	public void setSearchType(String searchType) {
		this.searchType = searchType;  
	}

	public String getSearchType() {
		return searchType;
	} 

	public void setKeyword(String keyword) {
		this.keyword = keyword;  
	} 

	public String getKeyword() {
		return keyword;
	}
		
}
