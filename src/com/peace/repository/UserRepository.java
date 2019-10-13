package com.peace.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.peace.bean.Item;
import com.peace.bean.User;
import com.peace.util.AppUtil;

public class UserRepository {
	
	private Connection con;
	private final int numItems = 10;
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public void setConnection(Object con) {
		this.con = (Connection) con;
	}

	public boolean addUser(User user) {
		String sql = "INSERT INTO users "
				+ "(id, password, nickName, email) "
				+ "VALUES (?, ?, ?, ? )";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getNickName());
			pstmt.setString(4, user.getEmail());
			
			count = pstmt.executeUpdate();
			
			if (count == 1) {
				return true;
			} else {
				return false;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AppUtil.close(pstmt);
		}
		
		return false;
		
		
		
	}

	public User getUser(String id, String pw) {
		String sql = "SELECT id, password, nickName, email "
				+ "FROM users "
				+ "WHERE id=? "
				+ "AND password=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				User user = new User();
				user.setId(id);
				user.setPassword(pw);
				user.setNickName(rs.getString(3));
				user.setEmail(rs.getString(4));
				
				return user;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AppUtil.close(pstmt, rs);
		}
		
		return null;
	}

}
