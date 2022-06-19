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
<form action="themsanpham" method="post">

            Tên sản phẩm: <input type="text" name="tenSanPham"/></br> 
            Giá tiền: <input type="text" name="giaTien"/></br> 
            Miêu tả: <input type="text" name="mieuTa"/></br> 
            Hình ảnh: <input type="text" name="hinhAnh"/></br>
            Đơn vị tính: <input type="text" name="donViTinh"></br>
            Số lượng: <input type="text" name="tonKho"></br>
            Thể loại: <select name="theloai">
            <c:forEach items="${dstheloai}" var="c">	
            		<option value="${c.maTheLoai }">${c.tenTheLoai }</option>
            		</c:forEach>
            </select>
            <input type="submit" value="SAVE"/>
        </form>
</body>
</html>