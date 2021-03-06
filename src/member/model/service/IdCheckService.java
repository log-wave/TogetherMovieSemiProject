package member.model.service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import member.model.dao.IdCheckDAO;
public class IdCheckService {

public int confirm(String userid) {
		
		IdCheckDAO idCheckDAO = IdCheckDAO.getInstance();
		Connection con = getConnection();
		
		idCheckDAO.setConnection(con);
		
		int result = idCheckDAO.confirm(userid);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		
		close(con);
		
		
		
		close(con);
		
		return result;
		
	}
	
}
