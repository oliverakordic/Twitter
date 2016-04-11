package com.twitter.poruke;

/**
 * Klasa ima setere i getere za atribute korisnik i poruka i redefinisanu metodu toString() klase Object.
 * @author Olivera Kordic
 */
public class TwitterPoruka {
		/**
		 * Atribut korisnik predstavlja ime korisnika Twittera.
		 */
		private String korisnik;
		/**
		 * Atribut poruka predstavlja poruku koju korisnik postavlja na svoju Twitter stranu.
		 */
		private String poruka;
		/**
		 * Metoda vraca ime korisnika, koje je private.
		 * @return korisnik
		 */
		public String getKorisnik() {
			return korisnik;
		}
		/**
		 * Metoda postavlja vrednost atributa korisnik na unetu vrednost preko parametra koji prima (on ne moze biti null niti prazan String).
		 * Nema povratne vrednosti. U slucaju da neki od ovih uslova nije ispunjen, metoda baca neproveravani izuzetak klase RuntimeException
		 * uz odgovarajucu poruku.
		 * @param korisnik
		 * @throws java.lang.RuntimeException Baca izuzetak u slucaju da je korisnik null ili prazan String
		 */
		public void setKorisnik(String korisnik) {
			if (korisnik==null || korisnik == "")
					throw new RuntimeException("Ime korisnika mora biti uneto");
			this.korisnik = korisnik;
		}
		/**
		 * Metoda vraca poruku, koja je private.
		 * @return poruka
		 */
		public String getPoruka() {
			return poruka; 
		}
		/**
		 * Metoda postavlja vrednost atributa poruka na unetu vrednost preko parametra koji prima (on ne moze biti null). Takodje se proverava 
		 * da li je duzina atributa poruka veca od 140. U slucaju da neki od ovih uslova nije ispunjen, metoda baza neproveravani izuzetak klase
		 * RuntimeException uz odgovarajucu poruku. Nema povratne vrednosti.
		 * @param poruka
		 * @throws java.lang.RuntimeException Baca izuzetak u slucaju da je poruka null ili je njena duzina veca od 140
		 */
		public void setPoruka(String poruka) {
			if (poruka==null || poruka.length()>140)
				throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
			this.poruka = poruka;
		}
		/**
		 * Redefinisana metoda toString() klase Object. Povratna vrednost je String koji cine vrednosti atributa korisnik i poruka.
		 */
		public String toString(){
			return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
		} 

}

