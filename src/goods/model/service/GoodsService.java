package goods.model.service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.BoardInfo;
import goods.model.dao.GoodsDAO;
import goods.model.vo.Goods;
import goods.model.vo.GoodsInfo;
import goods.model.vo.Pay;

public class GoodsService {

public int getGoodsListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new GoodsDAO().getGoodsListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList selectGoodsList(int i) {
		Connection conn = getConnection();
		
		ArrayList list = null;
		
		GoodsDAO gDAO = new GoodsDAO();
		if(i == 1) {
			list = gDAO.selectGList(conn);
		} else {
			list = gDAO.selectFList(conn);
		}
		
		close(conn);
		
		return list;
	}
	public ArrayList selectGoodsList2(int i) {
		Connection conn = getConnection();
		
		ArrayList list = null;
		
		GoodsDAO gDAO = new GoodsDAO();
		if(i == 1) {
			list = gDAO.selectGList2(conn);
		} else {
			list = gDAO.selectFList2(conn);
		}
		
		close(conn);
		
		return list;
	}

	public int insertGoods(Goods g, ArrayList<GoodsInfo> fileList) {
		
		Connection conn = getConnection();
		
		GoodsDAO dao = new GoodsDAO();
		
		int result1 = dao.insertGoods(conn, g);
		int result2 = dao.insertAttachment(conn, fileList);
		
		
		if(result1 > 0 && result2>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result1;
	}

	public Goods selectGoods(int gNo) {
		Connection conn = getConnection();
		
		GoodsDAO gDAO = new GoodsDAO();
		
		int result = gDAO.updateCount(conn, gNo);
		
		Goods goods = null;
		if(result> 0) {
			goods = gDAO.selectGoods(conn, gNo);
			
			if(goods != null) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
		} else {
			rollback(conn);
		}
		close(conn);
		return goods;
	}

	public ArrayList<GoodsInfo> selectGoodsInfo(int gNo) {
		Connection conn = getConnection();
		
		ArrayList<GoodsInfo> list = new GoodsDAO().selectGoodsInfo(conn, gNo);
		
				
		return list;
	}

	public int insertPay(Pay p) {
		Connection conn = getConnection();
		
		GoodsDAO dao = new GoodsDAO();
		
		int result = dao.insertGoods(conn, p);
		
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteGoods(int gNo) {
		Connection conn = getConnection();
		GoodsDAO dao = new GoodsDAO();
		
		int result1 = dao.deleteGoods(conn, gNo);
		int result2 = dao.deleteImg(conn, gNo);
		if(result1 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result1;
	}

	public int updateGoods(Goods g, ArrayList<GoodsInfo> fileList) {
		GoodsDAO dao = new GoodsDAO();
		Connection conn = getConnection();
		
		GoodsInfo gi = new GoodsInfo();
		
		int result1 = dao.updateBoard(conn, g);
		int result2 = dao.updateBoardInfo(conn, g,  fileList);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result1;
	}

	public int updateGoods1(Goods g) {
		GoodsDAO dao = new GoodsDAO();
		Connection conn = getConnection();
		
		GoodsInfo gi = new GoodsInfo();
		int result1 = dao.updateBoard(conn, g);
		
		if(result1 > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result1;
		
	}

}
