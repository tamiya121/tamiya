package com.ict.erp.dao.impl;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.ICTUtils;
import com.ict.erp.dao.DepartDAO;
import com.ict.erp.vo.DepartInfo;

public class DepartDAOImpl extends CommonDAOImpl implements DepartDAO {

	@Override
	public List<DepartInfo> selectDepartInfoList(DepartInfo di) throws SQLException {
		List<DepartInfo> diList = new ArrayList<DepartInfo>();
		String sql = "select * from (";
		sql += "select di.*, rownum as rNum from (";
		sql += "select * from depart_info order by diNum desc) di";
		sql += " where rownum<=?)";
		sql += " where rNum>=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, di.getPi().getlNum());
			ps.setInt(2, di.getPi().getsNum());
			rs = ps.executeQuery();

			diList = ICTUtils.parseList(rs, DepartInfo.class);
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
		return diList;
	}

	@Override
	public DepartInfo selectDepartInfo(int diNum) throws SQLException {
		String sql = "select * from depart_info where diNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, diNum);
			rs = ps.executeQuery();
			DepartInfo di = ICTUtils.parse(rs, DepartInfo.class);
			return di;
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public int insertDepartInfo(DepartInfo di) throws SQLException {
		String sql = "insert into depart_info(diNum, diName, diDesc, diCode)";
		sql += " values(seq_dinum.nextval, ?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, di.getDiName());
			ps.setString(2, di.getDiDesc());
			ps.setString(3, di.getDiCode());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public int updateDepartInfo(DepartInfo di) throws SQLException {
		String sql = "update depart_info ";
		sql += " set diName=?,";
		sql += "  diCode=?,";
		sql += "  diDesc=?";
		sql += "  where diNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, di.getDiName());
			ps.setString(2, di.getDiCode());
			ps.setString(3, di.getDiDesc());
			ps.setLong(4, di.getDiNum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public int deleteDepartInfo(DepartInfo di) throws SQLException {
		String sql = "delete from depart_info where diNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, di.getDiNum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public List<DepartInfo> selectDepartInfoNonePageList(DepartInfo di) throws SQLException {
		List<DepartInfo> diList = new ArrayList<DepartInfo>();
		String sql = "select * from depart_info order by diNum ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			diList = ICTUtils.parseList(rs, DepartInfo.class);
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
		return diList;
	}

}
