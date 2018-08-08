package spring.mvc.farmfarm.persistence;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.farmfarm.dto.AuctionListDTO;
import spring.mvc.farmfarm.dto.BoardDTO;
import spring.mvc.farmfarm.dto.CommentDTO;
import spring.mvc.farmfarm.dto.DonateDTO;
import spring.mvc.farmfarm.dto.FundDTO;
import spring.mvc.farmfarm.dto.MemberDTO;
import spring.mvc.farmfarm.dto.PartnerDTO;
import spring.mvc.farmfarm.dto.StockDTO;
import spring.mvc.farmfarm.dto.WeekFarmDTO;

@Repository
public class HostDAOImpl implements HostDAO {

	@Autowired
	private SqlSession sqlSession;

	// 인기펀드 리스트
	@Override
	public ArrayList<FundDTO> FarmFarmMainList() {
		ArrayList<FundDTO> dtos = null;
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		dtos = dao.FarmFarmMainList();

		return dtos;
	}

	// 메인 최신펀드 리스트
	@Override
	public ArrayList<FundDTO> FarmFarmMainList1() {
		ArrayList<FundDTO> dtos = null;
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		dtos = dao.FarmFarmMainList1();

		return dtos;
	}

	// 인기 경매상품
	@Override
	public ArrayList<AuctionListDTO> getAuctionList() {
		ArrayList<AuctionListDTO> dtos = null;
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		dtos = dao.getAuctionList();
		return dtos;
	}

	// *************************************************************************************
	// ****************************************펀드관리*******************************
	// *************************************************************************************
	// 펀드 수 //미등록 펀드수(1: 진행요청 // 2. 진행중 )-->
	@Override
	public int getFundCnt(Map<String, Object> map) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		int selectCnt = dao.getFundCnt(map);

