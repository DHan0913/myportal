<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<h1>파일 업로드</h1>

	<form method="post" action="<c:url value ="/fileupload/upload" />"
		enctype="multipart/form-data">
		<label>File</label>
		<input type="file" name="file1" />
		<input type="submit" value="upload" />
		</form>
</body>
</html>