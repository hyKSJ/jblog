package com.poscodx.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.CategoryVo;
import com.poscodx.jblog.vo.PostVo;

@Repository
public class BlogRepository {

	@Autowired
	private SqlSession sqlSession;

	public BlogVo findBlog(String blogId) {

		System.out.println(blogId);
		return sqlSession.selectOne("blog.findBlog", blogId);
	}

	public List<CategoryVo> findCategory(String blogId) {

		return sqlSession.selectList("blog.findCategory", blogId);
	}

	public List<PostVo> findPost(String blogId, Long categoryNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("blogId", blogId);
		map.put("categoryNo", categoryNo);

		return sqlSession.selectList("blog.findPost", map);
	}
	
	public List<CategoryVo> findDetailCategory(String blogId) {
		return sqlSession.selectList("blog.findDetailCategory", blogId);
	}
	
	public void delete(String blogId, Long no) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("blogId", blogId);
        map.put("no", no);

        sqlSession.delete("blog.deletePost", map);
        sqlSession.delete("blog.deleteCategory", map);
        
    }
	
	public void writeCategory(String blogId, String name, String description) {
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("blogId", blogId);
        map.put("name", name);
        map.put("description", description);
        sqlSession.insert("blog.writeCategory", map);
	}
	
	public void writePost(String blogId, String title, Long categoryNo, String contents) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("blogId", blogId);
		map.put("title", title);
		map.put("categoryNo", categoryNo);
		map.put("contents", contents);
		sqlSession.insert("blog.writePost", map);
	}
	
	public void updateBlog(String blogId, String title, String url) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("blogId", blogId);
		map.put("title", title);
		map.put("url", url);
		sqlSession.update("blog.updateBlog", map);
	}
}