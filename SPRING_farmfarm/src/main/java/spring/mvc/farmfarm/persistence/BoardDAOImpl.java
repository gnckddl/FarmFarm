package spring.mvc.farmfarm.persistence;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.farmfarm.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	SqlSession Sqlsession;

	@Override
	public int getArtileCnt() {
		BoardDAO dao = Sqlsession.getMapper(BoardDAO.class);
		int selectCnt=dao.getArtileCnt();
		return selectCnt;
	}

	@Override
	public ArrayList<BoardDTO> getArticleList(Map<String, Object> map) {
		
		ArrayList<BoardDTO> dtos = null;		
		
		//2, 큰바구니 생성(dtos)
		BoardDAO dao = Sqlsession.getMapper(BoardDAO.class);
		dtos = dao.getArticleList(map);
		return dtos;
	}
	  @Override
	   public BoardDTO getArticleBoard(int boa_id) {
	      BoardDAO dao=Sqlsession.getMapper(BoardDAO.class);
	      BoardDTO dto = new BoardDTO();
	      
	      dto=dao.getArticleBoard(boa_id);
	      return dto;
	   }

	   @Override
	   public void addReadCnt(int boa_id) {
	      BoardDAO dao=Sqlsession.getMapper(BoardDAO.class);
	      dao.addReadCnt(boa_id);
	      
	      
	   }

}
