package com.zerokikr.tutorial.hashtables;


public class MainApp {
	
	public static void main(String[] args) {
		
		
		Employee vasiliyPalkin = new Employee ("Vasiliy", "Palkin", 1234);
		Employee petrKonev = new Employee ("Petr", "Konev", 9876);
		Employee borisBritva = new Employee ("Boris", "Britva", 5678);
		Employee stepanRazin = new Employee ("Stepan", "Razin", 9157);
		
		ChainedHashTable ht = new ChainedHashTable();
		
		ht.put("vasiliy", vasiliyPalkin);
		ht.put("petr", petrKonev);
		ht.put("boris", borisBritva);
		ht.put("stepan", stepanRazin);
		
		ht.printHashtable();
		
		System.out.println("---------------");
		
		System.out.println(ht.remove("petr"));
		
		System.out.println("---------------");

		ht.printHashtable();

		
	}
	


}
