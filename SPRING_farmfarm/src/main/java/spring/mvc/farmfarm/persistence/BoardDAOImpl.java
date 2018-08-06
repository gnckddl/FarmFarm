package spring.mvc.farmfarm.persistence;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.farmfarm.dto.BoardDTO;
import spring.mvc.farmfarm.dto.CommentDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	SqlSession Sqlsession;

	@Override
	public int getArtileCnt(int boa_category) {
		BoardDAO dao = Sqlsession.getMapper(BoardDAO.class);
		int selectCnt=dao.getArtileCnt(boa_category);
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
	public BoardDTO getArticleBoard(Map<String,Object> map) {
		BoardDAO dao=Sqlsession.getMapper(BoardDAO.class);
		BoardDTO dto = new BoardDTO();
		
		dto=dao.getArticleBoard(map);
		return dto;
	}

	@Override
	public void addReadCnt(Map<String,Object> map) {
		BoardDAO dao=Sqlsession.getMapper(BoardDAO.class);
		dao.addReadCnt(map);
		
		
	}
	
	
	@Override
	public int farminsertBoard(BoardDTO dto) {
		BoardDAO dao=Sqlsession.getMapper(BoardDAO.class);
		int insertCnt=0;
		
		insertCnt=dao.farminsertBoard(dto);
	
		return insertCnt;
	}
	//댓글 리스트
	@Override
	public ArrayList<CommentDTO> RequestComment(int boa_id) {
		
		BoardDAO dao=Sqlsession.getMapper(BoardDAO.class);
		
		ArrayList<CommentDTO> commentinsert=dao.RequestComment(boa_id);
		return commentinsert;
	}
	
	//댓글 갯수
	@Override
	public int RequestCommentCnt(int boa_id) {
		
		BoardDAO dao = Sqlsession.getMapper(BoardDAO.class);
		int commentCnt=dao.RequestCommentCnt(boa_id);
		return commentCnt;
	}
	//댓글 작성 처리
	@Override
	public int commentBoardWirtePro(CommentDTO dto) {
		BoardDAO dao=Sqlsession.getMapper(BoardDAO.class);
		int insertCnt=0;
		
		insertCnt=dao.commentBoardWirtePro(dto);
		System.out.println("insertCnt:~~~~~~~~"+ insertCnt);
	
		return insertCnt;
	
	}
	//글수정 처리페이지
	@Override
	public int updateBoard(BoardDTO dto) {
		BoardDAO dao=Sqlsession.getMapper(BoardDAO.class);
		int updateCnt=0;
		updateCnt=dao.updateBoard(dto);
		return updateCnt;
	}
	
	//댓글 수정 처리
	@Override
	public int commentUpdate(CommentDTO dto) {
		BoardDAO dao=Sqlsession.getMapper(BoardDAO.class);
		int updateCnt=0;
		updateCnt=dao.commentUpdate(dto);
		return updateCnt;
	}

	
	@Override
	public int deleteBoard(int boa_id) {
		BoardDAO dao=Sqlsession.getMapper(BoardDAO.class);
		int deleteCnt = 0;
		
		deleteCnt=dao.deleteBoard(boa_id);
		return deleteCnt;
	}

	//댓글삭제
	@Override
	public int deleteComment(int cm_no) {
		BoardDAO dao=Sqlsession.getMapper(BoardDAO.class);
		int deleteCnt = 0;
		
		deleteCnt=dao.deleteComment(cm_no);
		return deleteCnt;
	}
	
	//소식게시판 카운트
	@Override
	public int getNewsCnt(int category) {
	       int selectCnt = 0;
	       
	       BoardDAO dao = Sqlsession.getMapper(BoardDAO.class);
	       selectCnt = dao.getNewsCnt(category);
	             
	       return selectCnt;
	}
	
	//소식게시판 리스트
	@Override
	public ArrayList<BoardDTO> getNewsList(Map<String, Object> map) {
	       ArrayList<BoardDTO> dtos = null;
	       
	       BoardDAO dao = Sqlsession.getMapper(BoardDAO.class);
	       dtos = dao.getNewsList(map);
	       
	       return dtos;
	}

	//소식게시판 글쓰기 처리
	@Override
	public int NewsWritePro(BoardDTO dto) {
	        int cnt = 0;
	        
	        BoardDAO dao = Sqlsession.getMapper(BoardDAO.class);
	        cnt = dao.NewsWritePro(dto);
	    
	        return cnt;
	}
	
	//소식게시판 글수정 처리
	@Override
	public int NewsModifyBoardPro(BoardDTO dto) {
		 int updateCnt = 0;
	        
	        BoardDAO dao = Sqlsession.getMapper(BoardDAO.class);
	        updateCnt = dao.NewsModifyBoardPro(dto);
	        System.out.println("씨엔ㄸ찌"+updateCnt);
        return updateCnt;
	}



}
