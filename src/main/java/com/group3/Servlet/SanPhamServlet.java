package com.group3.Servlet;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.group3.DAO.SanPhamDAO;
import com.group3.DAO.TheLoaiDAO;
import com.group3.Model.SanPham;
import com.group3.Model.TheLoai;
import com.group3.TienIch.KetNoiCSDL;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SanPhamServlet
 */
@WebServlet("/san-pham")
public class SanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = KetNoiCSDL.ketNoiPostgreSQL();
		List<TheLoai> arr = new TheLoaiDAO(conn).layTatCa();
		
		String p = request.getParameter("maTheLoai");
		int mtl=0;
		if(p==null) {
			mtl=arr.get(0).getMaTheLoai();
		}
		else {
			mtl = Integer.parseInt(p);
		}
		List<SanPham> arr3 = new SanPhamDAO(conn).layTatCaSanPhamTheoMaTheLoai(mtl);
		request.setAttribute("danhSachSanPham", arr3);
		request.setAttribute("mtl", mtl);
		request.setAttribute("danhSachTheLoai", arr);
		request.getRequestDispatcher("/View/KhoSanPham.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
