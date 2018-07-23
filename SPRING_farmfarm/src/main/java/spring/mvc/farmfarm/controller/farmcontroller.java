package spring.mvc.farmfarm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.farmfarm.service.BoardService;
import spring.mvc.farmfarm.service.MemberService;

@Controller
public class farmcontroller {
	
	@Autowired
	MemberService mem_service;
	
	@Autowired
	BoardService board_service;
	
	//메인화면
	@RequestMapping("FarmFarm")
	public String farmFarmBootStrap(HttpServletRequest req, Model model) {
		System.out.println("farmFarm");
		
		model.addAttribute("grade",req.getParameter("grade"));
		
		return	"common/FarmFarm";
	}
	//회원가입폼
	@RequestMapping("registerForm")
	public String registerForm(HttpServletRequest req, Model model) {
		System.out.println("registerForm");
		
		return	"guest/registerForm";
	}
	//회원가입처리
	@RequestMapping("registerPro")
	public String registerPro(HttpServletRequest req, Model model) {
		System.out.println("registerPro");
				
		mem_service.registerPro(req, model);
		return	"guest/registerPro";
	}
	//중복확인
		@RequestMapping("confirmId")
		public String confirmId(HttpServletRequest req, Model model) {
			System.out.println("confirmId");
			
			mem_service.confirmId(req, model);
			return	"guest/confirmId";
		}
	//로그인폼
	@RequestMapping("loginForm")
	public String loginForm(HttpServletRequest req, Model model) {
		System.out.println("loginForm");
		
		return	"guest/loginForm";
	}	
	//로그인처리
	@RequestMapping("LoginPro")
	public String Login(HttpServletRequest req, Model model) {
		System.out.println("LoginPro");
		
		mem_service.LoginPro(req, model);
		
		return	"guest/LoginPro";
	}
	
	//로그아웃
	@RequestMapping("logout")
	public String logout(HttpServletRequest req, Model model) {
		System.out.println("logout");
		
		req.getSession().invalidate();
	
		System.out.println("logout");
		return	"common/FarmFarm";
	}
	//펀드상품보기
	@RequestMapping("FundProducts")
	public String FundProducts(HttpServletRequest req, Model model) {
		System.out.println("FundProducts");
		
		return	"guest/FundProducts";
	}
	
	//펀드상품상세보기
	@RequestMapping("FundProductsContent")
	public String FundProductsContent(HttpServletRequest req, Model model) {
		System.out.println("FundProductsContent");
		
		return	"guest/FundProductsContent";
	}
	
	//경매상품보기
	@RequestMapping("AuctionItem")
	public String AuctionItem(HttpServletRequest req, Model model) {
		System.out.println("AuctionItem");
		
		return	"guest/AuctionItem";
	}
	
	//농부되기
	@RequestMapping("BecomeFarmer")
	public String BecomeFamer(HttpServletRequest req, Model model) {
		System.out.println("BecomeFarmer");
		
		return	"guest/BecomeFarmer";
	}
	
	//팜팜소개
	@RequestMapping("IntrFarmFarm")
	public String IntrFarmFarm(HttpServletRequest req, Model model) {
		System.out.println("IntrFarmFarm");
		
		return	"guest/IntrFarmFarm";
	}
	
	//기부소개
	@RequestMapping("Donate")
	public String Donate(HttpServletRequest req, Model model) {
		System.out.println("Donate");
		
		return	"guest/Donate";
	}
	
	//문의게시판
	@RequestMapping("questionBoard")
	public String questionBoard(HttpServletRequest req, Model model) {
		System.out.println("questionBoard");
		
		return	"guest/questionBoard";
	}
	
	//소식게시판
	@RequestMapping("NewsBoard")
	public String Newsboard(HttpServletRequest req, Model model) {
		System.out.println("NewsBoard");
		
		return	"guest/NewsBoard";
	}
	
