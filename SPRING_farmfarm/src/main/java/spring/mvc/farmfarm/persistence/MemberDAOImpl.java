package spring.mvc.farmfarm.persistence;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.farmfarm.dto.AdvantageDTO;
import spring.mvc.farmfarm.dto.MemDoDTO;
import spring.mvc.farmfarm.dto.MemberDTO;
import spring.mvc.farmfarm.dto.RankingDTO;
import spring.mvc.farmfarm.dto.SearchingDTO;


@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession ss;
	
	//아이디중복확인
	@Override
	public int idPwdCheck(Map<String, String> map) {
		int selectCnt=0;		
		MemberDAO dao =ss.getMapper(MemberDAO.class);
				
		selectCnt=dao.idPwdCheck(map);
		return selectCnt;
	}

	//id,pwd확인
	@Override
	public int idCheck(String strId) {
		int selectCnt=0;		
		MemberDAO dao =ss.getMapper(MemberDAO.class);
		System.out.println("strId dao"+strId);
		selectCnt=dao.idCheck(strId);
		return selectCnt;
	}

	//회원가입처리
	@Override
	public int insertMember(MemberDTO dto) {
		int insertCnt=0;		
		MemberDAO dao =ss.getMapper(MemberDAO.class);
		insertCnt=dao.insertMember(dto);
		return insertCnt;
	}

	@Override
	public int deleteMember(String strId) {
		int deleteCnt=0;
		MemberDAO dao =ss.getMapper(MemberDAO.class);
		deleteCnt=dao.deleteMember(strId);
		return deleteCnt;
	}

	@Override
	public MemberDTO getMemberInfo(String strId) {
		MemberDTO dto=null;
		MemberDAO dao =ss.getMapper(MemberDAO.class);
		dto=dao.getMemberInfo(strId);
		return dto;
	}

	@Override
	public int UpdateMember(MemberDTO dto) {
		int updateCnt=0;
		MemberDAO dao =ss.getMapper(MemberDAO.class);
		updateCnt=dao.UpdateMember(dto);
		return updateCnt;
	}

	@Override
	public int getAdvCnt(String strId) {
		int selectCnt=0;
		MemberDAO dao =ss.getMapper(MemberDAO.class);
		selectCnt=dao.getAdvCnt(strId);
		return selectCnt;
	}

	@Override
	public ArrayList<AdvantageDTO> getAdv(Map<String,Object> map) {
		ArrayList<AdvantageDTO> dtos=null;
		MemberDAO dao =ss.getMapper(MemberDAO.class);
		dtos=dao.getAdv(map);
		return dtos;
	}

	@Override
	public ArrayList<RankingDTO> getFundJoiner() {
		ArrayList<RankingDTO> dtos=null;
		MemberDAO dao =ss.getMapper(MemberDAO.class);
		dtos=dao.getFundJoiner();
		return dtos;
	}

	@Override
	public ArrayList<RankingDTO> getFundRanking() {
		ArrayList<RankingDTO> dtos=null;
		MemberDAO dao =ss.getMapper(MemberDAO.class);
		dtos=dao.getFundRanking();
		return dtos;
	}

	@Override
	public ArrayList<RankingDTO> getAucJoiner() {
		ArrayList<RankingDTO> dtos=null;
		MemberDAO dao =ss.getMapper(MemberDAO.class);
		dtos=dao.getAucJoiner();
		return dtos;
	}

	@Override
	public ArrayList<RankingDTO> getAucRanking() {
		ArrayList<RankingDTO> dtos=null;
		MemberDAO dao =ss.getMapper(MemberDAO.class);
		dtos=dao.getAucRanking();
		return dtos;
	}

	@Override
	public ArrayList<RankingDTO> getDonateRanking() {
		ArrayList<RankingDTO> dtos=null;
		MemberDAO dao =ss.getMapper(MemberDAO.class);
		dtos=dao.getDonateRanking();
		return dtos;
	}

	
	@Override
	public int getSearchCnt(String keyword) {
		int selectCnt=0;
		MemberDAO dao =ss.getMapper(MemberDAO.class);
		selectCnt=dao.getSearchCnt(keyword);
		return selectCnt;
	}
	
	@Override
	public ArrayList<SearchingDTO> getSearchData(Map<String,Object> map) {
		ArrayList<SearchingDTO> dtos=null;
		MemberDAO dao = ss.getMapper(MemberDAO.class);
		
		dtos=dao.getSearchData(map);
		return dtos;
	}

	

}
