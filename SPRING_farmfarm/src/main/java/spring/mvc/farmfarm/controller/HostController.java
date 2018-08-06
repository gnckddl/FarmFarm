package spring.mvc.farmfarm.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.farmfarm.service.HostService;

@Controller
public class HostController {

	@Autowired
	HostService hostService;

	private static final Logger logger = LoggerFactory.getLogger(HostController.class);

	// EX
	@RequestMapping("Ex")
	public String Ex(HttpServletRequest req, Model model) {
		System.out.println("Ex");

		return "host/Ex";
	}

	// ************* 관리자 메인 *************
	// 관리자 메인
	@RequestMapping("HostMain.ad")
	public String HostMain(HttpServletRequest req, Model model) {
		System.out.println("HostMain.ad");

		return "host/HostMain";
	}

	// *************************************************************************************
	// *************************************** 펀드 관리
	// *************************************
	// *************************************************************************************

	// 미등록 펀드 내역
	@RequestMapping("NoFundList.ad")
	public String NoFundList(HttpServletRequest req, Model model) {
		System.out.println("NoFundList.ad");

		int fund_status = 1; // 진행 요청
		req.setAttribute("fund_status", fund_status);

		hostService.fundList(req, model);

		return "host/NoFundList";
	}

	// 펀드 진행내역
	@RequestMapping("FundList.ad")
	public String FundList(HttpServletRequest req, Model model) {
		System.out.println("FundList.ad");

		int fund_status = 2; // 진행중
		req.setAttribute("fund_status", fund_status);

		// 경매내역 불러오기 //진행중
		hostService.fundList(req, model);

		fund_status = 3; // 유찰
		req.setAttribute("fund_status", fund_status);

		// 펀드내역 불러오기(유찰, 낙찰)
		hostService.fundList_end(req, model);

		return "host/FundList";
	}

	// 펀드 상태(1: 미등록 2: 진행중, 3: 유찰, 4: 낙찰) 미등록 -> 진행중
	@RequestMapping("fundOk.ad")
	public String fundOk(HttpServletRequest req, Model model) {
		System.out.println("fundOk.ad");

		hostService.fundOk(req, model);

		int fund_status = Integer.parseInt(req.getParameter("fund_status")); // 진행 요청
		req.setAttribute("fund_status", fund_status);
		
		hostService.fundList(req, model);
		
		fund_status = 3; // 유찰
		req.setAttribute("fund_status", fund_status);

		// 펀드내역 불러오기(유찰, 낙찰)
		hostService.fundList_end(req, model);
		
		if (fund_status == 1) {
			return "host/NoFundList";
		}else {
			return "host/FundList";
		}
	}

	// 미등록 펀드 삭제
	@RequestMapping("fundDelete.ad")
	public String fundDelete(HttpServletRequest req, Model model) {
		System.out.println("fundDelete.ad");

		hostService.fundDelete(req, model);

		int fund_status = 1; // 진행 요청
		req.setAttribute("fund_status", fund_status);

		hostService.fundList(req, model);

		return "host/NoFundList";
	}

	// *************************************************************************************
	// *************************************** 경매 관리
	// *************************************
	// *************************************************************************************
	// 보영
	// 미등록 경매 내역
	@RequestMapping("NoAucList.ad")
	public String NoAucList(HttpServletRequest req, Model model) {
		System.out.println("NoAucList.ad");

		int auc_status = 1; // 진행 요청
		req.setAttribute("auc_status", auc_status);

		hostService.aucList(req, model);

		return "host/NoAucList";
	}

	// 경매 진행내역
	@RequestMapping("AucList.ad")
	public String AucList(HttpServletRequest req, Model model) {
		System.out.println("AucList.ad");

		int auc_status = 2; // 진행중
		req.setAttribute("auc_status", auc_status);

		// 경매내역 불러오기 //진행중
		hostService.aucList(req, model);

		//auc_status = 3; // 유찰
		//req.setAttribute("auc_status", auc_status);

		// 경매내역 불러오기(유찰, 낙찰)
		//hostService.aucList_end(req, model);

		return "host/AucList2";
	}

