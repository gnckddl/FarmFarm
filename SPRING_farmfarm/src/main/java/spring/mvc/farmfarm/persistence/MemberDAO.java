package spring.mvc.farmfarm.persistence;

import java.util.ArrayList;
import java.util.Map;

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

public interface MemberDAO {
	// 아이디중복확인
	public int idCheck(String strId);

	// id,pwd확인
	public int idPwdCheck(Map<String, String> map);

	// 회원가입처리
	public int insertMember(MemberDTO dto);

	// 회원탈퇴처리
	public int deleteMember(String strId);

	// 회원정보 수정뷰
	public MemberDTO getMemberInfo(String strId);

	// 회원정보 수정처리
	public int UpdateMember(MemberDTO dto);

	// 회원 점수 기록횟수
	public int getAdvCnt(String strId);

	// 회원 점수목록 가져오기
	public ArrayList<AdvantageDTO> getAdv(Map<String, Object> map);

	// 펀드랭킹 데이터
	public ArrayList<RankingDTO> getFundRanking();

	// 경매랭킹 참여자수
	public ArrayList<RankingDTO> getAucJoiner();

	// 경매랭킹 데이터
	public ArrayList<RankingDTO> getAucRanking();

	// 기부 랭킹 데이터
	public ArrayList<RankingDTO> getDonateRanking();

	// 검색 데이터 수
	public int getSearchCnt(String keyword);

	// 검색 데이터
	public ArrayList<SearchingDTO> getSearchData(Map<String, Object> map);

	// 경매리스트
	public ArrayList<AuctionListDTO> getAuctionList();

	// 경매리스트 상세
	public AuctionDTO getAuctionContent(String auc_no);

	// 경매리스트 상세 농부데이터
	public AuctionFarmerDTO getAuctionFarmer(int farm_key);

	// 경매리스트 상세 농부 펀드개설갯수
	public int getAuctionFarmerFund(int farm_key);

	// 경매리스트 상세 농부 옥션개설갯수
	public int getAuctionFarmerAuction(int farm_key);

	// 현재 경매가 가져오기
	public Integer getNowPrice(String auc_no);

	// 경매 입찰처리(auction table update)
	public int auctionUpdate(Map<String, Object> map);

	// 경매 입찰처리(join table insert)
	public int auctionJoinInsert(Map<String, Object> map);

	// 경매 입찰처리(join table update)
	public int auctionJoinUpdate(Map<String, Object> map);

	// 경매 참여한적 있는지 체크
	public Integer auctionJoinCheck(Map<String, Object> map);

	// 경매참여후 포인트추가
	public void auctionJoinAdv(Map<String, Object> map);

	// 회원경매 참여내역 cnt
	public Integer getAuctionDataCnt(String userId);

	// 회원 경매참여내역
	public ArrayList<AuctionDTO> getAuctionData(String userId);

	// 회원 경매진행내역 받기
	public ArrayList<AuctionDTO> getAuctionProgress(Map<String, Object> map);

	// 펀드리스트 글갯수
	public int getFundCnt();

	// 펀드상품 리스트
	public ArrayList<FundDTO> getFundProductsList(Map<String, Object> map);

	// 펀드 상세 리스트
	public FundDTO getFundArticle(String fund_no);

	// 기부업체명 리스트 가져오기
	public ArrayList<DonateDTO> getDonateList();

	/**
	 * 장렬
	 */
	// 이메일 인증
	public String sendmail(String email, String key);

	/**
	 * 민웅
	 */
	// 농부 신청 - 처리
	public int BecomFarm(BecomeFarmerDTO dto);

	// 기부 내역
	public ArrayList<DonateListDTO> getDonated(String mem_id);

	// 멤버 adv점수 업데이트
	public void updateAdv(Map<String, Object> map);

	// 펀드 참여한적 있는지 체크
	public Integer FundJoinCheck(Map<String, Object> map);

	// 펀드 참여처리(join table insert)
	public int FundJoinInsert(Map<String, Object> map);

	// 펀드 참여처리(fund table update)
	public int FundUpdate(Map<String, Object> map);

	// 펀드 참여한적있는사람처리(join table update)
	public int FundJoinUpdate(Map<String, Object> map);
}
