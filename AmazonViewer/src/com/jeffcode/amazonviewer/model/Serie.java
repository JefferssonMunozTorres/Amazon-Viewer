package com.jeffcode.amazonviewer.model;

import java.util.ArrayList;

public class Serie extends Film {

	private int id;
	private int chapterQuantity;
	private ArrayList<Chapter> chapters;
	
	public Serie(String title, String genre, String creator, int duration, short year, int chapterQuantity) {
		super(title, genre, creator, duration);
		this.setYear(year);
		this.chapterQuantity = chapterQuantity;
	}
	
	public int getId() {
		return id;
	}
	
	public int getChapterQuantity() {
		return chapterQuantity;
	}
	
	public void setChapterQuantity (int chapterQuantity) {
		this.chapterQuantity=chapterQuantity;
	}

	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return 	"::SERIE::"+
				"\nTitle: " + getTitle() + 
				"\nGenre: " + getGenre()+
				"\nYear: " + getYear()+
				"\nCreator: " + getCreator()+
				"\nDuration: " + getDuration()+
				"\nChapters: "+ getChapterQuantity();
	}
	
	
	public static ArrayList<Serie> makeSerieList(){
		ArrayList<Serie> series = new ArrayList<Serie>();
		
		for (int i = 1; i <= 5; i++) {
			series.add(new Serie("Serie"+i,"Genre"+i, "Creator" +i,340+i,(short)(2013+i), 5));
			ArrayList<Chapter> chapters = new ArrayList<Chapter>();
			for(int j=1;j<=5;j++)
			{
				chapters.add(new Chapter("Capitulo"+j, 70+j));
			}
			series.get(i-1).setChapters(chapters);
		}
		
		return series;
	}
}
