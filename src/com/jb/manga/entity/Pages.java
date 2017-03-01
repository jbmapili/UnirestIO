package com.jb.manga.entity;
import java.io.Serializable;


public class Pages implements Serializable{
	private Integer pageId;
	private String url;
	public Integer getPageId() {
		return pageId;
	}
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
