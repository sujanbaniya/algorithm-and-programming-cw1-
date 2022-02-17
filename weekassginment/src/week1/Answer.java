package week1;


public class Answer {
	
	public static void main(String[] args ) {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList list3 = new LinkedList();
		LinkedList list4 = new LinkedList();
		
		list1.addData(100);
		list1.addData(400);
		list1.addData(-1000);
		list1.addData(-500);
		
		list2.addData(-300);
		list2.addData(2000);
		list2.addData(-500);
		
		int sum = 0;
		int indexL1 = 0;
		int indexL2 = 0;
		
		while(indexL1<list1.getSize()) {
			sum= sum+ list1.getDataByIndex(indexL1);
			if (sum>0) {
				list3.addData(list1.getDataByIndex(indexL1));
				indexL1++;
			}
			else {
				sum= sum-list1.getDataByIndex(indexL1);
				list4.addData(list1.getDataByIndex(indexL1));
				indexL1++;
			}
		}
		
		while(indexL2<list2.getSize()) {
			sum= sum+ list2.getDataByIndex(indexL2);
			if (sum>0) {
				list3.addData(list2.getDataByIndex(indexL2));
				indexL2++;
			}
			else {
				sum= sum-list2.getDataByIndex(indexL2);
				list4.addData(list2.getDataByIndex(indexL2));
				indexL2++;
			}
		}
		
		for(int i=0; i<list4.getSize();i++) {
			list3.addData(list4.getDataByIndex(i));
			sum = sum + list4.getDataByIndex(i);
		}
		
		if (sum > 0) {
			list3.printList();
		}
		else {
			System.out.println("-1");
		}

	}
	
}
