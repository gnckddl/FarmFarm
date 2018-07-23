package spring.mvc.farmfarm.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.farmfarm.dto.LettersDTO;
import spring.mvc.farmfarm.persistence.FarmDAO;

@Service
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	FarmDAO dao;
	
	
	/**
	 * 장렬
	 */
	// (농부에게)보낸 쪽지함 보기 / 회원에게서 받은 쪽지함
	@Override
	public void LetterList(HttpServletRequest req, Model model) {
		
		//게시판 관련
		int pageSize =5;		//한 페이지당 출력할 글 갯수
		int pageBlock =3;		//한 블럭당 페이지 갯수
		
		int cnt = 0;			//글 갯수
		int start = 0;			//현재 페이지 시작 글번호
		int end = 0;			//현재 페이지 마지막 글번호
		int number = 0;			//출력용 글번호
		String pageNum = null;	//페이지 번호
		int currentPage = 0;	//현재페이지
		
		int pageCount = 0;		//페이지 갯수
		int startPage = 0;		//시작 페이지
		int endPage = 0;		//마지막 페이지
		
				
		//4단계.dao 객체 생성(싱글톤, 다형성)
		//BoardDAO dao = BoardDAOImpl.getInstance();
		
		
		//글갯수 구하기
		cnt = dao.getArtileCnt();
		System.out.println("cnt:"+cnt);// 먼저 테이블에 30건을 insert 할것
		
		pageNum = req.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";	//첫페이지를 1페이지로 설정
			
		}
		
		//글 30건 기준
		currentPage = Integer.parseInt(pageNum);//현재 페이지 : 1
		System.out.println("currentPage:"+currentPage);
		
		//페이지 갯수 + 나머지있으면 1
		pageCount = (cnt/ pageSize) + (cnt % pageSize > 0 ? 1 : 0);
		
		
		start = (currentPage - 1) * pageSize + 1;	//현재 페이지 시작번호
		
		end = start + pageSize - 1;	
		
		System.out.println("start :" + start);
		System.out.println("end :" + end);
		
		if(end > cnt) end = cnt;
		
		//30 = 30 -(1 - 1) *5
		number = cnt - (currentPage -1) * pageSize; //출력용 글번호
		
		System.out.println("number :"+ number);
		System.out.println("pageSize :" + pageSize);
		
		if(cnt > 0) {
			//게시글 목록 조회
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("start", start);
			map.put("end", end);
			ArrayList<LettersDTO> dtos = dao.getArticleList(map);
			model.addAttribute("dtos",dtos);//큰바구니 : 게시글 목록 넘김
		}
		
		//1 = (1 / 3) * 3 + 1
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if(currentPage % pageBlock == 0) startPage -= pageBlock;
			System.out.println("startPage :"+startPage);
		
		//3 = 1 + 3 - 1
		endPage = startPage + pageBlock -1; //마지막 페이지
		
		if(endPage > pageCount) endPage = pageCount;
		System.out.println("endPage :"+endPage);
		
		model.addAttribute("cnt", cnt); //글갯수
		model.addAttribute("number", number); //글번호
		model.addAttribute("pageNum", pageNum);//페이지 번호
	
		
		if(cnt > 0) {
			model.addAttribute("startPage", startPage); //시작 페이지
			model.addAttribute("endPage", endPage);	  //마지막 페이지
			model.addAttribute("pageBlock", pageBlock); //출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); //페이지 갯수
			model.addAttribute("currentPage", currentPage); //현재 페이지
			
			
		}		
			
		//6단계,request나 session에 처리결과 넘기기
		
		model.addAttribute("cnt",cnt);

	}

	// 쪽지함 상세 페이지 확인 (농부/ 회원 공통)
	@Override
	public void LTContentsForm(HttpServletRequest req, Model model) {
		int letternum = 0;
		int pageNum = 0;
		
		letternum = Integer.parseInt(req.getParameter("letternum"));
		pageNum = Integer.parseInt(req.getParameter("pageNum"));
	
		LettersDTO dto = dao.getArticle(letternum);
		
		req.setAttribute("dto", dto);
		req.setAttribute("pageNum", pageNum);
		
	}
	
	// 작성 한 쪽지 처리
	@Override
	public void LTWritePro(HttpServletRequest req, Model model) {
		// 화면으로부터 받아온 값을 처리
		int letternum = 0;
		letternum=Integer.parseInt(req.getParameter("letternum"));
		LettersDTO dto = new LettersDTO();
		
		// 시퀀스 번호인 쪽지번호를 기준으로 화면에 전송
		dto.setLetternum(letternum);
		
		//폼 전송 입력값 처리
		dto.setLetterwritter(req.getParameter("letterwritter"));
		dto.setLettersubject(req.getParameter("lettersubject"));
		dto.setLettercontent(req.getParameter("lettercontent"));
		dto.setLetterreg_date(new Timestamp(System.currentTimeMillis()));
		
		int insertCnt=dao.insertLetter(dto);
		
		//완료된 세션 처리 컨트롤러로 전송
		req.setAttribute("insertCnt", insertCnt);
	}
	
/*	// 쪽지 선택 삭제
	@Override
	public void LTDeletePro(HttpServletRequest req, Model model) {
		int deleteCnt = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		
		String[] RowCheck = req.getParameterValues("RowCheck");
		for(String no : RowCheck) {
			System.out.println("no:" + no);
		}
		System.out.println("삭제쪽지");
		map.put("RowCheck", RowCheck);
		
		deleteCnt = dao.LTdelete(map);
		
		req.setAttribute("deleteCnt", deleteCnt);
	}*/
	
	
	
	/**
	 * 민웅
	 */
	// 상품 등록 - 처리
	@Override
	public void Auction_ApplyPro(HttpServletRequest req, Model model) {
			
	}







	

	
	
}


