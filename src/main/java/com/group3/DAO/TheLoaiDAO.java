package com.group3.DAO;

import java.sql.*;
import java.util.*;

import com.group3.Model.NguoiDung;
import com.group3.Model.TheLoai;
import com.group3.TienIch.KetNoiCSDL;

/**
 * Các thao tác với các Thể loại với CSDL
 * 
 */
public class TheLoaiDAO implements DAO<TheLoai> {

	private Connection conn;
	
	public TheLoaiDAO() {
		this.conn = KetNoiCSDL.ketNoiPostgreSQL();
	}
	public TheLoaiDAO(Connection conn) {
		this.conn = conn;
	}
	@Override
	public List<TheLoai> layTatCa() {
		ArrayList<TheLoai> res = new ArrayList();
		try {
            Statement sql = conn.createStatement();
            ResultSet rs = sql.executeQuery("select * from TheLoai");
            while (rs.next()) {
                TheLoai tl = new TheLoai(rs);
                res.add(tl);
            }

        } catch (SQLException ex) {
            
        }
        return res;
	}

	@Override
	public TheLoai layQuaMa(int ma) {
		TheLoai tl = new TheLoai();
		try {
			String sql = "SELECT * FROM theloai WHERE maTheLoai = ?";
			PreparedStatement pps = conn.prepareStatement(sql);
			pps.setInt(1, ma);
			ResultSet rs = pps.executeQuery();
			rs.next();
			tl = new TheLoai(rs);
			
		} catch (SQLException e) {		
		}	
		return tl;	
	}

	@Override
	public boolean taoMoi(TheLoai t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sua(TheLoai t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xoa(TheLoai t) {
		// TODO Auto-generated method stub
		return false;
	}

}
