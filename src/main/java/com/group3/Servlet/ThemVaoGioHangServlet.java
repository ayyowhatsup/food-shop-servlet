package com.group3.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;

import com.group3.DAO.SanPhamDAO;
import com.group3.Model.DonHang;
import com.group3.Model.DonHangChiTiet;
import com.group3.Model.SanPham;

/**
 * Servlet implementation class ThemVaoGioHangServlet
 */
public class ThemVaoGioHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ThemVaoGioHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int maSanPham;
		int soLuong = 1;
		if(request.getParameter("maSanPham")!=null) {
			maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
			SanPhamDAO spdao = new SanPhamDAO();
			SanPham thisSanPham = spdao.layQuaMa(maSanPham);
			if(thisSanPham!=null) {
				HttpSession session = request.getSession();
				if(session.getAttribute("giohang")==null) {
					DonHang donHang = new DonHang();
					List<DonHangChiTiet> arr = new ArrayList();
					DonHangChiTiet donHangChiTiet = new DonHangChiTiet();
					donHangChiTiet.setSoLuong(soLuong);
					donHangChiTiet.setSanPham(thisSanPham);
					arr.add(donHangChiTiet);
					donHang.setDanhSachVatPham(arr);
					donHang.tinhTongTien();
					session.setAttribute("giohang", donHang);
					response.sendRedirect("gio-hang");
				}else {	
					if(request.getParameter("soLuong")!=null) {
						soLuong = Integer.parseInt(request.getParameter("soLuong"));
					}
					DonHang donHang = (DonHang) session.getAttribute("giohang");
					List<DonHangChiTiet> arr = donHang.getDanhSachVatPham();
					boolean daTonTai = false;
					int index = 0;
					for(DonHangChiTiet dhct : arr) {
						if(dhct.getSanPham().getMaSanPham()==thisSanPham.getMaSanPham()) {
							daTonTai = true;
							dhct.setSoLuong(dhct.getSoLuong()+soLuong);
							if(dhct.getSoLuong()<=0) {
								arr.remove(dhct);
							}
							break;
						}
					}
					if(!daTonTai) {
						DonHangChiTiet donHangChiTiet = new DonHangChiTiet();
						donHangChiTiet.setSoLuong(soLuong);
						donHangChiTiet.setSanPham(thisSanPham);
						arr.add(donHangChiTiet);
					}
					donHang.tinhTongTien();
					session.setAttribute("giohang", donHang);
					response.sendRedirect("gio-hang");
				}
			}
		}
	}


}