	// 경매 상태(1: 미등록 2: 진행중, 3: 유찰, 4: 낙찰) 미등록 -> 진행중
	@RequestMapping("aucOk.ad")
	public String aucOk(HttpServletRequest req, Model model) {
		System.out.println("aucOk.ad");

		hostService.aucOk(req, model);

		int auc_status = Integer.parseInt(req.getParameter("auc_status")); // 진행 요청
		req.setAttribute("auc_status", auc_status);
		
		hostService.aucList(req, model);
		if (auc_status == 1) {
			return "host/NoAucList";
		}else {
			return "host/AucList2";
		}
	}

	// 미등록 경매 삭제
	@RequestMapping("aucDelete.ad")
	public String aucDelete(HttpServletRequest req, Model model) {
		System.out.println("aucDelete.ad");

		hostService.aucDelete(req, model);

		int auc_status = 1; // 진행 요청
		req.setAttribute("auc_status", auc_status);

		hostService.aucList(req, model);

		return "host/NoAucList";
	}

	// ************* 회원 관리 *************
	// 일반회원 관리
	@RequestMapping("GuestManage.ad")
	public String GuestManage(HttpServletRequest req, Model model) {
		logger.info("guestManage()");

		// 펀드 분야별 구매 차트
		hostService.guestFundSales(req, model);

		// 펀드 & 경매 진행 차트
		hostService.guestFundAuc(req, model);

		// 일반회원 목록 조회
		hostService.guestManage(req, model);

		return "host/GuestManage";
	}

	// 일반회원 어드벤티지 추가
	@RequestMapping("guestAdvManage.ad")
	public String guestAdvManage(HttpServletRequest req, Model model) {
		System.out.println("guestAdvManage.ad");

		// 어드벤티지 추가
		hostService.advManage(req, model);

		// 목록뿌리기
		hostService.guestManage(req, model);

		return "host/GuestManage";
	}

	// 일반회원 삭제
	@RequestMapping("guestDelete.ad")
	public String guestDelete(HttpServletRequest req, Model model) {
		System.out.println("/guestDelete.ad");

		hostService.guestDelete(req, model);

		// 목록뿌리기
		hostService.guestManage(req, model);

		return "host/GuestManage";
	}

	// ************* 파트너 관리 *************
	// 파트너 목록 조회
	@RequestMapping("PartnerManage.ad")
	public String partnerManage(HttpServletRequest req, Model model) {
		logger.info("partnerManage()");

		// 분야별 펀드 현황 차트
		hostService.partnerFund(req, model);

		// 분야별 경매 현황 차트
		hostService.partnerAuc(req, model);

		hostService.partnerManage(req, model);

		return "host/PartnerManage";
	}

	// 파트너 어드벤티지 관리
	@RequestMapping("PartnerAdvManage.ad")
	public String partnerAdvManage(HttpServletRequest req, Model model) {
		logger.info("partnerAdvManage()");

		// 어드벤티지 추가
		hostService.advManage(req, model);

		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		req.setAttribute("pageNum", pageNum);// 페이지 번호

		hostService.partnerManage(req, model);

		return "host/PartnerManage";
	}

	// 파트너 승인
	@RequestMapping("PartnerUp.ad")
	public String partnerUp(HttpServletRequest req, Model model) {
		logger.info("partnerUp()");

		hostService.partnerUp(req, model);
		hostService.partnerManage(req, model);

		return "host/PartnerManage";
	}

	// 파트너 강등(파트너에서 일반회원으로 강등)
	@RequestMapping("PartnerDown.ad")
	public String parternerDown(HttpServletRequest req, Model model) {
		logger.info("partnerDown()");

		hostService.partnerDown(req, model);
		hostService.partnerManage(req, model);

		return "host/PartnerManage";
	}

