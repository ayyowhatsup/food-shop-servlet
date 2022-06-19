<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
            function doDelete(id){
                if(confirm("Đồng ý xóa sản phẩm ")){
                    window.location="xoasanpham?id="+id;
                }
            }
            </script>
</head>
<body>
	
		<h1>List of category</h1>
		<h3>
			<a href="themsanpham">Add new</a>
		</h3>
		<table >
			<tr>
				<th>Mã sản phẩm</th>
				<th>Tên sản phẩm</th>
				<th>Giá tiền</th>
				<th>Miêu tả</th>
				<th>Hình ảnh</th>
				<th>Đơn vị tính</th>
				<th>Tồn kho</th>
				<th>Thể loại</th>
			</tr>
			<c:forEach items="${data}" var="c">			
				<tr>
					<td>${c.maSanPham}</td>
					<td>${c.tenSanPham}</td>
					<td>${c.giaTien}</td>
					<td>${c.mieuTa}</td>
					<td>${c.hinhAnh}</td>
					<td>${c.donViTinh }</td>
					<td>${c.tonKho }</td>
					<td>${c.theLoai.tenTheLoai }</td>

					<td><a href="capnhatsanpham?id=${c.maSanPham}">Update</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="#" onclick="doDelete('${c.maSanPham}')">Delete</a></td>
				</tr>
			</c:forEach>

		</table>

</body>
</html>