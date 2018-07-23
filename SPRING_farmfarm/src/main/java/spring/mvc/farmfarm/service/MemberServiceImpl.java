package spring.mvc.farmfarm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.farmfarm.dto.AdvantageDTO;
import spring.mvc.farmfarm.dto.BoardDTO;
import spring.mvc.farmfarm.dto.MemDoDTO;
import spring.mvc.farmfarm.dto.MemberDTO;
import spring.mvc.farmfarm.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO dao;
	
	@Override
	public void LoginPro(HttpServletRequest req, Model model) {
		//3 값받기
		int grade=0;
		String id = req.getParameter("userId");
		String pwd = req.getParameter("userPassword");
		System.out.println("id"+id);
		System.out.println("pwd"+pwd);
		//5 처리
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		grade=dao.idPwdCheck(map);
		
		//6 전송
		if(grade!=0) {//id,pwd 일치할시 id보냄
			req.getSession().setAttribute("userId", id);
			System.out.println("(일치)userId:"+id+"  grade : "+grade);
			req.getSession().setAttribute("grade", grade);
		}
		
	}

	@Override
	public void confirmId(HttpServletRequest req, Model model) {
		//3단계 화면값 가져옴
		String strId = req.getParameter("userId");
		int selectCnt=0;
		System.out.println("strId ser"+strId);
		//5 아이디 중복확인
		selectCnt=dao.idCheck(strId);
		
		//6 req,session이용해서 화면에 전달
		model.addAttribute("selectCnt", selectCnt);
		model.addAttribute("id", strId);
		
	}

	@Override
	public void registerPro(HttpServletRequest req, Model model) {
		MemberDTO dto = new MemberDTO();
		int insertCnt=0;
		//3 화면값
		//도로명or지번주소 + 상세주소 합쳐줌
		//String addr=req.getParameter("addr1")+" "+req.getParameter("addr2");
		
		dto.setMem_id(req.getParameter("userId"));
		dto.setMem_pwd(req.getParameter("userPassword"));
		dto.setMem_name(req.getParameter("userName"));		
		dto.setMem_address(req.getParameter("address"));
		dto.setMem_hp(req.getParameter("hp"));
		dto.setMem_email(req.getParameter("email"));

		//5 처리
		insertCnt=dao.insertMember(dto);
		System.out.println("insertCnt:"+insertCnt);
		//6 전달
		model.addAttribute("insertCnt", insertCnt);
		System.out.println("service");
		
	}

	@Override
	public void deleteMemberPro(HttpServletRequest req, Model model) {
		String id = (String) req.getSession().getAttribute("userId");
		String pwd = req.getParameter("userPassword");
		int selectCnt=0,deleteCnt=0;
		
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		selectCnt=dao.idPwdCheck(map);
		
		if(selectCnt!=0) {
			deleteCnt=dao.deleteMember(id);
			if(deleteCnt!=0) {
				System.out.println("deletecnt:"+deleteCnt);
				model.addAttribute("deleteCnt",deleteCnt);
			}
		}
		
		
	}
	
	@Override
	public void UpdateMemberView(HttpServletRequest req, Model model) {
		String id = (String)req.getSession().getAttribute("userId");
		String pwd = req.getParameter("userPassword");
		int selectCnt=0;
		
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		selectCnt=dao.idPwdCheck(map);
		
		if(selectCnt==1) {
			MemberDTO dto = dao.getMemberInfo(id);
			model.addAttribute("dto", dto);	
			System.out.println("dto보냄");
		}
		model.addAttribute("selectCnt", selectCnt);
		
	}
	
	@Override
	public void updateMemberPro(HttpServletRequest req, Model model) {
		String mem_id = (String) req.getSession().getAttribute("userId");
		String mem_pwd = req.getParameter("userPassword");
		String mem_hp=req.getParameter("hp");
		String mem_address=req.getParameter("address");
		String mem_email = req.getParameter("email");		
		int updateCnt=0;
		
		MemberDTO dto = new MemberDTO();
		dto.setMem_id(mem_id);
		dto.setMem_pwd(mem_pwd);
		dto.setMem_hp(mem_hp);
		dto.setMem_address(mem_address);
		dto.setMem_email(mem_email);
		
		updateCnt=dao.UpdateMember(dto);
		System.out.println("mem_ser_updateCnt:"+updateCnt);
		
		model.addAttribute("updateCnt", updateCnt);
		
	}


	@Override
	public void guestAdvList(HttpServletRequest req, Model model) {
		String mem_id = (String)req.getSession().getAttribute("userId");
		
		//////////////////////////////
		//게시판 관련
		int pageSize =10;		//한 페이지당 출력할 글 갯수
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
		
		int sumPoint=0;			//총 점수
		
		cnt = dao.getAdvCnt(mem_id);
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
			map.put("strId", mem_id);
			ArrayList<AdvantageDTO> dtos = dao.getAdv(map);
			model.addAttribute("dtos",dtos);//큰바구니 : 게시글 목록 넘김
			
			sumPoint=dtos.get(0).getAdv_sumPoint();
			model.addAttribute("sumPoint",sumPoint);
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


	

}
