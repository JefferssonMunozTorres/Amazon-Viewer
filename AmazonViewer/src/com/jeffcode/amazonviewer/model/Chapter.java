package com.jeffcode.amazonviewer.model;

public class Chapter extends Movie{

	private int id;
	
	public Chapter(String title, int duration) {
		super(title, duration);
	}


	@Override
	public int getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
	// TODO Auto-generated method stub
	return "::CHAPTER::"+
			"\nTitle: " + getTitle() + 
			"\nDuration: "+getDuration();
	}

	
}