	// ************* 정산 관리 *************
	// 펀드
	@RequestMapping("FundTotal.ad")
	public String FundTotal(HttpServletRequest req, Model model) {
		System.out.println("FundTotal.ad");

		int fund_status = 4;
		req.setAttribute("fund_status", fund_status);

		// hostService.aucVSfund(req, model); //0번 차트
		hostService.thisMonthFundKind(req, model); // 1번차트// 이번 달 펀드(상품 종류별) 차트
		hostService.monthFundTotal(req, model); // 2번차트//월별 펀드 총액 차트
		hostService.yearFundTotal(req, model); // 3번차트//년별 펀드 (총 액수) 차트
		hostService.yearFundKind(req, model); // 4번차트//년별 펀드(상품 종류별) 차트

		return "host/FundTotal";
	}

	// 경매
	@RequestMapping("AucTotal.ad")
	public String AucTotal(HttpServletRequest req, Model model) {
		System.out.println("AucTotal.ad");

		int auc_status = 4;
		req.setAttribute("auc_status", auc_status);

		// hostService.aucVSfund(req, model); ////0번 차트// 경매 - 펀드 비교 차트
		hostService.thisMonthAucKind(req, model); // 1번차트// 이번 달 경매(상품 종류별) 차트
		hostService.monthAucTotal(req, model); // 2번차트// 월별 경매 총액 차트
		hostService.yearAucTotal(req, model); // 3번차트//년별 경매 (총 액수) 차트
		hostService.yearAucKind(req, model); // 4번차트//년별 경매(상품 종류별) 차트

		return "host/AucTotal";
	}

	// ************* 게시판 관리 *************
	// 보영추가
	// 공지사항
	@RequestMapping("NoticeList.ad")
	public String NoticeList(HttpServletRequest req, Model model) {
		System.out.println("NoticeList.ad");

		return "host/NoticeList";
	}

	// 문의 게시판[농부], [회원], 소식 게시판, 요청 게시판 추가해야함

	// ************* 기부 *************
	// 기부 내역
	@RequestMapping("DonateList.ad")
	public String donateList(HttpServletRequest req, Model model) {
		logger.info("donateList()");

		hostService.donateList(req, model);

		return "host/DonateList";
	}

	// 기부 업체현황
	@RequestMapping("DonateConList.ad")
	public String DonateConList(HttpServletRequest req, Model model) {
		System.out.println("DonateConList.ad");

		hostService.DonateConList(req, model);

		return "host/DonateConList";
	}

	// 기부단체 글쓰기
	@RequestMapping("DonateWriteForm.ad")
	public String DonateWriteForm(HttpServletRequest req, Model model) {
		System.out.println("DonateWriteForm.ad");

		int pageNum = 0; // 페이지번호
		pageNum = Integer.parseInt(req.getParameter("pageNum"));
		System.out.println("pageNum" + pageNum);

		model.addAttribute("pageNum", pageNum);

		return "host/DonateWriteForm";
	}

	// 기부단체 글쓰기 처리
	@RequestMapping(value = "donateWritePro.ad", method = RequestMethod.POST)
	public String donateWritePro(MultipartHttpServletRequest req, Model model) {
		System.out.println("/donateWritePro.ad");

		hostService.donateWritePro(req, model);

		// 리스트 뿌리기
		hostService.DonateConList(req, model);

		return "host/DonateConList";
	}

