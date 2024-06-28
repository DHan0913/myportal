<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Homepage</title>
<link type="text/css" rel="stylesheet"
	href='<c:url value="/css/guestbook.css" />' />
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

				<h1>방명록</h1>
				<h3>방명록 삭제</h3>
				<form method="post" action="<c:url value="/guestbook/delete" />">
					<input type='hidden' name="no" value="${no }"> <label
						for="password">비밀번호</label> <input type="password" name="password" placeholder="비밀번호를 입력하세요">
					<input type="submit" value="확인"><br> <a
						href="<c:url value="/guestbook" />">목록 보기</a>
				</form>


			</div>
		</div>

		<!-- footer include -->
		<%@ include file="/WEB-INF/views/includes/footer.jsp"%>


	</div>
</body>
</html>