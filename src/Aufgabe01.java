import java.util.Scanner;
//Code sehr durcheinander, aber ich hatte Zeitdruck
public class Aufgabe01 {
	 public static void main(String[] args) {
		 
	    	Scanner scan = new Scanner(System.in);
	    	System.out.print("Geben sie die Höhe des Dreiecks an: ");
	    	int hoehe = scan.nextInt();
	    	scan.close();
	    	
	    	System.out.println();
	    	
	    	//3 Sonderfälle für richtige Formatierung
	    	if(hoehe == 1) {
	    		System.out.println("++1*");    		
	    	}else if(hoehe == 2) {
	    		System.out.println("  ++1*");
	    		System.out.println("++2*++3*"  );
	    	}else if(hoehe == 3) {
	    		System.out.println("    ++1*");
	    		System.out.println("  ++2*++3*"  );
	    		System.out.println("++4*++5*++6*");
	    	}else { 
	    		//zahl zählt, wie viele Zahlen in x Höhe addiert werden müssen
		    	int zahl = 0;
		    	
		    	for(int i = 1; i<=hoehe; i++) {
		    		
		    		for(int z = 1; z<=i; z++)
		    			zahl++;	
		    		
		    	}
		    	//Wandelt die addierte Zahl in String um, um Länge dieser herauszufinden
		    	String tmp = String.valueOf(zahl);
		    	int zaehler = 0;
		        for (int i = 0; i<tmp.length(); i++)
		        	zaehler++;
		        	//zaehler = Länge der Zahl, Bspw. 15 = 2, 200 = 3...
		        
		        pyramide(hoehe, zahl, zaehler);
		        //Übergibt Höhe, die addierte Zahl und die Länge dieser
		    }
	}
	 
    public static int pyramide(int hoehe, int groessteZahl, int laengeGroessteZahl) {
	    	//Berechnet Pyramide
	    	int zahl = 1;
	    	String space=" ";
	    	char toadd=' ';
	    	//wie viele Leerzeichen vor der Zahl?
	    	for(int j = 1; j <= laengeGroessteZahl - 1; j++) 
	    		space = space + toadd;
	    	
	    	for(int i = 1; i <= hoehe; i++) {
	    		//drucke Leerzeichen
	    		for(int s = 1; s <= hoehe - i; s++)		
	    			System.out.print(space);
	    		 		
	    		for(int z = 1; z <= i; z++) { 	    			
	    			format(laengeGroessteZahl, zahl, groessteZahl);
	    			zahl++; 
	    		}//Zeilenumbruch
	    		System.out.println();
	    		
	    	}
	    	return laengeGroessteZahl;
    }
    
    public static int format(int value, int zahl, int groesste) {
    	
	    	String formatPlus = "";
	    	String formatStar = "";
	    	char plus ='+';
	    	char star ='*';    	
	    	//Fügt + und - hinzu je nachdem wie lang die Zahl ist
	    	for(int i = 1; i <= value; i++) 
	    		formatPlus += plus;
	    	
	    	for(int k = 1; k <= value; k++) 
	    		formatStar += star;
	    	
	    	int gerade = 0;
	    	int ungerade = 1;
	    	int laengeSold = 1;
	    	//zieht + und * wieder ab, je nachdem ob die Zahl gerade oder ungerade ist
	    	for(int i = 0; i<= zahl; i++) {
	    		
	    		String s = String.valueOf(i);
	    		int laengeS = s.length();
	    		
	    		if(laengeS>laengeSold) {
	    			
	    			if(laengeS % 2 == 0) 
	    				gerade++;
	    			else if(laengeS % 2 != 0) 
	    				ungerade++;
	    			
	    		}
	    		
	    		laengeSold=laengeS;
	    	}
	  
	    		formatStar = formatStar.substring(0, formatStar.length()-ungerade);    	
	    		formatPlus = formatPlus.substring(0, formatPlus.length()-gerade);    		
	    	//gibt die komplette Zeile zurück	
	    	System.out.print(formatPlus+zahl+formatStar);
	    	return zahl;
    }
}
