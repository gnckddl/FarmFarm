package spring.mvc.farmfarm.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.farmfarm.service.BoardService;
import spring.mvc.farmfarm.service.HostService;
import spring.mvc.farmfarm.service.MemberService;

@Controller
public class farmcontroller {

	@Autowired
	MemberService mem_service;

	@Autowired
	BoardService board_service;

	@Autowired
	HostService host_service;

	private static final Logger logger = LoggerFactory.getLogger(HostController.class);

	// index
	@RequestMapping("index")
	public String index(HttpServletRequest req, Model model) {
		System.out.println("index");

		return "index";
	}

	// 메인화면
	@RequestMapping("FarmFarm")
	public String farmFarmBootStrap(HttpServletRequest req, Model model) {
		System.out.println("farmFarm");

		model.addAttribute("grade", req.getParameter("grade"));
		host_service.FarmFarmMain(req, model);

		return "common/FarmFarm";
	}

	// 회원가입폼
	@RequestMapping("registerForm")
	public String registerForm(HttpServletRequest req, Model model) {
		System.out.println("registerForm");

		return "guest/registerForm";
	}

	// 회원가입처리
	@RequestMapping("registerPro")
	public String registerPro(HttpServletRequest req, Model model) {
		System.out.println("registerPro");

		mem_service.registerPro(req, model);
		return "guest/registerPro";
	}

	// 중복확인
	@RequestMapping("confirmId")
	public String confirmId(HttpServletRequest req, Model model) {
		System.out.println("confirmId");

		mem_service.confirmId(req, model);
		return "guest/confirmId";
	}

	// 로그인폼
	@RequestMapping("loginForm")
	public String loginForm(HttpServletRequest req, Model model) {
		System.out.println("loginForm");

		return "guest/loginForm";
	}

	// 로그인처리
	@RequestMapping("LoginPro")
	public String Login(HttpServletRequest req, Model model) {
		System.out.println("LoginPro");

		mem_service.LoginPro(req, model);

		return "guest/LoginPro";
	}

	// 로그아웃
	@RequestMapping("logout")
	public String logout(HttpServletRequest req, Model model) {
		System.out.println("logout");

		req.getSession().invalidate();

		System.out.println("logout");
		return "common/FarmFarm";
	}

	// 펀드상품보기
	@RequestMapping("FundProducts")
	public String FundProducts(HttpServletRequest req, Model model) {
		System.out.println("FundProducts");

		mem_service.FundProductsList(req, model);

		return "guest/FundProducts";
	}

	// 펀드상품상세보기
	@RequestMapping("FundProductsContent")
	public String FundProductsContent(HttpServletRequest req, Model model) {
		System.out.println("FundProductsContent");

		mem_service.FundProductsContentList(req, model);
		mem_service.RemainingDate(req, model);

		return "guest/FundProductsContent";
	}

	// 펀드상품참여처리
	@RequestMapping("FundProductsPop")
	public String FundProductJoin(HttpServletRequest req, Model model) {
		System.out.println("FundProductsPop");
		String fund_no = req.getParameter("fund_no");
		int stock_price = Integer.parseInt(req.getParameter("stock_price"));
		String fund_title = req.getParameter("fund_title");

		mem_service.FundDonateJoin(req, model);

		model.addAttribute("fund_no", fund_no);
		model.addAttribute("stock_price", stock_price);
		model.addAttribute("fund_title", fund_title);

		return "guest/FundProductsPop";
	}

	// 펀드상품참여 기부참여
	@RequestMapping("FundJoinPro")
	public String FundJoinPro(HttpServletRequest req, Model model) {
		System.out.println("FundJoinPro");

		mem_service.FundJoinPro(req, model);
		mem_service.FundDonaJoinPro(req, model);

		return "guest/FundJoinPro";
	}

	// 경매상품보기
	@RequestMapping("AuctionItem")
	public String AuctionItem(HttpServletRequest req, Model model) {
		System.out.println("AuctionItem");

		mem_service.getActionList(req, model);

		return "guest/AuctionItem";
	}

	// 경매상품보기 상세
	@RequestMapping("AuctionItemContent")
	public String AuctionItemContent(HttpServletRequest req, Model model) {
		System.out.println("AuctionItemContent");

		mem_service.AuctionItemContent(req, model);

		return "guest/AuctionItemContent";
	}

	// 경매상품 현재가격 ajax
	@RequestMapping("AuctionNowPrice")
	public String AuctionNowPrice(HttpServletRequest req, Model model) {

		mem_service.AuctionNowPrice(req, model);

		return "guest/AuctionNowPrice";
	}

