package spring.mvc.farmfarm.persistence;

import java.util.ArrayList;
import java.util.Map;

import spring.mvc.farmfarm.dto.BoardDTO;


public interface BoardDAO {
	
	//글 갯수 구하기
	public int getArtileCnt();
	
	//게시글 목록 조회
	public ArrayList<BoardDTO>getArticleList(Map<String,Object> map);
	//상세페이지 조회
    public BoardDTO getArticleBoard(int boa_id);
   
    //조회수증가
    public void addReadCnt(int boa_id);
}
