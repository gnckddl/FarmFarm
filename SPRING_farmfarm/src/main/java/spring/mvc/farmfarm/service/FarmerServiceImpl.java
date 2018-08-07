package spring.mvc.farmfarm.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.farmfarm.dto.AdvantageDTO;
import spring.mvc.farmfarm.dto.AuctionDTO;
import spring.mvc.farmfarm.dto.AuctionListDTO;
import spring.mvc.farmfarm.dto.BoardDTO;
import spring.mvc.farmfarm.dto.FundDTO;
import spring.mvc.farmfarm.dto.FundListDTO;
import spring.mvc.farmfarm.dto.WeekFarmDTO;
import spring.mvc.farmfarm.persistence.FarmDAO;

@Service
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	FarmDAO dao;

	/**
	 * 장렬 1. 회원(쪽지)
	 */
	// 회원 - (농부에게)보낸 쪽지함 보기
	@Override
	public void LetterList(HttpServletRequest req, Model model) {

		// 게시판 관련
		int pageSize = 10; // 한 페이지당 출력할 글 갯수
		int pageBlock = 3; // 한 블럭당 페이지 갯수

		int cnt = 0; // 글 갯수
		int start = 0; // 현재 페이지 시작 글번호
		int end = 0; // 현재 페이지 마지막 글번호
		int number = 0; // 출력용 글번호
		String pageNum = null; // 페이지 번호
		int currentPage = 0; // 현재페이지

		int pageCount = 0; // 페이지 갯수
		int startPage = 0; // 시작 페이지
		int endPage = 0; // 마지막 페이지

		// 글갯수 구하기
		cnt = dao.getArtileCnt();
		System.out.println("cnt:" + cnt);// 먼저 테이블에 30건을 insert 할것

		pageNum = req.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1"; // 첫페이지를 1페이지로 설정

		}

		// 글 30건 기준
		currentPage = Integer.parseInt(pageNum);// 현재 페이지 : 1
		System.out.println("currentPage:" + currentPage);

		// 페이지 갯수 + 나머지있으면 1
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);

		start = (currentPage - 1) * pageSize + 1; // 현재 페이지 시작번호

		end = start + pageSize - 1;

		System.out.println("start :" + start);
		System.out.println("end :" + end);

		if (end > cnt)
			end = cnt;

		// 30 = 30 -(1 - 1) *5
		number = cnt - (currentPage - 1) * pageSize; // 출력용 글번호

		System.out.println("number :" + number);
		System.out.println("pageSize :" + pageSize);

		if (cnt > 0) {
			String userId = (String) req.getSession().getAttribute("userId");
			// 게시글 목록 조회
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			map.put("userId", userId);

			ArrayList<BoardDTO> dtos = dao.getArticleList(map);
			model.addAttribute("dtos", dtos);// 큰바구니 : 게시글 목록 넘김
		}

		// 1 = (1 / 3) * 3 + 1
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;
		System.out.println("startPage :" + startPage);

		// 3 = 1 + 3 - 1
		endPage = startPage + pageBlock - 1; // 마지막 페이지

		if (endPage > pageCount)
			endPage = pageCount;
		System.out.println("endPage :" + endPage);

		model.addAttribute("cnt", cnt); // 글갯수
		model.addAttribute("number", number); // 글번호
		model.addAttribute("pageNum", pageNum);// 페이지 번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작 페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage); // 현재 페이지

		}

		// 6단계,request나 session에 처리결과 넘기기

		model.addAttribute("cnt", cnt);

	}

	// 회원 - 받은 쪽지함
	@Override
	public void LetterGetList(HttpServletRequest req, Model model) {
		// 게시판 관련
		int pageSize = 10; // 한 페이지당 출력할 글 갯수
		int pageBlock = 3; // 한 블럭당 페이지 갯수

		int cnt = 0; // 글 갯수
		int start = 0; // 현재 페이지 시작 글번호
		int end = 0; // 현재 페이지 마지막 글번호
		int number = 0; // 출력용 글번호
		String pageNum = null; // 페이지 번호
		int currentPage = 0; // 현재페이지

		int pageCount = 0; // 페이지 갯수
		int startPage = 0; // 시작 페이지
		int endPage = 0; // 마지막 페이지

		// 글갯수 구하기
		cnt = dao.getArtileCnt();
		System.out.println("cnt:" + cnt);// 먼저 테이블에 30건을 insert 할것

		pageNum = req.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1"; // 첫페이지를 1페이지로 설정

		}

		// 글 30건 기준
		currentPage = Integer.parseInt(pageNum);// 현재 페이지 : 1
		System.out.println("currentPage:" + currentPage);

		// 페이지 갯수 + 나머지있으면 1
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);

		start = (currentPage - 1) * pageSize + 1; // 현재 페이지 시작번호

		end = start + pageSize - 1;

		System.out.println("start :" + start);
		System.out.println("end :" + end);

		if (end > cnt)
			end = cnt;

		// 30 = 30 -(1 - 1) *5
		number = cnt - (currentPage - 1) * pageSize; // 출력용 글번호

		System.out.println("number :" + number);
		System.out.println("pageSize :" + pageSize);

		if (cnt > 0) {
			String userId = (String) req.getSession().getAttribute("userId");
			// 게시글 목록 조회
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			map.put("userId", userId);

			ArrayList<BoardDTO> dtos = dao.LetterGetList(map);
			model.addAttribute("dtos", dtos);// 큰바구니 : 게시글 목록 넘김
		}

		// 1 = (1 / 3) * 3 + 1
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;
		System.out.println("startPage :" + startPage);

		// 3 = 1 + 3 - 1
		endPage = startPage + pageBlock - 1; // 마지막 페이지

		if (endPage > pageCount)
			endPage = pageCount;
		System.out.println("endPage :" + endPage);

		model.addAttribute("cnt", cnt); // 글갯수
		model.addAttribute("number", number); // 글번호
		model.addAttribute("pageNum", pageNum);// 페이지 번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작 페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage); // 현재 페이지

		}

		// 6단계,request나 session에 처리결과 넘기기

		model.addAttribute("cnt", cnt);

	}

	// 회원 - 쪽지함 상세 페이지 확인
	@Override
	public void LTContentsForm(HttpServletRequest req, Model model) {
		int boa_id = 0;
		int pageNum = 0;

		boa_id = Integer.parseInt(req.getParameter("boa_id"));
		pageNum = Integer.parseInt(req.getParameter("pageNum"));

		BoardDTO dto = dao.getArticle(boa_id);

		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);

	}

	// 회원 - 작성 한 쪽지 처리
	@Override
	public void LTWritePro(HttpServletRequest req, Model model) {
		// 화면으로부터 받아온 값을 처리
		int boa_id = 0;
		boa_id = Integer.parseInt(req.getParameter("boa_id"));
		BoardDTO dto = new BoardDTO();

		// 시퀀스 번호인 쪽지번호를 기준으로 화면에 전송
		dto.setBoa_id(boa_id);

		// 폼 전송 입력값 처리
		dto.setMem_id(req.getParameter("mem_id"));
		dto.setLetter_id(req.getParameter("letter_id"));
		dto.setBoa_subject(req.getParameter("boa_subject"));
		dto.setBoa_content(req.getParameter("boa_content"));

		Date from = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String to = transFormat.format(from);

		dto.setBoa_regDate(to);

		int insertCnt = dao.insertLetter(dto);

		// 완료된 세션 처리 컨트롤러로 전송
		model.addAttribute("insertCnt", insertCnt);
	}

	// 회원 - 쪽지 선택 삭제
	@Override
	public void LTDeletePro(HttpServletRequest req, Model model) {
		int deleteCnt = 0;
		Map<String, Object> map = new HashMap<String, Object>();

		String RowCheck = req.getParameter("result");
		String check[] = RowCheck.split(",");

		for (int i = 0; i < check.length; i++)
			System.out.println("check:" + check[i]);
		map.put("check", check);

		deleteCnt = dao.LTdelete(map);
		System.out.println(deleteCnt);
		model.addAttribute("deleteCnt", deleteCnt);
	}

	/**
	 * 장렬 2. 농부(쪽지)
	 */
	// 농부 - (회원에게)받은 쪽지함
	@Override
	public void LTFarmerletters(HttpServletRequest req, Model model) {
		// 게시판 관련
		int pageSize = 10; // 한 페이지당 출력할 글 갯수
		int pageBlock = 3; // 한 블럭당 페이지 갯수

		int cnt = 0; // 글 갯수
		int start = 0; // 현재 페이지 시작 글번호
		int end = 0; // 현재 페이지 마지막 글번호
		int number = 0; // 출력용 글번호
		String pageNum = null; // 페이지 번호
		int currentPage = 0; // 현재페이지

		int pageCount = 0; // 페이지 갯수
		int startPage = 0; // 시작 페이지
		int endPage = 0; // 마지막 페이지

		// 글갯수 구하기
		cnt = dao.getArtileCnt();
		System.out.println("cnt:" + cnt);// 먼저 테이블에 30건을 insert 할것

		pageNum = req.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1"; // 첫페이지를 1페이지로 설정

		}

		// 글 30건 기준
		currentPage = Integer.parseInt(pageNum);// 현재 페이지 : 1
		System.out.println("currentPage:" + currentPage);

		// 페이지 갯수 + 나머지있으면 1
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);

		start = (currentPage - 1) * pageSize + 1; // 현재 페이지 시작번호

		end = start + pageSize - 1;

		System.out.println("start :" + start);
		System.out.println("end :" + end);

		if (end > cnt)
			end = cnt;

		// 30 = 30 -(1 - 1) *5
		number = cnt - (currentPage - 1) * pageSize; // 출력용 글번호

		System.out.println("number :" + number);
		System.out.println("pageSize :" + pageSize);

		if (cnt > 0) {
			String userId = (String) req.getSession().getAttribute("userId");
			// 게시글 목록 조회
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			map.put("userId", userId);

			ArrayList<BoardDTO> dtos = dao.FarmersLetterReply(map);
			model.addAttribute("dtos", dtos);// 큰바구니 : 게시글 목록 넘김
		}

		// 1 = (1 / 3) * 3 + 1
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;
		System.out.println("startPage :" + startPage);

		// 3 = 1 + 3 - 1
		endPage = startPage + pageBlock - 1; // 마지막 페이지

		if (endPage > pageCount)
			endPage = pageCount;
		System.out.println("endPage :" + endPage);

		model.addAttribute("cnt", cnt); // 글갯수
		model.addAttribute("number", number); // 글번호
		model.addAttribute("pageNum", pageNum);// 페이지 번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작 페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage); // 현재 페이지

		}

		// 6단계,request나 session에 처리결과 넘기기

		model.addAttribute("cnt", cnt);

	}

	// 농부 - 회원 문의 쪽지 상세 페이지
	@Override
	public void LTFarmerContentsForm(HttpServletRequest req, Model model) {
		int boa_id = 0;
		int pageNum = 0;

		boa_id = Integer.parseInt(req.getParameter("boa_id"));
		pageNum = Integer.parseInt(req.getParameter("pageNum"));

		BoardDTO dto = dao.LTFarmerContentsForm(boa_id);

		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);

	}

	// 농부 - 회원문의 답변 처리
	@Override
	public void LTFarmerReplyPro(HttpServletRequest req, Model model) {
		// 화면으로부터 받아온 값을 처리
		int boa_id = 0;
		boa_id = Integer.parseInt(req.getParameter("boa_id"));
		BoardDTO dto = new BoardDTO();

		// 시퀀스 번호인 쪽지번호를 기준으로 화면에 전송
		dto.setBoa_id(boa_id);

		// 폼 전송 입력값 처리
		dto.setMem_id(req.getParameter("mem_id"));
		dto.setLetter_id(req.getParameter("letter_id"));
		dto.setBoa_subject(req.getParameter("boa_subject"));
		dto.setBoa_content(req.getParameter("boa_content"));

		Date from = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String to = transFormat.format(from);
		dto.setBoa_regDate(to);

		int insertCnt = dao.replyLetter(dto);

		// 완료된 세션 처리 컨트롤러로 전송
		model.addAttribute("insertCnt", insertCnt);
	}

	// 농부 - 답변 완료 목록
	@Override
	public void replyletters(HttpServletRequest req, Model model) {
		// 게시판 관련
		int pageSize = 10; // 한 페이지당 출력할 글 갯수
		int pageBlock = 3; // 한 블럭당 페이지 갯수

		int cnt = 0; // 글 갯수
		int start = 0; // 현재 페이지 시작 글번호
		int end = 0; // 현재 페이지 마지막 글번호
		int number = 0; // 출력용 글번호
		String pageNum = null; // 페이지 번호
		int currentPage = 0; // 현재페이지

		int pageCount = 0; // 페이지 갯수
		int startPage = 0; // 시작 페이지
		int endPage = 0; // 마지막 페이지

		// 글갯수 구하기
		cnt = dao.getArtileCnt();
		System.out.println("cnt:" + cnt);// 먼저 테이블에 30건을 insert 할것

		pageNum = req.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1"; // 첫페이지를 1페이지로 설정

		}

		// 글 30건 기준
		currentPage = Integer.parseInt(pageNum);// 현재 페이지 : 1
		System.out.println("currentPage:" + currentPage);

		// 페이지 갯수 + 나머지있으면 1
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);

		start = (currentPage - 1) * pageSize + 1; // 현재 페이지 시작번호

		end = start + pageSize - 1;

		System.out.println("start :" + start);
		System.out.println("end :" + end);

		if (end > cnt)
			end = cnt;

		// 30 = 30 -(1 - 1) *5
		number = cnt - (currentPage - 1) * pageSize; // 출력용 글번호

		System.out.println("number :" + number);
		System.out.println("pageSize :" + pageSize);

		if (cnt > 0) {
			String userId = (String) req.getSession().getAttribute("userId");
			// 게시글 목록 조회
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			map.put("userId", userId);

			ArrayList<BoardDTO> dtos = dao.replyletters(map);
			model.addAttribute("dtos", dtos);// 큰바구니 : 게시글 목록 넘김
		}

		// 1 = (1 / 3) * 3 + 1
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;
		System.out.println("startPage :" + startPage);

		// 3 = 1 + 3 - 1
		endPage = startPage + pageBlock - 1; // 마지막 페이지

		if (endPage > pageCount)
			endPage = pageCount;
		System.out.println("endPage :" + endPage);

		model.addAttribute("cnt", cnt); // 글갯수
		model.addAttribute("number", number); // 글번호
		model.addAttribute("pageNum", pageNum);// 페이지 번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작 페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage); // 현재 페이지

		}

		// 6단계,request나 session에 처리결과 넘기기

		model.addAttribute("cnt", cnt);

	}

	/**
	 * 장렬 03.농부 (주말농장)
	 */
	// 농부 - 주말농장 신청 처리
	@Override
	public void ChooseFarmPro(HttpServletRequest req, Model model) {
		String userId = (String) req.getSession().getAttribute("userId");
		int wfarm_status = 0;
		int wfarminfo_price = 0;

		wfarm_status = Integer.parseInt(req.getParameter("wfarm_status"));
		wfarminfo_price = Integer.parseInt(req.getParameter("wfarminfo_price"));

		WeekFarmDTO dto = new WeekFarmDTO();

		dto.setWfarm_status(wfarm_status);
		dto.setMem_id(req.getParameter("mem_id"));
		dto.setWfarminfo_title(req.getParameter("wfarminfo_title"));
		dto.setWfarminfo_price(wfarminfo_price);

		// 농장 주소 입력 처리
		String wfarminfo_add = "";
		String add1 = req.getParameter("add1");
		String add2 = req.getParameter("add2");
		wfarminfo_add = add1 + add2;
		dto.setWfarminfo_add(wfarminfo_add);

		int insertCnt = dao.insertyard(dto);
		req.setAttribute("insertCnt", insertCnt);
	}

	// 농부 - 주말농장 신청 완료
	@Override
	public void ConfirmWeekFarm(HttpServletRequest req, Model model) {

		// 게시판 관련
		int pageSize = 10; // 한 페이지당 출력할 글 갯수
		int pageBlock = 3; // 한 블럭당 페이지 갯수

		int cnt = 0; // 글 갯수
		int start = 0; // 현재 페이지 시작 글번호
		int end = 0; // 현재 페이지 마지막 글번호
		int number = 0; // 출력용 글번호
		String pageNum = null; // 페이지 번호
		int currentPage = 0; // 현재페이지

		int pageCount = 0; // 페이지 갯수
		int startPage = 0; // 시작 페이지
		int endPage = 0; // 마지막 페이지

		// 글갯수 구하기
		cnt = dao.getWeekCnt();
		System.out.println("cnt:" + cnt);// 먼저 테이블에 30건을 insert 할것

		pageNum = req.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1"; // 첫페이지를 1페이지로 설정

		}

		// 글 30건 기준
		currentPage = Integer.parseInt(pageNum);// 현재 페이지 : 1
		System.out.println("currentPage:" + currentPage);

		// 페이지 갯수 + 나머지있으면 1
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);

		start = (currentPage - 1) * pageSize + 1; // 현재 페이지 시작번호

		end = start + pageSize - 1;

		System.out.println("start :" + start);
		System.out.println("end :" + end);

		if (end > cnt)
			end = cnt;

		// 30 = 30 -(1 - 1) *5
		number = cnt - (currentPage - 1) * pageSize; // 출력용 글번호

		System.out.println("number :" + number);
		System.out.println("pageSize :" + pageSize);

		if (cnt > 0) {
			String userId = (String) req.getSession().getAttribute("userId");
			// 게시글 목록 조회
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			map.put("userId", userId);

			ArrayList<WeekFarmDTO> dtos = dao.getArticleWeekFarms(map);
			model.addAttribute("dtos", dtos);// 큰바구니 : 게시글 목록 넘김
		}

		// 1 = (1 / 3) * 3 + 1
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;
		System.out.println("startPage :" + startPage);

		// 3 = 1 + 3 - 1
		endPage = startPage + pageBlock - 1; // 마지막 페이지

		if (endPage > pageCount)
			endPage = pageCount;
		System.out.println("endPage :" + endPage);

		model.addAttribute("cnt", cnt); // 글갯수
		model.addAttribute("number", number); // 글번호
		model.addAttribute("pageNum", pageNum);// 페이지 번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작 페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage); // 현재 페이지

		}

		// 6단계,request나 session에 처리결과 넘기기

		model.addAttribute("cnt", cnt);
	}

	/**
	 * 장렬 04. 주말농장 신청
	 */
	// 회원 - 주말농장 신청 현황
	@Override
	public void CustomerWeeklyFarmlist(HttpServletRequest req, Model model) {
		// 게시판 관련
		int pageSize = 10; // 한 페이지당 출력할 글 갯수
		int pageBlock = 3; // 한 블럭당 페이지 갯수

		int cnt = 0; // 글 갯수
		int start = 0; // 현재 페이지 시작 글번호
		int end = 0; // 현재 페이지 마지막 글번호
		int number = 0; // 출력용 글번호
		String pageNum = null; // 페이지 번호
		int currentPage = 0; // 현재페이지

		int pageCount = 0; // 페이지 갯수
		int startPage = 0; // 시작 페이지
		int endPage = 0; // 마지막 페이지

		// 글갯수 구하기
		cnt = dao.getWeekCnt();
		System.out.println("cnt:" + cnt);// 먼저 테이블에 30건을 insert 할것

		pageNum = req.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1"; // 첫페이지를 1페이지로 설정

		}

		// 글 30건 기준
		currentPage = Integer.parseInt(pageNum);// 현재 페이지 : 1
		System.out.println("currentPage:" + currentPage);

		// 페이지 갯수 + 나머지있으면 1
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);

		start = (currentPage - 1) * pageSize + 1; // 현재 페이지 시작번호

		end = start + pageSize - 1;

		System.out.println("start :" + start);
		System.out.println("end :" + end);

		if (end > cnt)
			end = cnt;

		// 30 = 30 -(1 - 1) *5
		number = cnt - (currentPage - 1) * pageSize; // 출력용 글번호

		System.out.println("number :" + number);
		System.out.println("pageSize :" + pageSize);

		if (cnt > 0) {
			String userId = (String) req.getSession().getAttribute("userId");
			// 게시글 목록 조회
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			map.put("userId", userId);

			ArrayList<WeekFarmDTO> dtos = dao.CustomerWeeklyFarmlist(map);
			model.addAttribute("dtos", dtos);// 큰바구니 : 게시글 목록 넘김
		}

		// 1 = (1 / 3) * 3 + 1
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;
		System.out.println("startPage :" + startPage);

		// 3 = 1 + 3 - 1
		endPage = startPage + pageBlock - 1; // 마지막 페이지

		if (endPage > pageCount)
			endPage = pageCount;
		System.out.println("endPage :" + endPage);

		model.addAttribute("cnt", cnt); // 글갯수
		model.addAttribute("number", number); // 글번호
		model.addAttribute("pageNum", pageNum);// 페이지 번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작 페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage); // 현재 페이지

		}

		// 6단계,request나 session에 처리결과 넘기기
		model.addAttribute("cnt", cnt);

	}

	/**
	 * 장렬 05. 농부(농부점수)
	 */
	// 농부 - 농부가 받은 포인트
	@Override
	public void FarmerScore(HttpServletRequest req, Model model) {
		String mem_id = (String) req.getSession().getAttribute("userId");

		//////////////////////////////
		// 게시판 관련
		int pageSize = 10; // 한 페이지당 출력할 글 갯수
		int pageBlock = 3; // 한 블럭당 페이지 갯수

		int cnt = 0; // 글 갯수
		int start = 0; // 현재 페이지 시작 글번호
		int end = 0; // 현재 페이지 마지막 글번호
		int number = 0; // 출력용 글번호
		String pageNum = null; // 페이지 번호
		int currentPage = 0; // 현재페이지

		int pageCount = 0; // 페이지 갯수
		int startPage = 0; // 시작 페이지
		int endPage = 0; // 마지막 페이지

		int sumPoint = 0; // 총 점수

		cnt = dao.getFarmerAdvCnt(mem_id);
		System.out.println("cnt:" + cnt);// 먼저 테이블에 30건을 insert 할것

		pageNum = req.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1"; // 첫페이지를 1페이지로 설정

		}

		// 글 30건 기준
		currentPage = Integer.parseInt(pageNum);// 현재 페이지 : 1
		System.out.println("currentPage:" + currentPage);

		// 페이지 갯수 + 나머지있으면 1
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);

		start = (currentPage - 1) * pageSize + 1; // 현재 페이지 시작번호

		end = start + pageSize - 1;

		System.out.println("start :" + start);
		System.out.println("end :" + end);

		if (end > cnt)
			end = cnt;

		// 30 = 30 -(1 - 1) *5
		number = cnt - (currentPage - 1) * pageSize; // 출력용 글번호

		System.out.println("number :" + number);
		System.out.println("pageSize :" + pageSize);

		if (cnt > 0) {
			// 게시글 목록 조회
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			map.put("strId", mem_id);
			ArrayList<AdvantageDTO> dtos = dao.getFarmerAvg(map);
			model.addAttribute("dtos", dtos);// 큰바구니 : 게시글 목록 넘김

			sumPoint = dtos.get(0).getMem_adv();
			model.addAttribute("sumPoint", sumPoint);
		}

		// 1 = (1 / 3) * 3 + 1
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;
		System.out.println("startPage :" + startPage);

		// 3 = 1 + 3 - 1
		endPage = startPage + pageBlock - 1; // 마지막 페이지

		if (endPage > pageCount)
			endPage = pageCount;
		System.out.println("endPage :" + endPage);

		model.addAttribute("cnt", cnt); // 글갯수
		model.addAttribute("number", number); // 글번호
		model.addAttribute("pageNum", pageNum);// 페이지 번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작 페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage); // 현재 페이지
		}

		// 6단계,request나 session에 처리결과 넘기기

		model.addAttribute("cnt", cnt);
	}

	/**
	 * 민웅
	 */
	/**
	 * 민웅
	 */
	// 경매 상품 등록 - 처리
	@Override
	public void Auction_ApplyPro(MultipartHttpServletRequest req, Model model) {
		int Cnt = 0;
		MultipartFile file = req.getFile("stock_image");
		String saveDir = req.getRealPath("/resources/images/auction/"); // 업로드할 파일이 위치하게될 실제 경로
		String realDir = "C:\\Users\\gnckd\\git2\\farmfarm\\SPRING_farmfarm\\src\\main\\webapp\\resources\\images\\auction\\";
		// String
		// realDir="C:\\Dev36\\workspace_pams\\FarmFarm\\SPRING_farmfarm\\src\\main\\webapp\\resources\\images\\farmer";
		// // 저장 경로
		System.out.println(saveDir);
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
			String stock_name = req.getParameter("stock_name");
			String stock_detail = req.getParameter("stock_detail");
			int stock_kg = Integer.parseInt(req.getParameter("stock_kg"));
			int stock_ea = Integer.parseInt(req.getParameter("stock_ea"));
			int stock_price = Integer.parseInt(req.getParameter("stock_price"));
			int sInfo_kind = Integer.parseInt(req.getParameter("stock_kind"));
			int stock_regDate = Integer.parseInt(req.getParameter("stock_regDate"));
			String auc_term2 = req.getParameter("auc_term");

			Date auc_term = new SimpleDateFormat("yyyy-MM-dd").parse(auc_term2);

			String fileName = file.getOriginalFilename();
			int farmkey;
			String userId = (String) req.getSession().getAttribute("userId");
			farmkey = dao.getFarmKey(userId);
			System.out.println(farmkey);
			AuctionDTO dto = new AuctionDTO();
			dto.setStock_name(stock_name);
			dto.setStock_detail(stock_detail);
			dto.setStock_kg(stock_kg);
			dto.setStock_ea(stock_ea);
			dto.setStock_price(stock_price);
			dto.setStock_kind(sInfo_kind);
			dto.setStock_image(fileName);
			dto.setAuc_endDate(auc_term);
			dto.setFarm_key(farmkey);
			dto.setStock_regDate(stock_regDate);

			Cnt = dao.auctionUpdate(dto);
			model.addAttribute("cnt", Cnt);

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	// 경매 상품 현황 및 이전내역
	@Override
	public void Auction_status(HttpServletRequest req, Model model) {
		int cnt = 0;
		int farmkey = 0;
		int result = 0;
		int pageSize = 5; // 한 페이지당 출력할 글 갯수
		int pageBlock = 3; // 한 블럭당 페이지 갯수
		int start = 0; // 현재페이지 시작 글번호
		int end = 0; // 현재페이지 마지막 글번호
		int number = 0; // 출력용 글번호
		String pageNum = null; // 페이지 번호
		int currentPage = 0; // 현재 페이지
		int pageCount = 0; // 페이지 갯수
		int startPage = 0; // 시작 페이지
		int endPage = 0; // 마지막 페이지
		int oldCnt = 0;
		int newCnt = 0;

		// 5단계. 글 갯수 구하기
		cnt = dao.getAuctionCnt();
		System.out.println("cnt : " + cnt); // 먼저 테이블에 30건을 insert 할것

		pageNum = req.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1"; // 첫페이지를 1페이지로 설정
		}

		// 글 30건 기준
		currentPage = Integer.parseInt(pageNum); // 현재 페이지 : 1
		System.out.println("currentPage : " + currentPage);

		// 페이지 갯수 6 = (30 / 5) + (0)
		pageCount = (cnt / pageSize) + ((cnt % pageSize) > 0 ? 1 : 0); // 페이지 갯수 + 나머지

		// 1 = ( 1- 1) * 5 + 1
		start = (currentPage - 1) * pageSize + 1; // 현재 페이지 시작번호

		// 5 = 1 + 5 - 1;
		end = start + pageSize - 1;

		// 6단계 . request나 session에 처리 결과를 저장 - jsp로 글 개수 넘겨주기
		System.out.println("end :" + end);

		if (end > cnt)
			end = cnt;

		number = cnt - (currentPage - 1) * pageSize; // 출력용 글 번호

		System.out.println("number : " + number);
		System.out.println("pageSize : " + pageSize);

		if (cnt > 0) {
			String userId = (String) req.getSession().getAttribute("userId");
			System.out.println(userId);
			farmkey = dao.getFarmKey(userId);
			ArrayList<AuctionListDTO> dtos = dao.auctionList(farmkey);
			ArrayList<AuctionListDTO> oldDtos = new ArrayList<>();
			ArrayList<AuctionListDTO> newDtos = new ArrayList<>();

			// SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd
			// HH:mm", Locale.KOREA );
			Date currentTime = new Date();

			for (int i = 0; i < dtos.size(); i++) {

				result = currentTime.compareTo(dtos.get(i).getAuc_endDate());
				if (result > 0) {
					oldDtos.add(dtos.get(i));
					System.out.println("for.dtos>>" + i);
					oldCnt++;

				} else {
					newDtos.add(dtos.get(i));
					System.out.println("for.dtos<<" + i);
					newCnt++;
				}

			}

			if (dtos.size() != 0) {
				System.out.println("dtos : " + dtos.get(0).getAuc_title());
				// model.addAttribute("dtos", dtos);
				model.addAttribute("oldDtos", oldDtos);
				model.addAttribute("newDtos", newDtos);
				model.addAttribute("oldCnt", oldCnt);
				model.addAttribute("newCnt", newCnt);
			}
		}

		// 1 = (1 / 3) * 3 + 1
		startPage = (currentPage / pageBlock) * pageBlock + 1; // 시작페이지
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;
		System.out.println("startPage : " + startPage);

		// 3 = 1 + 3 - 1
		endPage = startPage + pageBlock - 1; // 마지막 페이지
		if (endPage > pageCount)
			endPage = pageCount;
		System.out.println("endPage : " + endPage);

		model.addAttribute("cnt", cnt); // 글갯수
		model.addAttribute("number", number); // 글번호
		model.addAttribute("pageNum", pageNum); // 페이지번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작페이지
			model.addAttribute("endPage", endPage); // 마지막페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage); // 현재 페이지
		}

	}

	// 펀드 신청 - 처리
	@Override
	public void Fund_ApplyPro(MultipartHttpServletRequest req, Model model) {
		int Cnt = 0;
		MultipartFile file = req.getFile("stock_image");
		String saveDir = req.getRealPath("/resources/images/fund/"); // 업로드할 파일이 위치하게될 실제 경로
		String realDir = "C:\\Users\\gnckd\\git2\\farmfarm\\SPRING_farmfarm\\src\\main\\webapp\\resources\\images\\fund\\";
		// String
		// realDir="C:\\Dev36\\workspace_pams\\FarmFarm\\SPRING_farmfarm\\src\\main\\webapp\\resources\\images\\fund";
		// // 저장 경로
		System.out.println(saveDir);
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
			String fund_title = req.getParameter("fund_title");
			String stock_name = req.getParameter("stock_name");
			String stock_detail = req.getParameter("stock_detail");
			int stock_kg = Integer.parseInt(req.getParameter("stock_kg"));
			int stock_ea = Integer.parseInt(req.getParameter("stock_ea"));
			int stock_price = Integer.parseInt(req.getParameter("stock_price"));
			int fund_price = Integer.parseInt(req.getParameter("fund_price"));
			int sInfo_kind = Integer.parseInt(req.getParameter("stock_kind"));
			int stock_regDate = Integer.parseInt(req.getParameter("stock_regDate"));
			String fund_endDate2 = req.getParameter("fund_endDate");

			// Date fund_endDate = new SimpleDateFormat("yyyy-MM-dd").parse(fund_endDate2);

			String fileName = file.getOriginalFilename();
			int farmkey;
			String userId = (String) req.getSession().getAttribute("userId");
			farmkey = dao.getFarmKey(userId);
			System.out.println(farmkey);
			FundDTO dto = new FundDTO();
			dto.setFund_title(fund_title);
			dto.setStock_name(stock_name);
			dto.setStock_detail(stock_detail);
			dto.setStock_kg(stock_kg);
			dto.setStock_ea(stock_ea);
			dto.setStock_price(stock_price);
			dto.setFund_price(fund_price);
			dto.setStock_kind(sInfo_kind);
			dto.setStock_image(fileName);
			dto.setStock_regDate(stock_regDate);

			dto.setFund_endDate(fund_endDate2);
			dto.setFarm_key(farmkey);

			Cnt = dao.fundUpdate(dto);
			System.out.println("dto : " + dto);
			model.addAttribute("cnt", Cnt);
			System.out.println("cnt : " + Cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 펀드 상품 현황 및 이전내역
	@Override
	public void Fund_status(HttpServletRequest req, Model model) {
		int cnt = 0;
		int farmkey = 0;
		int result = 0;
		int pageSize = 5; // 한 페이지당 출력할 글 갯수
		int pageBlock = 3; // 한 블럭당 페이지 갯수
		int start = 0; // 현재페이지 시작 글번호
		int end = 0; // 현재페이지 마지막 글번호
		int number = 0; // 출력용 글번호
		String pageNum = null; // 페이지 번호
		int currentPage = 0; // 현재 페이지
		int pageCount = 0; // 페이지 갯수
		int startPage = 0; // 시작 페이지
		int endPage = 0; // 마지막 페이지
		int oldCnt = 0;
		int newCnt = 0;

		// 5단계. 글 갯수 구하기
		cnt = dao.getfundCnt();
		System.out.println("cnt : " + cnt); // 먼저 테이블에 30건을 insert 할것

		pageNum = req.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1"; // 첫페이지를 1페이지로 설정
		}

		// 글 30건 기준
		currentPage = Integer.parseInt(pageNum); // 현재 페이지 : 1
		System.out.println("currentPage : " + currentPage);

		// 페이지 갯수 6 = (30 / 5) + (0)
		pageCount = (cnt / pageSize) + ((cnt % pageSize) > 0 ? 1 : 0); // 페이지 갯수 + 나머지

		// 1 = ( 1- 1) * 5 + 1
		start = (currentPage - 1) * pageSize + 1; // 현재 페이지 시작번호

		// 5 = 1 + 5 - 1;
		end = start + pageSize - 1;

		// 6단계 . request나 session에 처리 결과를 저장 - jsp로 글 개수 넘겨주기
		System.out.println("end :" + end);

		if (end > cnt)
			end = cnt;

		number = cnt - (currentPage - 1) * pageSize; // 출력용 글 번호

		System.out.println("number : " + number);
		System.out.println("pageSize : " + pageSize);

		if (cnt > 0) {
			String userId = (String) req.getSession().getAttribute("userId");
			System.out.println(userId);
			farmkey = dao.getFarmKey(userId);
			ArrayList<FundListDTO> dtos = dao.fundList(farmkey);
			ArrayList<FundListDTO> oldDtos = new ArrayList<FundListDTO>();
			ArrayList<FundListDTO> newDtos = new ArrayList<FundListDTO>();

			SimpleDateFormat mdSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.KOREA);
			Date currentTime = new Date();

			for (int i = 0; i < dtos.size(); i++) {

				result = currentTime.compareTo(dtos.get(i).getFund_endDate());
				if (result > 0) {
					oldDtos.add(dtos.get(i));
					System.out.println("for.dtos>>" + i);
					oldCnt++;

				} else {
					newDtos.add(dtos.get(i));
					System.out.println("for.dtos<<" + i);
					newCnt++;
				}

			}

			if (dtos.size() != 0) {
				// model.addAttribute("dtos", dtos);
				model.addAttribute("oldDtos", oldDtos);
				model.addAttribute("newDtos", newDtos);
				model.addAttribute("oldCnt", oldCnt);
				model.addAttribute("newCnt", newCnt);
			}
		}

		// 1 = (1 / 3) * 3 + 1
		startPage = (currentPage / pageBlock) * pageBlock + 1; // 시작페이지
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;
		System.out.println("startPage : " + startPage);

		// 3 = 1 + 3 - 1
		endPage = startPage + pageBlock - 1; // 마지막 페이지
		if (endPage > pageCount)
			endPage = pageCount;
		System.out.println("endPage : " + endPage);

		model.addAttribute("cnt", cnt); // 글갯수
		model.addAttribute("number", number); // 글번호
		model.addAttribute("pageNum", pageNum); // 페이지번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작페이지
			model.addAttribute("endPage", endPage); // 마지막페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage); // 현재 페이지
		}
	}

	
}
