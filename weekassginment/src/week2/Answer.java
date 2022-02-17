package week2;

import java.util.ArrayList;

public class Answer {
	public static int Buy(int n,ArrayList<Integer> list, ArrayList<Integer> buy) {
		int j = 0;
		boolean k = false;
		for(int i=n; i<list.size()-1; i++) {
			if (list.get(i)<list.get(i+1)) {
				buy.add(i);
				k = true;
				j = i;
				return j;
			}
		}
		if (k==true) {
			return j;
		}
		return -1;
	}
	
	public static int Sell(int n, ArrayList<Integer> list, ArrayList<Integer> buy,ArrayList<Integer> sell) {
		int b = n;
		for(int i=n; i<list.size()-1; i++) {
			if (list.get(i)>list.get(i+1)) {
				sell.add(i);
				return i;
			}
			b++;
		}
		return b;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(180);
		list.add(260);
		list.add(310);
		list.add(40);
		list.add(535);
		list.add(695);
		ArrayList<Integer> buy = new ArrayList<Integer>();
		ArrayList<Integer> sell = new ArrayList<Integer>();
		
		int buy_value = 0;
		while (buy_value<list.size()) {
			int a = Buy(buy_value, list, buy);
			if (a==-1) {
				System.out.println("There's no point in buying");
				break;
			}
			int c = Sell(a,list, buy, sell);
			if(c==list.size()-1) {
				sell.add(c);
				break;
			}
			else {
				buy_value = c+1;
				continue;
			}
		}
		int selling = 0;
		for (int i : sell) {
//			System.out.println("Sell Day" + i);
			selling = selling + list.get(i);
		}
		int buying = 0;
		for (int i : buy) {
//			System.out.println("Buy Day" + i);
			buying = buying + list.get(i);
		}
		System.out.println("Max Profit: ");
		System.out.println(selling-buying);
		System.out.println("Buy on Days: " + buy);
		System.out.println("Sell on Days: " + sell);
		
		
		
	}
}
