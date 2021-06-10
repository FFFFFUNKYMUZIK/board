<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회</title>
</head>

<body>

<div id="nav">
 <%@ include file="../include/nav.jsp" %>
</div>

<label> Title </label>
${view.title} <br />

<label>작성자</label>
${view.writer} <br />

<label>내용</label><br />
${view.content}	<br />

<div>
<a href = "/board/modify?bno=${view.bno}">게시물 수정</a>
<a href = "/board/delete?bno=${view.bno}">게시물 삭제</a>
</div>

<!--댓글 시작-->

<hr />

<ul>
    <li>
        <div>
            <p>첫번째 댓글 작성자</p>
            <p>첫번째 댓글</p>
        </div>
    </li>
    <li>
        <div>
            <p>두번째 댓글 작성자</p>
            <p>두번째 댓글</p>
        </div>
    </li>
    <li>
        <div>
            <p>세번째 댓글 작성자</p>
            <p>세번째 댓글</p>
        </div>
    </li>
</ul>

<div>
    <p>
        <label>댓글 작성자</label> <input type="text">
    </p>
    <p>
        <textarea rows="5" cols="50"></textarea>
    </p>
    <p>
        <button type="button">댓글 작성</button>
    </p>
</div>

<!--댓글 끝-->

</body>
</html>