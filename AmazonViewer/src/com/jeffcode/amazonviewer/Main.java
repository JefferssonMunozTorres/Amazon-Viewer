package com.jeffcode.amazonviewer;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

import com.jeffcode.amazonviewer.model.Chapter;
import com.jeffcode.amazonviewer.model.Movie;
import com.jeffcode.amazonviewer.model.Serie;

public class Main {

	public static void main(String[] args) {
		
		showMenu();	

	}

	public static void showMenu() {
		
		int opcion=0;
				
		do{
			System.out.println("\nBIENVENIDOS A AMAZON VIEWER\n");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("0. Exit");
			System.out.print("\nSelecciona el numero de la opcion deseada: ");
			
			opcion= new Scanner (System.in).nextInt();
			
			switch (opcion)
			{
			case 1:
				System.out.println("\nSee movies");
				showMovies();
				break;
			case 2:
				System.out.println("\nSee series");
				showSeries();
				break;
			case 0:
				System.out.println("Good bye!");
				break;
			default:
				System.out.println("*****Opcion no existe******\n");
				break;				
			};
			
		}while(opcion!=0);
	}
	
	static ArrayList<Movie> movies= Movie.makeMovieList();
	public static void showMovies(){
		int exit=1;
		do {
			System.out.println("\n::MOVIES::");
			
			//Muestra de Peliculas
			for (int i=0; i < movies.size();i++) {
				System.out.println((i+1)+". "+ movies.get(i).getTitle()+" Visto: " + movies.get(i).isViewed());	
			}
		
			System.out.println("0. Regresar al Menu");
			System.out.print("\nSelecciona la pelicula que deseas ver: ");
			
			int response = new Scanner(System.in).nextInt();
			
			if(response==0) {
				showMenu();
			}
			
			//Tratamiento de la seleccion de pelicula
			Movie movieSelect = movies.get(response-1);
			movieSelect.setViewed(true);
			Date dateI = movieSelect.starToSee(new Date());
			
			//Simulacion de vista 
			for(int i=0; i<100000;i++) {	
				System.out.println("..............");
			}
			
			//Termine de verla
			movieSelect.stopToSee(dateI, new Date());
			System.out.println("\n****************************\nViste: "+ movieSelect);
			System.out.println("Por: "+ movieSelect.getTimeViewed()+ " milisegundos\n****************************");			
			
		}while(exit!=0);
	}
	
	
	static ArrayList<Serie> series= Serie.makeSerieList();
	public static void showSeries(){
		int exit=1;
		do {
			System.out.println("\n::SERIES::");
			
			//Muestra de Series
			for (int i=0; i < series.size();i++) {
				System.out.println((i+1)+". "+ series.get(i).getTitle()+" Visto: " + series.get(i).isViewed());	
			}
		
			System.out.println("0. Regresar al Menu");
			System.out.print("\nSelecciona la serie que deseas ver: ");
			
			int response = new Scanner(System.in).nextInt();
			
			if(response==0) {
				showMenu();
			}else if(response<6) {
				showChapters(response);
			}
			
		}while(exit!=0);
	}
	

	public static void showChapters(int numberSerie){
		int exit=1;
		ArrayList<Chapter> chaptersSelect = series.get(numberSerie-1).getChapters();
		boolean viewedSerie=true;
		
		do {
			System.out.println("\n::CHAPTERS::");
			
			//Muestra de Series
			for (int i=0; i < chaptersSelect.size();i++) {
				System.out.println((i+1)+". "+ chaptersSelect.get(i).getTitle()+" Visto: " + chaptersSelect.get(i).isViewed());	
			}
			
			System.out.println("0. Regresar al Menu anterior");
			System.out.print("\nSelecciona el capitulo que deseas ver: ");
			
			int response = new Scanner(System.in).nextInt();
			
			if(response==0) {
				showSeries();
			}
			
			//Tratamiento de la seleccion de capitulo
			Chapter chapterSelect=chaptersSelect.get(response-1);
			chapterSelect.setViewed(true);
			Date dateI = chapterSelect.starToSee(new Date());
			
			//Simulacion de vista 
			for(int i=0; i<100000;i++) {	
				System.out.println("..............");
			}
			
			//Termine de verla
			chapterSelect.stopToSee(dateI, new Date());
			System.out.println("\n****************************\nViste: "+ series.get(numberSerie));
			System.out.println("\nViste: "+ chapterSelect); 
			System.out.println("Por: "+ chapterSelect.getTimeViewed()+ " milisegundos\n****************************");
			
			//Evalua si todos los capitulos han sido visualizados
			for (int i=0; i < chaptersSelect.size();i++) {
				viewedSerie = viewedSerie & chaptersSelect.get(i).getViewed();
			}
			//Si es verdadero, entonces la serie fue vista completamente
			if(viewedSerie==true){
				series.get(numberSerie-1).setViewed(true);
			}
			
		}while(exit!=0);
	}
	
		
	}