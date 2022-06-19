package com.group3.Servlet.Quanly;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.group3.DAO.SanPhamDAO;
import com.group3.DAO.TheLoaiDAO;
import com.group3.Model.SanPham;
import com.group3.Model.TheLoai;

/**
 * Servlet implementation class CapNhatSanPham
 */
public class CapNhatSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapNhatSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TheLoaiDAO a=new TheLoaiDAO();
		List<TheLoai> l =a.layTatCa();
		String ma=request.getParameter("id");
		SanPhamDAO spd=new SanPhamDAO();
		SanPham sp =spd.layQuaMa(Integer.parseInt(ma));
		request.setAttribute("sanpham", sp);
		request.setAttribute("dstheloai", l);
		request.getRequestDispatcher("/View/CapNhatSanPham.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
