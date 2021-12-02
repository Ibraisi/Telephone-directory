import java.util.*;
public class MainClass {
	public static void main(String args[]) {
		Dialog d = new Dialog();
		Register r = new Register();
		Person temp;
		int command = 0;
		while(command!=Integer.MAX_VALUE) {
			 command = d.readInt("1. Sätta in ett nytt namn med tillhörande telefonnummer.\r\n"
					+ "2. Ta bort alla personer med ett visst namn ur registret.\r\n"
					+ "3. Söka upp alla telefonnummer som gäller för ett visst namn. Det skall räcka att man anger \r\n"
					+ "en del av namnet. Samtliga personer vars namn passar in skall presenteras med både namn \r\n"
					+ "och telefonnummer.\r\n"
					+ "4. Söka upp det eller de namn som har ett visst telefonnummer. Personerna skall presenteras \r\n"
					+ "med både namn och telefonnummer.\r\n"
					+ "5. Presentera alla personer sorterade efter namn.\r\n"
					+ "6. Presentera alla personer sorterade efter telefonnummer.\r\n"
					+ "7. Spara registret på en fil.\r\n"
					+ "8. Hämta uppgifterna till registret från en fil");
			
			switch(command) {
			case 1: String a = d.readString("Enter a Name");
					String b = d.readString("Enter a Phone-Number");
					r.addNewPerson(a, b);
					r.writeToFile(a);
					break;
					
			case 2: String c = d.readString("Ta bort alla personer med skrivna namnt: ");
					r.removePerson(c);
					break;
					
			case 3: String D = d.readString("Söka upp ett telefonnummer som gäller för ett visst namn" );
		 			d.printString(r.getTelForName(D));
		 			break;
			case 4:  String e = d.readString("Söka upp ett namn som gäller för ett visst telefonnummer" );
 			d.printString(r.getNameForTel(e));
 			break;
			case 5: String f = r.printSortedByNameReg();
				d.printString(f);
			break;
			case 6: String g = r.printSortedByTelReg();
				d.printString(g);
			case 7: String h = d.readString("Enter File Name");
					r.writeToFile(h);
				break;
			case 8: String i = d.readString("Enter File Name");
					r.readFromFile(i);
			break;				
			}
		}
	
		
	}

}
