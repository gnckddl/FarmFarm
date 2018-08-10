package spring.mvc.farmfarm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface MemberService {

	// 스케쥴 처리
	public void scheduleRun();

	// 로그인처리
	public void LoginPro(HttpServletRequest req, Model model);

	// 회원가입 아이디 중복확인
	public void confirmId(HttpServletRequest req, Model model);

	// 회원가입 처리
	public void registerPro(HttpServletRequest req, Model model);

	// 회원수정뷰
	public void UpdateMemberView(HttpServletRequest req, Model model);

	// 회원수정처리
	public void updateMemberPro(HttpServletRequest req, Model model);

	// 회원탈퇴처리
	public void deleteMemberPro(HttpServletRequest req, Model model);

	// 회원 기부내역 가져오기
	public void guestAdvList(HttpServletRequest req, Model model);

	// 펀드랭킹
	public void fundRanking(HttpServletRequest req, Model model);

	// 경매랭킹
	public void auctionRanking(HttpServletRequest req, Model model);

	// 기부랭킹
	public void donateRanking(HttpServletRequest req, Model model);

	// 검색기능
	public void searching(HttpServletRequest req, Model model);

	// 경매상품보기
	public void getActionList(HttpServletRequest req, Model model);

	// 경매상품 상세
	public void AuctionItemContent(HttpServletRequest req, Model model);

	// 경매현재가격 가져오기
	public void AuctionNowPrice(HttpServletRequest req, Model model);

	// 경매 입찰폼
	public void AuctionJoin(HttpServletRequest req, Model model);

	// 경매 입찰처리
	public void AuctionJoinPro(HttpServletRequest req, Model model);

	// 회원경매내역
	public void AuctionList(HttpServletRequest req, Model model);

	// 회원경매 진행내역보기
	public void AuctionProgress(HttpServletRequest req, Model model);

	// 회원 경매 진행내역 ajax
	public void AuctionProgressAjax(HttpServletRequest req, Model model);

	// 회원 낙찰후 결제배송
	public void AuctionPay(HttpServletRequest req, Model model);

	// 회원 낙찰후 결제배송 처리
	public void AuctionPayPro(HttpServletRequest req, Model model);

	// 펀드상품보기
	public void FundProductsList(HttpServletRequest req, Model model);

	// 펀드상품상세보기
	public void FundProductsContentList(HttpServletRequest req, Model model);

	// 펀드상품참여 기부 참여
	public void FundDonateJoin(HttpServletRequest req, Model model);

	// 펀드상품 참여 기부 참여 처리
	public void FundJoinPro(HttpServletRequest req, Model model);

	// 펀드상품 참여 기부 참여 처리
	public void FundDonaJoinPro(HttpServletRequest req, Model model);

	/**
	 * 장렬
	 */
	// 이메일 인증
	public void mailconfirm(HttpServletRequest req, Model model);

	/**
	 * 민웅
	 */
	// 농부 되기 - 신청
	public void BecomeFarmerPro(HttpServletRequest req, Model model);

	// 기부내역
	public void guestDonateLists(HttpServletRequest req, Model model);

	// 남은날짜구하기
	public void RemainingDate(HttpServletRequest req, Model model);

	
	// 회원펀드내역
	public void FundList(HttpServletRequest req, Model model);

}
