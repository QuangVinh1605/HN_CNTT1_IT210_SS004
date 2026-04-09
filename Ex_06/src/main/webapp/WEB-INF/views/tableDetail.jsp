<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Chi tiết bàn</title>
</head>
<body>

<h2>Chi tiết bàn</h2>

<p>ID: ${table.id}</p>
<p>Sức chứa: ${table.capacity}</p>
<p>Trạng thái: ${table.status}</p>

<br>

<a href="<c:url value='/admin/tables/list'/>">Quay lại danh sách</a>

</body>
</html>
