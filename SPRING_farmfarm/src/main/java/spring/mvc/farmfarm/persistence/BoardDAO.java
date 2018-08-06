package spring.mvc.farmfarm.persistence;

import java.util.ArrayList;
import java.util.Map;

import spring.mvc.farmfarm.dto.BoardDTO;
import spring.mvc.farmfarm.dto.CommentDTO;


public interface BoardDAO {
	
	//글 갯수 구하기
	public int getArtileCnt(int boa_category);
	
	//게시글 목록 조회
	public ArrayList<BoardDTO>getArticleList(Map<String,Object> map);

	
	//상세페이지 조회
	public BoardDTO getArticleBoard(Map<String,Object> map);
	
	//조회수증가
	public void addReadCnt(Map<String,Object> map);
	
	//글작성
	public int farminsertBoard(BoardDTO dto);
	
	//댓글작성
	public ArrayList<CommentDTO> RequestComment(int boa_id);
	
	//댓글갯수
	public int RequestCommentCnt(int boa_id);
	
	//댓글 처리
	public int commentBoardWirtePro(CommentDTO dto);
	
	//글수정 처리
	public int updateBoard(BoardDTO dto);
	
	//댓글수정 처리
	public int commentUpdate(CommentDTO dto);
	
	//원글삭제
	public int deleteBoard(int boa_id);
	
	//댓글삭제
	public int deleteComment(int cm_no);
	
	 // 공지사항 건수 조회
    public int getNewsCnt(int category);
    
    // 공지사항 목록 조회
    public ArrayList<BoardDTO> getNewsList(Map<String, Object> map);

	//소식게시판 글쓰기 처리
    public int NewsWritePro(BoardDTO dto);
    
    //소식게시판 글수정 처리
    public int NewsModifyBoardPro(BoardDTO dto);
    
}
