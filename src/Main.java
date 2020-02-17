import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class Main
{
	static Pracownik[] pracownicy = new Pracownik[10];
	
	
	public static void wczytajpracownika()
	{
		String nazwisko;
		String imie;
		long pesel;
		int staz;
		double pensja;
		String x = "T";
		int i=0;
		Scanner in = new Scanner(System.in);
		
		while(x.toUpperCase().equals("T") && i<10)
		{
			
			System.out.print("Podaj nazwisko pracownika: ");
			nazwisko=in.next();
			System.out.print("Podaj imie pracownika: ");
			imie=in.next();
			System.out.print("Podaj pesel pracownika: ");
			pesel=in.nextLong();
			System.out.print("Podaj staz pracownika: ");
			staz=in.nextInt();
			System.out.print("Podaj pensje pracownika: ");
			pensja=in.nextDouble();
			pracownicy[i]= new Pracownik(nazwisko,imie,pesel,staz,pensja);
			i++;
			System.out.print("Czy chcesz dodac kolejnego pracownika T/N: ");
			x=in.next();
		}
		in.close();
	}
	
	public static void wyswietl()
	{
		Pracownik ip =new Pracownik();
		for(int i=0; i<ip.getIloscpracownikow(); i++)
		{
			pracownicy[i].wyswietl();
		}
	}
	
	
	public static void naglowek()
	{
		stopka();
		System.out.printf("|%-15s |%-10s |%-11s |%-5s |%-9s |%n", "NAZWISKO","IMIE","PESEL","STAZ","PENSJA");
		stopka();
	}
	public static void stopka()
	{
		String stopka="____________________________________________________________";
		System.out.println(stopka);
	}
	
	public static void zapiszobjekt()
	{
		Pracownik ip =new Pracownik();
		try
		{
			File o = new File("C:\\Users\\qba\\java\\workspace\\1.txt");
			ObjectOutputStream zapisz = new ObjectOutputStream(new FileOutputStream(o));
			zapisz.writeInt(ip.getIloscpracownikow());
			for(int i=0; i<ip.getIloscpracownikow(); i++)
			{
				zapisz.writeObject(pracownicy[i]);
				
			}
			
			zapisz.close();
			System.out.println("Obiekt zapisany pomyslnie!");
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Nie znaleziono pliku.");
		}
		catch (IOException e)
		{
			System.out.println("Blad wejscia/wyjscia");
		}
	}

	public static void wczytajobiekt() 
	{
		Pracownik ip =new Pracownik();
		try
		{	
			ObjectInputStream wczytaj = new ObjectInputStream(new FileInputStream("C:\\Users\\qba\\java\\workspace\\1.txt"));
			Pracownik[] odczyt= new Pracownik[10];
			System.out.println("Ilosc pracownikow: "+wczytaj.readInt());
			naglowek();
			for(int i=0;i<ip.getIloscpracownikow(); i++)
			{
				odczyt[i] = (Pracownik)wczytaj.readObject();
				odczyt[i].wyswietl();
			}
			stopka();
			wczytaj.close();
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Nie znaleziono pliku.");
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		} 
		catch (ClassNotFoundException e) 
		{
		}
		
	}
	
	
	public static void main(String[] args) 
	{	
		wczytajpracownika(); 
		naglowek();
		wyswietl();
		stopka();
		System.out.println();
		zapiszobjekt();
		wczytajobiekt();
	}
}
