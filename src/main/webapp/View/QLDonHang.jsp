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
	<h3>
			<a href="themsanpham">Add new</a>
		</h3>
		<table >
			<tr>
				<th>Mã đơn hàng</th>
				<th>Tên khách hàng</th>
				<th>Địa chỉ nhận hàng</th>
				<th>Danh sách đặt hàng</th>
				<th>Thành tiền</th>
				<th>Trạng thái</th>
			</tr>
			<c:forEach items="${data}" var="c">			
				<tr>
					<td>${c.maDonHang}</td>
					<td>${c.khachHang.tenNguoiDung }</td>
					<td>${c.diaChiNhanHang}</td>
					<td><a href="qldonhangchitiet?id=${c.maDonHang }">Danh sách đặt hàng</a>
					<td>${c.thanhTien}</td>
					<td>${c.trangThai}</td>
					<td><a href="cap?id=${c.maDonHang}">Update</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="#" onclick="doDelete('${c.maDonHang}')">Delete</a></td>
				</tr>
			</c:forEach>

		</table>
</body>
</html>