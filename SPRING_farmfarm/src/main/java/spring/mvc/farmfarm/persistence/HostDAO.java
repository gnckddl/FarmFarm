package spring.mvc.farmfarm.persistence;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import spring.mvc.farmfarm.dto.BoardDTO;
import spring.mvc.farmfarm.dto.CommentDTO;
import spring.mvc.farmfarm.dto.DonateDTO;
import spring.mvc.farmfarm.dto.MemberDTO;
import spring.mvc.farmfarm.dto.PartnerDTO;
import spring.mvc.farmfarm.dto.StockDTO;
import spring.mvc.farmfarm.dto.WeekFarmDTO;

public interface HostDAO {

	// *************************************************************************************
	// ****************************************펀드관리*******************************
	// *************************************************************************************

	// 펀드 수
	public int getFundCnt(int auc_status);

	// 펀드 수
	public int getFundCnt_end(int auc_status);

	// 펀드 목록 조회
	public ArrayList<StockDTO> getFundList(Map<String, Object> map);

	// 미등록 펀드 삭제
	public int fundDelete(String auc_no);

	// 펀드 상태(1: 미등록 2: 진행중, 3: 중단, 4: 완료) 1.미등록 -> 2.진행중
	public int fundUpdate(Map<String, Object> map);

	// *************************************************************************************
	// *************************************** 경매 관리
	// *************************************
	// *************************************************************************************
	// 김보영
	// 경매 수
	public int getAucCnt(int auc_status);

	// 경매 수
	public int getAucCnt_end(int auc_status);

	// 경매 목록 조회
	public ArrayList<StockDTO> getAucList(Map<String, Object> map);

	// 미등록 경매 삭제
	public int aucDelete(String auc_no);

	// 경매 상태(1: 미등록 2: 진행중, 3: 유찰, 4: 낙찰) 를 UPDATE한다.
	public int aucUpdate(Map<String, Object> map);

	// *************************************************************************************
	// ****************************************회원관리****************************************
	// *************************************************************************************

	// ************* 일반회원 차트**************
	// 펀드 분야별 구매
	public Integer guestFundSales(int stock_kind);

	// 펀드 & 경매 진행 차트
	public Integer guestFundAuc(int fundORauc);

	// ************* 일반 회원 관리 *************
	// 김보영
	// 회원의 수
	public int getGuestCnt();

	// 회원 목록 조회
	public ArrayList<MemberDTO> getGuestList(Map<String, Integer> map);

	// 회원 탈퇴시키기
	public int guestDelete(String mem_id);

	// 회원 어드벤티지 관리
	public int guestAdvUpdate(Map<String, Object> map);

	// ************* 파트너 관리 *************

	// *************파트너 차트관리**************
	// 분야별 펀드 현황
	public Integer partnerFund(int stock_kind);

	// 분야별 경매 현황
	public Integer partnerAuc(int stock_kind);

	// *************파트너 관리****************
	// 총 파트너 수
	public int getPartnerCnt();

	// 모든 파트너 조회
	public ArrayList<PartnerDTO> getPartnerList(Map<String, Object> map);

	// 파트너 어드벤티지 관리
	public int partnerAdvUpdate(Map<String, Object> map);

	// 파트너 승인
	public int partnerUp(String mem_id);

	// 파트너 강등
	public int partnerDown(String mem_id);

	// *************************************************************************************
	// **************************************** 정산
	// 관리************************************
	// *************************************************************************************
	// *************펀드****************
	// 경매 - 펀드 비교 차트
	// public void aucVSfund(HttpServletRequest req, Model model);

	// 이번 달 펀드(상품 종류별) 차트
	public Integer thisMonthFundKind(Map<String, Integer> mapParam);

	// 월별 펀드 총액 차트
	public Integer monthFundTotal(Map<String, Integer> mapParam);

	// 년별 펀드 (총 액수) 차트
	public Integer yearFundTotal(int year);

	// 년별 펀드(상품 종류별) 차트
	public Integer yearFundKind(Map<String, Integer> mapParam);

	// *************경매****************
	// 이번 달 경매(상품 종류별) 차트
	public Integer thisMonthAucKind(Map<String, Integer> mapParam);

	// 월별 경매 총액 차트
	public Integer monthAucTotal(Map<String, Integer> mapParam);

	// 년별 경매 (총 액수) 차트
	public Integer yearAucTotal(int year);

	// 년별 경매(상품 종류별) 차트
	public Integer yearAucKind(Map<String, Integer> mapParam);

	// *************************************************************************************
	// **************************************** 게시판
	// 관리************************************
	// *************************************************************************************

	// ************* 공지사항 *************
	// 공지사항 건수 조회
	public int getNoticeCnt(int category);

	// 공지사항 목록 조회
	public ArrayList<BoardDTO> getNoticeList(Map<String, Object> map);

	// 공지사항 삭제
	public int noticeDelete(Map<String, Object> map);

	// 공지사항 상세페이지
	public BoardDTO getNoticeContent(int boa_id);

	// ************* 댓글 *************
	// 댓글 목록 조회
	public ArrayList<CommentDTO> getCommentList(int boa_id);

	// 댓글 작성
	public void commentWrite(Map<String, Object> map);

	// 댓글 수정
	public int commentModify(Map<String, Object> map);

	// 댓글 삭제
	public int commentDelete(int cm_no);

	// *************************************************************************************
	// **************************************** 기부 관리
	// ************************************
	// *************************************************************************************
	// 기부 건수
	public int getDonateCnt();

	// 기부 내역 조회
	public ArrayList<DonateDTO> getDonateList(Map<String, Object> map);

	// 기부업체수
	public int getDonateConCnt();

	// 기부단체내역
	public ArrayList<DonateDTO> donateConList(Map<String, Object> map);

	// 기부단체 상세페이지
	public DonateDTO donateDetail(int doForm_id);

	// 기부단체 입력
	public int donateInsert(DonateDTO dto);

	// 기부단체 수정 처리
	public int donateUpdate(DonateDTO dto);

	// 기부단체 삭제 처리
	public int DonateDeletePro(int doForm_id);

	/* 차트 */
	// 이번 달 기부 (업체별) -- 1. doForm_id 가져오는 메소드 : getDoFormId()
	public Integer getDoFormId(Integer doForm_id);

	// 이번 달 기부 (업체별) -- 2. 업체별로 기부 모금액 가져오는 메소드 : thisMonthDonate()
	public Integer thisMonthDonate(int doForm_id);

	// 올해 기부 모금액
	public Integer monthDonate(int month);

	// 3.년별 경매(상품 종류별) 차트
	public Integer yearDonate(Map<String, Integer> mapParam);
	
	// *************************************************************************************
	// ***************************************** 주말농장
	// *************************************
	// *************************************************************************************

	// 주말농장 건수
	public int getWeekFarmCnt(int wfarm_status);

	// 주말농장 요청현황 조회
	public ArrayList<WeekFarmDTO> getWeekFarmRequestList(Map<String, Object> map);

	// 주말농장 현황 조회
	public ArrayList<WeekFarmDTO> getWeekFarmList(Map<String, Object> map);

	// 주말농장 요청승인
	public int weekFarmReqPermit(Map<String, Object> map);

	// 주말농장 삭제
	public int weekFarmDelete(int wfarm_key);

}
