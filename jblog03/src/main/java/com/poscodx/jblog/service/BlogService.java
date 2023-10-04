package com.poscodx.jblog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.jblog.repository.BlogRepository;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.CategoryVo;
import com.poscodx.jblog.vo.PostVo;

@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;

	public Map<String, Object> getBlog(String blogId, Long categoryNo, Long postNo) {
		Map<String, Object> map = new HashMap<String, Object>();

		BlogVo blogVo = blogRepository.findBlog(blogId);
		List<CategoryVo> list2 = blogRepository.findCategory(blogId);
		List<PostVo> list3 = blogRepository.findPost(blogId, categoryNo);

		map.put("blogVo", blogVo);
		map.put("list2", list2);
		map.put("list3", list3);
		map.put("postNo", postNo);
		map.put("blogId", blogId);

		return map;
	}
	
	public List<CategoryVo> getCategory(String blogId) {
		
		List<CategoryVo> list = blogRepository.findCategory(blogId);
		return list;
	}
	
	public List<CategoryVo> getDetailCategory(String blogId) {
		
		List<CategoryVo> list = blogRepository.findDetailCategory(blogId);
		return list;
	}
	
	public void delete(String blogId, Long no) {
		blogRepository.delete(blogId, no);
	}

	public void writeCategory(String blogId, String name, String description) {
		blogRepository.writeCategory(blogId, name, description);
	}
	
	public void writePost(String blogId, String title, Long categoryNo, String contents) {
		blogRepository.writePost(blogId, title, categoryNo, contents);
	}
	
	public void updateBlog(String blogId, String title, String url) {
		blogRepository.updateBlog(blogId, title, url);
	}
}
