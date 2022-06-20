<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="capnhatnguoidung" method="post">
<c:set var="c" value="${requestScope.nguoidung}"/>
Mã người dùng: <input type="text" name="maNguoiDung" readonly value="${c.maNguoiDung }"/></br>
            Tên người dùng: <input type="text" name="tenNguoiDung" value="${c.tenNguoiDung}"/></br> 
            Số điện thoại : <input type="text" name="soDienThoai" value="${c.soDienThoai }"/></br> 
            Chức năng: <input type="text" name="laQuanTriVien" value="${c.laQuanTriVien }"/></br>
            <input type="submit" value="Lưu"/>
        </form>
</body>
</html>