package spring.mvc.farmfarm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BoardService {

	//게시판
	public void boardList(HttpServletRequest req, Model model);
	//요청게시판상세
   public void RequestBoardContent(HttpServletRequest req, Model model);
}
