<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Homepage</title>
<!-- TODO: 현재 페이지에 적절한 CSS를 임포트하십시오. -->
<link type="text/css" 
	rel="stylesheet" 
	href='<c:url value="/css/users.css" />'/>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
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
	<h1>회원 가입</h1>
	
	<form:form
		modelAttribute="userVo"
		id="join-form"
		name="registerForm" 
		action="${pageContext.servletContext.contextPath }/users/join"
		method="POST"
		>


		<label for="name">이름</label>
		<form:input path="name" placeholder="이름을 입력하십시오" /><br>
		<form:errors path="name" cssClass="error" /><br>		
		<!-- 이름 필드 에러 메시지 -->
		<%--spring:hasBindErrors name="userVo">
			<c:if test="${errors.hasFieldErrors('name') }">
				<strong style="color:red;">
				${errors.getFieldError('name').defaultMessage }
				</strong>
				<br>
			</c:if>
		</spring:hasBindErrors --%>
		
		<label for="password">비밀번호</label>
		<!-- input name="password" type="password" placeholder="비밀번호를 입력하십시오"><br -->
		<form:input path="password" placeholder="비밀번호를 입력하십시오" /><br>
		<form:errors path="password" cssClass="error"/><br>
		<!-- 비밀번호 에러 메시지 -->
		<%--spring:hasBindErrors name="userVo">
			<c:if test="${errors.hasFieldErrors('password') }">
				<strong style="color:red;">
				${errors.getFieldError('password').defaultMessage }
				</strong>
				<br>
			</c:if>
		</spring:hasBindErrors --%>
		
		<label for="email">이메일</label>
		<!-- input type="text" name="email" placeholder="이메일을 입력하십시오." -->
		<form:input path="email" placeholder="이메일을 입력하십시오" />
		<input type="button" id="check-email"
			data-target="<c:url value="/users/checkEmail" />"
			value="이메일 중복체크" /><br>
		<input type="hidden" name="emailCheck" value="n" />
		<!-- 이메일 필드 에러 메시지 -->
		<%--spring:hasBindErrors name="userVo">
			<c:if test="${errors.hasFieldErrors('email') }">
				<strong style="color:red;">
				${errors.getFieldError('email').defaultMessage }
				</strong>
				<br>
			</c:if>
		</spring:hasBindErrors --%>
		<form:errors path="email" cssClass="error" /><br>
	
		<label for="gender">성별</label>
		<!-- input type="radio" name="gender" value="M" checked>남성</radio -->
		<form:radiobutton path="gender" value="F" label="여성" />
		<!-- input type="radio" name="gender" value="F">여성</radio><br -->
		<form:radiobutton path="gender" value="M" label="남성" /><br>
		
		<label for="agree">약관동의</label>
		<input type="checkbox" id="agree" name="agree" value="n" />
		
		<input type="submit" value="전송"> 
			
	
		
		
	</form:form>		

	</div>
	</div>
	
	<!-- footer include -->
	<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
	
	
  </div>
</body>
</html>