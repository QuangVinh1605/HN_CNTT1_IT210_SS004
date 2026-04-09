<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Danh sách bàn</title>
</head>
<body>

<h2>Danh sách bàn</h2>

<form action="<c:url value='/admin/tables/list'/>" method="get">
    Lọc sức chứa:
    <input name="cap" type="number">
    <button type="submit">Tìm</button>
</form>

<br>

<c:if test="${error != null}">
    <p style="color:red">${error}</p>
</c:if>

<c:if test="${message != null}">
    <p style="color:green">${message}</p>
</c:if>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Sức chứa</th>
        <th>Trạng thái</th>
        <th>Hành động</th>
    </tr>

    <c:forEach var="t" items="${tables}">
        <tr>
            <td>${t.id}</td>
            <td>${t.capacity}</td>
            <td>${t.status}</td>
            <td>

                <a href="<c:url value='/admin/tables/view/${t.id}'/>">Chi tiết</a>

                <form action="<c:url value='/admin/tables/update-status'/>" method="post" style="display:inline">
                    <input type="hidden" name="id" value="${t.id}">
                    <input type="hidden" name="status"
                           value="${t.status == 'Trống' ? 'Đang dùng' : 'Trống'}">
                    <button type="submit">
                            ${t.status == 'Trống' ? 'Nhận bàn' : 'Trả bàn'}
                    </button>
                </form>

                <form action="<c:url value='/admin/tables/delete/${t.id}'/>" method="post" style="display:inline">
                    <button type="submit"
                            onclick="return confirm('Xóa bàn này?')">
                        Xóa
                    </button>
                </form>

            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
