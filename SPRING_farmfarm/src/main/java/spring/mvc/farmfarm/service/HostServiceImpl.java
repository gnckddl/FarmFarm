package spring.mvc.farmfarm.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.farmfarm.dto.BoardDTO;
import spring.mvc.farmfarm.dto.CommentDTO;
import spring.mvc.farmfarm.dto.DonateDTO;
import spring.mvc.farmfarm.dto.MemberDTO;
import spring.mvc.farmfarm.dto.PartnerDTO;
import spring.mvc.farmfarm.dto.StockDTO;
import spring.mvc.farmfarm.dto.WeekFarmDTO;
import spring.mvc.farmfarm.persistence.HostDAO;

@Service
public class HostServiceImpl implements HostService {

	@Autowired
	HostDAO hostDao;

	// *************************************** 펀드 관리
	// *************************************

	// 펀드 진행내역_진행중/ 미등록 펀드 내역
	@Override
	public void fundList(HttpServletRequest req, Model model) {
		// 3단계 . 화면으로부터 입력받은 값을 받아온다.
		// 경매 목록 관련

		int pageSize = 10; // 한페이지당 출력될 글 갯수
		int pageBlock = 3; // 페이지 블록을 3개씩. 앞뒤를 화살표로 이동

		int cnt = 0; // 글갯수
		int start = 0; // 현재페이지 시작 글번호
		int end = 0; // 현재 페이지 마지막 글번호
		int number = 0; // 출력용 글번호, 번호삭제가 되어도
		String pageNum = null; // 페이지번호
		int currentPage = 0; // 현재 페이지

		// 블록당 앞뒤 화살표에 필요한 부분
		int pageCount = 0; // 페이지 갯수
		int startPage = 0; // 시작페이지
		int endPage = 0; // 마지막 페이지

		// 경매상태(1:경매요청, 2:진행중, 3: 유찰, 4: 낙찰)
		int fund_status = (Integer) req.getAttribute("fund_status");

		System.out.println("fund_status 미등록 갯수."+fund_status);
		
		// 5단계 펀드갯수 구하기
		cnt = hostDao.getFundCnt(fund_status);
		System.out.println("cnt(진행중인 경매 갯수):" + cnt); // 먼저 테이블에 최소 30건 insert,

		pageNum = req.getParameter("pageNum");
		System.out.println("pageNum(페이지번호) : " + pageNum);

		if (pageNum == null) {
			pageNum = "1"; // 첫페이지를 1페이지로 설정
		}

		// 글 30건 기준
		currentPage = Integer.parseInt(pageNum); // 현재페이지 : 1
		System.out.println("currentPage(현재페이지)" + currentPage);

		// 딱떨어질경우 + 나미저의것. ex) 7 = (30/5) + (1)
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);

		// 1 =(1-1) * 5+1
		start = (currentPage - 1) * pageSize + 1; // 현재페이지 시작번호 1(페이지별)

		// 5 = 1 + 5- 1;
		end = start + pageSize - 1; // 현재페이지 끝번호 5

		System.out.println("start(현재페이지 시작글번호):" + start);
		System.out.println("end(현제페이지 끝글번호):" + end);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("start", start);
		map.put("end", end);
		map.put("fund_status", fund_status);

		if (end > cnt)
			end = cnt;

		// 경매상태(1:경매요청, 2:진행중, 3: 유찰, 4: 낙찰)

		// 30 = 30 (1 - 1) *5
		number = cnt - (currentPage - 1) * pageSize; // 출력용 글번호

		System.out.println("number(출력용 글번호)" + number);
		System.out.println("pageSize(한페이지당 출력될 글갯수)" + pageSize);

		if (cnt > 0) {
			// 경매 낙찰 여부(1: 진행요청 // 2. 진행중, 3: 유찰, 4: 낙찰)
			// 경매 목록 조회
			System.out.println("fund_status 미등록 리스트 ."+fund_status);
			
			ArrayList<StockDTO> dtos = hostDao.getFundList(map);
			model.addAttribute("dtos", dtos); // 큰바구니 게시글 목록 5건.

		}

		// 1 = (1/3) * 3+1
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;
		System.out.println("startPage(화살표 시작페이지):" + startPage);

		// 3 = 1+3 -1
		endPage = startPage + pageBlock - 1;
		if (endPage > pageCount)
			endPage = pageCount;
		System.out.println("endPage(화살표 마지막페이지):" + endPage);

