<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>사원 정보 상세 조회</h1>
<table border="1">

<tr>
	<th>employee_id</th>
	<td>${emp.employeeId}</td>
</tr>
<tr>
	<th>employee_id</th>
	<td>${emp.employeeId}</td>
</tr>
<tr>
	<th>first_name</th>
	<td>${emp.firstName}</td>
</tr>
<tr>
	<th>last_name</th>
	<td>${emp.lastName}</td>
</tr>
<tr>
	<th>email</th>
	<td>${emp.email}</td>
</tr>
<tr>
	<th>phone_number</th>
	<td>${emp.phoneNumber}</td>
</tr>
<tr>
	<th>hire_date</th>
	<td>${emp.hireDate}</td>
</tr>
<tr>
	<th>job_id</th>
	<td>${emp.jobId}</td>
</tr>
<tr>
	<th>salary</th>
	<td>${emp.salary}</td>
</tr>
<tr>
	<th>commission_pct</th>
	<td>${emp.commissionPct}</td>
</tr>
<tr>
	<th>manager_id</th>
	<td>${emp.managerId}</td>
</tr>
<tr>
	<th>department_id</th>
	<td>${emp.departmentId}</td>
</tr>

</table>
<a href="update?empid=${emp.employeeId}">수정하기</a>
<a href="delete?empid=${emp.employeeId}">삭제하기</a>

</body>
</html>