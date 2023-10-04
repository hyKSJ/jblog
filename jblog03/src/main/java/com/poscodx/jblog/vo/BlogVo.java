package com.poscodx.jblog.vo;

public class BlogVo {

	private String title;
	private String image;
	private String blogId;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	@Override
	public String toString() {
		return "BlogVo [title=" + title + ", image=" + image + ", blogId=" + blogId + "]";
	}
	
}
