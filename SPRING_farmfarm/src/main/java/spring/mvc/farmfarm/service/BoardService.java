package spring.mvc.farmfarm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {

	// 게시판
	public void boardList(HttpServletRequest req, Model model);

	// 요청게시판상세
	public void RequestBoardContent(HttpServletRequest req, Model model);

	// 요청게시판 글쓰기 처리페이지
	public void RequestBoardWritePro(HttpServletRequest req, Model model);

	// 요청게시판 댓글 처리
	public void commentBoardWritePro(HttpServletRequest req, Model model);

	// 글수정 상세페이지
	public void modifyView(HttpServletRequest req, Model model);

	// 글수정 처리페이지
	public void modifyProBoard(HttpServletRequest req, Model model);

	// 댓글 처리페이지
	public void commentModifyPopPro(HttpServletRequest req, Model model);

	// 본글삭제
	public void deleteBoardPro(HttpServletRequest req, Model model);

	// 댓글 삭제
	public void commentDeletePro(HttpServletRequest req, Model model);

	// 소식게시판
	public void newsList(HttpServletRequest req, Model model);

	// 소식게시판 상세
	public void NewsBoardContent(HttpServletRequest req, Model model);

	// 소식게시판 글쓰기 처리
	public void NewsBoardWritePro(MultipartHttpServletRequest req, Model model);

	// 소식게시판 글수정 처리
	public void NewsModifyBoardPro(MultipartHttpServletRequest req, Model model);

	// 소식게시판 글삭제 처리
	public void NewsDeleteBoardPro(HttpServletRequest req, Model model);
}
