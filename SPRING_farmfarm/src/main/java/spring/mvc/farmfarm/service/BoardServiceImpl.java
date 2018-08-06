package spring.mvc.farmfarm.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.farmfarm.dto.BoardDTO;
import spring.mvc.farmfarm.dto.CommentDTO;
import spring.mvc.farmfarm.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO board_dao;

	@Override
	public void boardList(HttpServletRequest req, Model model) {
		// 3단계, 화면으로부터 입력받은 값을 받아온다.

		// 게시판 관련
		int pageSize = 5; // 한 페이지당 출력할 글 갯수
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
		int boa_category = 0;
		boa_category = Integer.parseInt(req.getParameter("boa_category"));
		System.out.println("뽀아카테꼬리_----_--:" + boa_category);
		cnt = board_dao.getArtileCnt(boa_category);
		System.out.println("뽀아카테꼬리_----_--!!!!:" + boa_category);

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
			map.put("boa_category", boa_category);
			System.out.println("뽀아카테꼬리_----_--#######:" + boa_category);
			ArrayList<BoardDTO> dtos = board_dao.getArticleList(map);
			for (int i = 0; i < dtos.size(); i++) {
				dtos.get(i).setCm_cnt(board_dao.RequestCommentCnt(dtos.get(i).getBoa_id()));
			}

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
		model.addAttribute("boa_category", boa_category);
	}

	@Override
	public void RequestBoardContent(HttpServletRequest req, Model model) {
		int boa_id = 0;
		int pageNum = 0;
		int number = 0;
		int cnt = 0;
		int boa_category = 0;
		boa_id = Integer.parseInt(req.getParameter("boa_id"));
		pageNum = Integer.parseInt(req.getParameter("pageNum"));
		number = Integer.parseInt(req.getParameter("number"));
		boa_category = Integer.parseInt(req.getParameter("boa_category"));
		System.out.println("보아아잉디~~~~~~~~~~~~" + boa_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boa_id", boa_id);
		map.put("boa_category", boa_category);
		BoardDTO dto = new BoardDTO();
		dto = board_dao.getArticleBoard(map);
		System.out.println("보아아잉디~~~~~~~~~~~~~~~~~~~%%%%%%%" + boa_id);
		// 조회수 증가
		board_dao.addReadCnt(map);

		cnt = board_dao.RequestCommentCnt(boa_id);
		if (cnt > 0) {

			ArrayList<CommentDTO> dtos = board_dao.RequestComment(boa_id);
			model.addAttribute("dtos", dtos);
		}
		// 상세페이지 조회
		System.out.println("tjkasdfCNT" + cnt);
		model.addAttribute("cnt", cnt);
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("number", number);
		model.addAttribute("boa_id", boa_id);
		model.addAttribute("boa_category", boa_category);
		System.out.println("보아아잉디~~~~~~~~~~~~!!!!!!!!!!" + boa_id);

	}

	@Override
	public void RequestBoardWritePro(HttpServletRequest req, Model model) {
		// 화면(hidden)으로부터 입력받은 값을 받아온다.
		int boa_category = 0;
		int pageNum = 0;

		boa_category = Integer.parseInt(req.getParameter("boa_category"));
		pageNum = Integer.parseInt(req.getParameter("pageNum"));
		System.out.println("boa_카테고링~~~~~~~~" + boa_category);
		// 바구니 생성

		BoardDTO dto = new BoardDTO();

		// hidden으로 부터 넘어온 값 받기.
		// 화면입력값받기
		dto.setMem_id((String) req.getSession().getAttribute("userId"));
		dto.setBoa_subject(req.getParameter("boa_subject"));
		dto.setBoa_content(req.getParameter("boa_content"));
		dto.setBoa_ip("5");
		dto.setBoa_category(boa_category);

		// 글작성/답글처리페이지
		int insertCnt = board_dao.farminsertBoard(dto);

		// request나session에 처리 결과를 저장(jsp로 전달하기 위함)
		model.addAttribute("insertCnt", insertCnt);
		model.addAttribute("boa_category", boa_category);
		model.addAttribute("pageNum", pageNum);
	}

	@Override
	public void commentBoardWritePro(HttpServletRequest req, Model model) {

		int boa_id = 0;
		int pageNum = 0;
		int number = 0;
		int boa_category = 0;

		boa_category = Integer.parseInt(req.getParameter("boa_category"));
		boa_id = Integer.parseInt(req.getParameter("boa_id"));
		pageNum = Integer.parseInt(req.getParameter("pageNum"));
		number = Integer.parseInt(req.getParameter("number"));
		CommentDTO dto = new CommentDTO();

		dto.setBoa_id(Integer.parseInt(req.getParameter("boa_id")));
		dto.setMem_id((String) req.getSession().getAttribute("userId"));
		dto.setCm_content(req.getParameter("cm_content"));
		int insertCnt = board_dao.commentBoardWirtePro(dto);

		req.setAttribute("insertCnt", insertCnt);
		model.addAttribute("boa_id", boa_id);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("number", number);
		model.addAttribute("boa_category", boa_category);

	}

	@Override
	public void modifyView(HttpServletRequest req, Model model) {
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int number = Integer.parseInt(req.getParameter("number"));
		int boa_id = Integer.parseInt(req.getParameter("boa_id"));
		System.out.println("남바~~~~~!~~~~~!!@#~!!@#" + number);
		int boa_category = Integer.parseInt(req.getParameter("boa_category"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boa_id", boa_id);
		map.put("boa_category", boa_category);

		BoardDTO dto = board_dao.getArticleBoard(map);

		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("number", number);
		model.addAttribute("boa_id", boa_id);
		model.addAttribute("boa_category", boa_category);
	}

	@Override
	public void modifyProBoard(HttpServletRequest req, Model model) {
		String boa_subject = req.getParameter("boa_subject");
		String boa_content = req.getParameter("boa_content");
		int number = Integer.parseInt(req.getParameter("number"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int boa_category = Integer.parseInt(req.getParameter("boa_category"));
		int boa_id = Integer.parseInt(req.getParameter("boa_id"));
		System.out.println("뽀아아이디~~~~~~~~~~~~~~~^^^^^^^^^^" + boa_id);

		BoardDTO dto = new BoardDTO();
		dto.setBoa_subject(boa_subject);
		dto.setBoa_content(boa_content);
		dto.setBoa_id(boa_id);
		int updateCnt = board_dao.updateBoard(dto);
		System.out.println("업뎃띠엔띠:" + updateCnt);

		model.addAttribute("updateCnt", updateCnt);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("boa_id", boa_id);
		model.addAttribute("boa_category", boa_category);
	}

	@Override
	public void commentModifyPopPro(HttpServletRequest req, Model model) {

		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int number = Integer.parseInt(req.getParameter("number"));
		int boa_id = Integer.parseInt(req.getParameter("boa_id"));
		int boa_category = Integer.parseInt(req.getParameter("boa_category"));
		String cm_content = req.getParameter("cm_content");
		int cm_no = Integer.parseInt(req.getParameter("cm_no"));

		CommentDTO dto = new CommentDTO();
		dto.setCm_content(cm_content);
		dto.setCm_no(cm_no);

		int updateCnt = board_dao.commentUpdate(dto);
		model.addAttribute("updateCnt", updateCnt);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("number", number);
		model.addAttribute("boa_id", boa_id);
		model.addAttribute("boa_category", boa_category);

	}

	@Override
	public void deleteBoardPro(HttpServletRequest req, Model model) {
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int number = Integer.parseInt(req.getParameter("number"));
		int boa_id = Integer.parseInt(req.getParameter("boa_id"));
		int boa_category = Integer.parseInt(req.getParameter("boa_category"));

		int deleteCnt = board_dao.deleteBoard(boa_id);

		model.addAttribute("deleteCnt", deleteCnt);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("number", number);
		model.addAttribute("boa_id", boa_id);
		model.addAttribute("boa_category", boa_category);
	}

	@Override
	public void commentDeletePro(HttpServletRequest req, Model model) {
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int number = Integer.parseInt(req.getParameter("number"));
		int cm_no = Integer.parseInt(req.getParameter("cm_no"));
		int boa_id = Integer.parseInt(req.getParameter("boa_id"));
		int boa_category = Integer.parseInt(req.getParameter("boa_category"));

		int deleteCnt = board_dao.deleteComment(cm_no);

		model.addAttribute("deleteCnt", deleteCnt);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("number", number);
		model.addAttribute("cm_no", cm_no);
		model.addAttribute("boa_id", boa_id);
		model.addAttribute("boa_category", boa_category);
	}

	@Override
	public void newsList(HttpServletRequest req, Model model) {

		int pageSize = 5; // 한 페이지당 출력할 글의 개수
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
		int boa_category = Integer.parseInt(req.getParameter("boa_category"));

		System.out.println("카텡공링" + boa_category);
		cnt = board_dao.getNewsCnt(boa_category); // 글 개수 구하기
		System.out.println("씨엔티이이이이이" + cnt);
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
			map.put("boa_category", boa_category);
			ArrayList<BoardDTO> dtos = board_dao.getNewsList(map);
			System.out.println("씨엔티이이이이이$$$$$$" + cnt);
			// 큰 바구니 : 게시글 목록
			// -> cf)작은 바구니 : 게시글 1건
			model.addAttribute("dtos", dtos);
			model.addAttribute("cnt", cnt);

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
		model.addAttribute("boa_category", boa_category);
		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작 페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage); // 현재 페이지

		}
	}

	@Override
	public void NewsBoardWritePro(MultipartHttpServletRequest req, Model model) {
		MultipartFile file = req.getFile("boa_image");

		String saveDir = req.getRealPath("/resources/images/board/"); // 업로드할 파일이 위치하게될 실제 경로
		String realDir = "C:\\Users\\gnckd\\git2\\farmfarm\\SPRING_farmfarm\\src\\main\\webapp\\resources\\images\\board\\";
		//String realDir = "C:\\Dev36\\Dev36\\workspace_farmfarmback\\FarmFarm\\SPRING_farmfarm\\src\\main\\webapp\\resources\\images\\";
		

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

			int pageNum = Integer.parseInt(req.getParameter("pageNum"));
			int boa_category = Integer.parseInt(req.getParameter("boa_category"));
			String fileName = file.getOriginalFilename();
			String boa_subject = req.getParameter("boa_subject");
			String boa_content = req.getParameter("boa_content");

			BoardDTO dto = new BoardDTO();
			dto.setMem_id((String) req.getSession().getAttribute("userId"));
			dto.setBoa_category(boa_category);
			dto.setBoa_image(fileName);
			dto.setBoa_subject(boa_subject);
			dto.setBoa_content(boa_content);
			dto.setBoa_ip("5");

			int insertCnt = board_dao.NewsWritePro(dto);
			model.addAttribute("insertCnt", insertCnt);
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("boa_category", boa_category);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void NewsBoardContent(HttpServletRequest req, Model model) {
		int boa_id = 0;
		int pageNum = 0;
		int number = 0;
		int cnt = 0;
		int boa_category = 0;

		boa_id = Integer.parseInt(req.getParameter("boa_id"));
		pageNum = Integer.parseInt(req.getParameter("pageNum"));
		number = Integer.parseInt(req.getParameter("number"));
		boa_category = Integer.parseInt(req.getParameter("boa_category"));
		System.out.println("보아아잉디~~~~~~~~~~~~" + boa_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boa_id", boa_id);
		map.put("boa_category", boa_category);
		BoardDTO dto = new BoardDTO();
		dto = board_dao.getArticleBoard(map);
		System.out.println("보아아잉디~~~~~~~~~~~~~~~~~~~%%%%%%%" + boa_id);
		// 조회수 증가
		board_dao.addReadCnt(map);

		cnt = board_dao.RequestCommentCnt(boa_id);
		if (cnt > 0) {

			ArrayList<CommentDTO> dtos = board_dao.RequestComment(boa_id);
			model.addAttribute("dtos", dtos);
		}
		// 상세페이지 조회
		System.out.println("tjkasdfCNT" + cnt);
		model.addAttribute("cnt", cnt);
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("number", number);
		model.addAttribute("boa_id", boa_id);
		model.addAttribute("boa_category", boa_category);
		System.out.println("보아아잉디~~~~~~~~~~~~!!!!!!!!!!" + boa_id);

	}

	@Override
	public void NewsModifyBoardPro(MultipartHttpServletRequest req, Model model) {
		MultipartFile file = req.getFile("boa_image");

		String saveDir = req.getRealPath("/resources/images/board/"); // 업로드할 파일이 위치하게될 실제 경로
		//String realDir = "C:\\Dev36\\Dev36\\workspace_farmfarmback\\FarmFarm\\SPRING_farmfarm\\src\\main\\webapp\\resources\\images\\";
		String realDir = "C:\\Users\\gnckd\\git2\\farmfarm\\SPRING_farmfarm\\src\\main\\webapp\\resources\\images\\board\\";

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

			int pageNum = Integer.parseInt(req.getParameter("pageNum"));
			int boa_category = Integer.parseInt(req.getParameter("boa_category"));
			String fileName = file.getOriginalFilename();
			String boa_subject = req.getParameter("boa_subject");
			String boa_content = req.getParameter("boa_content");
			int boa_id = Integer.parseInt(req.getParameter("boa_id"));

			BoardDTO dto = new BoardDTO();
			dto.setBoa_id(boa_id);
			dto.setMem_id((String) req.getSession().getAttribute("userId"));
			dto.setBoa_category(boa_category);
			dto.setBoa_image(fileName);
			dto.setBoa_subject(boa_subject);
			dto.setBoa_content(boa_content);
			dto.setBoa_ip("5");

			int updateCnt = board_dao.NewsModifyBoardPro(dto);
			System.out.println("업뎃 씨엔띠" + updateCnt);
			model.addAttribute("updateCnt", updateCnt);
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("boa_category", boa_category);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 소식게시판 글삭제 처리
	@Override
	public void NewsDeleteBoardPro(HttpServletRequest req, Model model) {
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int number = Integer.parseInt(req.getParameter("number"));
		int boa_id = Integer.parseInt(req.getParameter("boa_id"));
		int boa_category = Integer.parseInt(req.getParameter("boa_category"));

		int deleteCnt = board_dao.deleteBoard(boa_id);

		model.addAttribute("deleteCnt", deleteCnt);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("number", number);
		model.addAttribute("boa_id", boa_id);
		model.addAttribute("boa_category", boa_category);
	}
}
