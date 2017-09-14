

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
	
		List<String > s =new ArrayList<String>();
		if (movieRatings!=null && movieRatings.isEmpty()==false ){
		s=new ArrayList<>(movieRatings.keySet());
		return s; 
	}
		else return s;
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		TreeMap<String, PriorityQueue<Integer>> tp = new TreeMap<String, PriorityQueue<Integer>>();
		ArrayList<String>al = new ArrayList<>();
		if (movieRatings!=null &&  movieRatings.isEmpty()==false ){
			for(String st : movieRatings.keySet()){
				PriorityQueue<Integer> p =  movieRatings.get(st);
				if(p.peek()> rating) {
					tp.put(st,p);
				}
			}
		
			
		return getAlphabeticalMovies(tp);}
		
		return al; 
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		if (movieRatings!=null &&  movieRatings.isEmpty()==false ){
			Set<String> sets = movieRatings.keySet();
			List<String> ll = new ArrayList<String>();
			for(String ss: sets){
				PriorityQueue<Integer> pp = movieRatings.get(ss);
				if(pp.peek()< rating){
				ll.add(ss)	;
				}
			}
			
			for(String st : ll){
				PriorityQueue<Integer> p =  movieRatings.get(st);
				int count=0;
				while(p.peek()<rating && p.isEmpty()==false){
					p.remove();
					count++;		
				}
			if(p.isEmpty()==true){movieRatings.remove(st);}	
			else{
				tm.put(st, count);}
			}
	return tm;	}
		
		return tm; 
	}
}
