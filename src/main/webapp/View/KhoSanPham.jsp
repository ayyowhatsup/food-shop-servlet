<%@page import="com.group3.Model.TheLoai"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<LINK REL="stylesheet"
	HREF="<%=request.getContextPath()%>/View/css/KhoSanPham.css"
	TYPE="text/css">
<title>Refood - Sản phẩm</title>

</head>

<body>
	<header>
		<jsp:include page="DauTrang.jsp"></jsp:include>
	</header>
	<section class="gallery" id="gallery">

		<h1 class="heading">Sản phẩm</h1>
		<div class="gallery-wrap">
			<div class="gallery-nav">
				<h2>DANH MỤC</h2>
				<ul class="nav-list">
					<c:forEach items="${danhSachTheLoai}" var="theLoai">
						<li
							class='<c:if test="${theLoai.maTheLoai == mtl}">on-selected-active</c:if>'><i
							class="fa fa-arrow-circle-right" aria-hidden="true"></i> <a
							href="san-pham?maTheLoai=${theLoai.maTheLoai}"> <c:out
									value="${theLoai.tenTheLoai}"></c:out>
						</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="box-container">
				<c:forEach items="${danhSachSanPham}" var="sanPham">
					<div class="box">
						<img src="${sanPham.hinhAnh}" alt="">
						<div class="content">
							<h3>${sanPham.tenSanPham}</h3>
							<p>${sanPham.mieuTa}</p>
							<h3>
								<fmt:setLocale value="vi_VN" />
								<fmt:formatNumber value="${sanPham.giaTien}" type="currency" />
								/1 ${sanPham.donViTinh}
							</h3>
							<a href="them-vao-gio-hang?maSanPham=${sanPham.maSanPham}"
								class="btn">Đặt mua</a>
						</div>
					</div>
				</c:forEach>


			</div>
		</div>



	</section>
</body>

</html>