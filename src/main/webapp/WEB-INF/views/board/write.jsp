<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post</title>
</head>

<body>

<div id="nav">
 <%@ include file="../include/nav.jsp" %>
</div>

<form method="post">

<label> Title </label>
<input type="text" name="title" /><br />

<label>작성자</label>
<input type="text" name="writer" /><br />

<label>내용</label>
<textarea cols="50" rows="5" name="content"></textarea><br />

<button type="submit">작성</button>

</form>

</body>
</html>