package com.group3.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.group3.Model.NguoiDung;
import com.group3.TienIch.KetNoiCSDL;

public class NguoiDungDAO implements DAO<NguoiDung> {
	
	private Connection conn;
	
	public NguoiDungDAO() {
		conn = KetNoiCSDL.ketNoiPostgreSQL();
	}
	public NguoiDungDAO(Connection conn2) {
		conn = conn2;
	}
	@Override
	public List<NguoiDung> layTatCa() {
		ArrayList<NguoiDung> res = new ArrayList();
		try {
            Statement sql = conn.createStatement();
            ResultSet rs = sql.executeQuery("select * from NguoiDung");
            while (rs.next()) {
                NguoiDung nd = new NguoiDung(rs);
                res.add(nd);
            }

        } catch (SQLException ex) {
            
        }
        return res;
	}

	@Override
	public NguoiDung layQuaMa(int ma) {
		try {
			Statement sql = conn.createStatement();
			ResultSet rs = sql.executeQuery("Select * from NguoiDung where maNguoiDung = " + ma);
			rs.next();
			NguoiDung nd = new NguoiDung(rs);
			return nd;
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public boolean taoMoi(NguoiDung t) {
        try {
            String sql = "insert into NguoiDung(tennguoidung,sodienthoai,matkhaumahoa,laquantrivien)\nvalues(?,?,?,?);";
            PreparedStatement pps = conn.prepareStatement(sql);
            pps.setString(1,t.getTenNguoiDung());
            pps.setString(2,t.getSoDienThoai());
            pps.setString(3, t.getMatKhauMaHoa());
            pps.setInt(4, t.getLaQuanTriVien());   
            pps.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
	}

	@Override
	public boolean sua(NguoiDung t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xoa(NguoiDung t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public NguoiDung dangNhap(String soDienThoai, String matKhauDaMaHoa) {
		try {
			String sql = "SELECT * from NguoiDung where soDienThoai = ? and matKhauMaHoa =?; ";
			PreparedStatement pps = conn.prepareStatement(sql);	
			pps.setString(1, soDienThoai);
			pps.setString(2, matKhauDaMaHoa);
			ResultSet rs =  pps.executeQuery();
			rs.next();
			NguoiDung t = new NguoiDung(rs);
			return t;
		
		}
		catch (Exception e) {
			
		}
		return null;
	}

}
