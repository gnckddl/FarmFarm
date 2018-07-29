package spring.mvc.farmfarm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface MemberService {
	//로그인처리
	public void LoginPro(HttpServletRequest req, Model model);
	//회원가입 아이디 중복확인
	public void confirmId(HttpServletRequest req, Model model);
	//회원가입 처리
	public void registerPro(HttpServletRequest req, Model model);
	
	//회원수정뷰
	public void UpdateMemberView(HttpServletRequest req, Model model);
	//회원수정처리
	public void updateMemberPro(HttpServletRequest req, Model model);	
	//회원탈퇴처리
	public void deleteMemberPro(HttpServletRequest req, Model model);
	
	//회원 기부내역 가져오기
	public void guestAdvList(HttpServletRequest req, Model model);
	
	
	
	//펀드랭킹
	public void fundRanking(HttpServletRequest req, Model model);
	//경매랭킹
	public void auctionRanking(HttpServletRequest req, Model model);
	//기부랭킹
	public void donateRanking(HttpServletRequest req, Model model);
	
	
	//검색기능
	public void searching(HttpServletRequest req, Model model);
}
