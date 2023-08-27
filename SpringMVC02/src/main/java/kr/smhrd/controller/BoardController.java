package kr.smhrd.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.smhrd.entity.Board;
import kr.smhrd.mapper.BoardMapper;

@Controller //POJO 표시
public class BoardController { // new BoardController {}
	
	@Autowired //(DI : 의존성주의)
	private BoardMapper mapper;
	// 1. 리스트 요청 처리 : /list.do --> boardList() : HandlerMapping(헨들러메핑)
	@RequestMapping("/list.do")
	public String boardList(Model request) {
		
		List<Board> list = mapper.boardList();
		request.addAttribute("list",list); // <-- 객체 바인딩(HttpServletRequest, HttpSession, ServletContext)
		
		return "boardList"; // forward방식 무조건 jsp로~~ // 뷰의 논리적인 이름 --> 물리적인 위치로 변경(ViewResovler)
	}
	// 2. 게시글 등록 UI 요청 처리
	@GetMapping("register.do")
	public String register() {
		return "register"; // /WEB_INF/views/register.jsp
	}
	
	// 2. 게시글 등록 요청 처리
	@PostMapping("/register.do") //register.jsp(등록화면) : title, content, writer
	public String register(Board vo) { // vo = new Board(){}
		mapper.boardInsert(vo); // 등록성공
		return "redirect:/list.do"; //redirect 방식 사용법
	}
	
	// 3. 상세보기 요청 처리
	@RequestMapping("/get.do") // ?num = 10 --> @RequestParam("num") int idx
	public String get(int num, Model model) {
		Board vo = mapper.boardGet(num);
		model.addAttribute("vo", vo); //*************
		//조회수 누적
		mapper.count(num);
		
		return "get"; // get.jsp
	}
	
	// 4. 삭제 요청 처리
	@RequestMapping("/remove.do")
	public String remove(int num) {
		mapper.boardDelete(num);
		return "redirect:/list.do";
	}
	
	// 5. 수정 화면 요청 처리
	@GetMapping("/modify.do") // ?num=10
	public String modify(int num, Model model) {
		Board vo = mapper.boardGet(num);
		model.addAttribute("vo", vo);
		return "modify";
	}
	
	// 6. 수정하기 요청 처리 //num, title, content
	@PostMapping("modify.do")
	public String modify(Board vo, RedirectAttributes rttr) {
		mapper.boardModify(vo);
		// 수정 성공 -> 리스트 페이지(list.do) or 상세보기 페이지(get.do)로 이동
		//return "redirect:/list.do";
		rttr.addAttribute("num", vo.getNum()); //***** ? num=10
		return "redirect:/get.do";
	}
}










