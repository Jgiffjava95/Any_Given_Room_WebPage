package com.anygivenroom.AGRwebapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Show;

public class AgrDao {

	private String selectAllFromShows = "SELECT showId, showImage, showLocation, entryPrice, showDate, upcoming, showName FROM Shows";
	
	public List<Show> getAllShows() {
		List<Show> shows = new ArrayList<Show>();

		ResultSet result = null;
		Statement statement = null;

		Connection conn = DButil.getConnection();

		try {
			statement = conn.createStatement();
			result = statement.executeQuery(selectAllFromShows);
			while (result.next()) {
				Show show = createShow(result);
				shows.add(show);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					result.close();
					statement.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return shows;
		
	}

	private Show createShow(ResultSet result) throws SQLException {
		Show newShow = new Show(result.getInt("showId"), 
								result.getString("showName"), 
								result.getString("showImage"),
								result.getString("showLocation"),
								result.getDouble("entryPrice"),
								result.getString("showDate"),
								result.getBoolean("upcoming"));
		return newShow;
	}

}
