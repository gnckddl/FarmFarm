package spring.mvc.farmfarm.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.mvc.farmfarm.service.FarmerService;

@Controller
public class farmercontroller {

	//농부 서비스
	@Autowired
	FarmerService farm_service;

	
	/**
	 * 장렬
	 */
	// 농부 쪽지 리스트 - 농부가 고객에게
	@RequestMapping("LetterList")
	public String LetterList(HttpServletRequest req, Model model) {
		System.out.println("LetterList");
		farm_service.LetterList(req, model);
		return "farm/LetterList";
	}
	
	//받은 쪽지 상세 보기
	@RequestMapping("LTContentsForm")
	public String LTContentsForm(HttpServletRequest req, Model model) {
		System.out.println("LTContentsForm");
		farm_service.LTContentsForm(req, model);
		return "farm/LTContentsForm";
	}
	
	// 농부한테 쪽지 보내기
	@RequestMapping("LTWriteForm")
	public String LTWriteForm(HttpServletRequest req, Model model) {
		System.out.println("LTWriteForm");
		
		int letternum=0;
		
		if(req.getParameter("letternum")!=null) {
			letternum = Integer.parseInt(req.getParameter("letternum"));
			
		}
		req.setAttribute("letternum", letternum);

		return "farm/LTWriteForm";
	}
	
	// 작성한 쪽지 처리
	@RequestMapping("LTWritePro")
	public String LTWritePro(HttpServletRequest req, Model model) {
		System.out.println("LTWritePro");
		
		farm_service.LTWritePro(req, model);
		return "farm/LTWritePro";
	}
	
/*	// 쪽지 삭제
	@RequestMapping("LTDeletePro")
	public String LTDeletePro(HttpServletRequest req, Model model) {
		System.out.println("LTDeletePro");
		
		farm_service.LTDeletePro(req, model);
		return "farm/LTDeletePro";
	}*/
	
	
	
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
	
	// 농부 - 경매 신청
	@RequestMapping("Auction_Apply")
	public String Auction_Apply(HttpServletRequest req, Model model) {
		System.out.println("Auction_Apply");
		
		return "farm/Auction_Apply";
	}
	
	// 농부 - 경매 신청 - 처리
	@RequestMapping("Auction_ApplyPro")
	public String Auction_ApplyPro(HttpServletRequest req, Model model) {
		System.out.println("Auction_ApplyPro");
		
		/*fmservice.Auction_ApplyPro(req, model);*/
		
		return "farm/Auction_ApplyPro";
	}
	
}
