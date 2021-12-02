public class Person {
	private String name; // personens namn
	private String nbr; // personens telefonnummer
	/** Skapar en person med namnet name och telefonnumret nbr */
	public Person(String name, String nbr) {
		this.name = name;
		this.nbr = nbr;
	}
	/** Returnerar namnet */
	public String getName() {
		return name;
	}
	/** Returnerar telefonnumret */
	public String getNbr() {
		return nbr;
	}
	/** Returnerar en sträng som består av personens namn och 
 telefonnummer */
	public String toString() {
		return name + "\n" + nbr;
	}
}
