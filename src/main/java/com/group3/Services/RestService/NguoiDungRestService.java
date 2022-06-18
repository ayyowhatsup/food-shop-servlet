package com.group3.Services.RestService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.group3.DAO.NguoiDungDAO;
import com.group3.Model.NguoiDung;

/**
 * Servlet implementation class NguoiDungRestService
 */
public class NguoiDungRestService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NguoiDungRestService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		Gson gson = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
				.setPrettyPrinting()
				.create();
		PrintWriter pr = response.getWriter();
		String str = request.getPathInfo();
		if(str == null || str.length()==1) {
			List<NguoiDung> arr = new NguoiDungDAO().layTatCa();
			String json = gson.toJson(arr);
			pr.println(json);
		}
		else {
			int maNguoiDung = Integer.parseInt(str.substring(1));
			NguoiDung nd = new NguoiDungDAO().layQuaMa(maNguoiDung);
			pr.println(gson.toJson(nd));
		}
		pr.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
