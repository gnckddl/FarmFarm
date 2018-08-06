package spring.mvc.farmfarm.persistence;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.farmfarm.dto.AdvantageDTO;
import spring.mvc.farmfarm.dto.AuctionDTO;
import spring.mvc.farmfarm.dto.AuctionListDTO;
import spring.mvc.farmfarm.dto.BoardDTO;
import spring.mvc.farmfarm.dto.FundDTO;
import spring.mvc.farmfarm.dto.FundListDTO;
import spring.mvc.farmfarm.dto.WeekFarmDTO;

@Repository
public class FarmDAOImpl implements FarmDAO{

	@Autowired
	private SqlSession SqlSession;
	
	/**
	 * 장렬
	 * 1. 회원(쪽지기능)
	 */
	//쪽지 글 갯수 구하기
	@Override
	public int getArtileCnt() {
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		int selectCnt=dao.getArtileCnt();
		return selectCnt;
	}

	//쪽지 리스트 목록
	@Override
	public ArrayList<BoardDTO> getArticleList(Map<String, Object> map) {
		ArrayList<BoardDTO> dtos = null;
		
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		dtos = dao.getArticleList(map);
		return dtos;
	}

	//받은 쪽지함
	@Override
	public ArrayList<BoardDTO> LetterGetList(Map<String, Object> map) {
		ArrayList<BoardDTO> dtos = null;
		
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		dtos = dao.LetterGetList(map);
		return dtos;
	}

	//쪽지 상세페이지 보기
	@Override
	public BoardDTO getArticle(int boa_id) {
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		BoardDTO dto = new BoardDTO();
		dto = dao.getArticle(boa_id);
		return dto;
	}

	//쪽지 전송 처리
	@Override
	public int insertLetter(BoardDTO dto) {
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		int insertCnt=0;
		insertCnt=dao.insertLetter(dto);
		
		return insertCnt;
	}

	//쪽지 삭제 처리
	@Override
	public int LTdelete(Map<String, Object> map) {
		int deleteCnt=0;
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		deleteCnt = dao.LTdelete(map);
		return deleteCnt;
	}


	/**
	 * 장렬
	 * 2. 농부(쪽지기능)
	 */
	//농부 - 농부 받은 쪽지함
	@Override
	public ArrayList<BoardDTO> FarmersLetterReply(Map<String, Object> map) {
		ArrayList<BoardDTO> dtos = null;
		
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		dtos = dao.FarmersLetterReply(map);
		return dtos;
	}

	//농부 - 회원 문의사항 상세 페이지
	@Override
	public BoardDTO LTFarmerContentsForm(int boa_id) {
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		BoardDTO dto = new BoardDTO();
		dto = dao.LTFarmerContentsForm(boa_id);
		return dto;
	}

	//농부 - 회원문의 답변 처리
	@Override
	public int replyLetter(BoardDTO dto) {
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		int insertCnt=0;
		insertCnt=dao.replyLetter(dto);
		
		return insertCnt;
	}

	//농부 - 답변 완료 목록
	@Override
	public ArrayList<BoardDTO> replyletters(Map<String, Object> map) {
		ArrayList<BoardDTO> dtos = null;
		
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		dtos = dao.replyletters(map);
		return dtos;
	}

	/**
	 * 장렬
	 * 3. 농부 - 주말농장
	 */
	//농부 - 주말농장 신청
	@Override
	public int insertyard(WeekFarmDTO dto) {
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		int insertCnt=0;
		insertCnt=dao.insertyard(dto);
		
		return insertCnt;
	}
	//농부 - 주말농장 신청 현황 건수 파악
	@Override
	public int getWeekCnt() {
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		int selectCnt=dao.getWeekCnt();
		return selectCnt;
	}

	//농부 - 주말농장 신청 현황 목록화
	@Override
	public ArrayList<WeekFarmDTO> getArticleWeekFarms(Map<String, Object> map) {
		ArrayList<WeekFarmDTO> dtos = null;
		
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		dtos = dao.getArticleWeekFarms(map);
		return dtos;
	}

	/**
	 * 장렬 
	 * 04. 회원 (주말농장)
	 */
	// 회원 - 주말농장 신청 현황 목록화
	@Override
	public ArrayList<WeekFarmDTO> CustomerWeeklyFarmlist(Map<String, Object> map) {
		ArrayList<WeekFarmDTO> dtos = null;
		
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		dtos = dao.CustomerWeeklyFarmlist(map);
		return dtos;	
		
	}
	
	
	/**
	 * 장렬 
	 * 05. 농부 (농부점수)
	 */
	// 농부 - 농부점수
	@Override
	public int getFarmerAdvCnt(String strId) {
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		int selectCnt=dao.getFarmerAdvCnt(strId);
		return selectCnt;
	}
	// 농부 - 농부점수 목록화
	@Override
	public ArrayList<AdvantageDTO> getFarmerAvg(Map<String, Object> map) {
		ArrayList<AdvantageDTO> dtos=null;
		FarmDAO dao =SqlSession.getMapper(FarmDAO.class);
		dtos=dao.getFarmerAvg(map);
		return dtos;
	}

	
	/**
	 * 민웅
	 */
	// farmkey 가져오기
	@Override
	public int getFarmKey(String userId) {
		int farmkey = 0;
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		System.out.println("dfsfdsdf : " + dao.getFarmKey(userId));
		farmkey = dao.getFarmKey(userId);
		return farmkey;
	}
	
	// 경매 상품 등록 - 처리
	@Override
	public int auctionUpdate(AuctionDTO dto) {
		System.out.println(dto);
		int cnt = 0;
		
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		cnt = dao.auctionUpdate(dto);
		System.out.println(cnt);
		return cnt;
	}
	
	// 경매 진행 내역 건수
	@Override
	public int getAuctionCnt() {
		int selectCnt = 0;
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		selectCnt = dao.getAuctionCnt();
		return selectCnt;
	}

	// 경매 상품 현황및 이전내역
	@Override
	public ArrayList<AuctionListDTO> auctionList(int farmkey) {
		ArrayList<AuctionListDTO> dtos = null;
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		dtos = dao.auctionList(farmkey);
		return dtos;
	}

	// 펀드 신청 - 처리
	@Override
	public int fundUpdate(FundDTO dto) {
		int cnt = 0;
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		cnt = dao.fundUpdate(dto);
		System.out.println("cnt : " + cnt);
		return cnt;
	}

	// 펀드 진행 내역 건수
	@Override
	public int getfundCnt() {
		int selectCnt = 0;
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		selectCnt = dao.getfundCnt();
		return selectCnt;
	}

	// 펀드 상품 현황및 이전내역
	@Override
	public ArrayList<FundListDTO> fundList(int farmkey) {
		ArrayList<FundListDTO> dtos = null;
		FarmDAO dao = SqlSession.getMapper(FarmDAO.class);
		dtos = dao.fundList(farmkey);
		System.out.println("타이틀 :"+dtos.get(0).getFund_title());
		return dtos;
	}
}
