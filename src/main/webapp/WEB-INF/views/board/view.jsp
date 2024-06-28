<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>My Homepage</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet"
	href='<c:url value="/css/board.css" />' />
</head>
<body>
  <div id="container">
  
    <!-- header include -->
    <c:import url="/WEB-INF/views/includes/header.jsp">
    	<c:param name="param1" value="value1" />
    	<c:param name="param2" value="value2" />
    </c:import>

	<!-- navigation include -->
	<c:import url="/WEB-INF/views/includes/navigation.jsp" />
    
	<div id="wrapper">
      <div id="content">
			<!-- Content 영역 -->
				
	<table border="1" width="480">
		<tr>
			<td colspan="2"><h3>게시판</h3></td>
		</tr>
		<tr>
			<th colspan="2">글보기</th>
		</tr>
		<tr>
			<td>제목</td>
			<td>${vo.title }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<div>
					${vo.content }
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="<c:url value="/board" />">글목록</a>
				<a href="">글수정</a>
			</td>
		</tr>
	</table>


	</div>
	</div>
	
	<!-- footer include -->
	<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
	
	
  </div>
</body>
</html>
