package spring.mvc.farmfarm.persistence;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.farmfarm.dto.LettersDTO;
import spring.mvc.farmfarm.persistence.FarmDAO;

@Repository
public class FarmDAOImpl implements FarmDAO{

	@Autowired
	private SqlSession SqlSession;
	
	//쪽지 글 갯수 구하기
	@Override
	public int getArtileCnt() {
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		int selectCnt=dao.getArtileCnt();
		return selectCnt;
	}

	
	//쪽지 리스트 목록
	@Override
	public ArrayList<LettersDTO> getArticleList(Map<String, Object> map) {
		ArrayList<LettersDTO> dtos = null;
		
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		dtos = dao.getArticleList(map);
		return dtos;
	}


	//쪽지 상세페이지 보기
	@Override
	public LettersDTO getArticle(int letternum) {
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		LettersDTO dto = new LettersDTO();
		dto = dao.getArticle(letternum);
		return dto;
	}

	//쪽지 전송 처리
	@Override
	public int insertLetter(LettersDTO dto) {
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		int insertCnt=0;
		insertCnt=dao.insertLetter(dto);
		return insertCnt;
	}

/*	//쪽지 삭제 처리
	@Override
	public int LTdelete(Map<String, Object> map) {
		int deleteCnt=0;
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		deleteCnt = dao.LTdelete(map);
		return deleteCnt;
	}*/

}