	// 경매 입찰폼
	@RequestMapping("AuctionJoin")
	public String AuctionJoin(HttpServletRequest req, Model model) {
		System.out.println("AuctionJoin");

		mem_service.AuctionJoin(req, model);

		return "guest/AuctionJoin";
	}

	// 경매 입찰처리
	@RequestMapping("AuctionJoinPro")
	public String AuctionJoinPro(HttpServletRequest req, Model model) {
		System.out.println("AuctionJoinPro");

		mem_service.AuctionJoinPro(req, model);

		return "guest/AuctionJoinPro";
	}

	// 회원 경매내역(진행중)
	@RequestMapping("AuctionList_ing")
	public String AuctionList_ing(HttpServletRequest req, Model model) {
		System.out.println("AuctionList_ing");

		mem_service.AuctionList(req, model);

		return "guest/AuctionList_ing";
	}

	// 회원 경매내역(종료)
	@RequestMapping("AuctionList_old")
	public String AuctionList_old(HttpServletRequest req, Model model) {
		System.out.println("AuctionList_old");

		mem_service.AuctionList(req, model);

		return "guest/AuctionList_old";
	}

	// 경매진행내역보기
	@RequestMapping("AuctionProgress")
	public String AuctionProgress(HttpServletRequest req, Model model) {
		System.out.println("AuctionProgress");

		mem_service.AuctionProgress(req, model);

		return "guest/AuctionProgress";
	}

	// 경매진행내역보기 ajax
	@RequestMapping("AuctionProgressAjax")
	public String AuctionProgressAjax(HttpServletRequest req, Model model) {
		mem_service.AuctionProgressAjax(req, model);

		return "guest/AuctionProgressAjax";
	}

	// 경매낙찰후 결제배송
	@RequestMapping("AuctionPay")
	public String AuctionPay(HttpServletRequest req, Model model) {
		mem_service.AuctionPay(req, model);

		return "guest/AuctionPay";
	}

	// 경매낙찰후 결제배송처리
	@RequestMapping("AuctionPayPro")
	public String AuctionPayPro(HttpServletRequest req, Model model) {
		mem_service.AuctionPayPro(req, model);

		return "guest/AuctionPayPro";
	}

	// 농부되기
	@RequestMapping("BecomeFarmer")
	public String BecomeFamer(HttpServletRequest req, Model model) {
		System.out.println("BecomeFarmer");

		return "guest/BecomeFarmer";
	}

	// 농부되기 - 처리
	@RequestMapping("BecomeFarmerPro")
	public String BecomeFamerPro(HttpServletRequest req, Model model) {
		System.out.println("BecomeFarmerPro");

		mem_service.BecomeFarmerPro(req, model);

		return "guest/BecomeFarmerPro";
	}

	// 팜팜소개
	@RequestMapping("IntrFarmFarm")
	public String IntrFarmFarm(HttpServletRequest req, Model model) {
		System.out.println("IntrFarmFarm");

		return "guest/IntrFarmFarm";
	}

	// 기부소개
	@RequestMapping("Donate")
	public String Donate(HttpServletRequest req, Model model) {
		System.out.println("Donate");

		return "guest/Donate";
	}

	// 회원문의게시판
	@RequestMapping("memberQuestionBoard")
	public String memberQuestionBoard(HttpServletRequest req, Model model) {
		System.out.println("memberQuestionBoard");

		board_service.boardList(req, model);
		return "guest/memberQuestionBoard";
	}

	// 농부문의게시판
	@RequestMapping("farmerQuestionBoard")
	public String farmerQuestionBoard(HttpServletRequest req, Model model) {
		System.out.println("farmerQuestionBoard");

		board_service.boardList(req, model);
		return "guest/farmerQuestionBoard";
	}

	// 요청게시판
	@RequestMapping("RequestBoard")
	public String RequestBoard(HttpServletRequest req, Model model) {
		System.out.println("RequestBoard");

		board_service.boardList(req, model);

		return "guest/RequestBoard";
	}

	// 요청게시판
	@RequestMapping("RequestBoardContent")
	public String RequestBoardContent(HttpServletRequest req, Model model) {
		System.out.println("RequestBoardContent");

		board_service.RequestBoardContent(req, model);

		return "guest/RequestBoardContent";
	}

