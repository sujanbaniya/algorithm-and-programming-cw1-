package week3;
import java.util.ArrayList;

public class Answer {

	public static ArrayList<Integer> returnList(ArrayList<Integer> list){
		int i = list.size()-1;
		int j = list.size()-1;
		while(i>0) {
			if(list.get(i)<list.get(i-1)) {
				list.remove(i-1);
				i=i-2;	
			}
			else {
				i--;
			} 
		}
		return list;
	}
	
	public static boolean allLeftSmall(ArrayList<Integer> list) {
		int k = list.size()-1;
		boolean truth = false;
		for (int i = k-1; i>=0; i--) {
			if (list.get(k)>list.get(i)) {
				truth = true;
				continue;
				
			}
			else{
				truth = false;
				break;
			}
		}
		return truth;
		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(7);
		list.add(3);
		list.add(9);
		list.add(2);
		
		int j = 0;
		ArrayList<Integer> list2 = returnList(list);
		
		while (true) {
			System.out.println(list2);
			j++;
			if(allLeftSmall(list2)==true) {
				break;
			}
			else {
				list2 = returnList(list2);
			}
		}
		System.out.println(j);
		
		
		
	}
}