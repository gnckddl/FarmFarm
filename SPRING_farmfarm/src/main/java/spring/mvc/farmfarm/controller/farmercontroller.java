package spring.mvc.farmfarm.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.farmfarm.service.FarmerService;

@Controller
public class farmercontroller {

	//농부 서비스
	@Autowired
	FarmerService farm_service;

	/**
	 * 장렬
	 * 1. 회원(쪽지기능)
	 */
	// 회원 - 보낸 쪽지함
	@RequestMapping("LetterList")
	public String LetterList(HttpServletRequest req, Model model) {
		System.out.println("LetterList");
		farm_service.LetterList(req, model);
		return "farm/Letters/LetterList";
	}
	
	// 회원 - 받은 쪽지함
	@RequestMapping("LetterGetList")
	public String LetterGetList(HttpServletRequest req, Model model) {
		System.out.println("LetterGetList");
		farm_service.LetterGetList(req, model);
		return "farm/Letters/LetterGetList";
	}
	
	// 회원 - 받은 쪽지 상세 보기 /보낸쪽지 상세 보기 (공통)
	@RequestMapping("LTContentsForm")
	public String LTContentsForm(HttpServletRequest req, Model model) {
		System.out.println("LTContentsForm");
		farm_service.LTContentsForm(req, model);
		return "farm/Letters/LTContentsForm";
	}
	
	// 회원 - 농부한테 쪽지 보내기
	@RequestMapping("LTWriteForm")
	public String LTWriteForm(HttpServletRequest req, Model model) {
		System.out.println("LTWriteForm");
		int boa_id=0;
		if(req.getParameter("boa_id")!=null) {
			boa_id = Integer.parseInt(req.getParameter("boa_id"));
		}
		req.setAttribute("boa_id", boa_id);
		return "farm/Letters/LTWriteForm";
	}
	
	// 회원 - 작성한 쪽지 처리
	@RequestMapping("LTWritePro")
	public String LTWritePro(HttpServletRequest req, Model model) {
		System.out.println("LTWritePro");
		farm_service.LTWritePro(req, model);
		return "farm/Letters/LTWritePro";
	}
	
	// 회원 - 쪽지 삭제(받은 쪽지 보낸쪽지 삭제 공통)
	@RequestMapping("LTDeletePro")
	public String LTDeletePro(HttpServletRequest req, Model model) {
		System.out.println("LTDeletePro");
		farm_service.LTDeletePro(req, model);
		return "farm/Letters/LTDeletePro";
	}
	
	
	
	
	/**
	 * 장렬
	 * 2.농부(쪽지기능)
	 */
	//농부 - 농부 쪽지함
	@RequestMapping("LTFarmerLetters")
	public String LTFarmerLetters(HttpServletRequest req, Model model) {
		System.out.println("LTFarmerLetters");
		farm_service.LTFarmerletters(req, model);
		return "farm/Letters/LTFarmerLetters";
	}
		
	//농부 - 회원쪽지문의 상세 페이지
	@RequestMapping("LTFarmerContentsForm")
	public String LTFarmerContentsForm(HttpServletRequest req, Model model) {
		System.out.println("LTFarmerContentsForm");
		farm_service.LTFarmerContentsForm(req, model);
		return "farm/Letters/LTFarmerContentsForm";
	}
	
	// 농부 - 담당 고객에게 답변글 작성
	@RequestMapping("LTFarmerReply")
	public String LTFarmerReply(HttpServletRequest req, Model model) {
		System.out.println("LTFarmerReply");
		int boa_id=0;
		if(req.getParameter("boa_id")!=null) {
			boa_id = Integer.parseInt(req.getParameter("boa_id"));
		}
		req.setAttribute("boa_id", boa_id);
		return "farm/Letters/LTFarmerReply";
	}
	
	// 농부 - 답변글 처리
	@RequestMapping("LTFarmerReplyPro")
	public String LTFarmerReplyPro(HttpServletRequest req, Model model) {
		System.out.println("LTFarmerReplyPro");
		farm_service.LTFarmerReplyPro(req, model);
		
		return "farm/Letters/LTFarmerReplyPro";
	}
	
	// 농부 - 답변완료 목록
	@RequestMapping("replyletters")
	public String replyletters(HttpServletRequest req, Model model) {
		System.out.println("replyletters");
		farm_service.replyletters(req, model);
		return "farm/Letters/replyletters";
	}
	
	/**
	 * 3. 장렬
	 * 농부 - 주말농장 개장신청 관련
	 */
	// 농부 주말농장 신청 메인
	@RequestMapping("ChooseWeekFarm")
	public String ChooseWeekFarm(HttpServletRequest req, Model model) {
		System.out.println("ChooseWeekFarm");
		return "farm/submitWeeklyfarm/ChooseWeekFarm";
	}
	
	// 각 농장으로 페이지 이동 1.상추농원
	@RequestMapping("ChooselettuceFarm")
	public String ChooselettuceFarm(HttpServletRequest req, Model model) {
		System.out.println("ChooselettuceFarm");
		int num = 0;
		int wfarm_status = 0;
		if(req.getParameter("num")!=null) {
			num =Integer.parseInt(req.getParameter("num"));
			wfarm_status =Integer.parseInt(req.getParameter("wfarm_status"));
		}
		req.setAttribute("num", num);
		req.setAttribute("wfarm_status", wfarm_status);
		return "farm/submitWeeklyfarm/ChooselettuceFarm";
	}
	// 각 농장으로 페이지 이동 2.유기농 야채농원
	@RequestMapping("Choosevegetable")
	public String Choosevegetable(HttpServletRequest req, Model model) {
		System.out.println("Choosevegetable");
		return "farm/submitWeeklyfarm/Choosevegetable";
	}
	// 각 농장으로 페이지 이동 3.호박농원
		@RequestMapping("Choosepumpkin")
		public String Choosepumpkin(HttpServletRequest req, Model model) {
			System.out.println("Choosepumpkin");
			return "farm/submitWeeklyfarm/Choosepumpkin";
		}
		