	// 요청게시판글쓰기
	@RequestMapping("RequestBoardWrite")
	public String RequestBoardWrite(HttpServletRequest req, Model model) {
		System.out.println("RequestBoardWrite");

		int pageNum = 0;
		int boa_category = 0;

		pageNum = Integer.parseInt(req.getParameter("pageNum"));
		boa_category = Integer.parseInt(req.getParameter("boa_category"));

		model.addAttribute("pageNum", pageNum);
		model.addAttribute("boa_category", boa_category);

		return "guest/RequestBoardWrite";

	}

	// 농부문의게시판글쓰기
	@RequestMapping("farmerQuestionBoardWrite")
	public String farmerQuestionBoardWrite(HttpServletRequest req, Model model) {
		System.out.println("farmerQuestionBoardWrite");

		int pageNum = 0;
		int boa_category = 0;

		pageNum = Integer.parseInt(req.getParameter("pageNum"));
		boa_category = Integer.parseInt(req.getParameter("boa_category"));
		pageNum = Integer.parseInt(req.getParameter("pageNum"));

		model.addAttribute("pageNum", pageNum);
		model.addAttribute("boa_category", boa_category);

		return "guest/farmerQuestionBoardWrite";

	}

	// 회원문의게시판글쓰기
	@RequestMapping("memberQuestionBoardWrite")
	public String memberQuestionBoardWrite(HttpServletRequest req, Model model) {
		System.out.println("memberQuestionBoardWrite");

		int pageNum = 0;
		int boa_category = 0;

		pageNum = Integer.parseInt(req.getParameter("pageNum"));
		boa_category = Integer.parseInt(req.getParameter("boa_category"));
		pageNum = Integer.parseInt(req.getParameter("pageNum"));

		model.addAttribute("pageNum", pageNum);
		model.addAttribute("boa_category", boa_category);

		return "guest/memberQuestionBoardWrite";

	}

	// 소식게시판
	@RequestMapping("NewsBoard")
	public String Newsboard(HttpServletRequest req, Model model) {
		System.out.println("NewsBoard");

		board_service.newsList(req, model);
		return "guest/NewsBoard";
	}

	// 소식게시판 글쓰기
	@RequestMapping("NewsBoardWrite")
	public String NewsBoardWrite(HttpServletRequest req, Model model) {
		System.out.println("NewsBoardWrite");

		int pageNum = 0;
		int boa_category = 0;

		pageNum = Integer.parseInt(req.getParameter("pageNum"));
		boa_category = Integer.parseInt(req.getParameter("boa_category"));

		model.addAttribute("pageNum", pageNum);
		model.addAttribute("boa_category", boa_category);

		return "guest/NewsBoardWrite";

	}

	// 소식게시판 상세
	@RequestMapping("NewsBoardContent")
	public String NewsBoardContent(HttpServletRequest req, Model model) {
		System.out.println("NewsBoardContent");

		board_service.NewsBoardContent(req, model);

		return "guest/NewsBoardContent";
	}

	// 소식 게시판 글쓰기 추가 처리페이지
	@RequestMapping(value = "NewsBoardWritePro", method = RequestMethod.POST)
	public String NewsBoardWritePro(MultipartHttpServletRequest req, Model model) {
		System.out.println("NewsBoardWritePro");

		board_service.NewsBoardWritePro(req, model);

		return "guest/NewsBoardWritePro";
	}

	// 소식게시판 수정
	@RequestMapping("NewsModifyFormBoard")
	public String NewsModifyFormBoard(HttpServletRequest req, Model model) {
		System.out.println("NewsModifyFormBoard");

		String boa_subject = req.getParameter("boa_subject");
		String boa_content = req.getParameter("boa_content");
		String mem_id = req.getParameter("mem_id");
		String boa_id = req.getParameter("boa_id");
		int number = Integer.parseInt(req.getParameter("number"));
		int boa_category = Integer.parseInt(req.getParameter("boa_category"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));

		model.addAttribute("boa_id", boa_id);
		model.addAttribute("boa_subject", boa_subject);
		model.addAttribute("boa_content", boa_content);
		model.addAttribute("mem_id", mem_id);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("boa_category", boa_category);

		board_service.modifyView(req, model);

		return "guest/NewsModifyFormBoard";
	}

	// 소식게시판 글수정 처리
	@RequestMapping("NewsModifyBoardPro")
	public String NewsModifyBoardPro(MultipartHttpServletRequest req, Model model) {
		System.out.println("NewsModifyBoardPro");

		board_service.NewsModifyBoardPro(req, model);

		return "guest/NewsModifyBoardPro";
	}

