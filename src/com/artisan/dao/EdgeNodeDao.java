package com.artisan.dao;

import java.sql.SQLException;

import com.artisan.model.EdgeNode;

public class EdgeNodeDao extends BaseDao {
	public boolean addEdgeNode (EdgeNode edgeNode, int networkId) {
		String sql = "insert into s_edgeNode values(null,?,?,?,?)"; //Ìí¼ÓÓï¾ä
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, edgeNode.getName());
			preparedStatement.setInt(2, networkId);
			preparedStatement.setDouble(3, edgeNode.getTrustValue());
			preparedStatement.setString(4, edgeNode.getTrustType());
			if(preparedStatement.executeUpdate() > 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