		// 6단계. request나 session에 처리결과를 저장 (jsp에 전딜하기 위함)
		model.addAttribute("cnt", cnt); // 글갯수
		model.addAttribute("number", number); // 글번호
		model.addAttribute("pageNum", pageNum); // 페이지번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage);
		}
	}

	// 미등록 펀드 삭제
	@Override
	public void fundDelete(HttpServletRequest req, Model model) {
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		String fund_no = req.getParameter("fund_no");

		System.out.println("pageNum" + pageNum);
		System.out.println("fund_no" + fund_no);

		int deleteCnt = hostDao.fundDelete(fund_no);

		// 6단계. request 나 session에 처리결과를 저장 (jsp에 전달하기 위함)
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("deleteCnt", deleteCnt);
	}

	// 펀드 진행내역_ 3: 중단, 4: 완료
	@Override
	public void fundList_end(HttpServletRequest req, Model model) {
		System.out.print("=================2페이지======-----------=");
		// 3단계 . 화면으로부터 입력받은 값을 받아온다.
		// 경매 목록 관련
		int pageSize1 = 10; // 한페이지당 출력될 글 갯수
		int pageBlock1 = 3; // 페이지 블록을 3개씩. 앞뒤를 화살표로 이동

		int cnt1 = 0; // 글갯수
		int start1 = 0; // 현재페이지 시작 글번호
		int end1 = 0; // 현재 페이지 마지막 글번호
		int number1 = 0; // 출력용 글번호, 번호삭제가 되어도
		String pageNum1 = null; // 페이지번호
		int currentPage1 = 0; // 현재 페이지

		// 블록당 앞뒤 화살표에 필요한 부분
		int pageCount1 = 0; // 페이지 갯수
		int startPage1 = 0; // 시작페이지
		int endPage1 = 0; // 마지막 페이지

		// 경매상태(1:경매요청, 2:진행중, 3: 유찰, 4: 낙찰)
		int fund_status = (Integer) req.getAttribute("fund_status");

		// 5단계 경매갯수 구하기
		cnt1 = hostDao.getFundCnt_end(fund_status);
		System.out.println("cnt1(진행중인 경매 갯수):" + cnt1); // 먼저 테이블에 최소 30건 insert,

		pageNum1 = req.getParameter("pageNum");
		System.out.println("pageNum(페이지번호) : " + pageNum1);

		if (pageNum1 == null) {
			pageNum1 = "1"; // 첫페이지를 1페이지로 설정
		}

		// 글 30건 기준
		currentPage1 = Integer.parseInt(pageNum1); // 현재페이지 : 1
		System.out.println("currentPage1(현재페이지)" + currentPage1);

		// 딱떨어질경우 + 나미저의것. ex) 7 = (30/5) + (1)
		pageCount1 = (cnt1 / pageSize1) + (cnt1 % pageSize1 > 0 ? 1 : 0);

		// 1 =(1-1) * 5+1
		start1 = (currentPage1 - 1) * pageSize1 + 1; // 현재페이지 시작번호 1(페이지별)

		// 5 = 1 + 5- 1;
		end1 = start1 + pageSize1 - 1; // 현재페이지 끝번호 5

		System.out.println("start(현재페이지 시작글번호):" + start1);
		System.out.println("end(현제페이지 끝글번호):" + end1);

		/*
		 * Map<String, Object> map = new HashMap<String, Object>();
		 * 
		 * map.put("start1", start1); map.put("end1", end1); map.put("auc_status1",
		 * auc_status);
		 */
		if (end1 > cnt1)
			end1 = cnt1;

		// 경매상태(1:경매요청, 2:진행중, 3: 유찰, 4: 낙찰)

		// 30 = 30 (1 - 1) *5
		number1 = cnt1 - (currentPage1 - 1) * pageSize1; // 출력용 글번호

		System.out.println("number1(출력용 글번호)" + number1);
		System.out.println("pageSize1(한페이지당 출력될 글갯수)" + pageSize1);

		/*
		 * if(cnt1 >0 ) { //경매 낙찰 여부(1: 진행요청 // 2. 진행중, 3: 유찰, 4: 낙찰) //경매 목록 조회
		 * ArrayList<StockDTO> dtos1 = hostDao.getAucList(map);
		 * model.addAttribute("dtos1", dtos1); //큰바구니 게시글 목록 5건.
		 * 
		 * }
		 */

		// 1 = (1/3) * 3+1
		startPage1 = (currentPage1 / pageBlock1) * pageBlock1 + 1;
		if (currentPage1 % pageBlock1 == 0)
			startPage1 -= pageBlock1;
		System.out.println("startPage1(화살표 시작페이지):" + startPage1);

		// 3 = 1+3 -1
		endPage1 = startPage1 + pageBlock1 - 1;
		if (endPage1 > pageCount1)
			endPage1 = pageCount1;
		System.out.println("endPage1(화살표 마지막페이지):" + endPage1);

		// 6단계. request나 session에 처리결과를 저장 (jsp에 전딜하기 위함)
		model.addAttribute("cnt1", cnt1); // 글갯수
		model.addAttribute("number1", number1); // 글번호
		model.addAttribute("pageNum1", pageNum1); // 페이지번호

		if (cnt1 > 0) {
			model.addAttribute("startPage1", startPage1); // 시작페이지
			model.addAttribute("endPage1", endPage1); // 마지막 페이지
			model.addAttribute("pageBlock1", pageBlock1); // 출력할 페이지 갯수
			model.addAttribute("pageCount1", pageCount1); // 페이지 갯수
			model.addAttribute("currentPage1", currentPage1);
		}
	}

	// 펀드 상태(1: 미등록 2: 진행중, 3: 중단, 4: 완료) 1.미등록 -> 2.진행중
	@Override
	public void fundOk(HttpServletRequest req, Model model) {
		// auc_status 1.미등록 -> 2.진행중
		// 3단계. 화면으로부터 입력받은값
		int fund_status = Integer.parseInt(req.getParameter("fund_status")); // 경매상태
		String fund_no = req.getParameter("fund_no"); // 펀드 기본키
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));

		System.out.println(pageNum);
		System.out.println("fund_status:" + fund_status);
		System.out.println("fund_no:" + fund_no);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("fund_status", fund_status);
		map.put("fund_no", fund_no);

		// <td>${join_noCnt}</td>
		// 5단계. d_state :0을 1 로처리
		int updateCnt = hostDao.fundUpdate(map);

		// 6단계. request 나 session에 처리결과를 저장 (jsp에 전달하기 위함)
		model.addAttribute("updateCnt", updateCnt);
		model.addAttribute("fund_status", fund_status);
		model.addAttribute("fund_no", fund_no);
		model.addAttribute("pageNum", pageNum);
	}

	// *************************************** 경매 관리
	// *************************************
	// 보영
	// 경매 진행내역(미등록// 진행중)
	@Override
	public void aucList(HttpServletRequest req, Model model) {
		
		System.out.print("=================aucList 1페이지======-----------=");
		
		// 3단계 . 화면으로부터 입력받은 값을 받아온다.
		// 경매 목록 관련

		int pageSize = 10; // 한페이지당 출력될 글 갯수
		int pageBlock = 3; // 페이지 블록을 3개씩. 앞뒤를 화살표로 이동

		int cnt = 0; // 글갯수
		int cnt1 = 0; // 글갯수
		
		int start = 0; // 현재페이지 시작 글번호
		int end = 0; // 현재 페이지 마지막 글번호
		int number = 0; // 출력용 글번호, 번호삭제가 되어도
		int number2 = 0; // 출력용 글번호, 번호삭제가 되어도
		
		String pageNum = null; // 페이지번호
		int currentPage = 0; // 현재 페이지
		
		// 블록당 앞뒤 화살표에 필요한 부분
		int pageCount = 0; // 페이지 갯수
		int startPage = 0; // 시작페이지
		int endPage = 0; // 마지막 페이지

		// 경매상태(1:경매요청, 2:진행중, 3: 유찰, 4: 낙찰)
		int auc_status = (Integer) req.getAttribute("auc_status");

		// 5단계 1.미등록경매갯수 /2.진행중  구하기 --> 미등록, 진행내역 1번.
		cnt = hostDao.getAucCnt(auc_status);
		System.out.println("cnt(진행중인 경매 갯수):" + cnt); // 먼저 테이블에 최소 30건 insert,
		
		if (auc_status == 2) { // 진행내역 2번, 유찰낙찰 뿌려주기위해 여기로.
			cnt1 = hostDao.getAucCnt_end(auc_status);
			System.out.println("cnt1(진행중인 경매 갯수):" + cnt1); // 먼저 테이블에 최소 30건 insert,
		}
	
		//왕 Cnt
		int ToCnt = cnt + cnt1;
		
		pageNum = req.getParameter("pageNum");
		System.out.println("pageNum(페이지번호) : " + pageNum);

		if (pageNum == null) {
			pageNum = "1"; // 첫페이지를 1페이지로 설정
		}

		// 글 30건 기준
		currentPage = Integer.parseInt(pageNum); // 현재페이지 : 1
		System.out.println("currentPage(현재페이지)" + currentPage);

		// 딱떨어질경우 + 나미저의것. ex) 7 = (30/5) + (1)
		pageCount = (ToCnt / pageSize) + (ToCnt % pageSize > 0 ? 1 : 0);

		// 1 =(1-1) * 5+1
		start = (currentPage - 1) * pageSize + 1; // 현재페이지 시작번호 1(페이지별)

		// 5 = 1 + 5- 1;
		end = start + pageSize - 1; // 현재페이지 끝번호 5

		System.out.println("start(현재페이지 시작글번호):" + start);
		System.out.println("end(현제페이지 끝글번호):" + end);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("start", start);
		map.put("end", end);
		map.put("auc_status", auc_status);
		
		if (end > ToCnt)
			end = ToCnt;

		// 경매상태(1:경매요청, 2:진행중, 3: 유찰, 4: 낙찰)

		// 30 = 30 (1 - 1) *5
		number = cnt - (currentPage - 1) * pageSize; // 출력용 글번호
		number2 = cnt1 - (currentPage - 1) * pageSize; // 출력용 글번호
		int number3 = ToCnt - (currentPage - 1) * pageSize; // 출력용 글번호
		
		System.out.println("cnt"+cnt);
		System.out.println("cnt1 :"+cnt1);
		System.out.println("number(출력용 글번호)" + number);
		System.out.println("number2(출력용 글번호)" + number2);
		
		System.out.println("pageSize(한페이지당 출력될 글갯수)" + pageSize);

		if (ToCnt > 0) {
			// 경매 낙찰 여부(1: 진행요청 // 2. 진행중, 3: 유찰, 4: 낙찰)
			// 경매 목록 조회
			ArrayList<StockDTO> dtos = hostDao.getAucList(map);
			model.addAttribute("dtos", dtos); // 큰바구니 게시글 목록 5건.

		}

		// 1 = (1/3) * 3+1
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;
		System.out.println("startPage(화살표 시작페이지):" + startPage);

		// 3 = 1+3 -1
		endPage = startPage + pageBlock - 1;
		if (endPage > pageCount)
			endPage = pageCount;
		System.out.println("endPage(화살표 마지막페이지):" + endPage);

		// 6단계. request나 session에 처리결과를 저장 (jsp에 전딜하기 위함)
		model.addAttribute("ToCnt", ToCnt); // 왕 글갯수
		model.addAttribute("cnt", cnt); // 글갯수
		model.addAttribute("cnt1", cnt1); // 글갯수
		
		model.addAttribute("number", number); // 글번호
		model.addAttribute("number2", number2); // 글번호
		model.addAttribute("number3", number3); // 글번호
		model.addAttribute("pageNum", pageNum); // 페이지번호

		if (ToCnt > 0) {
			model.addAttribute("startPage", startPage); // 시작페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage);
		}
	}

	// 미등록 경매 삭제
	@Override
	public void aucDelete(HttpServletRequest req, Model model) {
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		String auc_no = req.getParameter("auc_no");

		System.out.println("pageNum" + pageNum);
		System.out.println("auc_no" + auc_no);

		int deleteCnt = hostDao.aucDelete(auc_no);

		// 6단계. request 나 session에 처리결과를 저장 (jsp에 전달하기 위함)
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("deleteCnt", deleteCnt);
	}

	// 경매 진행내역 (3.유찰, 4.낙찰)
	@Override
	public void aucList_end(HttpServletRequest req, Model model) {
		System.out.print("=================aucList_end 2페이지======-----------=");
		// 3단계 . 화면으로부터 입력받은 값을 받아온다.
		// 경매 목록 관련
		int pageSize1 = 10; // 한페이지당 출력될 글 갯수
		int pageBlock1 = 3; // 페이지 블록을 3개씩. 앞뒤를 화살표로 이동

		int cnt1 = 0; // 글갯수
		int start1 = 0; // 현재페이지 시작 글번호
		int end1 = 0; // 현재 페이지 마지막 글번호
		int number1 = 0; // 출력용 글번호, 번호삭제가 되어도
		String pageNum1 = null; // 페이지번호
		int currentPage1 = 0; // 현재 페이지

		// 블록당 앞뒤 화살표에 필요한 부분
		int pageCount1 = 0; // 페이지 갯수
		int startPage1 = 0; // 시작페이지
		int endPage1 = 0; // 마지막 페이지

		// 경매상태(1:경매요청, 2:진행중, 3: 유찰, 4: 낙찰)
		int auc_status = (Integer) req.getAttribute("auc_status");

		// 5단계 경매갯수 구하기
		cnt1 = hostDao.getAucCnt_end(auc_status);
		System.out.println("cnt1(진행중인 경매 갯수):" + cnt1); // 먼저 테이블에 최소 30건 insert,

		pageNum1 = req.getParameter("pageNum");
		System.out.println("pageNum(페이지번호) : " + pageNum1);

		if (pageNum1 == null) {
			pageNum1 = "1"; // 첫페이지를 1페이지로 설정
		}

		// 글 30건 기준
		currentPage1 = Integer.parseInt(pageNum1); // 현재페이지 : 1
		System.out.println("currentPage1(현재페이지)" + currentPage1);

		// 딱떨어질경우 + 나미저의것. ex) 7 = (30/5) + (1)
		pageCount1 = (cnt1 / pageSize1) + (cnt1 % pageSize1 > 0 ? 1 : 0);

		// 1 =(1-1) * 5+1
		start1 = (currentPage1 - 1) * pageSize1 + 1; // 현재페이지 시작번호 1(페이지별)

		// 5 = 1 + 5- 1;
		end1 = start1 + pageSize1 - 1; // 현재페이지 끝번호 5

		System.out.println("start(현재페이지 시작글번호):" + start1);
		System.out.println("end(현제페이지 끝글번호):" + end1);

		/*
		 * Map<String, Object> map = new HashMap<String, Object>();
		 * 
		 * map.put("start1", start1); map.put("end1", end1); map.put("auc_status1",
		 * auc_status);
		 */
		if (end1 > cnt1)
			end1 = cnt1;

		// 경매상태(1:경매요청, 2:진행중, 3: 유찰, 4: 낙찰)

		// 30 = 30 (1 - 1) *5
		number1 = cnt1 - (currentPage1 - 1) * pageSize1; // 출력용 글번호

		System.out.println("number1(출력용 글번호)" + number1);
		System.out.println("pageSize1(한페이지당 출력될 글갯수)" + pageSize1);

		/*
		 * if(cnt1 >0 ) { //경매 낙찰 여부(1: 진행요청 // 2. 진행중, 3: 유찰, 4: 낙찰) //경매 목록 조회
		 * ArrayList<StockDTO> dtos1 = hostDao.getAucList(map);
		 * model.addAttribute("dtos1", dtos1); //큰바구니 게시글 목록 5건.
		 * 
		 * }
		 */

		// 1 = (1/3) * 3+1
		startPage1 = (currentPage1 / pageBlock1) * pageBlock1 + 1;
		if (currentPage1 % pageBlock1 == 0)
			startPage1 -= pageBlock1;
		System.out.println("startPage1(화살표 시작페이지):" + startPage1);

		// 3 = 1+3 -1
		endPage1 = startPage1 + pageBlock1 - 1;
		if (endPage1 > pageCount1)
			endPage1 = pageCount1;
		System.out.println("endPage1(화살표 마지막페이지):" + endPage1);

		// 6단계. request나 session에 처리결과를 저장 (jsp에 전딜하기 위함)
		model.addAttribute("cnt1", cnt1); // 글갯수
		model.addAttribute("number1", number1); // 글번호
		model.addAttribute("pageNum1", pageNum1); // 페이지번호

		if (cnt1 > 0) {
			model.addAttribute("startPage1", startPage1); // 시작페이지
			model.addAttribute("endPage1", endPage1); // 마지막 페이지
			model.addAttribute("pageBlock1", pageBlock1); // 출력할 페이지 갯수
			model.addAttribute("pageCount1", pageCount1); // 페이지 갯수
			model.addAttribute("currentPage1", currentPage1);
		}
	}

	// 경매 상태(1: 미등록 2: 진행중, 3: 유찰, 4: 낙찰) 1.미등록 -> 2.진행중
	@Override
	public void aucOk(HttpServletRequest req, Model model) {
		// auc_status 1.미등록 -> 2.진행중
		// 3단계. 화면으로부터 입력받은값
		int auc_status = Integer.parseInt(req.getParameter("auc_status")); // 경매상태
		String auc_no = req.getParameter("auc_no"); // 경매 기본키
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));

		System.out.println(pageNum);
		System.out.println("auc_status:" + auc_status);
		System.out.println("auc_no:" + auc_no);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("auc_status", auc_status);
		map.put("auc_no", auc_no);

		// <td>${join_noCnt}</td>
		// 5단계. d_state :0을 1 로처리
		int updateCnt = hostDao.aucUpdate(map);

		// 6단계. request 나 session에 처리결과를 저장 (jsp에 전달하기 위함)
		model.addAttribute("updateCnt", updateCnt);
		model.addAttribute("auc_status", auc_status);
		model.addAttribute("auc_no", auc_no);
		model.addAttribute("pageNum", pageNum);
	}
	// ****************************************회원관리****************************************

	// ************** 일반 회원 차트***************
	// 펀드 분야별 구매 차트
	@Override
	public void guestFundSales(HttpServletRequest req, Model model) {
		// map에 입력할 key값을 배열로 정해준다.
		// -> 나중에 key[i]로 map에 값 입력할 때 쓰인다.
		String[] key = { "event", "farm", "animal", "fish", "health", "mushroom", "alcohol", "etc" };

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("event", 0);
		map.put("farm", 0);
		map.put("animal", 0);
		map.put("fish", 0);
		map.put("health", 0);
		map.put("mushroom", 0);
		map.put("alcohol", 0);
		map.put("etc", 0);

		for (int i = 0; i < map.size(); i++) { // 미리 지정한 map의 size만큼 반복
			Integer fundSales = hostDao.guestFundSales(i + 1); // i = stock_kind

			if (fundSales != null)
				map.put(key[i], fundSales);
		}

		model.addAttribute("map", map);
	}

	// 펀드 & 경매 진행 차트
	@Override
	public void guestFundAuc(HttpServletRequest req, Model model) {
		// map에 입력할 key값을 배열로 정해준다.
		// -> 나중에 key[i]로 map에 값 입력할 때 쓰인다.
		String[] key = { "guestFund", "guestAuc" };

		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("guestFund", 0);
		map1.put("guestAuc", 0);

		// 미리 지정한 map의 size만큼 반복
		for (int i = 0; i < map1.size(); i++) {
			// i=0 : 펀드인 경우, i=1 : 경매인 경우
			Integer fundAuc = hostDao.guestFundAuc(i);

			if (fundAuc != null)
				map1.put(key[i], fundAuc);
		}

		model.addAttribute("map1", map1);
	}

	// ************* 일반 회원 관리 *************
	// 일반회원 관리: guestManage()
	@Override
	public void guestManage(HttpServletRequest req, Model model) {
		// 일반회원 리스트
		int pageSize = 10; // 한페이지당 출력될 글 갯수
		int pageBlock = 3; // 페이지 블록을 3개씩. 앞뒤를 화살표로 이동

		int cnt = 0; // 글갯수
		int start = 0; // 현재페이지 시작 글번호
		int end = 0; // 현재 페이지 마지막 글번호
		int number = 0; // 출력용 글번호, 번호삭제가 되어도
		String pageNum = null; // 페이지번호
		int currentPage = 0; // 현재 페이지

		// 블록당 앞뒤 화살표에 필요한 부분
		int pageCount = 0; // 페이지 갯수
		int startPage = 0; // 시작페이지
		int endPage = 0; // 마지막 페이지

		// 회원 수 구하기
		cnt = hostDao.getGuestCnt();
		System.out.println("cnt:" + cnt); // 먼저 테이블에 최소 30건 insert,

		pageNum = req.getParameter("pageNum");
		System.out.println("pageNum(페이지번호) : " + pageNum);

		if (pageNum == null) {
			pageNum = "1"; // 첫페이지를 1페이지로 설정
		}
		// 글 30건 기준
		currentPage = Integer.parseInt(pageNum); // 현재페이지 : 1
		System.out.println("currentPage(현재페이지)" + currentPage);

		// 딱떨어질경우 + 나미저의것. ex) 7 = (30/5) + (1)
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);

		// 1 =(1-1) * 5+1
		start = (currentPage - 1) * pageSize + 1; // 현재페이지 시작번호 1(페이지별)

		// 5 = 1 + 5- 1;
		end = start + pageSize - 1; // 현재페이지 끝번호 5

		System.out.println("start(현재페이지 시작글번호):" + start);
		System.out.println("end(현제페이지 끝글번호):" + end);

		if (end > cnt)
			end = cnt;

		// 30 = 30 (1 - 1) *5
		number = cnt - (currentPage - 1) * pageSize; // 출력용 글번호

		System.out.println("number(출력용 글번호)" + number);
		System.out.println("pageSize(한페이지당 출력될 글갯수)" + pageSize);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);

		if (cnt > 0) {
			// 게시글목록 조회
			ArrayList<MemberDTO> dtos = hostDao.getGuestList(map);

			model.addAttribute("dtos", dtos); // 큰바구니 게시글 목록 5건.
		}

		// 1 = (1/3) * 3+1
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;
		System.out.println("startPage(화살표 시작페이지):" + startPage);

		// 3 = 1+3 -1
		endPage = startPage + pageBlock - 1;
		if (endPage > pageCount)
			endPage = pageCount;
		System.out.println("endPage(화살표 마지막페이지):" + endPage);

		// 6단계. request나 session에 처리결과를 저장 (jsp에 전딜하기 위함)
		model.addAttribute("cnt", cnt); // 리스트 갯수
		model.addAttribute("number", number); // 글번호
		model.addAttribute("pageNum", pageNum); // 페이지번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage);
		}

	}

	// 일반회원 검색: guestSearch()
	@Override
	public void guestSearch(HttpServletRequest req, Model model) {
		// TODO Auto-generated method stub

	}

	// 일반회원 삭제: guestDelete()
	@Override
	public void guestDelete(HttpServletRequest req, Model model) {
		// 3단계. 화면(hidden)으로부터 입력받은값 받아온다.
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		String mem_id = req.getParameter("mem_id"); // 회원아이디

		int deleteCnt = hostDao.guestDelete(mem_id);

		// 6단계. request 나 session에 처리결과를 저장 (jsp에 전달하기 위함)
		model.addAttribute("deleteCnt", deleteCnt);
		model.addAttribute("pageNum", pageNum);
	}

	// 회원 및 파트너 어드밴티지 관리 : advManage()
	@Override
	public void advManage(HttpServletRequest req, Model model) {
		int advStatue = Integer.parseInt(req.getParameter("advStatue"));// + ,- 구분
		int mem_adv = Integer.parseInt(req.getParameter("mem_adv"));// 회원 어드벤티지
		String mem_id = req.getParameter("mem_id"); // 회원아이디
		int pageNum = Integer.parseInt(req.getParameter("pageNum")); // 페이지 번호
		int mem_grade = Integer.parseInt(req.getParameter("mem_grade")); // 회원 등급

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("mem_id", mem_id); // 회원아이디
		map.put("mem_adv", mem_adv); // 회원 어드벤티지
		map.put("advStatue", advStatue); // +, - 구분
		map.put("mem_grade", mem_grade); // 회원 등급

		System.out.println("mem_id" + mem_id);
		System.out.println("mem_adv" + mem_adv);
		System.out.println("advStatue" + advStatue);
		System.out.println("mem_grade" + mem_grade);

		// 5단계. 어드벤티지 증가
		if (mem_grade == 1) {
			int updateCnt = hostDao.guestAdvUpdate(map);
			model.addAttribute("updateCnt", updateCnt);
		} else if (mem_grade == 2) {
			int updateCnt = hostDao.partnerAdvUpdate(map);
			model.addAttribute("updateCnt", updateCnt);
		}

		// 리스트가져오기

		// 6단계 request 나 session에 처리결과를 저장 (jsp에 전달하기 위함)
		// smodel.addAttribute("pageNum");
		model.addAttribute("pageNum", pageNum);
	}

	// ********파트너 관리******************
	// *********************파트너 차트 관리*******************
	// 분야별 펀드 현황 차트
	@Override
	public void partnerFund(HttpServletRequest req, Model model) {
		// map에 입력할 key값을 배열로 정해준다.
		// -> 나중에 key[i]로 map에 값 입력할 때 쓰인다.
		String[] key = { "event", "farm", "animal", "fish", "health", "mushroom", "alcohol", "etc" };

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("event", 0);
		map.put("farm", 0);
		map.put("animal", 0);
		map.put("fish", 0);
		map.put("health", 0);
		map.put("mushroom", 0);
		map.put("alcohol", 0);
		map.put("etc", 0);

		for (int i = 0; i < map.size(); i++) { // 미리 지정한 map의 size만큼 반복
			Integer partnerFund = hostDao.partnerFund(i + 1); // i = stock_kind

			if (partnerFund != null)
				map.put(key[i], partnerFund);
		}

		model.addAttribute("map", map);
	}

	// 분야별 경매 현황 차트
	@Override
	public void partnerAuc(HttpServletRequest req, Model model) {
		// map에 입력할 key값을 배열로 정해준다.
		// -> 나중에 key[i]로 map에 값 입력할 때 쓰인다.
		String[] key = { "event", "farm", "animal", "fish", "health", "mushroom", "alcohol", "etc" };

		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("event", 0);
		map1.put("farm", 0);
		map1.put("animal", 0);
		map1.put("fish", 0);
		map1.put("health", 0);
		map1.put("mushroom", 0);
		map1.put("alcohol", 0);
		map1.put("etc", 0);

		for (int i = 0; i < map1.size(); i++) { // 미리 지정한 map의 size만큼 반복
			Integer partnerAuc = hostDao.partnerAuc(i + 1); // i = stock_kind

			if (partnerAuc != null)
				map1.put(key[i], partnerAuc);
		}

		model.addAttribute("map1", map1);
	}

	// **********************파트너 관리**************
	// 영민
	// 파트너 관리
	// 파트너 조회
	@Override
	public void partnerManage(HttpServletRequest req, Model model) {
		// 페이지 출력 관련
		int pageSize = 10; // 한 페이지당 출력할 글의 개수
		int pageBlock = 3; // 한 블럭당 페이지의 개수

		int cnt = 0; // DB에 저장된 총 글의 개수
		int start = 0; // 현재 페이지의 시작 글 번호
		int end = 0; // 현재 페이지의 마지막 글 번호
		int number = 0; // 출력용 글 번호
		// Ex) 29번이 삭제 되어도 5개의 글이 나오게 해준다.
		String pageNum = null; // 페이지 번호
		int currentPage = 0; // 현재 페이지 = 최신 페이지

		// 블럭당 앞-뒤 화살표를 클릭했을 때 필요한 기능
		int pageCount = 0; // 총 페이지 개수
		int startPage = 0; // 시작 페이지
		int endPage = 0; // 마지막 페이지

		// 4단계. 다형성 적용, 싱글톤 방식으로 dao객체 생성
		// DAO객체 생성(싱글톤, 다형성 적용)
		// BoardDAO dao = BoardDAOImpl.getInstance();

		// 5단계. 글 개수 구하기
		cnt = hostDao.getPartnerCnt();

		pageNum = req.getParameter("pageNum");

		if (pageNum == null)
			pageNum = "1"; // 첫 페이지를 1페이지로 설정

		// 글이 30건일 때 기준
		currentPage = Integer.parseInt(pageNum); // 현재 페이지 : 1

		// 6 = (30 / 5) + ( (30 % 5)>0 1 : 0 --> 0)
		// --> 6 = (30 / 5) + (0)
		// 6 = (26 / 5) + ( (26 % 5)>0 1 : 0 --> 1)
		// --> 6 = (26 / 5) + (1)
		// 총 페이지 개수 = (총 글의 개수 / pageSize) + (총 글의 개수가 pageSize의 배수가 아닐 때)나머지
		pageCount = (cnt / pageSize) + ((cnt % pageSize) > 0 ? 1 : 0);

		// (currentPage - 1) * pageSize
		// - pageSize가 5일 경우에는
		// --> 시작 페이지가 1일 경우 = 0
		// --> 시작 페이지가 2일 경우 = 5
		// --> 시작 페이지가 3일 경우 = 10
		// --> pageSize의 배수만큼 증가한다.

		// 1 = (1 - 1) * 5 + 1;
		// 현재 페이지 시작 번호 (각각의 페이지별로 시작 번호)
		start = (currentPage - 1) * pageSize + 1;

		// 5 = 1 + 5 - 1;
		// 현재 페이지 마지막 번호 (각각의 페이지별로 마지막 번호)
		end = start + pageSize - 1;

		// DB에서의 마지막 번호로 저장된 글이 총 글 개수의 번호보다 클 때,
		// end값을 cnt값으로 설정해준다.
		// Ex) DB에서 29번 삭제 후 31번 추가 --> cnt = 30
		// - 화면에서 글 번호는 30으로 보여지고,
		// - DB에서는 29번 데이터는 존재하지 않고 31번 데이터가 존재한다.
		if (end > cnt)
			end = cnt;

		// 30 = 30 - (1 - 1) * 5
		// 출력용 글 번호
		number = cnt - (currentPage - 1) * pageSize;

		// DB에 저장된 글이 최소 1개 이상일 경우
		// 글 목록을 조회하러 DB를 가기 위해 실제 DB작없을 하는 DAO를 호출한다.
		if (cnt > 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);

			// 글 목록 조회
			ArrayList<PartnerDTO> dtos = hostDao.getPartnerList(map);
			// 큰 바구니 : 게시글 목록
			// -> cf)작은 바구니 : 게시글 1건
			model.addAttribute("dtos", dtos);
		}

		// 1 = (1 / 3) * 3 + 1;
		// 시작 페이지가 pageBlock의 배수와 다를 경우
		// --> 처음 페이지는 1이 되어야하며(1페이지부터 시작하므로),
		// --> 다음 페이지 부터는 pageBlock의 (다음 배수의 값 - 현재 배수의 값) +1이 된다.
		// Ex) pageBlock = 3일 경우, 3의 배수 3, 6, 9, 12, ...
		// 시작 페이지는 1, 4, 7, 10, ... 이 된다.
		// Ex) pageBlock = 4일 경우, 4의 배수 4, 8, 12, 16, ...
		// 시작 페이지는 1, 5, 9, 13, ... 이 된다.
		startPage = (currentPage / pageBlock) * pageBlock + 1; // 시작 페이지

		// 현재 페이지가 pageBlock의 배수와 같을 경우
		// --> pageBlock의 (다음 배수의 값 - 현재 배수의 값) +1 - pageBlock이 된다.
		// 현재 페이지가 pageBlock의 배수의 값과 값이 같으므로
		// pageBlock의 이전 배수의 값을 가지는 page가 현재 페이지에 나와주어야한다.
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;

		// 3 = 1 + 3 - 1;
		// 마지막 페이지는 pageBlock의 배수가 되므로
		// 시작 페이지 공식인 pageBlock의 (다음 배수의 값 - 현재 배수의 값) +1에서 -1을 해준다.
		// --> 시작 페이지가 pageBlock의 현재 배수보다 1의 값을 더 가지므로
		// --> 거기에서 1의 값을 빼준다.
		endPage = startPage + pageBlock - 1; // 마지막 페이지
		if (endPage > pageCount)
			endPage = pageCount;

		// 6단계. request나 session에 처리결과를 저장 - jsp로 글 개수 넘겨주기
		model.addAttribute("cnt", cnt); // 글 개수
		model.addAttribute("number", number); // 글 번호
		model.addAttribute("pageNum", pageNum); // 페이지 번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작 페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 개수
			model.addAttribute("pageCount", pageCount); // 페이지 개수
			model.addAttribute("currentPage", currentPage); // 현재 페이지
		}

	}

	/*
	 * //파트너 검색
	 * 
	 * @Override public void partnerSearch(HttpServletRequest req, Model model) { //
	 * TODO Auto-generated method stub
	 * 
	 * }
	 */

	// 파트너 승인
	@Override
	public void partnerUp(HttpServletRequest req, Model model) {
		String mem_id = req.getParameter("mem_id");

		int updateCnt = hostDao.partnerUp(mem_id);

		model.addAttribute("mem_id", mem_id);
		model.addAttribute("updateCnt", updateCnt);
	}

	// 파트너 강등
	@Override
	public void partnerDown(HttpServletRequest req, Model model) {
		String mem_id = req.getParameter("mem_id");

		int updateCnt = hostDao.partnerDown(mem_id);

		model.addAttribute("mem_id", mem_id);
		model.addAttribute("updateCnt", updateCnt);
	}

	// *************************************************************************************
	// **************************************** 정산 관리
	// ************************************
	// *************************************************************************************
	// ************* 펀드 *************
	// 경매 - 펀드 비교 차트
	public void aucVSfund(HttpServletRequest req, Model model) {
		// TODO Auto-generated method stub

	}

	// 이번 달 펀드(상품 종류별) 차트
	@Override
	public void thisMonthFundKind(HttpServletRequest req, Model model) {
		// map에 입력할 key값을 배열로 정해준다.
		// -> 나중에 key[i]로 map에 값 입력할 때 쓰인다.
		String[] key = { "event", "farm", "animal", "fish", "health", "mushroom", "alcohol", "etc" };
		int fund_status = (Integer) req.getAttribute("fund_status");

		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("event", 0);
		map1.put("farm", 0);
		map1.put("animal", 0);
		map1.put("fish", 0);
		map1.put("health", 0);
		map1.put("mushroom", 0);
		map1.put("alcohol", 0);
		map1.put("etc", 0);

		Map<String, Integer> mapParam = new HashMap<String, Integer>();
		mapParam.put("fund_status", fund_status);

		for (int j = 0; j < map1.size(); j++) { // 미리 지정한 map의 size만큼 반복
			mapParam.put("stock_kind", j + 1); // j는 map1.size() ==> 상품 종

			Integer thisMonthFundKind = hostDao.thisMonthFundKind(mapParam);

			if (thisMonthFundKind != null)
				map1.put(key[j], thisMonthFundKind);
		}

		model.addAttribute("map1", map1);
	}

	// 월별 펀드 총액 차트
	@Override
	public void monthFundTotal(HttpServletRequest req, Model model) {
		// map에 입력할 key값을 배열로 정해준다.
		// -> 나중에 key[i]로 map에 값 입력할 때 쓰인다.
		String[] key = { "fundTotal_1", "fundTotal_2", "fundTotal_3", "fundTotal_4", "fundTotal_5", "fundTotal_6",
				"fundTotal_7", "fundTotal_8", "fundTotal_9", "fundTotal_10", "fundTotal_11", "fundTotal_12" };
		int fund_status = (Integer) req.getAttribute("fund_status");

		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("fundTotal_1", 0);
		map2.put("fundTotal_2", 0);
		map2.put("fundTotal_3", 0);
		map2.put("fundTotal_4", 0);
		map2.put("fundTotal_5", 0);
		map2.put("fundTotal_6", 0);
		map2.put("fundTotal_7", 0);
		map2.put("fundTotal_8", 0);
		map2.put("fundTotal_9", 0);
		map2.put("fundTotal_10", 0);
		map2.put("fundTotal_11", 0);
		map2.put("fundTotal_12", 0);

		// 파라미터로 넘길 Map객체 생성
		Map<String, Integer> mapParam = new HashMap<String, Integer>();
		mapParam.put("fund_status", fund_status);

		for (int i = 0; i < 12; i++) { // 1월 ~ 12월
			mapParam.put("month", i + 1);

			Integer monthFundTotal = hostDao.monthFundTotal(mapParam);

			if (monthFundTotal != null)
				map2.put(key[i], monthFundTotal);
		}
		model.addAttribute("map2", map2);
	}

	// 년별 펀드 (총 액수) 차트
	@Override
	public void yearFundTotal(HttpServletRequest req, Model model) {
		// map에 입력할 key값을 배열로 정해준다.
		// -> 나중에 key[i]로 map에 값 입력할 때 쓰인다.
		String[] key = { "2013", "2014", "2015", "2016", "2017", "2018" };

		Map<String, Integer> map3 = new HashMap<String, Integer>();
		map3.put("2018", 0);
		map3.put("2017", 0);
		map3.put("2016", 0);
		map3.put("2015", 0);
		map3.put("2014", 0);
		map3.put("2013", 0);

		for (int i = 0; i < map3.size(); i++) { // 미리 지정한 map3의 size만큼 반복
			Integer aucSales = hostDao.yearFundTotal(i + 13); // 13~18의 숫자가 들어감

			if (aucSales != null)
				map3.put(key[i], aucSales);// 금액이 없으면 기본값인 0이지만, 년도 합계가 있으면 각각의 변수에 값이 들어간후, map3에 넣어줌.
		}
		model.addAttribute("ToCnt", map3.size()); // map3 의 총길이
		model.addAttribute("map3", map3); // 맵 보내주기
	}

	// 년별 펀드(상품 종류별) 차트
	@Override
	public void yearFundKind(HttpServletRequest req, Model model) {
		// map에 입력할 key값을 배열로 정해준다.
		// -> 나중에 key[i]로 map에 값 입력할 때 쓰인다.
		int AucYear4 = 3; // 2016, 2017, 2018
		int AucKind4 = 8; // 상품 종류(1: 이벤트, 2: 농산, 3: 축산, 4: 수산, 5: 건강·유기농, 6: 버섯, 7: 주류, 8: 기타)
		int auc_status = 4;// 경매완료

		String[] key = { "2016_1", "2016_2", "2016_3", "2016_4", "2016_5", "2016_6", "2016_7", "2016_8", "2017_1",
				"2017_2", "2017_3", "2017_4", "2017_5", "2017_6", "2017_7", "2017_8", "2018_1", "2018_2", "2018_3",
				"2018_4", "2018_5", "2018_6", "2018_7", "2018_8" };

		Map<String, Integer> map4 = new HashMap<String, Integer>();

		map4.put("2018_1", 0);
		map4.put("2018_2", 0);
		map4.put("2018_3", 0);
		map4.put("2018_4", 0);
		map4.put("2018_5", 0);
		map4.put("2018_6", 0);
		map4.put("2018_7", 0);
		map4.put("2018_8", 0);

		map4.put("2017_1", 0);
		map4.put("2017_2", 0);
		map4.put("2017_3", 0);
		map4.put("2017_4", 0);
		map4.put("2017_5", 0);
		map4.put("2017_6", 0);
		map4.put("2017_7", 0);
		map4.put("2017_8", 0);

		map4.put("2016_1", 0);
		map4.put("2016_2", 0);
		map4.put("2016_3", 0);
		map4.put("2016_4", 0);
		map4.put("2016_5", 0);
		map4.put("2016_6", 0);
		map4.put("2016_7", 0);
		map4.put("2016_8", 0);

		System.out.println("2018_2" + map4.put("2018_2", 0));

		Map<String, Integer> mapParam = new HashMap<String, Integer>();

		for (int i = 0; i < AucYear4; i++) { // 년수만큼 반복 3
			for (int j = 0; j < AucKind4; j++) { // 종류만큼 반복 8
				mapParam.put("year", i + 16);// 16,17,18의 숫자가 들어감
				mapParam.put("kind", j + 1); // 1 ~8 의 숫자가 들어감
				mapParam.put("auc_status", auc_status); // 1 ~8 의 숫자가 들어감

				Integer aucSales = hostDao.yearFundKind(mapParam);

				if (aucSales != null) {

					if (i == 0) {// 0
						map4.put(key[j], aucSales);

					} else if (i == 1) {// 8
						map4.put(key[AucKind4 + j], aucSales);

					} else if (i == 2) {// 16
						map4.put(key[2 * AucKind4 + j], aucSales);
					}

				} // 금액이 없으면 기본값인 0이지만, 년도 합계가 있으면 각각의 변수에 값이 들어간후, map3에 넣어줌.
			}
		}
		model.addAttribute("map4", map4); // 맵 보내주기
	}

	// ************* 경매 *************

	// 이번 달 경매 (상품 종류별) 차트
	@Override
	public void thisMonthAucKind(HttpServletRequest req, Model model) {
		// map에 입력할 key값을 배열로 정해준다.
		// -> 나중에 key[i]로 map에 값 입력할 때 쓰인다.
		String[] key = { "event", "farm", "animal", "fish", "health", "mushroom", "alcohol", "etc" };
		int auc_status = (Integer) req.getAttribute("auc_status");

		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("event", 0);
		map1.put("farm", 0);
		map1.put("animal", 0);
		map1.put("fish", 0);
		map1.put("health", 0);
		map1.put("mushroom", 0);
		map1.put("alcohol", 0);
		map1.put("etc", 0);

		Map<String, Integer> mapParam = new HashMap<String, Integer>();
		mapParam.put("auc_status", auc_status);

		for (int j = 0; j < map1.size(); j++) { // 미리 지정한 map의 size만큼 반복
			mapParam.put("stock_kind", j + 1); // j는 map1.size() ==> 상품 종

			Integer thisMonthAucKind = hostDao.thisMonthAucKind(mapParam);

			if (thisMonthAucKind != null)
				map1.put(key[j], thisMonthAucKind);
		}

		model.addAttribute("map1", map1);
	}

	// 월별 경매 총액 차트
	@Override
	public void monthAucTotal(HttpServletRequest req, Model model) {
		// map에 입력할 key값을 배열로 정해준다.
		// -> 나중에 key[i]로 map에 값 입력할 때 쓰인다.
		String[] key = { "aucTotal_1", "aucTotal_2", "aucTotal_3", "aucTotal_4", "aucTotal_5", "aucTotal_6",
				"aucTotal_7", "aucTotal_8", "aucTotal_9", "aucTotal_10", "aucTotal_11", "aucTotal_12" };
		int auc_status = (Integer) req.getAttribute("auc_status");

		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("aucTotal_1", 0);
		map2.put("aucTotal_2", 0);
		map2.put("aucTotal_3", 0);
		map2.put("aucTotal_4", 0);
		map2.put("aucTotal_5", 0);
		map2.put("aucTotal_6", 0);
		map2.put("aucTotal_7", 0);
		map2.put("aucTotal_8", 0);
		map2.put("aucTotal_9", 0);
		map2.put("aucTotal_10", 0);
		map2.put("aucTotal_11", 0);
		map2.put("aucTotal_12", 0);

		// 파라미터로 넘길 Map객체 생성
		Map<String, Integer> mapParam = new HashMap<String, Integer>();
		mapParam.put("auc_status", auc_status);

		for (int i = 0; i < 12; i++) { // 1월 ~ 12월
			mapParam.put("month", i + 1);

			Integer monthAucTotal = hostDao.monthAucTotal(mapParam);

			if (monthAucTotal != null)
				map2.put(key[i], monthAucTotal);
		}
		model.addAttribute("map2", map2);
	}

	// 년별 경매 (총 액수) 차트
	@Override
	public void yearAucTotal(HttpServletRequest req, Model model) {

		// map에 입력할 key값을 배열로 정해준다.
		// -> 나중에 key[i]로 map에 값 입력할 때 쓰인다.
		String[] key = { "2013", "2014", "2015", "2016", "2017", "2018" };

		Map<String, Integer> map3 = new HashMap<String, Integer>();
		map3.put("2018", 0);
		map3.put("2017", 0);
		map3.put("2016", 0);
		map3.put("2015", 0);
		map3.put("2014", 0);
		map3.put("2013", 0);

		for (int i = 0; i < map3.size(); i++) { // 미리 지정한 map3의 size만큼 반복
			Integer aucSales = hostDao.yearAucTotal(i + 13); // 13~18의 숫자가 들어감

			if (aucSales != null)
				map3.put(key[i], aucSales);// 금액이 없으면 기본값인 0이지만, 년도 합계가 있으면 각각의 변수에 값이 들어간후, map3에 넣어줌.
		}
		model.addAttribute("ToCnt", map3.size()); // map3 의 총길이
		model.addAttribute("map3", map3); // 맵 보내주기
	}

	// 년별 경매(상품 종류별) 차트
	@Override
	public void yearAucKind(HttpServletRequest req, Model model) {
		// map에 입력할 key값을 배열로 정해준다.
		// -> 나중에 key[i]로 map에 값 입력할 때 쓰인다.
		int AucYear4 = 3; // 2016, 2017, 2018
		int AucKind4 = 8; // 상품 종류(1: 이벤트, 2: 농산, 3: 축산, 4: 수산, 5: 건강·유기농, 6: 버섯, 7: 주류, 8: 기타)
		int auc_status = 4;// 경매완료

		String[] key = { "2016_1", "2016_2", "2016_3", "2016_4", "2016_5", "2016_6", "2016_7", "2016_8", "2017_1",
				"2017_2", "2017_3", "2017_4", "2017_5", "2017_6", "2017_7", "2017_8", "2018_1", "2018_2", "2018_3",
				"2018_4", "2018_5", "2018_6", "2018_7", "2018_8" };

		Map<String, Integer> map4 = new HashMap<String, Integer>();

		map4.put("2018_1", 0);
		map4.put("2018_2", 0);
		map4.put("2018_3", 0);
		map4.put("2018_4", 0);
		map4.put("2018_5", 0);
		map4.put("2018_6", 0);
		map4.put("2018_7", 0);
		map4.put("2018_8", 0);

		map4.put("2017_1", 0);
		map4.put("2017_2", 0);
		map4.put("2017_3", 0);
		map4.put("2017_4", 0);
		map4.put("2017_5", 0);
		map4.put("2017_6", 0);
		map4.put("2017_7", 0);
		map4.put("2017_8", 0);

		map4.put("2016_1", 0);
		map4.put("2016_2", 0);
		map4.put("2016_3", 0);
		map4.put("2016_4", 0);
		map4.put("2016_5", 0);
		map4.put("2016_6", 0);
		map4.put("2016_7", 0);
		map4.put("2016_8", 0);

		Map<String, Integer> mapParam = new HashMap<String, Integer>();

		for (int i = 0; i < AucYear4; i++) { // 년수만큼 반복 3
			for (int j = 0; j < AucKind4; j++) { // 종류만큼 반복 8
				mapParam.put("year", i + 16);// 16,17,18의 숫자가 들어감
				mapParam.put("kind", j + 1); // 1 ~8 의 숫자가 들어감
				mapParam.put("auc_status", auc_status); // 1 ~8 의 숫자가 들어감

				Integer aucSales = hostDao.yearAucKind(mapParam);

				if (aucSales != null) {

					if (i == 0) {// 0
						map4.put(key[j], aucSales);

					} else if (i == 1) {// 8
						map4.put(key[AucKind4 + j], aucSales);

					} else if (i == 2) {// 16
						map4.put(key[2 * AucKind4 + j], aucSales);
					}

				} // 금액이 없으면 기본값인 0이지만, 년도 합계가 있으면 각각의 변수에 값이 들어간후, map3에 넣어줌.
			}
		}
		model.addAttribute("map4", map4); // 맵 보내주기
	}

	// *************************************************************************************
	// **************************************** 게시판 관리
	// ************************************
	// *************************************************************************************

	// *************** 공지사항 ***************
	// 공지사항 목록
	@Override
	public void noticeList(HttpServletRequest req, Model model) {
		// 공지사항 관련
		int pageSize = 3; // 한 페이지당 출력할 글의 개수
		int pageBlock = 3; // 한 블럭당 페이지의 개수

		int cnt = 0; // DB에 저장된 총 글의 개수
		int start = 0; // 현재 페이지의 시작 글 번호
		int end = 0; // 현재 페이지의 마지막 글 번호
		int number = 0; // 출력용 글 번호
						// Ex) 29번이 삭제 되어도 5개의 글이 나오게 해준다.
		String pageNum = null; // 페이지 번호
		int currentPage = 0; // 현재 페이지 = 최신 페이지

		// 블럭당 앞-뒤 화살표를 클릭했을 때 필요한 기능
		int pageCount = 0; // 총 페이지 개수
		int startPage = 0; // 시작 페이지
		int endPage = 0; // 마지막 페이지

		// 4단계. 다형성 적용, 싱글톤 방식으로 dao객체 생성
		// DAO객체 생성(싱글톤, 다형성 적용)
		// BoardDAO dao = BoardDAOImpl.getInstance();
		int category = (Integer) req.getAttribute("category");

		cnt = hostDao.getNoticeCnt(category); // 글 개수 구하기

		pageNum = req.getParameter("pageNum");
		if (pageNum == null)
			pageNum = "1"; // 첫 페이지를 1페이지로 설정

		// 글이 30건일 때 기준
		currentPage = Integer.parseInt(pageNum); // 현재 페이지 : 1

		// 총 페이지 개수 = (총 글의 개수 / pageSize) + (총 글의 개수가 pageSize의 배수가 아닐 때)나머지
		pageCount = (cnt / pageSize) + ((cnt % pageSize) > 0 ? 1 : 0);

		// 현재 페이지 시작 번호 (각각의 페이지별로 시작 번호)
		start = (currentPage - 1) * pageSize + 1;

		// 현재 페이지 마지막 번호 (각각의 페이지별로 마지막 번호)
		end = start + pageSize - 1;

		if (end > cnt)
			end = cnt;

		// 30 = 30 - (1 - 1) * 5
		// 출력용 글 번호
		number = cnt - (currentPage - 1) * pageSize;

		// DB에 저장된 글이 최소 1개 이상일 경우
		// 글 목록을 조회하러 DB를 가기 위해 실제 DB작없을 하는 DAO를 호출한다.
		if (cnt > 0) {
			// 글 목록 조회
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);

			ArrayList<BoardDTO> dtos = hostDao.getNoticeList(map);

			// 큰 바구니 : 게시글 목록
			// -> cf)작은 바구니 : 게시글 1건
			model.addAttribute("dtos", dtos);
		}

		startPage = (currentPage / pageBlock) * pageBlock + 1; // 시작 페이지

		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;

		endPage = startPage + pageBlock - 1; // 마지막 페이지
		if (endPage > pageCount)
			endPage = pageCount;

		// 6단계. request나 session에 처리결과를 저장 - jsp로 글 개수 넘겨주기
		model.addAttribute("cnt", cnt); // 글 개수
		model.addAttribute("number", number); // 글 번호
		model.addAttribute("pageNum", pageNum); // 페이지 번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작 페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 개수
			model.addAttribute("pageCount", pageCount); // 페이지 개수
			model.addAttribute("currentPage", currentPage); // 현재 페이지
		}

	}

	// 공지사항 작성
	/*
	 * @Override public void noticeWrite(HttpServletRequest req, Model model) {
	 * 
	 * }
	 */

	// 공지사항 수정
	/*
	 * @Override public void noticeWrite(HttpServletRequest req, Model model) {
	 * 
	 * }
	 */

	// 공지사항 삭제
	@Override
	public void noticeDelete(HttpServletRequest req, Model model) {
		// 3단계. 화면으로부터 입력받은 값을 받아온다.
		int boa_id = Integer.parseInt(req.getParameter("boa_id"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));

		// 4단계. 다형성 적용, 싱글톤 방식으로 dao객체 생성
		// BoardDAO dao = BoardDAOImpl.getInstance();

		// 5단계. 상세 페이지 조회
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boa_id", boa_id);
		map.put("pageNum", pageNum);

		int deleteCnt = hostDao.noticeDelete(map);

		// 6단계. request나 session에 처리결과를 저장 - jsp로 글 개수 넘겨주기
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("deleteCnt", deleteCnt);
	}

	// 공지사항 상세페이지
	@Override
	public void noticeContent(HttpServletRequest req, Model model) {
		// 3단계. 화면으로부터 입력받은 값을 받아온다.
		int boa_id = Integer.parseInt(req.getParameter("boa_id"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));

		// 4단계. 다형성 적용, 싱글톤 방식으로 dao객체 생성
		// BoardDAO dao = BoardDAOImpl.getInstance();

		// 5단계. 상세 페이지 조회
		BoardDTO dto = hostDao.getNoticeContent(boa_id);

		// 6단계. request나 session에 처리결과를 저장 - jsp로 글 개수 넘겨주기
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("dto", dto);
	}

	// ******************* 댓글 *******************
	// 댓글 조회
	@Override
	public void commentList(HttpServletRequest req, Model model) {
		// 글 번호를 파라미터 값에서 가지고온다.
		int boa_id = Integer.parseInt(req.getParameter("boa_id"));

		List<CommentDTO> dtos = new ArrayList<CommentDTO>();
		dtos = hostDao.getCommentList(boa_id);

		model.addAttribute("dtos", dtos);
	}

	// 댓글 작성
	@Override
	public void commentWrite(HttpServletRequest req, Model model) {
		String userId = (String) req.getSession().getAttribute("userId");
		int boa_id = Integer.parseInt(req.getParameter("boa_id")); // 글 번호
		String cm_content = req.getParameter("cm_content");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("boa_id", boa_id);
		map.put("cm_content", cm_content);

		hostDao.commentWrite(map);

		model.addAttribute("boa_id", boa_id);
	}

	// 댓글 수정
	@Override
	public void commentModify(HttpServletRequest req, Model model) {
		int boa_id = Integer.parseInt(req.getParameter("boa_id")); // 글 번호
		int cm_no = Integer.parseInt(req.getParameter("cm_no")); // 댓글 번호
		String cm_content = req.getParameter("cm_content");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cm_no", cm_no);
		map.put("cm_content", cm_content);

		int updateCnt = hostDao.commentModify(map);

		model.addAttribute("updateCnt", updateCnt); // 0: 수정 실패, 1: 수정 성공
		model.addAttribute("boa_id", boa_id);
	}

	// 댓글 삭제
	@Override
	public void commentDelete(HttpServletRequest req, Model model) {
		int boa_id = Integer.parseInt(req.getParameter("boa_id")); // 글 번호
		int cm_no = Integer.parseInt(req.getParameter("cm_no")); // 댓글 번호
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));

		int deleteCnt = hostDao.commentDelete(cm_no);

		model.addAttribute("deleteCnt", deleteCnt); // 0: 삭제 실패, 1: 삭제 성공
		model.addAttribute("boa_id", boa_id);
		model.addAttribute("pageNum", pageNum);
	}

	// *************************************************************************************
	// **************************************** 기부 관리
	// ************************************
	// *************************************************************************************
	// 기부 내역
	@Override
	public void donateList(HttpServletRequest req, Model model) {
		// 기부 내역 목록 조회
		int pageSize = 10; // 한 페이지당 출력할 글의 개수
		int pageBlock = 3; // 한 블럭당 페이지의 개수

		int cnt = 0; // DB에 저장된 총 글의 개수
		int start = 0; // 현재 페이지의 시작 글 번호
		int end = 0; // 현재 페이지의 마지막 글 번호
		int number = 0; // 출력용 글 번호
		// Ex) 29번이 삭제 되어도 5개의 글이 나오게 해준다.
		String pageNum = null; // 페이지 번호
		int currentPage = 0; // 현재 페이지 = 최신 페이지

		// 블럭당 앞-뒤 화살표를 클릭했을 때 필요한 기능
		int pageCount = 0; // 총 페이지 개수
		int startPage = 0; // 시작 페이지
		int endPage = 0; // 마지막 페이지

		// 4단계. 다형성 적용, 싱글톤 방식으로 dao객체 생성
		// DAO객체 생성(싱글톤, 다형성 적용)
		// BoardDAO dao = BoardDAOImpl.getInstance();

		cnt = hostDao.getDonateCnt(); // 글 개수 구하기

		pageNum = req.getParameter("pageNum");
		if (pageNum == null)
			pageNum = "1"; // 첫 페이지를 1페이지로 설정

		// 글이 30건일 때 기준
		currentPage = Integer.parseInt(pageNum); // 현재 페이지 : 1

		// 총 페이지 개수 = (총 글의 개수 / pageSize) + (총 글의 개수가 pageSize의 배수가 아닐 때)나머지
		pageCount = (cnt / pageSize) + ((cnt % pageSize) > 0 ? 1 : 0);

		// 현재 페이지 시작 번호 (각각의 페이지별로 시작 번호)
		start = (currentPage - 1) * pageSize + 1;

		// 현재 페이지 마지막 번호 (각각의 페이지별로 마지막 번호)
		end = start + pageSize - 1;

		if (end > cnt)
			end = cnt;

		// 30 = 30 - (1 - 1) * 5
		// 출력용 글 번호
		number = cnt - (currentPage - 1) * pageSize;

		// DB에 저장된 글이 최소 1개 이상일 경우
		// 글 목록을 조회하러 DB를 가기 위해 실제 DB작없을 하는 DAO를 호출한다.
		if (cnt > 0) {
			// 글 목록 조회
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);

			ArrayList<DonateDTO> dtos = hostDao.getDonateList(map);

			// 큰 바구니 : 게시글 목록
			// -> cf)작은 바구니 : 게시글 1건
			model.addAttribute("dtos", dtos);
		}

		startPage = (currentPage / pageBlock) * pageBlock + 1; // 시작 페이지

		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;

		endPage = startPage + pageBlock - 1; // 마지막 페이지
		if (endPage > pageCount)
			endPage = pageCount;

		// 6단계. request나 session에 처리결과를 저장 - jsp로 글 개수 넘겨주기
		model.addAttribute("cnt", cnt); // 글 개수
		model.addAttribute("number", number); // 글 번호
		model.addAttribute("pageNum", pageNum); // 페이지 번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작 페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 개수
			model.addAttribute("pageCount", pageCount); // 페이지 개수
			model.addAttribute("currentPage", currentPage); // 현재 페이지
		}
	}

	// 기부업체내역
	@Override
	public void DonateConList(HttpServletRequest req, Model model) {
		// 3단계 . 화면으로부터 입력받은 값을 받아온다.
		// 재고목록 관련
		int pageSize = 10; // 한페이지당 출력될 글 갯수
		int pageBlock = 3; // 페이지 블록을 3개씩. 앞뒤를 화살표로 이동

		int cnt = 0; // 글갯수
		int start = 0; // 현재페이지 시작 글번호
		int end = 0; // 현재 페이지 마지막 글번호
		int number = 0; // 출력용 글번호, 번호삭제가 되어도
		String pageNum = null; // 페이지번호
		int currentPage = 0; // 현재 페이지

		// 블록당 앞뒤 화살표에 필요한 부분
		int pageCount = 0; // 페이지 갯수
		int startPage = 0; // 시작페이지
		int endPage = 0; // 마지막 페이지

		// 5단계 재고갯수 구하기
		cnt = hostDao.getDonateConCnt();
		System.out.println("cnt:" + cnt); // 먼저 테이블에 최소 30건 insert,

		pageNum = req.getParameter("pageNum");
		System.out.println("pageNum(페이지번호) : " + pageNum);

		if (pageNum == null) {
			pageNum = "1"; // 첫페이지를 1페이지로 설정
		}

		// 글 30건 기준
		currentPage = Integer.parseInt(pageNum); // 현재페이지 : 1
		System.out.println("currentPage(현재페이지)" + currentPage);

		// 딱떨어질경우 + 나미저의것. ex) 7 = (30/5) + (1)
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);

		// 1 =(1-1) * 5+1
		start = (currentPage - 1) * pageSize + 1; // 현재페이지 시작번호 1(페이지별)

		// 5 = 1 + 5- 1;
		end = start + pageSize - 1; // 현재페이지 끝번호 5

		System.out.println("start(현재페이지 시작글번호):" + start);
		System.out.println("end(현제페이지 끝글번호):" + end);

		if (end > cnt)
			end = cnt;

		// 30 = 30 (1 - 1) *5
		number = cnt - (currentPage - 1) * pageSize; // 출력용 글번호

		System.out.println("number(출력용 글번호)" + number);
		System.out.println("pageSize(한페이지당 출력될 글갯수)" + pageSize);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);

		if (cnt > 0) {
			// 게시글목록 조회
			ArrayList<DonateDTO> dtos = hostDao.donateConList(map);
			model.addAttribute("dtos", dtos); // 큰바구니 게시글 목록 5건.
		}

		// 1 = (1/3) * 3+1
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;
		System.out.println("startPage(화살표 시작페이지):" + startPage);

		// 3 = 1+3 -1
		endPage = startPage + pageBlock - 1;
		if (endPage > pageCount)
			endPage = pageCount;
		System.out.println("endPage(화살표 마지막페이지):" + endPage);

		// 6단계. request나 session에 처리결과를 저장 (jsp에 전딜하기 위함)
		model.addAttribute("cnt", cnt); // 글갯수
		model.addAttribute("number", number); // 글번호
		model.addAttribute("pageNum", pageNum); // 페이지번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage);
		}
	}

	// 기부단체 수정 상세페이지
	@Override
	public void donateModifyView(HttpServletRequest req, Model model) {

		// 3단계. 화면으로부터 입력받은값
		int doForm_id = Integer.parseInt(req.getParameter("doForm_id"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));

		DonateDTO dto = hostDao.donateDetail(doForm_id);
		model.addAttribute("dto", dto);

		// 6단계. request 나 session에 처리결과를 저장 (jsp에 전달하기 위함)
		model.addAttribute("doForm_id", doForm_id);
		model.addAttribute("pageNum", pageNum);

	}

	// 기부단체 수정 처리페이지
	@Override
	public void donateModifyPro(MultipartHttpServletRequest req, Model model) {
		MultipartFile file = req.getFile("doOrg_image");

		String saveDir = req.getSession().getServletContext().getRealPath("/resources/images/host/"); // 업로드할 파일이 위치하게될
																										// 실제 경로
		String realDir = "C:\\Dev36\\workspace_spring\\SPRING_farmfarm\\src\\main\\webapp\\resources\\images\\host\\";
		try {
			file.transferTo(new File(saveDir + file.getOriginalFilename()));

			FileInputStream fis = new FileInputStream(saveDir + file.getOriginalFilename());
			FileOutputStream fos = new FileOutputStream(realDir + file.getOriginalFilename());

			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();

			// 바구니 생성
			DonateDTO dto = new DonateDTO();

			// hidden으로부터 넘어온값
			int pageNum = Integer.parseInt(req.getParameter("pageNum"));
			int doForm_id = Integer.parseInt(req.getParameter("doForm_id"));

			// 화면에서 입력한값들을 바구니에 담는다.
			dto.setDoForm_id(doForm_id); // 기부아이디
			dto.setDoOrg_address(req.getParameter("doOrg_address")); // 단체주소
			dto.setDoOrg_person(req.getParameter("doOrg_person")); // 담당자
			dto.setDoOrg_hp(req.getParameter("doOrg_hp")); // 단체번호
			dto.setDoOrg_title(req.getParameter("doOrg_title")); // 신청제목
			dto.setDoOrg_content(req.getParameter("doOrg_content")); // 신청내용
			dto.setDoOrg_image(file.getOriginalFilename()); // 이미지

			System.out.println("담당자:" + req.getParameter("doOrg_person"));
			System.out.println("이미지 파일 이름:" + file.getOriginalFilename());
			System.out.println("기부아이디" + req.getParameter("doForm_id"));
			System.out.println("타이틀:" + req.getParameter("doOrg_title"));

			// 5단계. 글수정 처리
			int updateCnt = hostDao.donateUpdate(dto);

			System.out.println("updateCnt" + updateCnt);

			// 6단계. request 나 session에 처리결과를 저장 (jsp에 전달하기 위함)
			model.addAttribute("doForm_id", doForm_id);
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("updateCnt", updateCnt);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 기부업체 등록 글쓰기
	@Override
	public void donateWritePro(MultipartHttpServletRequest req, Model model) {
		MultipartFile file = req.getFile("doOrg_image");

		String saveDir = req.getSession().getServletContext().getRealPath("/resources/images/host/"); // 업로드할 파일이 위치하게될
																										// 실제 경로
		String realDir = "C:\\Dev36\\workspace_spring\\SPRING_farmfarm\\src\\main\\webapp\\resources\\images\\host\\";
		try {
			file.transferTo(new File(saveDir + file.getOriginalFilename()));

			FileInputStream fis = new FileInputStream(saveDir + file.getOriginalFilename());
			FileOutputStream fos = new FileOutputStream(realDir + file.getOriginalFilename());

			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();

			// 바구니 생성
			DonateDTO dto = new DonateDTO();

			// 화면에서 입력한값들을 바구니에 담는다.
			// dto.setDoOrg_image(req.getParameter("doOrg_image")); //단체로고
			dto.setDoOrg_name(req.getParameter("doOrg_name")); // 단체명
			dto.setDoOrg_address(req.getParameter("doOrg_address")); // 단체주소
			dto.setDoOrg_person(req.getParameter("doOrg_person")); // 담당자
			dto.setDoOrg_hp(req.getParameter("doOrg_hp")); // 단체번호
			dto.setDoOrg_title(req.getParameter("doOrg_title")); // 신청제목
			dto.setDoOrg_content(req.getParameter("doOrg_content")); // 신청내용
			dto.setDoOrg_image(file.getOriginalFilename()); // 이미지

			System.out.println("이미지 파일 이름:" + file.getOriginalFilename());

			// 기부단체 삽입
			int insertCnt = hostDao.donateInsert(dto);

			// 6단계. request 나 session에 처리결과를 저장 (jsp에 전달하기 위함)
			model.addAttribute("insertCnt", insertCnt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 기부단체 삭제 처리페이지
	@Override
	public void DonateDeletePro(HttpServletRequest req, Model model) {

		// 3단계. 화면(hidden)으로부터 입력받은값 받아온다.
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int doForm_id = Integer.parseInt(req.getParameter("doForm_id"));
		int deleteCnt = 0;

		// 5-2단계 글삭제 처리페이지
		deleteCnt = hostDao.DonateDeletePro(doForm_id);
		System.out.println("deleteCnt" + deleteCnt);

		// 6단계. request 나 session에 처리결과를 저장 (jsp에 전달하기 위함)
		model.addAttribute("deleteCnt", deleteCnt);
		model.addAttribute("pageNum", pageNum);
	}

	// 3.업체별 기부액 3년치
	@Override
	public void yearDonate(HttpServletRequest req, Model model) {
		// map에 입력할 key값을 배열로 정해준다.
		// -> 나중에 key[i]로 map에 값 입력할 때 쓰인다.
		int DonaYear4 = 3; // 2016, 2017, 2018
		int DonaKind4 = 8; // 기부 단체('1.국내아동지원', '2.해외아동지원', '3.북한아동지원', '4.나눔 SOS', '5.해외아동결연' ,6.하나사랑 ,
							// 7.유니세프 , 8. 위스타트)

		String[] key = { "2016_1", "2016_2", "2016_3", "2016_4", "2016_5", "2016_6", "2016_7", "2016_8", "2017_1",
				"2017_2", "2017_3", "2017_4", "2017_5", "2017_6", "2017_7", "2017_8", "2018_1", "2018_2", "2018_3",
				"2018_4", "2018_5", "2018_6", "2018_7", "2018_8" };

		Map<String, Integer> map4 = new HashMap<String, Integer>();

		map4.put("2018_1", 0);
		map4.put("2018_2", 0);
		map4.put("2018_3", 0);
		map4.put("2018_4", 0);
		map4.put("2018_5", 0);
		map4.put("2018_6", 0);
		map4.put("2018_7", 0);
		map4.put("2018_8", 0);

		map4.put("2017_1", 0);
		map4.put("2017_2", 0);
		map4.put("2017_3", 0);
		map4.put("2017_4", 0);
		map4.put("2017_5", 0);
		map4.put("2017_6", 0);
		map4.put("2017_7", 0);
		map4.put("2017_8", 0);

		map4.put("2016_1", 0);
		map4.put("2016_2", 0);
		map4.put("2016_3", 0);
		map4.put("2016_4", 0);
		map4.put("2016_5", 0);
		map4.put("2016_6", 0);
		map4.put("2016_7", 0);
		map4.put("2016_8", 0);

		System.out.println("2018_2" + map4.put("2018_2", 0));

		Map<String, Integer> mapParam = new HashMap<String, Integer>();

		for (int i = 0; i < DonaYear4; i++) { // 년수만큼 반복 3
			for (int j = 0; j < DonaKind4; j++) { // 종류만큼 반복 8
				mapParam.put("year", i + 16);// 16,17,18의 숫자가 들어감

				int doForm_id = hostDao.getDoFormId(j); // rNum 를 가져가서 뽑아준다.

				mapParam.put("doForm_id", doForm_id); // 1 ~8 의 숫자가 들어감

				Integer donaSales = hostDao.yearDonate(mapParam); // year , doForm_id

				if (donaSales != null) {

					if (i == 0) {// 0
						map4.put(key[j], donaSales);

					} else if (i == 1) {// 8
						map4.put(key[DonaKind4 + j], donaSales);

					} else if (i == 2) {// 16
						map4.put(key[2 * DonaKind4 + j], donaSales);
					}

				} // 금액이 없으면 기본값인 0이지만, 년도 합계가 있으면 각각의 변수에 값이 들어간후, map3에 넣어줌.
			}
		}
		model.addAttribute("ToCnt", map4.size()); // map4 의 총길이
		model.addAttribute("map4", map4); // 맵 보내주기
	}

	// *************************************************************************************
	// ***************************************** 주말농장
	// *************************************
	// *************************************************************************************
	// 주말농장 요청현황 조회
	@Override
	public void getWeekFarmRequestList(HttpServletRequest req, Model model) {
		// 3단계 . 화면으로부터 입력받은 값을 받아온다.
		int pageSize = 10; // 한페이지당 출력될 글 갯수
		int pageBlock = 3; // 페이지 블록을 3개씩. 앞뒤를 화살표로 이동

		int cnt = 0; // 글갯수
		int start = 0; // 현재페이지 시작 글번호
		int end = 0; // 현재 페이지 마지막 글번호
		int number = 0; // 출력용 글번호, 번호삭제가 되어도
		String pageNum = null; // 페이지번호
		int currentPage = 0; // 현재 페이지

		// 블록당 앞뒤 화살표에 필요한 부분
		int pageCount = 0; // 페이지 갯수
		int startPage = 0; // 시작페이지
		int endPage = 0; // 마지막 페이지

		// 주말농장 상태(1: 승인대기, 2: 승인)
		int wfarm_status = (Integer) req.getAttribute("wfarm_status");

		// 주말농장 요청 건수
		cnt = hostDao.getWeekFarmCnt(wfarm_status);
		System.out.println("cnt(진행중인 경매 갯수):" + cnt); // 먼저 테이블에 최소 30건 insert,

		pageNum = req.getParameter("pageNum");
		System.out.println("pageNum(페이지번호) : " + pageNum);

		if (pageNum == null) {
			pageNum = "1"; // 첫페이지를 1페이지로 설정
		}

		// 글 30건 기준
		currentPage = Integer.parseInt(pageNum); // 현재페이지 : 1
		System.out.println("currentPage(현재페이지)" + currentPage);

		// 딱떨어질경우 + 나미저의것. ex) 7 = (30/5) + (1)
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);

		// 1 =(1-1) * 5+1
		start = (currentPage - 1) * pageSize + 1; // 현재페이지 시작번호 1(페이지별)

		// 5 = 1 + 5- 1;
		end = start + pageSize - 1; // 현재페이지 끝번호 5

		System.out.println("start(현재페이지 시작글번호):" + start);
		System.out.println("end(현제페이지 끝글번호):" + end);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("start", start);
		map.put("end", end);
		map.put("wfarm_status", wfarm_status);

		if (end > cnt)
			end = cnt;

		// 경매상태(1:경매요청, 2:진행중, 3: 유찰, 4: 낙찰)

		// 30 = 30 (1 - 1) *5
		number = cnt - (currentPage - 1) * pageSize; // 출력용 글번호

		System.out.println("number(출력용 글번호)" + number);
		System.out.println("pageSize(한페이지당 출력될 글갯수)" + pageSize);

		if (cnt > 0) {
			// 주말농장 상태(1: 승인대기, 2: 승인)
			// 주말농장 요청현황(승인대기) 조회
			ArrayList<WeekFarmDTO> dtos = hostDao.getWeekFarmRequestList(map);
			model.addAttribute("dtos", dtos); // 큰바구니 게시글 목록 5건.
		}

		// 1 = (1/3) * 3+1
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;
		System.out.println("startPage(화살표 시작페이지):" + startPage);

		// 3 = 1+3 -1
		endPage = startPage + pageBlock - 1;
		if (endPage > pageCount)
			endPage = pageCount;
		System.out.println("endPage(화살표 마지막페이지):" + endPage);

		// 6단계. request나 session에 처리결과를 저장 (jsp에 전딜하기 위함)
		model.addAttribute("cnt", cnt); // 글갯수
		model.addAttribute("number", number); // 글번호
		model.addAttribute("pageNum", pageNum); // 페이지번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage);
		}
	}

	// 주말농장 현황 조회
	@Override
	public void getWeekFarmList(HttpServletRequest req, Model model) {
		System.out.print("=================2페이지======-----------=");
		// 3단계 . 화면으로부터 입력받은 값을 받아온다.
		// 경매 목록 관련
		int pageSize1 = 10; // 한페이지당 출력될 글 갯수
		int pageBlock1 = 3; // 페이지 블록을 3개씩. 앞뒤를 화살표로 이동

		int cnt1 = 0; // 글갯수
		int start1 = 0; // 현재페이지 시작 글번호
		int end1 = 0; // 현재 페이지 마지막 글번호
		int number1 = 0; // 출력용 글번호, 번호삭제가 되어도
		String pageNum1 = null; // 페이지번호
		int currentPage1 = 0; // 현재 페이지

		// 블록당 앞뒤 화살표에 필요한 부분
		int pageCount1 = 0; // 페이지 갯수
		int startPage1 = 0; // 시작페이지
		int endPage1 = 0; // 마지막 페이지

		// 경매상태(1:경매요청, 2:진행중, 3: 유찰, 4: 낙찰)
		int wfarm_status = (Integer) req.getAttribute("wfarm_status");

		// 5단계 경매갯수 구하기
		cnt1 = hostDao.getWeekFarmCnt(wfarm_status);
		System.out.println("cnt1(진행중인 경매 갯수):" + cnt1); // 먼저 테이블에 최소 30건 insert,

		pageNum1 = req.getParameter("pageNum");
		System.out.println("pageNum(페이지번호) : " + pageNum1);

		if (pageNum1 == null) {
			pageNum1 = "1"; // 첫페이지를 1페이지로 설정
		}

		// 글 30건 기준
		currentPage1 = Integer.parseInt(pageNum1); // 현재페이지 : 1
		System.out.println("currentPage1(현재페이지)" + currentPage1);

		// 딱떨어질경우 + 나미저의것. ex) 7 = (30/5) + (1)
		pageCount1 = (cnt1 / pageSize1) + (cnt1 % pageSize1 > 0 ? 1 : 0);

		// 1 =(1-1) * 5+1
		start1 = (currentPage1 - 1) * pageSize1 + 1; // 현재페이지 시작번호 1(페이지별)

		// 5 = 1 + 5- 1;
		end1 = start1 + pageSize1 - 1; // 현재페이지 끝번호 5

		System.out.println("start(현재페이지 시작글번호):" + start1);
		System.out.println("end(현제페이지 끝글번호):" + end1);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start1", start1);
		map.put("end1", end1);
		map.put("wfarm_status", wfarm_status);

		if (end1 > cnt1)
			end1 = cnt1;

		// 경매상태(1:경매요청, 2:진행중, 3: 유찰, 4: 낙찰)

		// 30 = 30 (1 - 1) *5
		number1 = cnt1 - (currentPage1 - 1) * pageSize1; // 출력용 글번호

		System.out.println("number1(출력용 글번호)" + number1);
		System.out.println("pageSize1(한페이지당 출력될 글갯수)" + pageSize1);

		if (cnt1 > 0) {
			// 주말농장 현황 조회
			ArrayList<WeekFarmDTO> dtos1 = hostDao.getWeekFarmList(map);
			model.addAttribute("dtos1", dtos1); // 큰바구니 게시글 목록 5건.

		}

		// 1 = (1/3) * 3+1
		startPage1 = (currentPage1 / pageBlock1) * pageBlock1 + 1;
		if (currentPage1 % pageBlock1 == 0)
			startPage1 -= pageBlock1;
		System.out.println("startPage1(화살표 시작페이지):" + startPage1);

		// 3 = 1+3 -1
		endPage1 = startPage1 + pageBlock1 - 1;
		if (endPage1 > pageCount1)
			endPage1 = pageCount1;
		System.out.println("endPage1(화살표 마지막페이지):" + endPage1);

		// 6단계. request나 session에 처리결과를 저장 (jsp에 전딜하기 위함)
		model.addAttribute("cnt1", cnt1); // 글갯수
		model.addAttribute("number1", number1); // 글번호
		model.addAttribute("pageNum1", pageNum1); // 페이지번호

		if (cnt1 > 0) {
			model.addAttribute("startPage1", startPage1); // 시작페이지
			model.addAttribute("endPage1", endPage1); // 마지막 페이지
			model.addAttribute("pageBlock1", pageBlock1); // 출력할 페이지 갯수
			model.addAttribute("pageCount1", pageCount1); // 페이지 갯수
			model.addAttribute("currentPage1", currentPage1);
		}

	}

	// 주말농장 요청승인
	@Override
	public void weekFarmReqPermit(HttpServletRequest req, Model model) {
		int wfarm_status = (Integer) req.getAttribute("wfarm_status");
		int wfarm_key = Integer.parseInt(req.getParameter("wfarm_key"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("wfarm_status", wfarm_status);
		map.put("wfarm_key", wfarm_key);

		int updateCnt = hostDao.weekFarmReqPermit(map);

		model.addAttribute("updateCnt", updateCnt);
	}

	// 주말농장 요청거부
	@Override
	public void weekFarmDelete(HttpServletRequest req, Model model) {
		int wfarm_key = Integer.parseInt(req.getParameter("wfarm_key"));

		int deleteCnt = hostDao.weekFarmDelete(wfarm_key);

		model.addAttribute("deleteCnt", deleteCnt);
	}

}
