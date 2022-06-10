package com.group3.DAO;

import java.util.List;

public interface DAO<T> {
	List<T> layTatCa();
	
	T layQuaMa(int ma);
	
	boolean taoMoi(T t);
	
	boolean sua(T t);
	
	boolean xoa(T t);
	
}
