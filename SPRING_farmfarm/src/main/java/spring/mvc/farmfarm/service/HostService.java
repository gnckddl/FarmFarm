package spring.mvc.farmfarm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface HostService {

	// 메인
	public void FarmFarmMain(HttpServletRequest req, Model model);

	// *************************************************************************************
	// *************************************** 펀드 관리
	// *************************************
	// *************************************************************************************

	// 보영
	// 경매 진행내역_진행중/ 미등록 경매내역
	public void fundList(HttpServletRequest req, Model model);

	// 미등록 펀드 삭제
	public void fundDelete(HttpServletRequest req, Model model);

	// 펀드 상태(1: 미등록 2: 진행중, 3: 중단, 4: 완료) 1.미등록 -> 2.진행중
	public void fundOk(HttpServletRequest req, Model model);

	// *************************************************************************************
	// *************************************** 경매 관리
	// *************************************
	// *************************************************************************************
	// 보영
	// 경매 진행내역_진행중/ 미등록 경매내역
	public void aucList(HttpServletRequest req, Model model);

	// 미등록 경매 삭제
	public void aucDelete(HttpServletRequest req, Model model);

	// 경매 상태(1: 미등록 2: 진행중, 3: 유찰, 4: 낙찰) 1.미등록 -> 2.진행중
	public void aucOk(HttpServletRequest req, Model model);

	// *************************************************************************************
	// ****************************************회원관리****************************************
	// *************************************************************************************

	// ************** 일반 회원 차트***************
	// 펀드 분야별 구매 차트
	public void guestFundSales(HttpServletRequest req, Model model);

	// 펀드 & 경매 진행 차트
	public void guestFundAuc(HttpServletRequest req, Model model);

	// ************* 일반 회원 관리 *************
	// 일반회원 관리: guestManage()
	public void guestManage(HttpServletRequest req, Model model);

	// 일반회원 검색: guestSearch()
	public void guestSearch(HttpServletRequest req, Model model);

	// 일반회원 삭제: guestDelete()
	public void guestDelete(HttpServletRequest req, Model model);

	// 어드벤티지 +,-: guestAdvManage()
	public void advManage(HttpServletRequest req, Model model);

	// ************* 파트너 관리 *************
	// 영민
	// ************* 파트너 차트 *************
	// 분야별 펀드 현황 차트
	public void partnerFund(HttpServletRequest req, Model model);

	// 분야별 경매 현황 차트
	public void partnerAuc(HttpServletRequest req, Model model);

	// ************* 파트너 관리 *************
	// 파트너 관리
	// 파트너 조회
	public void partnerManage(HttpServletRequest req, Model model);

	/*
	 * //파트너 검색 public void partnerSearch(HttpServletRequest req, Model model);
	 */

	// 파트너 승인
	public void partnerUp(HttpServletRequest req, Model model);

	// 파트너 강등
	public void partnerDown(HttpServletRequest req, Model model);

	// *************************************************************************************
	// **************************************** 정산 관리
	// ************************************
	// *************************************************************************************
	// ************* 펀드 *************
	// 경매 - 펀드 비교 차트
	public void aucVSfund(HttpServletRequest req, Model model);

	// 이번 달 펀드 (상품 종류별) 차트
	public void thisMonthFundKind(HttpServletRequest req, Model model);

	// 월별 펀드 총액 차트
	public void monthFundTotal(HttpServletRequest req, Model model);

	// 년별 펀드 (총 액수) 차트
	public void yearFundTotal(HttpServletRequest req, Model model);

	// 년별 펀드(상품 종류별) 차트
	public void yearFundKind(HttpServletRequest req, Model model);

	// ************* 경매 *************

	// 이번 달 경매 (상품 종류별) 차트
	public void thisMonthAucKind(HttpServletRequest req, Model model);

	// 월별 경매 총액 차트
	public void monthAucTotal(HttpServletRequest req, Model model);

	// 년별 경매 (총 액수) 차트
	public void yearAucTotal(HttpServletRequest req, Model model);

	// 년별 경매(상품 종류별) 차트
	public void yearAucKind(HttpServletRequest req, Model model);

	// *************************************************************************************
	// **************************************** 게시판 관리
	// ************************************
	// *************************************************************************************

	// ************* 공지사항 *************
	// 공지사항 목록
	public void noticeList(HttpServletRequest req, Model model);

	// 공지사항 작성
	// public void noticeWrite(HttpServletRequest req, Model model);

	// 공지사항 수정
	// public void noticeModify(HttpServletRequest req, Model model);

	// 공지사항 삭제
	public void noticeDelete(HttpServletRequest req, Model model);

	// 공지사항 상세페이지
	public void noticeContent(HttpServletRequest req, Model model);

	// 댓글 목록
	public void commentList(HttpServletRequest req, Model model);

	// 댓글 작성
	public void commentWrite(HttpServletRequest req, Model model);

	// 댓글 수정
	public void commentModify(HttpServletRequest req, Model model);

	// 댓글 삭제
	public void commentDelete(HttpServletRequest req, Model model);

	// *************************************************************************************
	// **************************************** 기부 관리
	// ************************************
	// *************************************************************************************
	// 기부 내역
	public void donateList(HttpServletRequest req, Model model);

	// 기부업체내역
	public void DonateConList(HttpServletRequest req, Model model);

	// 기부수정 상세페이지
	public void donateModifyView(HttpServletRequest req, Model model);

	// 기부수정 처리페이지
	public void donateModifyPro(MultipartHttpServletRequest req, Model model);

	// 기부 삭제 처리페이지
	public void DonateDeletePro(HttpServletRequest req, Model model);

	// 기부업체 등록 글쓰기
	public void donateWritePro(MultipartHttpServletRequest req, Model model);

	/* 기부통계 */
	// 3.업체별 기부액 3년치
	public void yearDonate(HttpServletRequest req, Model model);

	// *************************************************************************************
	// **************************************** 주말농장 관리
	// ************************************
	// *************************************************************************************

	// 주말농장 요청현황 조회
	public void getWeekFarmRequestList(HttpServletRequest req, Model model);

	// 주말농장 현황 조회
	public void getWeekFarmList(HttpServletRequest req, Model model);

	// 주말농장 요청승인
	public void weekFarmReqPermit(HttpServletRequest req, Model model);

	// 주말농장 삭제
	public void weekFarmDelete(HttpServletRequest req, Model model);
}