	// 기부단체 수정 상세페이지
	@RequestMapping("donateModifyView.ad")
	public String donateModifyView(HttpServletRequest req, Model model) {
		System.out.println("donateModifyView.ad");

		int doForm_id = Integer.parseInt(req.getParameter("doForm_id"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		model.addAttribute("doForm_id", doForm_id);
		model.addAttribute("pageNum", pageNum);

		hostService.donateModifyView(req, model);

		return "host/DonateModifyForm";
	}

	// 기부단체 수정 처리페이지
	@RequestMapping("donateModifyPro.ad")
	public String donateModifyPro(MultipartHttpServletRequest req, Model model) {
		System.out.println("donateModifyPro.ad");

		hostService.donateModifyPro(req, model);

		// 리스트 뿌리기
		hostService.DonateConList(req, model);

		return "host/DonateConList";
	}

	// 기부단체 삭제
	@RequestMapping("donateDeletePro.ad")
	public String donateDeletePro(HttpServletRequest req, Model model) {
		System.out.println("donateDeletePro.ad");

		int doForm_id = Integer.parseInt(req.getParameter("doForm_id"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));

		hostService.DonateDeletePro(req, model);

		model.addAttribute("doForm_id", doForm_id);
		model.addAttribute("pageNum", pageNum);

		// 리스트 뿌리기
		hostService.DonateConList(req, model);

		return "host/DonateConList";
	}

	// 기부 통계
	@RequestMapping("DonateTotal.ad")
	public String DonateTotal(HttpServletRequest req, Model model) {
		System.out.println("DonateTotal.ad");

		hostService.yearDonate(req, model); // 3.업체별 기부액 3년치

		return "host/DonateTotal";
	}

	// ************* 주말농장 *************
	// 주말농장 관리
	@RequestMapping("WeekFarmManage.ad")
	public String weekFarmManage(HttpServletRequest req, Model model) {
		logger.info("weekFarmManage()");

		// 주말농장 요청현황 조회
		int wfarm_status = 1;
		req.setAttribute("wfarm_status", wfarm_status);

		hostService.getWeekFarmRequestList(req, model);

		// 주말농장 현황 조회
		wfarm_status = 2;
		req.setAttribute("wfarm_status", wfarm_status);

		hostService.getWeekFarmList(req, model);

		return "host/WeekFarmManage";
	}

	// 주말농장 요청승인
	@RequestMapping("WeekFarmReqPermit.ad")
	public String weekFarmReqPermit(HttpServletRequest req, Model model) {
		logger.info("weekFarmReqPermit()");

		int wfarm_status = 2;
		req.setAttribute("wfarm_status", wfarm_status);

		hostService.weekFarmReqPermit(req, model);

		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		wfarm_status = 1;
		req.setAttribute("wfarm_status", wfarm_status);
		req.setAttribute("pageNum", pageNum); // 1번 페이지 페이지번호

		hostService.getWeekFarmRequestList(req, model);

		int pageNum1 = Integer.parseInt(req.getParameter("pageNum1"));
		wfarm_status = 2;
		req.setAttribute("wfarm_status", wfarm_status);
		req.setAttribute("pageNum1", pageNum1); // 2번 페이지 페이지번호

		hostService.getWeekFarmList(req, model);

		return "host/WeekFarmManage";
	}

	// 주말농장 요청거부
	@RequestMapping("WeekFarmDelete.ad")
	public String weekFarmReqDelete(HttpServletRequest req, Model model) {
		logger.info("weekFarmDelete()");

		hostService.weekFarmDelete(req, model);

		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int wfarm_status = 1;
		req.setAttribute("wfarm_status", wfarm_status);
		req.setAttribute("pageNum", pageNum); // 1번 페이지 페이지번호

		hostService.getWeekFarmRequestList(req, model);

		int pageNum1 = Integer.parseInt(req.getParameter("pageNum1"));
		wfarm_status = 2;
		req.setAttribute("wfarm_status", wfarm_status);
		req.setAttribute("pageNum1", pageNum1); // 2번 페이지 페이지번호

		hostService.getWeekFarmList(req, model);

		return "host/WeekFarmManage";
	}

	// IoT
	@RequestMapping("IOTManage.ad")
	public String IOTManage(HttpServletRequest req, Model model) {
		System.out.println("IOTManage.ad");

		return "host/IOTManage";
	}

}