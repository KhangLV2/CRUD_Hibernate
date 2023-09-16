
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form thêm</title>
    <!-- Latest compiled and minified CSS -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
    />
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
</head>
<body>
<div class="container">
    <h2 style="text-align: center;margin-top: 20px;">Thêm sinh viên</h2>
    <form action="/update?id=${lh.id}" method="post">
        <div class="mb-3">
            <label class="form-label">Mã lớp học:</label>
            <input type="text" class="form-control" name="ma" value="${lh.maLop}">
        </div>
        <div class="mb-3">
            <label class="form-label">Tên lớp học:</label>
            <input type="text" class="form-control" name="ten" value="${lh.tenLop}">
        </div>
        <div class="mb-3">
            <label  class="form-label">Số lượng sinh viên:</label>
            <input type="text" class="form-control" name="soluong" value="${lh.soLuong}" >
        </div>
        <div class="mb-3">
            <label class="form-label">Tòa:</label>
            <input type="text" class="form-control" name="toa" value="${lh.toa}">
        </div>
        <button type="submit" class="btn btn-success" style="margin-left:600px;padding: 10px 20px;font-size: 20px;">Update</button>
    </form>
</div>

</body>
</html>
