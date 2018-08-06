package spring.mvc.farmfarm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 농부 서비스 인터페이스
 */

public interface FarmerService {

	/**
	 * 장렬 1. 회원(쪽지기능)
	 */
	// 회원 - 회원 보낸 쪽지함
	public void LetterList(HttpServletRequest req, Model model);

	// 회원 - 회원 받은 쪽지함
	public void LetterGetList(HttpServletRequest req, Model model);

	// 회원 - 쪽지함 상세 보기
	public void LTContentsForm(HttpServletRequest req, Model model);

	// 회원 - 작성한 쪽지 전송처리
	public void LTWritePro(HttpServletRequest req, Model model);

	// 회원 - 쪽지 삭제 처리
	public void LTDeletePro(HttpServletRequest req, Model model);

	/**
	 * 장렬 2. 농부(쪽지기능)
	 */
	// 농부 - 받은 쪽지함
	public void LTFarmerletters(HttpServletRequest req, Model model);

	// 농부 - 회원문의 쪽지 상세 페이지
	public void LTFarmerContentsForm(HttpServletRequest req, Model model);

	// 농부 - 회원문의 답변 처리
	public void LTFarmerReplyPro(HttpServletRequest req, Model model);

	// 농부 - 답변 완료 쪽지함
	public void replyletters(HttpServletRequest req, Model model);

	/**
	 * 장렬 3. 농부(주말농장 신청)
	 */
	// 농부 - 주말농장 신청 처리
	public void ChooseFarmPro(HttpServletRequest req, Model model);

	// 농부 - 주말농장 신청 완료 목록
	public void ConfirmWeekFarm(HttpServletRequest req, Model model);

	/**
	 * 장렬 4.회원(주말농장 신청)
	 */

	// 회원 - 주말농장 신청 현황 상세 보기
	public void CustomerWeeklyFarmlist(HttpServletRequest req, Model model);

	/**
	 * 장렬 5. 농부 점수
	 */
	public void FarmerScore(HttpServletRequest req, Model model);

	/**
	 * 민웅
	 */

	// 경매 상품 등록 - 처리
	public void Auction_ApplyPro(MultipartHttpServletRequest req, Model model);

	// 경매 상품 현황 및 이전내역
	public void Auction_status(HttpServletRequest req, Model model);

	// 펀드 신청 등록 - 처리
	public void Fund_ApplyPro(MultipartHttpServletRequest req, Model model);

	// 펀드 상품 현황 및 이전내역
	public void Fund_status(HttpServletRequest req, Model model);

	
}
