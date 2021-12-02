import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Register {
	private  ArrayList<Person> reg;
	String test;
	
	public Register(){
		reg = new  ArrayList<Person>();
		
	}
	/** Läser registret från filen med namn fileName. */
	
	public void readFromFile(String fileName) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File(fileName));
		}catch(FileNotFoundException e) {
			System.err.println("Filen kunde inte öppnas"); 
			System.exit(1);
		}
		while(scan.hasNextLine()) {
			String a = scan.nextLine();
			String b = scan.nextLine();
			addNewPerson(a,b);
		}
		

	}
	
	/** Sparar registret på fil med namnet fileName. */
	public void writeToFile(String fileName) {
		String s = printUtRegister();
		PrintWriter out = null;
		try {
			out = new PrintWriter(new File (fileName));
		}catch (FileNotFoundException e) { 
			System.err.println("Filen kunde inte öppnas"); 
			System.exit(1); 
			}
		out.write(s);
		out.close();
		
		
	}
	
	/** lägger till en ny Person i register */
	public void addNewPerson(String name, String tN) {
		reg.add(new Person(name,tN));
		sortAfterName();
	}
	
	/* skriver ut reg innehåll till en string*/
	public String printUtRegister() {
		StringBuilder sb=new StringBuilder();
		for(Person p:reg) {
			sb.append(p.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public String getTelForName(String s) {
		StringBuilder sb=new StringBuilder();
		for(Person p:reg) {
			if(p.getName().toLowerCase().indexOf(s.toLowerCase())>=0) {
				sb.append(p.toString());
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	public String getNameForTel(String s) {
		StringBuilder sb=new StringBuilder();
		for(Person p:reg) {
			if(p.getNbr().compareTo(s)==0) {
				sb.append(p.toString());
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	public void removePerson(String s) {
		for(int i = 0; i<reg.size();i++) {
			if(reg.get(i).getName().toLowerCase().compareTo(s.toLowerCase())==0) {
				reg.remove(reg.get(i));
			}
		}
	}
	private void sortAfterName() {
		Person temp;
		for(int i = 0; i<reg.size()-1;i++) {
			for(int j = i+1;j<reg.size() ;j++) {
					if(reg.get(i).getName().toLowerCase().compareTo(reg.get(j).getName().toLowerCase())>0) {
						temp = reg.get(i);
						reg.set(i,reg.get(j));
						reg.set(j,temp);
					}
				}
			}
		}
	

	private void sortAfterTel() {
		Person temp;
		for(int i = 0; i<reg.size()-1;i++) {
			for(int j = i+1;j<reg.size() ;j++) {
					if(Integer.parseInt(reg.get(i).getNbr())<Integer.parseInt(reg.get(j).getNbr())) {
						temp = reg.get(i);
						reg.set(i,reg.get(j));
						reg.set(j,temp);
					}
				}
			}
	
	}
	
	public String printSortedByNameReg() {
		StringBuilder sb=new StringBuilder();
		for(Person p:reg) {
			sb.append(p.toString());
			sb.append("\n");
			}
		return sb.toString();
	}
	
	public String printSortedByTelReg() {
		sortAfterTel();
		StringBuilder sb=new StringBuilder();
		for(Person p:reg) {
			sb.append(p.toString());
			sb.append("\n");
			}
		return sb.toString();
	}
}

