package com.peace.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.peace.bean.Item;
import com.peace.util.AppUtil;

public class ItemRepository {
	private Connection con;
	private final int numItems = 10;
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public void setConnection(Object con) {
		this.con = (Connection) con;
	}

	public List<Item> list(int page) {
		ArrayList<Item> items = new ArrayList<>();
		String sql = "SELECT item_id, title, body, inserted "
				+ "FROM items "
				+ "ORDER BY item_id desc "
				+ "LIMIT ?, ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, page * numItems);
			pstmt.setInt(2, numItems);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Item i = new Item();
				i.setId(rs.getInt(1));
				i.setTitle(rs.getString(2));
				i.setBody(rs.getString(3));
//				i.setInserted(rs.getDate(4));
				i.setInserted(rs.getTimestamp(4));
				items.add(i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AppUtil.close(pstmt, rs);
		}
		
		return items;
	}

	public Item getItem(int id) {
		String sql = "SELECT i.item_id, "
				+ "i.title, "
				+ "i.body, "
				+ "i.inserted, "
				+ "i.user_id, "
				+ "u.nickName "
				+ "FROM items i INNER JOIN users u"
				+ " ON i.user_id = u.id "
				+ "WHERE item_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Item item = new Item();
				item.setId(id);
				item.setTitle(rs.getString(2));
				item.setBody(rs.getString(3));
				item.setInserted(rs.getTimestamp(4));
				item.setUserId(rs.getString(5));
				item.setUserNickName(rs.getString(6));
				
				return item;
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

	public boolean addItem(Item item) {
		String sql = "INSERT INTO items "
				+ "(title, body, user_id) "
				+ "VALUES (?, ?, ?)";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item.getTitle());
			pstmt.setString(2, item.getBody());
			pstmt.setString(3, item.getUserId());
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

	public boolean updateItem(Item item) {
		String sql = "UPDATE items "
				+ "SET title=?, "
				+ "body=? "
				+ "WHERE item_id=?";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item.getTitle());
			pstmt.setString(2, item.getBody());
			pstmt.setInt(3, item.getId());
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

	public boolean removeItem(int id) {
		String sql = "DELETE FROM items "
				+ "WHERE item_id=?";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
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
	
}