	// 각 농장으로 페이지 이동 4.꽃님이네 수박농원
		@RequestMapping("Choosewatermelon")
		public String Choosewatermelon(HttpServletRequest req, Model model) {
			System.out.println("Choosewatermelon");
			return "farm/submitWeeklyfarm/Choosewatermelon";
		}
		
	// 각 농장으로 페이지 이동 5.청출어람 감귤농장
	@RequestMapping("Choosetangerine")
	public String Choosetangerine(HttpServletRequest req, Model model) {
		System.out.println("Choosetangerine");
		return "farm/submitWeeklyfarm/Choosetangerine";
		}		
	
	// 각 농장으로 페이지 이동 6.포도밭 사나이의 포도농장
		@RequestMapping("Choosegrapes")
		public String Choosegrapes(HttpServletRequest req, Model model) {
			System.out.println("Choosegrapes");
			return "farm/submitWeeklyfarm/Choosegrapes";
		}
	// 각 농장으로 페이지 이동 7.인삼 재배 농장
		@RequestMapping("ChooseGinseng")
		public String ChooseGinseng(HttpServletRequest req, Model model) {
			System.out.println("ChooseGinseng");
			return "farm/submitWeeklyfarm/ChooseGinseng";
		}
		
	// 각 농장으로 페이지 이동 8.사과농장
		@RequestMapping("ChooseApple")
		public String ChooseApple(HttpServletRequest req, Model model) {
			System.out.println("ChooseApple");
			return "farm/submitWeeklyfarm/ChooseApple";
		}	
		
	// 농부 - 주말농장 신청 처리 페이지
		@RequestMapping("ChooseFarmPro")
		public String ChooseFarmPro(HttpServletRequest req, Model model) {
			System.out.println("ChooseFarmPro");
			farm_service.ChooseFarmPro(req, model);
			//서비스 인서트
			return "farm/submitWeeklyfarm/ChooseFarmPro";
		}
		
	// 농부 - 주말농장 신청 결과 보기
		@RequestMapping("ConfirmWeekFarm")
		public String ConfirmWeekFarm(HttpServletRequest req, Model model) {
			System.out.println("ConfirmWeekFarm");
			farm_service.ConfirmWeekFarm(req, model);
			return "farm/submitWeeklyfarm/ConfirmWeekFarm";
		}
		
	/**
	 * 4. 장렬
	 * 	농부 - 농부 점수
	 */
	// 농부 - 농부 점수 관련
		@RequestMapping("FarmerScore")
		public String FarmerScore(HttpServletRequest req, Model model) {
			System.out.println("FarmerScore");
			farm_service.FarmerScore(req, model);
			return "farm/FarmerScore";
		}
		
	/**
	 * 5. 장렬
	 * 	회원 - 주말농장 신청 현황 확인
	 */
		@RequestMapping("CustomerWeeklyFarmlist")
		public String CustomerWeeklyFarmlist(HttpServletRequest req, Model model) {
			System.out.println("CustomerWeeklyFarmlist");
			farm_service.CustomerWeeklyFarmlist(req, model);
			return "farm/CustomerWeeklyFarmlist";
		}
		
		
		
	/**
	 * 민웅
	 */
		// 농부 - 신청(펀드신청 & 경매신청)
		@RequestMapping("Farmer_Apply")
		public String Farmer_Apply(HttpServletRequest req, Model model) {
			System.out.println("Farmer_Apply");
			
			return "farm/Farmer_Apply";
		}
		
		// 농부 - 펀드 신청
		@RequestMapping("Fund_Apply")
		public String Fund_Apply(HttpServletRequest req, Model model) {
			System.out.println("Fund_Apply");
			
			return "farm/Fund_Apply";
		}
		
		// 농부 - 펀드 신청 - 처리
		@RequestMapping(value="Fund_ApplyPro", method=RequestMethod.POST)
		public String inventory_addProFund(MultipartHttpServletRequest req, Model model) {
			System.out.println("Fund_ApplyPro");
			
			farm_service.Fund_ApplyPro(req, model);
			return "farm/Fund_ApplyPro";
		}
		
		// 농부 - 경매 신청
		@RequestMapping("Auction_Apply")
		public String Auction_Apply(HttpServletRequest req, Model model) {
			System.out.println("Auction_Apply");
			
			return "farm/Auction_Apply";
		}
		
		// 농부 - 경매 신청 - 처리
		@RequestMapping(value="Auction_ApplyPro", method=RequestMethod.POST)
		public String inventory_addPro(MultipartHttpServletRequest req, Model model) {
			System.out.println("Auction_ApplyPro");
			
			farm_service.Auction_ApplyPro(req, model);
			return "farm/Auction_ApplyPro";
		}
		
		// 농부 - 경매  현황및 이전내역
		@RequestMapping("Auction_status")
		public String Auction_status(HttpServletRequest req, Model model) {
			System.out.println("Auction_status");
			
			farm_service.Auction_status(req, model);
			
			return "farm/Auction_status";
		}
		
		// 농부 - 펀드  현황및 이전내역
		@RequestMapping("Fund_status")
		public String Fund_status(HttpServletRequest req, Model model) {
			System.out.println("Fund_status");
			
			farm_service.Fund_status(req, model);
			
			return "farm/Fund_status";
		}
	
}
