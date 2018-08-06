package spring.mvc.farmfarm.persistence;
import java.util.ArrayList;
import java.util.Map;

import spring.mvc.farmfarm.dto.AdvantageDTO;
import spring.mvc.farmfarm.dto.AuctionDTO;
import spring.mvc.farmfarm.dto.AuctionListDTO;
import spring.mvc.farmfarm.dto.BoardDTO;
import spring.mvc.farmfarm.dto.FundDTO;
import spring.mvc.farmfarm.dto.FundListDTO;
import spring.mvc.farmfarm.dto.WeekFarmDTO;

public interface FarmDAO {
	
	/**
	 * 장렬
	 * 1. 회원(쪽지)
	 */
	//쪽지 갯수 구하기(회원 농부 공통)
	public int getArtileCnt();
	
	//쪽지 리스트 출력
	public ArrayList<BoardDTO> getArticleList(Map<String,Object> map);
	
	//받은 쪽지함
	public ArrayList<BoardDTO> LetterGetList(Map<String,Object> map);
	
	//쪽지함 상세페이지 조회
	public BoardDTO getArticle(int boa_id);
	
	//쪽지 전송 처리
	public int insertLetter(BoardDTO dto);
	
	//쪽지 삭제 처리
	public int LTdelete(Map<String, Object> map);
	
	
	/**
	 * 장렬
	 * 2. 농부(쪽지)
	 */
	//농부 - 쪽지 리스트 출력
	public ArrayList<BoardDTO> FarmersLetterReply(Map<String,Object> map);
	
	//농부 - 회원 쪽지 문의 상세 페이지
	public BoardDTO LTFarmerContentsForm(int boa_id);
	
	//농부 - 회원 문의 답변 처리
	public int replyLetter(BoardDTO dto);
	
	//농부 - 답변완료한 쪽지 목록
	public ArrayList<BoardDTO> replyletters(Map<String,Object> map);
	
	
	/**
	 * 장렬
	 * 3. 농부(주말농장 신청)
	 */
	//농부 - 주말농장 신청 처리
	public int insertyard(WeekFarmDTO dto);
	
	//농부 - 주말농장 신청 건수 파악
	public int getWeekCnt();
	
	//농부 - 주말농장  신청 완료 리스트
	public ArrayList<WeekFarmDTO> getArticleWeekFarms(Map<String, Object> map);
	
	
	
	
	/**
	 * 장렬
	 * 4. 회원(주말농장)
	 */
	// 회원 - 주말농장 신청 현황
	public ArrayList<WeekFarmDTO> CustomerWeeklyFarmlist(Map<String, Object> map);

	/**
	 * 장렬
	 * 5. 농부(농부점수)
	 */
	// 농부 - 농부점수 건수
	public int getFarmerAdvCnt(String strId);
	
	// 농부 - 농부점수 목록화
	public ArrayList<AdvantageDTO> getFarmerAvg(Map<String,Object> map);
	
	/**
	 * 민웅
	 */
	// farmkey 가져오기
	public int getFarmKey(String userId);
	
	// 경매 상품 등록 - 처리
	public int auctionUpdate(AuctionDTO dto);
	
	// 경매 진행 내역 건수
	public int getAuctionCnt();
	
	// 경매 상품 현황및 이전내역
	public ArrayList<AuctionListDTO> auctionList(int farmkey);
	
	// 펀드 신청 - 처리
	public int fundUpdate(FundDTO dto);
	
	// 펀드 진행 내역 건수
	public int getfundCnt();
	
	// 펀드 상품 현황및 이전내역
	public ArrayList<FundListDTO> fundList(int farmkey);
}
