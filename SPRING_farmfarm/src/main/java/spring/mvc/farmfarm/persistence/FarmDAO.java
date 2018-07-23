package spring.mvc.farmfarm.persistence;
import java.util.ArrayList;
import java.util.Map;
import spring.mvc.farmfarm.dto.LettersDTO;

public interface FarmDAO {
	
	/**
	 * 장렬
	 */
	//쪽지 갯수 구하기
	public int getArtileCnt();
	
	//쪽지 리스트 출력
	public ArrayList<LettersDTO> getArticleList(Map<String,Object> map);
	
	//쪽지함 상세페이지 조회
	public LettersDTO getArticle(int letternum);
	
	//쪽지 전송 처리
	public int insertLetter(LettersDTO dto);
	
/*	//쪽지 삭제 처리
	public int LTdelete(Map<String, Object> map);*/
}
