<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 24px; }
        .box { border: 1px solid #ddd; border-radius: 8px; padding: 16px; max-width: 520px; }
        .label { font-weight: bold; }
    </style>
</head>
<body>
<div class="box">
    <h1>Danh sách món ăn</h1>
    <p><span class="label">Category:</span> ${category}</p>
    <p><span class="label">Limit:</span> ${limit}</p>
    <p><span class="label">Message:</span> ${message}</p>
</div>
</body>
</html>

