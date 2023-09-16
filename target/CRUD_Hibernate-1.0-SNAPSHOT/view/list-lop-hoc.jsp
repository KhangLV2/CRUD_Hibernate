
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách lớp học</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
     <div class="container mt-3">
         <h1>Danh sách lớp học</h1>
         <a href="/view-add" class="btn btn-success">Add</a>
         <table class="table table-hover">
             <thead>
                 <tr>
                     <th>Mã lớp</th>
                     <th>Tên lớp</th>
                     <th>Số lượng</th>
                     <th>Tòa</th>
                     <th>Action</th>
                 </tr>
             </thead>
             <tbody>
                <c:forEach items="${lopHoc}" var="o">
                    <tr>
                        <td>${o.maLop}</td>
                        <td>${o.tenLop}</td>
                        <td>${o.soLuong}</td>
                        <td>${o.toa}</td>
                        <td>
                            <a href="/view-update?idLopHoc=${o.id}" class="btn btn-primary">Update</a>
                            <a href="/delete?id=${o.id}" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
             </tbody>
         </table>
     </div>
</body>
</html>
