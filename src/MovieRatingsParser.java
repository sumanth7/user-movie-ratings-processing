

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		
TreeMap<String, PriorityQueue<Integer>> tmap = new TreeMap<>();
if(allUsersRatings==null || allUsersRatings.isEmpty()==true){return tmap;}
for (UserMovieRating x : allUsersRatings){
	if((x!=null) &&(x.getMovie()!=null ) && (x.getUserRating()>=0) && x.getMovie().isEmpty()==false) {
	
	if(!(tmap.containsKey(x.getMovie().toLowerCase()))){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		 pq.add(x.getUserRating());
 		tmap.put(x.getMovie().toLowerCase(),pq);
	}
	else{
	   (tmap.get(x.getMovie().toLowerCase())).add(x.getUserRating());
	}
}
}
		
		return tmap; 
	}

}
