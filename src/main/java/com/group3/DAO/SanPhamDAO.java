package com.group3.DAO;

import java.sql.*;
import java.util.*;

import com.group3.Model.NguoiDung;
import com.group3.Model.SanPham;
import com.group3.Model.TheLoai;
import com.group3.TienIch.KetNoiCSDL;

public class SanPhamDAO implements DAO<SanPham> {

	private Connection conn;
	public SanPhamDAO() {
		conn=KetNoiCSDL.ketNoiPostgreSQL();
	}
	public SanPhamDAO(Connection conn2) {
		conn = conn2;
	}
	@Override
	public List<SanPham> layTatCa() {
		ArrayList<SanPham> res = new ArrayList();
		try {
            Statement sql = conn.createStatement();
            ResultSet rs = sql.executeQuery("select * from SanPham");
            while (rs.next()) {
            	SanPham sp = new SanPham(rs);
            	TheLoai tl = sp.getTheLoai();
            	int id = tl.getMaTheLoai();
            	sp.setTheLoai(new TheLoaiDAO(conn).layQuaMa(id));
                res.add(sp);
            }

        } catch (SQLException ex) {
            
        }
        return res;
	}

	@Override
	public SanPham layQuaMa(int ma) {
		try {
			Statement sql = conn.createStatement();
			ResultSet rs = sql.executeQuery("Select * from SanPham where maSanPham = " + ma);
			rs.next();
			SanPham sp = new SanPham(rs);
			return sp;
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public boolean taoMoi(SanPham t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sua(SanPham t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xoa(SanPham t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<SanPham> layTatCaSanPhamTheoMaTheLoai(int maTheLoai) {
		ArrayList<SanPham> res = new ArrayList();
		try {
			String sql = "SELECT * FROM SanPham WHERE maTheLoai = ?";
			PreparedStatement pps = conn.prepareStatement(sql);
			pps.setInt(1, maTheLoai);
			ResultSet rs =  pps.executeQuery();
            while (rs.next()) {
            	SanPham sp = new SanPham(rs);
            	//TheLoai tl = sp.getTheLoai();
            	//int id = tl.getMaTheLoai();
            	//sp.setTheLoai(new TheLoaiDAO(conn).layQuaMa(id));
                res.add(sp);
            }

        } catch (SQLException ex) {
            
        }
        return res;
	}
}
