package spring.mvc.farmfarm.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
/**
 * 농부 서비스 인터페이스
 */

public interface FarmerService {

	/**
	 * 장렬 
	 */
	// 회원 보낸 쪽지함 / 농부 받은 쪽지함
	public void LetterList(HttpServletRequest req, Model model);
	
	// 쪽지함 상세 보기
	public void LTContentsForm(HttpServletRequest req, Model model);
	
	// 작성한 쪽지 전송처리
	public void LTWritePro(HttpServletRequest req, Model model);
	
/*	// 쪽지 삭제 처리
	public void LTDeletePro(HttpServletRequest req, Model model);*/
	
	/**
	 * 민웅
	 */
	// 상품 등록 - 처리
	public void Auction_ApplyPro(HttpServletRequest req, Model model);
}
