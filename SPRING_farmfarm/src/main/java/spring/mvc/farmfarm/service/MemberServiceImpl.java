package spring.mvc.farmfarm.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.farmfarm.dto.AdvantageDTO;
import spring.mvc.farmfarm.dto.AuctionDTO;
import spring.mvc.farmfarm.dto.AuctionFarmerDTO;
import spring.mvc.farmfarm.dto.AuctionListDTO;
import spring.mvc.farmfarm.dto.BecomeFarmerDTO;
import spring.mvc.farmfarm.dto.DonateDTO;
import spring.mvc.farmfarm.dto.DonateListDTO;
import spring.mvc.farmfarm.dto.FundDTO;
import spring.mvc.farmfarm.dto.MemberDTO;
import spring.mvc.farmfarm.dto.RankingDTO;
import spring.mvc.farmfarm.dto.SearchingDTO;
import spring.mvc.farmfarm.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO dao;

	@Override
	public void LoginPro(HttpServletRequest req, Model model) {
		// 3 값받기
		int grade = 0;
		String id = req.getParameter("userId");
		String pwd = req.getParameter("userPassword");
		System.out.println("id" + id);
		System.out.println("pwd" + pwd);
		// 5 처리
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		grade = dao.idPwdCheck(map);

		// 6 전송
		if (grade != 0) {// id,pwd 일치할시 id보냄
			req.getSession().setAttribute("userId", id);
			System.out.println("(일치)userId:" + id + "  grade : " + grade);
			req.getSession().setAttribute("grade", grade);
		}

	}

	@Override
	public void confirmId(HttpServletRequest req, Model model) {
		// 3단계 화면값 가져옴
		String strId = req.getParameter("userId");
		int selectCnt = 0;
		System.out.println("strId ser" + strId);
		// 5 아이디 중복확인
		selectCnt = dao.idCheck(strId);

		// 6 req,session이용해서 화면에 전달
		model.addAttribute("selectCnt", selectCnt);
		model.addAttribute("id", strId);

	}

	@Override
	public void registerPro(HttpServletRequest req, Model model) {
		MemberDTO dto = new MemberDTO();
		int insertCnt = 0;
		// 3 화면값

		dto.setMem_id(req.getParameter("userId"));
		dto.setMem_pwd(req.getParameter("userPassword"));
		dto.setMem_name(req.getParameter("userName"));

		// 주소 API처리
		// 도로명or지번주소 + 상세주소
		// String addr=req.getParameter("addr1")+" "+req.getParameter("addr2");
		String address = "";
		String add1 = req.getParameter("add1");
		String add2 = req.getParameter("add2");
		// null 처리가 될 경우 방지 체크
		if (!add1.equals("") && !add2.equals("")) {
			address = add1 + add2;
		}

		dto.setMem_address(address);
		dto.setMem_hp(req.getParameter("hp"));

		String email1 = req.getParameter("email1");
		String email2 = req.getParameter("email2");
		dto.setMem_email(email1 + "@" + email2);

		// 5 처리
		insertCnt = dao.insertMember(dto);
		System.out.println("insertCnt:" + insertCnt);
		// 6 전달
		model.addAttribute("insertCnt", insertCnt);
		System.out.println("service");

	}

	@Override
	public void deleteMemberPro(HttpServletRequest req, Model model) {
		String id = (String) req.getSession().getAttribute("userId");
		String pwd = req.getParameter("userPassword");
		int selectCnt = 0, deleteCnt = 0;

		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		selectCnt = dao.idPwdCheck(map);

		if (selectCnt != 0) {
			deleteCnt = dao.deleteMember(id);
			if (deleteCnt != 0) {
				System.out.println("deletecnt:" + deleteCnt);
				model.addAttribute("deleteCnt", deleteCnt);
			}
		}

	}

	@Override
	public void UpdateMemberView(HttpServletRequest req, Model model) {
		String id = (String) req.getSession().getAttribute("userId");
		String pwd = req.getParameter("userPassword");
		int selectCnt = 0;

		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		selectCnt = dao.idPwdCheck(map);

		if (selectCnt == 1) {
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
		String mem_hp = req.getParameter("hp");
		String mem_address = req.getParameter("address");
		String mem_email = req.getParameter("email");
		int updateCnt = 0;

		MemberDTO dto = new MemberDTO();
		dto.setMem_id(mem_id);
		dto.setMem_pwd(mem_pwd);
		dto.setMem_hp(mem_hp);
		dto.setMem_address(mem_address);
		dto.setMem_email(mem_email);

		updateCnt = dao.UpdateMember(dto);
		System.out.println("mem_ser_updateCnt:" + updateCnt);

		model.addAttribute("updateCnt", updateCnt);

	}

	@Override
	public void guestAdvList(HttpServletRequest req, Model model) {
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

		cnt = dao.getAdvCnt(mem_id);
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
			ArrayList<AdvantageDTO> dtos = dao.getAdv(map);
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

	}

	@Override
	public void fundRanking(HttpServletRequest req, Model model) {
		ArrayList<RankingDTO> dtos = new ArrayList<>();
		dtos = dao.getFundRanking();

		model.addAttribute("dtos", dtos);

	}

	@Override
	public void auctionRanking(HttpServletRequest req, Model model) {
		ArrayList<RankingDTO> dtos = new ArrayList<>();
		dtos = dao.getAucRanking();

		model.addAttribute("dtos", dtos);
	}

	@Override
	public void donateRanking(HttpServletRequest req, Model model) {
		ArrayList<RankingDTO> dtos = new ArrayList<>();
		String name = null;
		int length = 0;

		// mem_id를 farmer_id로, donate_price의 합을 fund_price로 mem_name은 stock_name으로 사용
		dtos = dao.getDonateRanking();
		// 이름이 홍길동이면 홍길* 으로 변환
		for (int i = 0; i < dtos.size(); i++) {
			length = dtos.get(i).getStock_name().length();
			if (length > 2) {
				name = dtos.get(i).getStock_name().substring(0, 2);
				for (int j = 0; j < length - 2; j++) {
					name += "*";
				}
			} else {
				name = dtos.get(i).getStock_name().substring(0, 1);
				name += "*";
			}
			System.out.println(name);
			dtos.get(i).setStock_name(name);
		}

		model.addAttribute("dtos", dtos);
	}

	@Override
	public void searching(HttpServletRequest req, Model model) {
		String keyword = req.getParameter("keyword");
		ArrayList<SearchingDTO> dtos = null;

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

		cnt = dao.getSearchCnt(keyword);
		System.out.println("검색selectCnt: " + cnt);

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
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			map.put("keyword", keyword);
			dtos = dao.getSearchData(map);
			model.addAttribute("dtos", dtos);
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
		model.addAttribute("keyword", keyword);
	}

	@Override
	public void getActionList(HttpServletRequest req, Model model) {

		ArrayList<AuctionListDTO> dtos = new ArrayList<>();

		dtos = dao.getAuctionList();

		model.addAttribute("dtos", dtos);
	}

	@Override
	public void AuctionItemContent(HttpServletRequest req, Model model) {
		String auc_no = req.getParameter("auc_no");
		System.out.println("auc_no:" + auc_no);

		AuctionDTO dto = new AuctionDTO();
		AuctionFarmerDTO dto2 = new AuctionFarmerDTO();

		dto = dao.getAuctionContent(auc_no);
		int farmkey = dto.getFarm_key();

		dto2 = dao.getAuctionFarmer(farmkey);

		int fcnt = dao.getAuctionFarmerFund(farmkey);
		int acnt = dao.getAuctionFarmerAuc(farmkey);

		System.out.println("fkey" + farmkey);
		System.out.println("acnt" + acnt + "fcnt" + fcnt);

		dto2.setFundCnt(fcnt);
		dto2.setAuctionCnt(acnt);

		model.addAttribute("dto", dto);
		model.addAttribute("dto2", dto2);
	}

	@Override
	public void AuctionNowPrice(HttpServletRequest req, Model model) {
		String auc_no = req.getParameter("auc_no");
		Integer nowPrice = 0;
		nowPrice = dao.getNowPrice(auc_no);

		if (nowPrice == null)
			nowPrice = 0;
		model.addAttribute("nowPrice", nowPrice);

	}

	@Override
	public void AuctionJoin(HttpServletRequest req, Model model) {
		String auc_no = req.getParameter("auc_no");
		AuctionDTO dto = null;
		dto = dao.getAuctionContent(auc_no);

		ArrayList<DonateDTO> donateDtos = null;
		donateDtos = dao.getDonateList();

		model.addAttribute("dto", dto);
		model.addAttribute("donateDtos", donateDtos);

	}

	@Override
	public void AuctionJoinPro(HttpServletRequest req, Model model) {
		String auc_no = req.getParameter("auc_no");
		String userId = (String) req.getSession().getAttribute("userId");
		int nowPrice = Integer.parseInt(req.getParameter("nowPrice"));
		int updateCnt = 0, insertCnt = 0, sumPoint = 0;
		Integer aucPrice = 0, check = 0;
		boolean judge = false;// 현재 입찰가보다 큰 금액을 입찰했는지?

		// 회원의 총점수 가져오는 부분(guestAdvList메소드 부분을 긁어왔기에 다소복잡해보이기만함)
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 1);
		map.put("end", 5);
		map.put("strId", userId);
		ArrayList<AdvantageDTO> dtos = dao.getAdv(map);
		model.addAttribute("dtos", dtos);// 큰바구니 : 게시글 목록 넘김

		if (dtos.size() == 0)
			sumPoint = 0;
		else
			sumPoint = dtos.get(0).getMem_adv();

		// map2는 실제로 사용하는 맵 이고 map은 sumPoint를 위해 사용한 map
		Map<String, Object> map2 = new HashMap<>();

		map2.put("auc_no", auc_no);
		map2.put("userId", userId);
		map2.put("nowPrice", nowPrice);
		map2.put("sumPoint", sumPoint);
		map2.put("adv_reason", 3);// 경매참여:3
		map2.put("adv_point", 1);// 경매참여시 포인트:1
		// 현재입찰가격
		aucPrice = dao.getNowPrice(auc_no);
		if (aucPrice == null)
			aucPrice = 0;

		if (nowPrice > aucPrice)
			judge = true;

		if (judge == true) {
			// join테이블 join_no가져와서 처음입찰인지, 두번째이상인지 체크
			check = dao.auctionJoinCheck(map2);
			// auction테이블 update
			updateCnt = dao.auctionUpdate(map2);
			// advantage테이블 insert
			dao.auctionJoinAdv(map2);
			// member테이블 mem_adv update
			dao.updateAdv(map2);

			if (check == null)
				// check==null 즉 처음 입찰이면 join 테이블 insert
				insertCnt = dao.auctionJoinInsert(map2);
			else {
				// check!=null 즉 여러번 입찰이면 join테이블 update, 그리고 update를 위해 join테이블의 키를 받아왔던 check를
				// map에 추가
				map2.put("join_no", check);
				System.out.println(check);
				System.out.println(nowPrice);
				insertCnt = dao.auctionJoinUpdate(map2);
			}
		}

		model.addAttribute("judge", judge);
		model.addAttribute("insertCnt", insertCnt);
		model.addAttribute("updateCnt", updateCnt);
		model.addAttribute("auc_no", auc_no);
	}

	// 펀드상품보기
	@Override
	public void FundProductsList(HttpServletRequest req, Model model) {
		int pageSize = 4; // 한 페이지당 출력할 글의 개수
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

		cnt = dao.getFundCnt(); // 글 개수 구하기
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

			ArrayList<FundDTO> dtos = dao.getFundProductsList(map);
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

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작 페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage); // 현재 페이지

		}

	}

	// 펀드상품 상세보긴
	@Override
	public void FundProductsContentList(HttpServletRequest req, Model model) {
		int pageNum = 0;
		int number = 0;
		String fund_no = req.getParameter("fund_no");
		number = Integer.parseInt(req.getParameter("number"));

		FundDTO dto = new FundDTO();

		dto = dao.getFundArticle(fund_no);

		System.out.println("fdddd" + dto.getFund_endDate());

		req.setAttribute("fund_endDate", dto.getFund_endDate());
		// 상세페이지 조회
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("number", number);
	}

	@Override
	public void FundDonateJoin(HttpServletRequest req, Model model) {

		ArrayList<DonateDTO> donateDtos = null;

		donateDtos = dao.getDonateList();

		model.addAttribute("donateDtos", donateDtos);

	}

	// 펀드상품참여 기부참여 처리
	@Override
	public void FundJoinPro(HttpServletRequest req, Model model) {
		String fund_no = req.getParameter("fund_no");
		String userId = (String) req.getSession().getAttribute("userId");
		int stock_price = Integer.parseInt(req.getParameter("stock_price"));
		int updateCnt = 0, insertCnt = 0, sumPoint = 0;
		Integer check = 0;

		System.out.println("stock_price:~~~~~~~~~~~" + stock_price);
		System.out.println("fund_no:~~~~~~~~~~~" + fund_no);
		System.out.println("userId:~~~~~~~~~~~" + userId);
		// 회원의 총점수 가져오는 부분(guestAdvList메소드 부분을 긁어왔기에 다소복잡해보이기만함)
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 1);
		map.put("end", 5);
		map.put("strId", userId);
		ArrayList<AdvantageDTO> dtos = dao.getAdv(map);
		model.addAttribute("dtos", dtos);// 큰바구니 : 게시글 목록 넘김

		if (dtos.size() == 0)
			sumPoint = 0;
		else
			sumPoint = dtos.get(0).getAdv_point();

		// map2는 실제로 사용하는 맵 이고 map은 sumPoint를 위해 사용한 map
		Map<String, Object> map2 = new HashMap<String, Object>();

		map2.put("fund_no", fund_no);
		map2.put("userId", userId);
		map2.put("stock_price", stock_price);
		map2.put("sumPoint", sumPoint);
		map2.put("adv_reason", 1);// 펀드참여:1
		map2.put("adv_point", 5);// 펀드참여시 포인트:5
		// 현재입찰가격
		// aucPrice = dao.getNowPrice(auc_no);

		// join테이블 join_no가져와서 처음입찰인지, 두번째이상인지 체크
		check = dao.FundJoinCheck(map2);
		// fund테이블 update
		updateCnt = dao.FundUpdate(map2);
		// advantage테이블 insert
		dao.auctionJoinAdv(map2);

		// member테이블 mem_adv update
		dao.updateAdv(map2);

		if (check == null)
			// check==null 즉 처음 입찰이면 join 테이블 insert
			insertCnt = dao.FundJoinInsert(map2);
		else {
			// check!=null 즉 여러번 입찰이면 join테이블 update, 그리고 update를 위해 join테이블의 키를 받아왔던 check를
			// map에 추가
			map2.put("join_no", check);
			System.out.println(check);
			System.out.println(stock_price);
			insertCnt = dao.FundJoinUpdate(map2);

		}

		model.addAttribute("insertCnt", insertCnt);
		model.addAttribute("updateCnt", updateCnt);
		model.addAttribute("fund_no", fund_no);
	}

	@Override
	public void mailconfirm(HttpServletRequest req, Model model) {
		String email1 = req.getParameter("email1");
		String email2 = req.getParameter("email2");
		String email = "";
		email = email1 + "@" + email2;
		req.getSession().setAttribute("email", email);

		System.out.println("email : " + email);

		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();

		for (int i = 0; i < 6; i++) {
			int rIndex = rnd.nextInt(2);
			switch (rIndex) {
			case 0:
				// A-Z
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 1:
				// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}
		String key = temp.toString();// StringBuffer 형식인 Key를 String으로 변환
		System.out.println("key : " + key);
		req.getSession().setAttribute("key", key);
		model.addAttribute("cnt", 1);

		dao.sendmail(email, key);

		model.addAttribute("key", key);
	}

	/**
	 * 민웅
	 */
	// 농부 신청 처리
	@Override
	public void BecomeFarmerPro(HttpServletRequest req, Model model) {
		int updateCnt = 0;
		String mem_id = (String) req.getSession().getAttribute("userId");
		String fPlan_title = req.getParameter("fPlan_title");
		String fPlan_plan = req.getParameter("fPlan_plan");
		int fPlan_capital = Integer.parseInt(req.getParameter("fPlan_capital"));
		String fPlan_use = req.getParameter("fPlan_use");
		String fPlan_detail = req.getParameter("fPlan_detail");
		String fPlan_address = req.getParameter("fPlan_address");

		BecomeFarmerDTO dto = new BecomeFarmerDTO();
		dto.setfPlan_title(fPlan_title);
		dto.setfPlan_plan(fPlan_plan);
		dto.setfPlan_capital(fPlan_capital);
		dto.setfPlan_use(fPlan_use);
		dto.setfPlan_detail(fPlan_detail);
		dto.setfPlan_address(fPlan_address);
		dto.setMem_id(mem_id);

		updateCnt = dao.BecomFarm(dto);

		model.addAttribute("updateCnt", updateCnt);
	}

	// 기부내역
	@Override
	public void guestDonateLists(HttpServletRequest req, Model model) {
		String mem_id = (String) req.getSession().getAttribute("userId");
		ArrayList<DonateListDTO> dtos = dao.getDonated(mem_id);
		req.setAttribute("dtos", dtos);
	}

	// 남은날짜
	@Override
	public void RemainingDate(HttpServletRequest req, Model model) {
		// 현재시간구하기
		Date todaydate = new Date();

		String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(todaydate);
		System.out.println(todayDate); // 2011-01-18

		String fund_endDate = (String) req.getAttribute("fund_endDate");
		System.out.println("엔드데이트" + fund_endDate);

		try { // String Type을 Date Type으로 캐스팅하면서 생기는 예외로 인해 여기서 예외처리 해주지 않으면 컴파일러에서 에러가 발생해서
				// 컴파일을 할 수 없다.
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			// date1, date2 두 날짜를 parse()를 통해 Date형으로 변환.
			Date FirstDate = format.parse(fund_endDate);
			Date SecondDate = format.parse(todayDate);

			// Date로 변환된 두 날짜를 계산한 뒤 그 리턴값으로 long type 변수를 초기화 하고 있다.
			// 연산결과 -950400000. long type 으로 return 된다.
			long calDate = FirstDate.getTime() - SecondDate.getTime();

			// Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다.
			// 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
			long calDateDays = calDate / (24 * 60 * 60 * 1000);

			calDateDays = Math.abs(calDateDays);

			System.out.println("두 날짜의 날짜 차이: " + calDateDays);
			model.addAttribute("calDateDays", calDateDays);

		} catch (Exception e) {
			// 예외 처리
			e.printStackTrace();
		}
	}

	@Override
	public void AuctionList(HttpServletRequest req, Model model) {
		String userId = (String) req.getSession().getAttribute("userId");
		ArrayList<AuctionDTO> dtos = null;
		ArrayList<AuctionDTO> newDtos = new ArrayList<>();
		ArrayList<AuctionDTO> oldDtos = new ArrayList<>();
		int selectCnt = 0, oldCnt = 0, newCnt = 0;

		selectCnt = dao.getAuctionDataCnt(userId);

		if (selectCnt > 0) {
			dtos = dao.getAuctionData(userId);

			Date currentTime = new Date();
			int result = 0;
			for (int i = 0; i < dtos.size(); i++) {
				result = currentTime.compareTo(dtos.get(i).getAuc_endDate());

				if (result > 0) {
					oldDtos.add(dtos.get(i));
					oldCnt++;
				} else {
					newDtos.add(dtos.get(i));
					newCnt++;
				}
			}

		}

		model.addAttribute("newCnt", newCnt);
		model.addAttribute("oldCnt", oldCnt);
		model.addAttribute("oldDtos", oldDtos);
		model.addAttribute("newDtos", newDtos);
	}

	@Override
	public void AuctionProgress(HttpServletRequest req, Model model) {
		String userId = (String) req.getSession().getAttribute("userId");
		String auc_no = req.getParameter("auc_no");
		System.out.println("auc_no:" + auc_no);
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("auc_no", auc_no);

		ArrayList<AuctionDTO> dtos = dao.getAuctionProgress(map);
		AuctionDTO dto = new AuctionDTO();

		dto.setStock_image(dtos.get(0).getStock_image());
		dto.setAuc_title(dtos.get(0).getAuc_title());
		dto.setAuc_startPrice(dtos.get(0).getAuc_startPrice());

		model.addAttribute("dto", dto);
		model.addAttribute("dtos", dtos);
		model.addAttribute("auc_no", auc_no);
	}

	@Override
	public void AuctionProgressAjax(HttpServletRequest req, Model model) {
		String auc_no = req.getParameter("auc_no");
		Map<String, Object> map = new HashMap<>();
		map.put("auc_no", auc_no);

		ArrayList<AuctionDTO> dtos = dao.getAuctionProgress(map);

		model.addAttribute("dtos", dtos);
	}
}
