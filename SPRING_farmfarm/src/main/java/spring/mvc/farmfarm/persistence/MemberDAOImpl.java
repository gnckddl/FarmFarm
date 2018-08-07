package spring.mvc.farmfarm.persistence;

import java.util.ArrayList;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

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

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private JavaMailSender mailSender; // xml에 등록한 bean autowired
	// 아이디중복확인

	@Override
	public int idPwdCheck(Map<String, String> map) {
		int selectCnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);

		selectCnt = dao.idPwdCheck(map);
		return selectCnt;
	}

	// id,pwd확인
	@Override
	public int idCheck(String strId) {
		int selectCnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		System.out.println("strId dao" + strId);
		selectCnt = dao.idCheck(strId);
		return selectCnt;
	}

	// 회원가입처리
	@Override
	public int insertMember(MemberDTO dto) {
		int insertCnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		insertCnt = dao.insertMember(dto);
		return insertCnt;
	}

	@Override
	public int deleteMember(String strId) {
		int deleteCnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		deleteCnt = dao.deleteMember(strId);
		return deleteCnt;
	}

	@Override
	public MemberDTO getMemberInfo(String strId) {
		MemberDTO dto = null;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dto = dao.getMemberInfo(strId);
		return dto;
	}

	@Override
	public int UpdateMember(MemberDTO dto) {
		int updateCnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		updateCnt = dao.UpdateMember(dto);
		return updateCnt;
	}

	@Override
	public int getAdvCnt(String strId) {
		int selectCnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		selectCnt = dao.getAdvCnt(strId);
		return selectCnt;
	}

	@Override
	public ArrayList<AdvantageDTO> getAdv(Map<String, Object> map) {
		ArrayList<AdvantageDTO> dtos = null;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dtos = dao.getAdv(map);
		return dtos;
	}

	@Override
	public ArrayList<RankingDTO> getFundRanking() {
		ArrayList<RankingDTO> dtos = null;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dtos = dao.getFundRanking();
		return dtos;
	}

	@Override
	public ArrayList<RankingDTO> getAucJoiner() {
		ArrayList<RankingDTO> dtos = null;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dtos = dao.getAucJoiner();
		return dtos;
	}

	@Override
	public ArrayList<RankingDTO> getAucRanking() {
		ArrayList<RankingDTO> dtos = null;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dtos = dao.getAucRanking();
		return dtos;
	}

	@Override
	public ArrayList<RankingDTO> getDonateRanking() {
		ArrayList<RankingDTO> dtos = null;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dtos = dao.getDonateRanking();
		return dtos;
	}

	@Override
	public int getSearchCnt(String keyword) {
		int selectCnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		selectCnt = dao.getSearchCnt(keyword);
		return selectCnt;
	}

	@Override
	public ArrayList<SearchingDTO> getSearchData(Map<String, Object> map) {
		ArrayList<SearchingDTO> dtos = null;
		MemberDAO dao = ss.getMapper(MemberDAO.class);

		dtos = dao.getSearchData(map);
		return dtos;
	}

	@Override
	public ArrayList<AuctionListDTO> getAuctionList() {
		ArrayList<AuctionListDTO> dtos = null;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dtos = dao.getAuctionList();
		return dtos;
	}

	@Override
	public AuctionDTO getAuctionContent(String auc_no) {
		AuctionDTO dto = null;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dto = dao.getAuctionContent(auc_no);
		return dto;
	}

	@Override
	public Integer getNowPrice(String auc_no) {
		Integer nowPrice = 0;
		MemberDAO dao = null;
		dao = ss.getMapper(MemberDAO.class);
		nowPrice = dao.getNowPrice(auc_no);
		return nowPrice;
	}

	@Override
	public ArrayList<DonateDTO> getDonateList() {
		ArrayList<DonateDTO> dtos = null;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dtos = dao.getDonateList();
		return dtos;
	}

	@Override
	public int auctionUpdate(Map<String, Object> map) {
		int updateCnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		updateCnt = dao.auctionUpdate(map);
		return updateCnt;
	}

	@Override
	public int auctionJoinInsert(Map<String, Object> map) {
		int insertCnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		insertCnt = dao.auctionJoinInsert(map);
		return insertCnt;
	}

	@Override
	public Integer auctionJoinCheck(Map<String, Object> map) {
		Integer check = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		check = dao.auctionJoinCheck(map);
		return check;
	}

	@Override
	public int auctionJoinUpdate(Map<String, Object> map) {
		int updateCnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		updateCnt = dao.auctionJoinUpdate(map);
		return updateCnt;
	}

	@Override
	public void auctionJoinAdv(Map<String, Object> map) {
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dao.auctionJoinAdv(map);
	}

	// 펀드상품보기 글갯수
	@Override
	public int getFundCnt() {
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		int selectCnt = dao.getFundCnt();
		System.out.println("셀렉트씨엔띠" + selectCnt);
		return selectCnt;
	}

	// 펀드상품보기리스트
	@Override
	public ArrayList<FundDTO> getFundProductsList(Map<String, Object> map) {
		ArrayList<FundDTO> dtos = null;

		// 2, 큰바구니 생성(dtos)
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dtos = dao.getFundProductsList(map);
		return dtos;
	}

	// 펀드상품보기 상세
	@Override
	public FundDTO getFundArticle(String fund_no) {

		FundDTO dto = new FundDTO();
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dto = dao.getFundArticle(fund_no);
		return dto;
	}

	/**
	 * 장렬
	 */
	// 이메일 인증
	@Override
	public String sendmail(String email, String key) {
		try {
			MimeMessage message = mailSender.createMimeMessage();

			String txt = "팜팜(관리자) - 이메일 인증에 필요한 키값입니다." + key;
			message.setSubject("저희 사이트 회원가입 인증 메일입니다.");
			message.setText(txt, "UTF-8", "html");
			message.setFrom(new InternetAddress("admin@mss.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(email));
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}

	/**
	 * 민웅
	 */
	// 농부 신청 - 처리
	@Override
	public int BecomFarm(BecomeFarmerDTO dto) {
		int updateCnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		updateCnt = dao.BecomFarm(dto);
		return updateCnt;
	}

	// 기부내역
	@Override
	public ArrayList<DonateListDTO> getDonated(String mem_id) {
		ArrayList<DonateListDTO> dtos = null;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dtos = dao.getDonated(mem_id);
		for (int i = 0; i < dtos.size(); i++) {
			System.out.println("name :" + dtos.get(i).getDoOrg_name());
		}
		return dtos;
	}

	@Override
	public void updateAdv(Map<String, Object> map) {
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dao.updateAdv(map);
	}

	@Override
	public ArrayList<AuctionDTO> getAuctionData(String userId) {
		ArrayList<AuctionDTO> dtos = null;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dtos = dao.getAuctionData(userId);
		return dtos;
	}

	@Override
	public Integer getAuctionDataCnt(String userId) {
		Integer selectCnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		selectCnt = dao.getAuctionDataCnt(userId);
		return selectCnt;
	}

	@Override
	public ArrayList<AuctionDTO> getAuctionProgress(Map<String, Object> map) {
		ArrayList<AuctionDTO> dtos = null;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dtos = dao.getAuctionProgress(map);
		return dtos;
	}

	// 경매리스트 상세 농부데이터
	@Override
	public AuctionFarmerDTO getAuctionFarmer(int farm_key) {
		AuctionFarmerDTO dto = null;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		dto = dao.getAuctionFarmer(farm_key);
		return dto;
	}

	@Override
	public int getAuctionFarmerFund(int farm_key) {
		int cnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		cnt = dao.getAuctionFarmerFund(farm_key);
		return cnt;
	}

	@Override
	public int getAuctionFarmerAuction(int farm_key) {
		int cnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		cnt = dao.getAuctionFarmerAuction(farm_key);
		return cnt;
	}

	// 펀드 참여한적 있는지 체크
	@Override
	public Integer FundJoinCheck(Map<String, Object> map) {
		Integer check = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		check = dao.FundJoinCheck(map);
		return check;
	}

	// 펀드 참여처리(fund table update)
	@Override
	public int FundUpdate(Map<String, Object> map) {
		int updateCnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		updateCnt = dao.FundUpdate(map);
		return updateCnt;
	}

	@Override
	public int FundJoinInsert(Map<String, Object> map) {
		int insertCnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		insertCnt = dao.FundJoinInsert(map);
		return insertCnt;
	}

	@Override
	public int FundJoinUpdate(Map<String, Object> map) {
		int updateCnt = 0;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		updateCnt = dao.FundJoinUpdate(map);
		return updateCnt;
	}

}
