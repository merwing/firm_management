import java.io.Serializable;

public class Pracownik implements Serializable
{
	private String nazwisko;
	private String imie;
	private long pesel;
	private int staz;
	private double pensja;
	private static int iloscpracownikow=0;
	
	Pracownik()
	{
		nazwisko=null;
		imie=null;
		pesel=0;
		staz=0;
		pensja=0;
	}
	
	Pracownik(String nazwisko,String imie,long pesel,int staz,double pensja)
	{
		this.nazwisko=nazwisko;
		this.imie=imie;
		this.pesel=pesel;
		this.staz=staz;
		this.pensja=pensja;
		setIloscpracownikow(getIloscpracownikow() + 1);
	}
	
	public void wyswietl()
	{
		System.out.printf("|%-15s |%-10s |%11d |%5d |%9.2f |%n",nazwisko,imie,pesel,staz,pensja);
		
	}
	public static int getIloscpracownikow() {
		return iloscpracownikow;
	}

	public static void setIloscpracownikow(int iloscpracownikow) {
		Pracownik.iloscpracownikow = iloscpracownikow;
	}

	public String toString()
	{
		return String.format("|%-15s |%-10s |%11d |%5d |%9.2f |%n",nazwisko,imie,pesel,staz,pensja);
		
	}
}
