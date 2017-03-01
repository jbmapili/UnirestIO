package com.jb.manga.entity;

import java.io.Serializable;

public class UserList implements Serializable{
	private String mangaId;
	private String name;
	public String getMangaId() {
		return mangaId;
	}
	public void setMangaId(String mangaId) {
		this.mangaId = mangaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