		return selectCnt;
	}

	// 펀드 수 //미등록 펀드(3: 유찰, 4: 낙찰) -->
	@Override
	public int getFundCnt_end(int auc_status) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		int selectCnt = dao.getFundCnt_end(auc_status);

		return selectCnt;
	}

	// 펀드 진행내역 //미등록 펀드 내역
	@Override
	public ArrayList<StockDTO> getFundList(Map<String, Object> map) {
		// 큰바구니를 생성해라
		ArrayList<StockDTO> dtos = null;

		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		dtos = dao.getFundList(map);

		return dtos;
	}

	// 미등록 펀드 삭제
	@Override
	public int fundDelete(String auc_no) {

		HostDAO dao = sqlSession.getMapper(HostDAO.class);

		int deleteCnt = dao.fundDelete(auc_no);

		return deleteCnt;
	}

	// 펀드 상태(1: 미등록 2: 진행중, 3: 중단, 4: 완료) 1.미등록 -> 2.진행중
	@Override
	public int fundUpdate(Map<String, Object> map) {

		HostDAO dao = sqlSession.getMapper(HostDAO.class);

		int updatetCnt = dao.fundUpdate(map);
		return updatetCnt;
	}

	// *************************************************************************************
	// ****************************************경매관리*******************************
	// *************************************************************************************

	// 김보영
	// 경매 수 //미등록 경매수(1: 진행요청 // 2. 진행중 )-->
	@Override
	public int getAucCnt(Map<String, Object> map) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		int selectCnt = dao.getAucCnt(map);

		return selectCnt;
	}

	// 경매 진행내역 //미등록 경매 내역
	@Override
	public ArrayList<StockDTO> getAucList(Map<String, Object> map) {
		// 큰바구니를 생성해라
		ArrayList<StockDTO> dtos = null;

		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		dtos = dao.getAucList(map);

		return dtos;
	}

	// 미등록 경매 삭제
	@Override
	public int aucDelete(String auc_no) {

		HostDAO dao = sqlSession.getMapper(HostDAO.class);

		int deleteCnt = dao.aucDelete(auc_no);

		return deleteCnt;
	}

	// 경매 상태(1: 미등록 2: 진행중, 3: 유찰, 4: 낙찰) 를 UPDATE한다.
	@Override
	public int aucUpdate(Map<String, Object> map) {

		HostDAO dao = sqlSession.getMapper(HostDAO.class);

		int updatetCnt = dao.aucUpdate(map);
		return updatetCnt;
	}

	// *************************************************************************************
	// ****************************************회원관리****************************************
	// *************************************************************************************

	// ************* 일반회원 차트**************
	// 펀드 분야별 구매 차트
	@Override
	public Integer guestFundSales(int stock_kind) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		Integer fundSales = dao.guestFundSales(stock_kind);

		return fundSales;
	}

	// 펀드 & 경매 진행 차트
	@Override
	public Integer guestFundAuc(int fundORauc) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		Integer fundAuc = dao.guestFundAuc(fundORauc);

		return fundAuc;
	}

	// ************* 일반회원 관리 *************김보영

	// 회원의 수
	@Override
	public int getGuestCnt() {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		int selectCnt = dao.getGuestCnt();

		return selectCnt;
	}

	// 회원 목록 조회
	@Override
	public ArrayList<MemberDTO> getGuestList(Map<String, Integer> map) {

		// 큰바구니를 생성해라
		ArrayList<MemberDTO> dtos = null;

		// start와 end 사이에 해당하는 게시글을 읽어서 큰바구니에 담는다.
		HostDAO dao = sqlSession.getMapper(HostDAO.class);

		dtos = dao.getGuestList(map);

		// 큰바구니 리턴
		return dtos;
	}

	// 어드벤티지 플러스:
	@Override
	public int guestAdvUpdate(Map<String, Object> map) {

		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		int updateCnt = dao.guestAdvUpdate(map);

		return updateCnt;
	}

	// 일반회원 삭제: guestDelete()
	@Override
	public int guestDelete(String mem_id) {

		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		int deleteCnt = dao.guestDelete(mem_id);

		return deleteCnt;
	}
	// *************************************************************************************
	// ****************************************파트너
	// 관리****************************************
	// *************************************************************************************

	// ************* 파트너 차트 *************// 영민
	// 분야별 펀드 현황 차트
	@Override
	public Integer partnerFund(int stock_kind) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		Integer partnerFund = dao.partnerFund(stock_kind);

		return partnerFund;
	}

	// 분야별 경매 현황 차트
	@Override
	public Integer partnerAuc(int stock_kind) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		Integer partnerAuc = dao.partnerAuc(stock_kind);

		return partnerAuc;
	}

	// ************* 파트너 관리 *************// 영민
	// 총 파트너 수
	@Override
	public int getPartnerCnt() {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		int selectCnt = dao.getPartnerCnt();

		return selectCnt;
	}

	// 모든 파트너 조회
	@Override
	public ArrayList<PartnerDTO> getPartnerList(Map<String, Object> map) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		ArrayList<PartnerDTO> dtos = dao.getPartnerList(map);

		return dtos;
	}

	// 파트너 어드밴티지 관리
	@Override
	public int partnerAdvUpdate(Map<String, Object> map) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		int updateCnt = dao.partnerAdvUpdate(map);

		return updateCnt;
	}

	// 파트너 승인
	@Override
	public int partnerUp(String mem_id) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		int updateCnt = dao.partnerUp(mem_id);

		return updateCnt;
	}

	// 파트너 강등
	@Override
	public int partnerDown(String mem_id) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		int updateCnt = dao.partnerDown(mem_id);

		return updateCnt;
	}

	// *************************************************************************************
	// **************************************** 정산
	// 관리************************************
	// *************************************************************************************
	// *************펀드****************
	// 이번 달 펀드(상품 종류별) 차트
	@Override
	public Integer thisMonthFundKind(Map<String, Integer> mapParam) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		Integer thisMonthFundKind = dao.thisMonthFundKind(mapParam);

		return thisMonthFundKind;
	}

	// 월별 펀드 총액 차트
	@Override
	public Integer monthFundTotal(Map<String, Integer> mapParam) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		Integer monthFundTotal = dao.monthFundTotal(mapParam);

		return monthFundTotal;
	}

	// 3.년별 펀드 (총 액수) 차트
	@Override
	public Integer yearFundTotal(int year) {
		Integer aucSales = 0;

		System.out.println(year);
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		aucSales = dao.yearFundTotal(year);

		return aucSales;
	}

	// 4번차트//년별 펀드(상품 종류별) 차트
	@Override
	public Integer yearFundKind(Map<String, Integer> mapParam) {
		Integer aucSales = 0;

		System.out.println(mapParam);
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		aucSales = dao.yearFundKind(mapParam);

		return aucSales;
	}

	// *************경매****************
	// 이번 달 경매 (상품 종류별) 차트
	@Override
	public Integer thisMonthAucKind(Map<String, Integer> mapParam) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		Integer thisMonthAucKind = dao.thisMonthAucKind(mapParam);

		return thisMonthAucKind;
	}

	// 월별 경매 총액 차트
	@Override
	public Integer monthAucTotal(Map<String, Integer> mapParam) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		Integer monthAucTotal = dao.monthAucTotal(mapParam);

		return monthAucTotal;
	}

	// 3.년별 경매 (총 액수) 차트
	@Override
	public Integer yearAucTotal(int year) {
		Integer aucSales = 0;

		System.out.println(year);
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		aucSales = dao.yearAucTotal(year);

		return aucSales;
	}

	// 4번차트//년별 경매(상품 종류별) 차트
	@Override
	public Integer yearAucKind(Map<String, Integer> mapParam) {
		Integer aucSales = 0;

		System.out.println(mapParam);
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		aucSales = dao.yearAucKind(mapParam);

		return aucSales;
	}
	// *************************************************************************************
	// **************************************** 게시판 관리
	// ************************************
	// *************************************************************************************

	@Override
	// 공지사항 건수 조회
	public int getNoticeCnt(int category) {
		int selectCnt = 0;

		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		selectCnt = dao.getNoticeCnt(category);

		return selectCnt;
	}

	// 공지사항 목록 조회
	@Override
	public ArrayList<BoardDTO> getNoticeList(Map<String, Object> map) {
		ArrayList<BoardDTO> dtos = null;

		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		dtos = dao.getNoticeList(map);

		return dtos;
	}

	// 공지사항 삭제
	@Override
	public int noticeDelete(Map<String, Object> map) {
		int deleteCnt = 0;

		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		deleteCnt = dao.noticeDelete(map);

		return deleteCnt;
	}

	// 공지사항 상세페이지
	@Override
	public BoardDTO getNoticeContent(int boa_id) {
		BoardDTO dto = null;

		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		dto = dao.getNoticeContent(boa_id);

		return dto;
	}

	// ************* 댓글 *************
	// 댓글 목록 조회
	@Override
	public ArrayList<CommentDTO> getCommentList(int boa_id) {
		ArrayList<CommentDTO> dtos = null;

		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		dtos = dao.getCommentList(boa_id);

		return dtos;
	}

	// 댓글 작성
	@Override
	public void commentWrite(Map<String, Object> map) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		dao.commentWrite(map);
	}

	// 댓글 수정
	@Override
	public int commentModify(Map<String, Object> map) {
		int updateCnt = 0;

		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		updateCnt = dao.commentModify(map);

		return updateCnt;
	}

	// 댓글 삭제
	@Override
	public int commentDelete(int cm_no) {
		int deleteCnt = 0;

		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		deleteCnt = dao.commentDelete(cm_no);

		return deleteCnt;
	}

	// *************************************************************************************
	// **************************************** 기부 관리
	// ************************************
	// *************************************************************************************
	// 기부 건수
	@Override
	public int getDonateCnt() {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		int seleteCnt = dao.getDonateCnt();

		return seleteCnt;
	}

	// 기부 내역 조회
	@Override
	public ArrayList<DonateDTO> getDonateList(Map<String, Object> map) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		ArrayList<DonateDTO> dtos = dao.getDonateList(map);

		return dtos;
	}

	// 기부업체수
	@Override
	public int getDonateConCnt() {
		int selectCnt = 0;

		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		selectCnt = dao.getDonateConCnt();

		return selectCnt;
	}

	// 기부단체내역
	@Override
	public ArrayList<DonateDTO> donateConList(Map<String, Object> map) {
		// 큰바구니를 생성해라
		ArrayList<DonateDTO> dtos = null;

		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		dtos = dao.donateConList(map);

		return dtos;
	}

	// 기부단체 상세페이지
	@Override
	public DonateDTO donateDetail(int doForm_id) {

		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		DonateDTO dto = dao.donateDetail(doForm_id);

		return dto;
	}

	// 기부단체 입력
	@Override
	public int donateInsert(DonateDTO dto) {
		int insertCnt = 0;

		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		insertCnt = dao.donateInsert(dto);

		return insertCnt;
	}

	// 기부단체 수정페이지
	@Override
	public int donateUpdate(DonateDTO dto) {
		int updateCnt = 0;

		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		updateCnt = dao.donateUpdate(dto);

		return updateCnt;
	}

	// 기부단체 삭제 처리페이지
	@Override
	public int DonateDeletePro(int doForm_id) {
		int deleteCnt = 0;

		HostDAO dao = sqlSession.getMapper(HostDAO.class);

		System.out.println("삭제시작" + doForm_id);
		deleteCnt = dao.DonateDeletePro(doForm_id);

		System.out.println("deleteCnt" + deleteCnt);
		return deleteCnt;
	}

	// 이번 달 기부 (업체별) -- 1. doForm_id 가져오는 메소드 : getDoFormId()
	@Override
	public Integer getDoFormId(Integer doForm_id) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		Integer selectCnt = dao.getDoFormId(doForm_id);

		return selectCnt;
	}

	// 이번 달 기부 (업체별) -- 2. 업체별로 기부 모금액 가져오는 메소드 : thisMonthDonate()
	@Override
	public Integer thisMonthDonate(int doForm_id) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		Integer thisMonthDonate = dao.thisMonthDonate(doForm_id);

		return thisMonthDonate;
	}

	// 올해 기부 모금액
	@Override
	public Integer monthDonate(int month) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);

		Integer monthDonate = dao.monthDonate(month);

		return monthDonate;
	}

	// 3.업체별 기부액 3년치
	@Override
	public Integer yearDonate(Map<String, Integer> mapParam) {
		Integer aucSales = 0;

		System.out.println(mapParam);
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		aucSales = dao.yearDonate(mapParam);

		return aucSales;
	}
	// *************************************************************************************
	// **************************************** 주말농장
	// *************************************
	// *************************************************************************************

	// 주말농장 건수
	@Override
	public int getWeekFarmCnt(int wfarm_status) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		int selectCnt = dao.getWeekFarmCnt(wfarm_status);

		return selectCnt;
	}

	// 주말농장 요청현황 조회
	@Override
	public ArrayList<WeekFarmDTO> getWeekFarmRequestList(Map<String, Object> map) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		ArrayList<WeekFarmDTO> dtos = dao.getWeekFarmRequestList(map);

		return dtos;
	}

	// 주말농장 현황 조회
	@Override
	public ArrayList<WeekFarmDTO> getWeekFarmList(Map<String, Object> map) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		ArrayList<WeekFarmDTO> dtos = dao.getWeekFarmList(map);

		return dtos;
	}

	// 주말농장 요청승인
	@Override
	public int weekFarmReqPermit(Map<String, Object> map) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		int updateCnt = dao.weekFarmReqPermit(map);

		return updateCnt;
	}

	// 주말농장 삭제
	@Override
	public int weekFarmDelete(int wfarm_key) {
		HostDAO dao = sqlSession.getMapper(HostDAO.class);
		int deleteCnt = dao.weekFarmDelete(wfarm_key);

		return deleteCnt;
	}
}