	// 소식게시판 삭제처리
	@RequestMapping("NewsDeleteBoardPro")
	public String NewsDeleteBoardPro(HttpServletRequest req, Model model) {
		System.out.println("NewsDeleteBoardPro");

		board_service.NewsDeleteBoardPro(req, model);

		return "guest/NewsDeleteBoardPro";
	}

	// 요청게시판 글쓰기 처리페이지
	@RequestMapping("RequestBoardWritePro")
	public String RequestBoardWritePro(HttpServletRequest req, Model model) {
		System.out.println("RequestBoardWritePro");

		board_service.RequestBoardWritePro(req, model);
		return "guest/RequestBoardWritePro";
	}

	// 요청게시판 글쓰기
	@RequestMapping("commentBoard")
	public String commentBoard(HttpServletRequest req, Model model) {
		System.out.println("commentBoard");

		board_service.RequestBoardContent(req, model);
		return "guest/RequestBoardContent";
	}

	// 요청게시판 글쓰기 처리페이지
	@RequestMapping("commentBoardWritePro")
	public String commentBoardWritePro(HttpServletRequest req, Model model) {
		System.out.println("commentBoardWritePro");

		board_service.commentBoardWritePro(req, model);
		return "guest/commentBoardWritePro";
	}

	// 글수정폼
	@RequestMapping("modifyFormBoard")
	public String modifyFormBoard(HttpServletRequest req, Model model) {
		System.out.println("modifyFormBoard");
		String boa_subject = req.getParameter("boa_subject");
		String boa_content = req.getParameter("boa_content");
		String mem_id = req.getParameter("mem_id");
		String boa_id = req.getParameter("boa_id");
		int number = Integer.parseInt(req.getParameter("number"));
		int boa_category = Integer.parseInt(req.getParameter("boa_category"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));

		model.addAttribute("boa_id", boa_id);
		model.addAttribute("boa_subject", boa_subject);
		model.addAttribute("boa_content", boa_content);
		model.addAttribute("mem_id", mem_id);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("boa_category", boa_category);
		System.out.println("남바~~~~~!~~~~~" + number);

		board_service.modifyView(req, model);

		System.out.println("남바~~~~~!~~~~~$$$$$$$$$$$" + number);
		return "guest/modifyFormBoard";
	}

	// 글수정 처리
	@RequestMapping("modifyProBoard")
	public String modifyPro(HttpServletRequest req, Model model) {
		System.out.println("modifyProBoard");

		board_service.modifyProBoard(req, model);

		return "guest/modifyProBoard";
	}

