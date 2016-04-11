package com.twitter;
import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * 	
 * @author Olivera
 *
 */

public class Twitter {
	/**
	 * lista poruka tipa TwitterPoruka.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	/**
	 * Metoda vraca listu sa porukama tipa TwitterPoruka
	 * @return poruke
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	/**
	 * Metoda unosi poruku tipa TwitterPoruka u listu sa porukama tog tipa. 
	 * @param korisnik
	 * @param poruka
	 * @throws java.lang.RuntimeException Metoda baca izuzetak u slucaju da joj se prosledi null za vrednost korisnik.
	 */
	public void unesi(String korisnik, String poruka) {
		if(korisnik==null)
			throw new RuntimeException("Korisnik ne moze biti null");
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Metoda pretrazuje poruke koje sadrze tag koji joj se prosledjuje i vraca niz sa porukama koje sadrze taj tag.
	 * @param maxBroj
	 * @param tag
	 * @return rezultat
	 * @throws java.lang.RuntimeException Izuzetak se baca u slucaju da je tag null ili prazan String.
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0; 
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac]=poruke.get(i);
					brojac++;
				}
				else break;
		return rezultat;
		}
	} 



