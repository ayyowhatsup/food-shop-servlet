<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>


</head>
<body>
<script type="text/javascript">
	function doDelete(id) {
		if (confirm("Đồng ý xóa thể loại ?? ")) {
			window.location = "xoatheloai?id=" + id;
		}
	}
</script>
	<h3>
		<a href="themtheloai">Add new</a>
	</h3>
	<table>
		<tr>
			<th>Mã thể loại</th>
			<th>Tên thể loại</th>
		</tr>
		<c:forEach items="${data}" var="c">
			<tr>
				<td>${c.maTheLoai}</td>
				<td>${c.tenTheLoai }</td>
				<td><a href="suatheloai?id=${c.maTheLoai}">Update</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="#" onclick="doDelete('${c.maTheLoai}')">Delete</a></td>
			</tr>
		</c:forEach>

	</table>
	<form action="themtheloai" method="post">
		<h3>Thêm thể loại</h3>
		<label>Tên thể loại: </label><input type="text" name="tenTheLoai" /></br> 
		<input
			type="submit" value="SAVE" />
	</form>
</body>
</html>