package com.poscodx.jblog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poscodx.jblog.service.BlogService;
import com.poscodx.jblog.service.FileUploadService;
import com.poscodx.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/{id:^(?!assets$|user$|blog$).*}")
public class BlogController {
	@Autowired
	private BlogService blogService;
	@Autowired
	private FileUploadService fileUploadService;

	@RequestMapping({ "", "/{categoryNo}", "/{categoryNo}/{postNo}" })
	public String index(@PathVariable("id") String blogId,
			@PathVariable(value = "categoryNo", required = false) Long categoryNo,
			@PathVariable(value = "postNo", required = false) Long postNo, Model model) {

		Map<String, Object> map = blogService.getBlog(blogId, categoryNo, postNo);

		model.addAttribute("map", map);

		return "blog/main";
	}

	@RequestMapping("/admin/basic")
	public String adminBasic(@PathVariable("id") String blogId, Model model) {
		
		Map<String, Object> map = blogService.getBlog(blogId, null, null);

		model.addAttribute("map", map);
		
		return "blog/admin-basic";
	}

	@RequestMapping("/admin/category")
	public String adminCategory(@PathVariable("id") String blogId, Model model) {
		
		Map<String, Object> map = blogService.getBlog(blogId, null, null);

		model.addAttribute("map", map);
		

		List<CategoryVo> list = blogService.getDetailCategory(blogId);

		model.addAttribute("list", list);
		return "blog/admin-category";
	}

	@RequestMapping("/admin/write")
	public String adminWrite(@PathVariable("id") String blogId, Model model) {
		
		Map<String, Object> map = blogService.getBlog(blogId, null, null);

		model.addAttribute("map", map);
		

		List<CategoryVo> list = blogService.getCategory(blogId);

		model.addAttribute("list", list);
		return "blog/admin-write";
	}

	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable("id") String blogId, @PathVariable("no") Long no) {
		blogService.delete(blogId, no);
		return "redirect:/" + blogId + "/admin/category";
	}

	@RequestMapping("/writecategory")
	public String writeCategory(@PathVariable("id") String blogId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "description", required = false) String description) {
		blogService.writeCategory(blogId, name, description);
		return "redirect:/" + blogId + "/admin/category";
	}

	@RequestMapping("/writepost")
	public String writePost(@PathVariable("id") String blogId,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "category", required = false) Long categoryNo,
			@RequestParam(value = "contents", required = false) String contents) {
		blogService.writePost(blogId, title, categoryNo, contents);
		return "redirect:/" + blogId + "/admin/write";
	}

	@RequestMapping("/updateblog")
	public String updateBlog(@PathVariable("id") String blogId, @RequestParam("f") MultipartFile file,
			@RequestParam(value = "title", required = false) String title) {
		String url = fileUploadService.restore(file);

		blogService.updateBlog(blogId, title, url);

		return "redirect:/" + blogId + "/admin/basic";
	}

}