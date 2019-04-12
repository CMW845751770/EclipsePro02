package cn.edu.tju.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.tju.pojo.Blog;
import cn.edu.tju.pojo.Comment;
import cn.edu.tju.pojo.PageInfo;
import cn.edu.tju.service.BlogService;
import cn.edu.tju.service.CommentService;

@Controller
@RequestMapping("/blog")
public class BlogController {
	@Resource
	private BlogService blogServiceImpl;

	@Resource
	private CommentService commentServiceImpl;

	@RequestMapping("/show")
	public String showBlogByPage(@RequestParam(defaultValue = "1") int pageSize,
			@RequestParam(defaultValue = "1") int pageNumber,
			@RequestParam(defaultValue = "design") String type ,Model model) 
	{
		PageInfo pi = blogServiceImpl.selBlogByPage(pageSize, pageNumber, type);
		model.addAttribute("blogPage", pi) ; 
		return "forward:/main.html" ; 
	}

	@RequestMapping("/view")
	public ModelAndView viewBlog(@RequestParam("bid")int bid,  @RequestParam(defaultValue = "6") int pageSize,
			@RequestParam(defaultValue = "1") int pageNumber) 
	{
		System.out.println("BlogController.viewBlog()");
		ModelAndView model = new ModelAndView("forward:/details.html") ; 
		Blog blog = blogServiceImpl.selById(bid);
		PageInfo pi = commentServiceImpl.selCommentsByBidAndPage(bid, pageSize, pageNumber);
		blog.setComments(pi);
		model.addObject("blog", blog);
		return model;
	}

	@ResponseBody
	@RequestMapping("insertComment")
	public Map<String, Object> insertComment(String content, String userName, int bid) {
		Map<String, Object> map = new HashMap<>();
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setDate(new Date().toLocaleString());
		comment.setPerson(userName);
		comment.setBid(bid);
		System.out.println(comment);
		int index = commentServiceImpl.insComment(comment);
		if (index > 0) {
			map.put("msg", "success");
			return map;
		}
		map.put("msg", "failed");
		return map;
	}

	@RequestMapping("pageTurning")
	public ModelAndView pageTurning(int bid, String type, int flag, @RequestParam(defaultValue = "6") int pageSize,
			@RequestParam(defaultValue = "1") int pageNumber) 
	{
		ModelAndView model = new ModelAndView() ; 
		if(flag == 0)//��һƪ����
		{ 
			Blog blog = blogServiceImpl.selPrevByBid(bid, type) ;
			if(blog == null)
			{
				model.setViewName("forward:/blog/view?bid="+bid);
				return model   ; 
			}
			else
			{
				System.out.println(blog.getId());
				PageInfo pi = commentServiceImpl.selCommentsByBidAndPage(blog.getId(), pageSize, pageNumber);
				blog.setComments(pi);
				model.addObject("blog", blog) ;
				model.setViewName("forward:/details.html");
				return model;
			}
		}
		else if(flag == 1 )
		{
			Blog blog = blogServiceImpl.selNextByBid(bid, type) ;
			if(blog == null)
			{
				model.setViewName("forward:/blog/view?bid="+bid );
				return  model ; 
			}
			else
			{
				PageInfo pi = commentServiceImpl.selCommentsByBidAndPage(blog.getId(), pageSize, pageNumber);
				blog.setComments(pi);
				model.addObject("blog", blog) ;
				model.setViewName("forward:/details.html");
				return model;
			}
		}
		model.setViewName("forward:/blog/view?bid="+bid);
		return model   ; 
	}

}
