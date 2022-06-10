package com.group3.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;

import com.group3.DAO.DonHangDAO;
import com.group3.DAO.NguoiDungDAO;
import com.group3.Model.DonHang;
import com.group3.Model.DonHangChiTiet;
import com.group3.Model.NguoiDung;

/**
 * Servlet implementation class ThanhToan
 */
public class ThanhToanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanhToanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int maND = (Integer) session.getAttribute("maND");
		NguoiDung nd = new NguoiDungDAO().layQuaMa(maND);
		DonHang dh = (DonHang) session.getAttribute("giohang");
		request.setAttribute("donHang", dh);
		request.setAttribute("nguoiDung", nd);
		request.getRequestDispatcher("/View/ThanhToan.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String diaChi = request.getParameter("diaChi");
		HttpSession session = request.getSession();
		int maND = (Integer) session.getAttribute("maND");
		NguoiDung nd = new NguoiDungDAO().layQuaMa(maND);
		DonHang dh = (DonHang) session.getAttribute("giohang");
		
		if(diaChi.equals("")) {
			request.setAttribute("mess", "Vui lòng điền địa chỉ nhận hàng!");
			request.setAttribute("donHang", dh);
			request.setAttribute("nguoiDung", nd);
			request.getRequestDispatcher("/View/ThanhToan.jsp").forward(request, response);
		}
		else {
			dh.setDiaChiNhanHang(diaChi);
			dh.setThoiGianDatHang(new Date(System.currentTimeMillis()));
			dh.setTrangThai("Đang chờ xác nhận");
			dh.setKhachHang(nd);
			
			
			new DonHangDAO().taoMoi(dh);
			
			session.removeAttribute("giohang");
			
			response.sendRedirect("ca-nhan");
		}
	}
	
}
