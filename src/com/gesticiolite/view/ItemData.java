package com.gesticiolite.view;

public class ItemData {
	private String title;
	private int imageUrl;
	
	public ItemData(String title, int imageUrl){
		this.title = title;
		this.imageUrl = imageUrl;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setimageUrl(int imageUrl){
		this.imageUrl = imageUrl;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public int getImageUrl(){
		return this.imageUrl;
	}
}
