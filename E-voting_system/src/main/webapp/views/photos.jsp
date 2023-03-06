<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1"  %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>View Photo</h1>
<img th:src="*{'data:image/jpg;base64,'+image}">
</body>
</html>