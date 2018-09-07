package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MenuDAO;
import com.ict.erp.dao.impl.MenuDAOImpl;
import com.ict.erp.service.MemberService;
import com.ict.erp.service.MenuService;
import com.ict.erp.vo.MenuInfo;

public class MenuServiceImpl implements MenuService {
	private MenuDAO mdao = new MenuDAOImpl();
	
	@Override
	public List<MenuInfo> selectMenuList(MenuInfo menu) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.selectMenuList(menu);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public MenuInfo selectMenu(MenuInfo menu) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.selectMenu(menu);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public int insertMenu(MenuInfo menu) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.insertMenu(menu);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public int updateMenu(MenuInfo menu) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.updateMenu(menu);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public int deleteMenu(MenuInfo menu) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.deleteMenu(menu);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	public static void main(String[] args) {
		MenuService ms = new MenuServiceImpl();
		try {
			System.out.println(ms.selectMenuList(null));
			MenuInfo menu = new MenuInfo();
			menu.setMeiNum(3l);
			menu.setMeiName("파스타");
			menu.setMeiPrice(15000l);
			menu.setMeiDesc("맛있음");
			System.out.println(ms.updateMenu(menu));
			System.out.println(ms.deleteMenu(menu));
			System.out.println(ms.selectMenu(menu));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
