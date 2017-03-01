package com.jb.manga.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class UsersChapter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8360642314806418264L;
	
	private String href;
	private String name;
	private String lastUpdate;
	private List<Pages> pages;
	
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public List<Pages> getPages() {
		return pages;
	}
	public void setPages(List<Pages> pages) {
		this.pages = pages;
	}
	
}
