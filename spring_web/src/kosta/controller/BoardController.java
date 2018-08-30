package kosta.controller;

import java.io.File;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kosta.model.Board;
import kosta.model.BoardValidator;
import kosta.service.BoardService;
import kosta.service.HelloService;

@Controller
public class BoardController {

	private BoardService serv;
	private String uploadDir= "E:/upload";

	public BoardController(BoardService serv) {
		super();
		this.serv = serv;
	}

	public BoardService getServ() {
		return serv;
	}

	@Autowired
	public void setServ(BoardService serv) {
		this.serv = serv;
	}

	/*
	 * @RequestMapping("insertForm.do") //2 public String insertForm (Model
	 * model){ model.addAttribute("title", service.getMessage());
	 * 
	 * return "insert_form"; //뷰이름설정 }
	 * 
	 * @RequestMapping("board_insert.do") //3 public String Board_Insert (Board
	 * board){
	 * 
	 * board.getTitle(); board.getWriter(); board.getContents();
	 * 
	 * System.out.println(board);
	 * 
	 * return null;
	 * 
	 * 
	 * }
	 */

	@RequestMapping(value = "board_insert", method = RequestMethod.GET) 
	// 3 동일한 url 호출시 get과 post 메소드로 구별가능 하다.

	public String insertForm(@ModelAttribute("boardCommand") Board board, Model model) {
		model.addAttribute("title", "qkqh");

		return "insert_form"; // 뷰이름설정
	}

	@RequestMapping(value ="board_insert", method = RequestMethod.POST) // 4
	public String board_Insert(@ModelAttribute("boardCommand") @Valid Board board,BindingResult errors) {
		
		if(errors.hasErrors()){
			System.out.println("error 발생");
			return "insert_form";
		}
		
		  MultipartFile multi = board.getUploadFile();
	      if(multi != null){
	         String fname = multi.getOriginalFilename(); //파일 이름 꺼내기
	         System.out.println("file: " + fname);
	         board.setFname(fname); //board에 filename 넣기.
	         
	         try {
	            multi.transferTo(new File(uploadDir,fname));
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	         
	      }
	      serv.insertBoardService(board);
	      
	      return "redirect:board_list"; //새로운 요청이니  redirect


	}
	
	/*@InitBinder      
	 *  //validator 객체 board 클래스에서 언노테이션으로 validate를 사용 할수 있다. 
	 *  메소드파라미터에 @valid 언노테이션 사용
	protected void InitBinder(WebDataBinder binder){
		binder.setValidator(new BoardValidator());
	}
*/
	@RequestMapping("board_list")
	public String Boardlist(Model model) {
        List<Board> list = serv.listBoardService();
		
        model.addAttribute("list",list);

		return "list";
	}
	//RequestParam
/*	@RequestMapping("board_detail")
	public String DetailBoard(@RequestParam("seq") int seq ,Model model){
		Board board= serv.detailBoardService(seq);
		model.addAttribute("board", board);
		
		return "detail";
		
	}*/
	//PathVariable
	@RequestMapping("board_detail{seq}")
	public String DetailBoard(@PathVariable int seq ,Model model){
		Board board= serv.detailBoardService(seq);
		model.addAttribute("board", board);
		
		return "detail";
		
	}
	
	@RequestMapping("spring_client1")
	public String spring_client1(){
		
		return "jlist";
	}
	
	@RequestMapping("board_download")
	public String board_download(@RequestParam("filename") String filename
			,Model model )throws Exception{
		File file= new File(uploadDir, filename);
		model.addAttribute("downloadFile", file);
		
		return "downloadView";
	}
}