	//요청게시판
	@RequestMapping("RequestBoard")
	public String RequestBoard(HttpServletRequest req, Model model) {
		System.out.println("RequestBoard");
		
		board_service.boardList(req, model);
		
		return	"guest/RequestBoard";
	}
	
	//주말농장관리
	@RequestMapping("WeekFarmManagement")
	public String WeekFarmManagement(HttpServletRequest req, Model model) {
		System.out.println("WeekFarmManagement");
		
		return	"guest/WeekFarmManagement";
	}
	
	//IOT
	@RequestMapping("IOT")
	public String IOT(HttpServletRequest req, Model model) {
		System.out.println("IOT");
		
		return	"guest/IOT";
	}
	
	//영상확인
	@RequestMapping("View")
	public String View(HttpServletRequest req, Model model) {
		System.out.println("View");
		
		return	"guest/View";
	}
	
	//공지사항
	@RequestMapping("Notice")
	public String Notice(HttpServletRequest req, Model model) {
		System.out.println("Notice");
		
		return	"guest/Notice";
	}
	
	//경매랭킹
	@RequestMapping("AuctionRanking")
	public String AuctionRanking(HttpServletRequest req, Model model) {
		System.out.println("AuctionRanking");
		
		return	"guest/AuctionRanking";
	}
	
	//기부랭킹
	@RequestMapping("DonateRanking")
	public String DonateRanking(HttpServletRequest req, Model model) {
		System.out.println("DonateRanking");
		
		return	"guest/DonateRanking";
	}
	
	//펀드랭킹
	@RequestMapping("FundRanking")
	public String FundRanking(HttpServletRequest req, Model model) {
		System.out.println("FundRanking");
		
		return	"guest/FundRanking";
	}
	
	//주말농장신청
	@RequestMapping("WeekFarmApply")
	public String WeekFarmApply(HttpServletRequest req, Model model) {
		System.out.println("WeekFarmApply");
		
		return	"guest/WeekFarmApply";
	}
 //도움말
   @RequestMapping("Help")
   public String Help(HttpServletRequest req, Model model) {
   System.out.println("Help");
   
   return   "guest/Help";
   }
	
	/////////////////////////////일반회원 메뉴
	//정보수정페이지
	@RequestMapping("updateInfoPage")
	public String updateInfoPage(HttpServletRequest req, Model model) {
		System.out.println("updateInfoPage");
		
		return	"guest/updateInfoPage";
	}
	//정보수정뷰
	@RequestMapping("updateInfoView")
	public String updateInfoView(HttpServletRequest req, Model model) {
		System.out.println("updateInfoView");
		
		mem_service.UpdateMemberView(req, model);
		return	"guest/updateInfoView";
	}
	
	//회원수정처리
	@RequestMapping("updateMemberPro")
	public String updateMemberPro(HttpServletRequest req, Model model) {
		System.out.println("updateMemberPro");
		
		mem_service.updateMemberPro(req, model);
		return	"guest/updateMemberPro";
	}	
	
	//회원탈퇴
	@RequestMapping("deleteMember")
	public String deleteMember(HttpServletRequest req, Model model) {
		System.out.println("deleteMember");
		
		return	"guest/deleteMember";
	}	
	//회원탈퇴처리
	@RequestMapping("deleteMemberPro")
	public String deleteMemberPro(HttpServletRequest req, Model model) {
		System.out.println("deleteMemberPro");
		
		mem_service.deleteMemberPro(req, model);
		req.getSession().invalidate();
		return	"guest/deleteMemberPro";
	}
	
	//회원점수
	@RequestMapping("gusetAdv")
	public String gusetAdv(HttpServletRequest req, Model model) {
		System.out.println("gusetAdv");
		
		mem_service.guestAdvList(req, model);
		return	"guest/gusetAdv";
	}
	
	//회원 내 기부내내역
	@RequestMapping("guestDonateList")
	public String guestDonateList(HttpServletRequest req, Model model) {
		System.out.println("guestDonateList");
		
		mem_service.guestAdvList(req, model);
		return	"guest/guestDonateList";
		
	}
	
}
