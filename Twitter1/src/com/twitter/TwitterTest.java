package com.twitter;

import static org.junit.Assert.*;

import com.twitter.Twitter;
import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.twitter.poruke.TwitterPoruka;

/**
 * @author Olivera
 *
 */
public class TwitterTest {
	private Twitter t;
	private TwitterPoruka tp;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
		tp = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
		tp = null;
		
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		String korisnik1 = "Mirko Mirkovic";
		String korisnik2 = "Pera Peric";
		String poruka1 = "Idem na cas.";
		String poruka2 = "Idem na dvocas";
		TwitterPoruka tp1 = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();
		tp1.setKorisnik(korisnik1);
		tp1.setPoruka(poruka1);
		
		tp2.setKorisnik(korisnik2);
		tp2.setPoruka(poruka2);
		LinkedList <TwitterPoruka> listaZaVratiti = new LinkedList<TwitterPoruka>();
		listaZaVratiti.addLast(tp1);
		listaZaVratiti.addLast(tp2);
		
		t.unesi(korisnik1,poruka1);
		t.unesi(korisnik2, poruka2);
		//assertEquals(listaZaVratiti, t.vratiSvePoruke());
		assertEquals(listaZaVratiti.get(0).getKorisnik(), t.vratiSvePoruke().get(0).getKorisnik());
		assertEquals(listaZaVratiti.get(0).getPoruka(), t.vratiSvePoruke().get(0).getPoruka());
		assertEquals(listaZaVratiti.get(1).getKorisnik(), t.vratiSvePoruke().get(1).getKorisnik());
		assertEquals(listaZaVratiti.get(1).getPoruka(), t.vratiSvePoruke().get(1).getPoruka());
		
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesiSveOk() {
		String korisnik = "Mirko Mirkovic";
		String poruka = "Napolju je toplo.";
		
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		
		t.unesi(korisnik, poruka);
		
		assertEquals(tp.getKorisnik(),t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals(tp.getPoruka(),t.vratiSvePoruke().getLast().getPoruka());
	}
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesiNullKorisnik() {
		String korisnik = null;
		String poruka = "Napolju je toplo.";
		try{
			t.unesi(korisnik, poruka);
			//tp.setKorisnik(korisnik);
			//tp.setPoruka(poruka);
		}catch(RuntimeException e){
			
		}
		
		assertEquals(new LinkedList<TwitterPoruka>(),t.vratiSvePoruke());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPorukeSveOk() {
		String tag = "zanimljivo";
		int maxBroj = 2;
		TwitterPoruka  tp2 = new TwitterPoruka();
		TwitterPoruka  tp1 = new TwitterPoruka();
		tp1.setKorisnik("Ana Anic");
		tp2.setKorisnik("Bana Banic");
		tp1.setPoruka("Prva poruka, zanimljivo");
		tp2.setPoruka("Druga poruka, nezanimljivo");
		
		t.unesi("Ana Anic","Prva poruka, zanimljivo");
		t.unesi("Bana Banic", "Druga poruka, nezanimljivo");
		
		
		
		assertEquals(t.vratiSvePoruke().get(0), t.vratiPoruke(maxBroj, tag)[0]);
		
	}

	

}