	// 댓글 수정 팝업
	@RequestMapping("commentModifyPop")
	public String commentModifyPop(HttpServletRequest req, Model model) {
		System.out.println("commentModifyPop");
		int cm_no = Integer.parseInt(req.getParameter("cm_no"));
		String boa_id = req.getParameter("boa_id");
		int number = Integer.parseInt(req.getParameter("number"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int boa_category = Integer.parseInt(req.getParameter("boa_category"));
		System.out.println("씨엠엔오:" + cm_no);

		model.addAttribute("boa_id", boa_id);
		model.addAttribute("cm_no", cm_no);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("boa_category", boa_category);

		return "guest/commentModifyPop";
	}

	// 댓글 수정 팝업
	@RequestMapping("commentModifyPopPro")
	public String commentModifyPopPro(HttpServletRequest req, Model model) {
		System.out.println("commentModifyPopPro");

		board_service.commentModifyPopPro(req, model);

		return "guest/commentModifyPopPro";
	}

	// 댓글 삭제처리
	@RequestMapping("deleteBoardPro")
	public String deleteBoardPro(HttpServletRequest req, Model model) {
		System.out.println("deleteBoardPro");

		board_service.deleteBoardPro(req, model);

		return "guest/deleteBoardPro";
	}

	// 댓글 수정 팝업
	@RequestMapping("commentDeletePro")
	public String deletecommentDeleteProBoardPro(HttpServletRequest req, Model model) {
		System.out.println("commentDeletePro");

		board_service.commentDeletePro(req, model);

		return "guest/commentDeletePro";
	}

	// 주말농장관리
	@RequestMapping("WeekFarmManagement")
	public String WeekFarmManagement(HttpServletRequest req, Model model) {
		System.out.println("WeekFarmManagement");

		return "guest/WeekFarmManagement";
	}

	// IOT
	@RequestMapping("IOT")
	public String IOT(HttpServletRequest req, Model model) {
		System.out.println("IOT");

		return "guest/IOT";
	}

	// 영상확인
	@RequestMapping("View")
	public String View(HttpServletRequest req, Model model) {
		System.out.println("View");

		return "guest/View";
	}

	// 경매랭킹
	@RequestMapping("AuctionRanking")
	public String AuctionRanking(HttpServletRequest req, Model model) {
		System.out.println("AuctionRanking");

		mem_service.auctionRanking(req, model);
		return "guest/AuctionRanking";
	}

	// 기부랭킹
	@RequestMapping("DonateRanking")
	public String DonateRanking(HttpServletRequest req, Model model) {
		System.out.println("DonateRanking");

		mem_service.donateRanking(req, model);
		return "guest/DonateRanking";
	}

	// 펀드랭킹
	@RequestMapping("FundRanking")
	public String FundRanking(HttpServletRequest req, Model model) {
		System.out.println("FundRanking");

		mem_service.fundRanking(req, model);

		return "guest/FundRanking";
	}

	// 주말농장신청
	@RequestMapping("WeekFarmApply")
	public String WeekFarmApply(HttpServletRequest req, Model model) {
		System.out.println("WeekFarmApply");

		return "guest/WeekFarmApply";
	}

	// 도움말
	@RequestMapping("Help")
	public String Help(HttpServletRequest req, Model model) {
		System.out.println("Help");

		return "guest/Help";
	}

	///////////////////////////// 일반회원 메뉴
	// 정보수정페이지
	@RequestMapping("updateInfoPage")
	public String updateInfoPage(HttpServletRequest req, Model model) {
		System.out.println("updateInfoPage");

		return "guest/updateInfoPage";
	}

	// 정보수정뷰
	@RequestMapping("updateInfoView")
	public String updateInfoView(HttpServletRequest req, Model model) {
		System.out.println("updateInfoView");

		mem_service.UpdateMemberView(req, model);
		return "guest/updateInfoView";
	}

	// 회원수정처리
	@RequestMapping("updateMemberPro")
	public String updateMemberPro(HttpServletRequest req, Model model) {
		System.out.println("updateMemberPro");

		mem_service.updateMemberPro(req, model);
		return "guest/updateMemberPro";
	}

	// 회원탈퇴
	@RequestMapping("deleteMember")
	public String deleteMember(HttpServletRequest req, Model model) {
		System.out.println("deleteMember");

		return "guest/deleteMember";
	}

	// 회원탈퇴처리
	@RequestMapping("deleteMemberPro")
	public String deleteMemberPro(HttpServletRequest req, Model model) {
		System.out.println("deleteMemberPro");

		mem_service.deleteMemberPro(req, model);
		req.getSession().invalidate();
		return "guest/deleteMemberPro";
	}

	// 회원점수
	@RequestMapping("gusetAdv")
	public String gusetAdv(HttpServletRequest req, Model model) {
		System.out.println("gusetAdv");

		mem_service.guestAdvList(req, model);
		return "guest/gusetAdv";
	}

	// 검색기능
	@RequestMapping("searching")
	public String searching(HttpServletRequest req, Model model) {
		System.out.println("searching");

		mem_service.searching(req, model);
		return "searching";

	}

	/**
	 * 민웅
	 */
	// 회원 내 기부내내역
	@RequestMapping("guestDonateLists")
	public String guestDonateLists(HttpServletRequest req, Model model) {
		System.out.println("guestDonateLists");

		mem_service.guestDonateLists(req, model);
		return "guest/guestDonateLists";

	}

	// 이메일 인증 확인
	@RequestMapping(value = "registerEmailConfirm", method = RequestMethod.GET)
	public String registerEmailConfirm(HttpServletRequest req, Model model) {
		System.out.println("registerEmailConfirm");
		mem_service.mailconfirm(req, model);
		return "guest/registerEmailConfirm";
	}

	// 카카오페이 결제
	@RequestMapping("kakao")
	public String kakao(HttpServletRequest req, Model model) {
		System.out.println("kakao");

		return "guest/kakao";

	}

	// 회원 경매내역(진행중)
	@RequestMapping("FundList_ing")
	public String FundList_ing(HttpServletRequest req, Model model) {
		System.out.println("FundList_ing");

		mem_service.FundList(req, model);

		return "guest/FundList_ing";
	}

	// 회원 경매내역(종료)
	@RequestMapping("FundList_old")
	public String FundList_old(HttpServletRequest req, Model model) {
		System.out.println("FundList_old");

		mem_service.FundList(req, model);

		return "guest/FundList_old";
	}

}
