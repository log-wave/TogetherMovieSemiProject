package mypage.model.dao;

import static db.JdbcUtil.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import board.model.vo.Board;
import board.model.vo.Comment;
import goods.model.vo.Pay;

public class mypageDAO {
	
	private static mypageDAO mpDAO;
	private Properties prop = new Properties();
	private Connection con;

	public mypageDAO() {
		String filePath = mypageDAO.class.getResource("/sql/mypage.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static mypageDAO getInstance() {
		if(mpDAO == null) {
			mpDAO = new mypageDAO();
		}
		return mpDAO;
	}
	
	public void setConnection(Connection conn) {
		this.con = conn;
	}

	public ArrayList<Board> selectbList(Connection conn, int uNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> bList = null;
		
		String query = prop.getProperty("selectBoardList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, uNo);
			
			rset = pstmt.executeQuery();
			bList = new ArrayList<Board>();
			
			while(rset.next()) {
				Board b = new Board(rset.getInt("BOARD_NO"),
									rset.getInt("BOARD_TYPE"),
									rset.getString("BOARD_TITLE"),
									rset.getString("BOARD_CONTENT"),
									rset.getDate("BOARD_DATE"),
									rset.getInt("BOARD_VIEW"),
									rset.getString("BOARD_CATEGORY"),
									rset.getInt("BOARD_CODE"),
									rset.getString("STATUS"),
									rset.getInt("USERS_NO"),
									rset.getString("USERS_NICKNAME"));
				bList.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return bList;
	}

	public ArrayList<Comment> selectcList(Connection conn, int uNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Comment> cList = null;
		
		String query = prop.getProperty("selectCommentList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, uNo);
			
			rset = pstmt.executeQuery();
			cList = new ArrayList<Comment>();
			
			while(rset.next()) {
				Comment c = new Comment(rset.getInt("COMMENTS_NO"),
									rset.getInt("BOARD_NO"),
									rset.getInt("USERS_NO"),
									rset.getString("USERS_NICKNAME"),
									rset.getString("COMMENTS_CONTENTS"),
									rset.getDate("COMMENTS_DATE"),
									rset.getString("STATUS"));
				cList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return cList;
	}

	public ArrayList<Board> selectqList(Connection conn, int uNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> qList = null;
		
		String query = prop.getProperty("selectQNAList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, uNo);
			
			rset = pstmt.executeQuery();
			qList = new ArrayList<Board>();
			
			while(rset.next()) {
				Board b = new Board(rset.getInt("BOARD_NO"),
									rset.getInt("BOARD_TYPE"),
									rset.getString("BOARD_TITLE"),
									rset.getString("BOARD_CONTENT"),
									rset.getDate("BOARD_DATE"),
									rset.getInt("BOARD_VIEW"),
									rset.getString("BOARD_CATEGORY"),
									rset.getInt("BOARD_CODE"),
									rset.getString("STATUS"),
									rset.getInt("USERS_NO"),
									rset.getString("USERS_NICKNAME"));
				qList.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("qList : " + qList);
		
		return qList;
	}

	public ArrayList<Pay> selectpList(Connection conn, String uId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Pay> pList = null;
		
		String query = prop.getProperty("selectPayList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uId);
			
			rset = pstmt.executeQuery();
			pList = new ArrayList<Pay>();
			
			while(rset.next()) {
				Pay p = new Pay(rset.getInt("PAY_NO"),
								rset.getInt("GOODS_NO"),
								rset.getString("TITLE"),
								rset.getString("USER_ID"),
								rset.getInt("AMOUNT"),
								rset.getInt("ACOUNT"),
								rset.getString("EMAIL"),
								rset.getString("STATUS"));
				pList.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return pList;
	}
}
