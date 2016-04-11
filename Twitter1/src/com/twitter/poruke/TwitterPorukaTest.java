
package com.twitter.poruke;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Olivera
 *
 */
public class TwitterPorukaTest {
	private TwitterPoruka t;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t=null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnikSveOk() {
		String korisnik = "Marko Markovic";
		
		t.setKorisnik(korisnik);
		
		assertEquals(korisnik, t.getKorisnik());
		
	}
	@Test
	public void testSetKorisnikSveOk2() {
		String korisnik = "Petar Petrovic";
		
		t.setKorisnik(korisnik);
		
		assertEquals(korisnik, t.getKorisnik());
		
	}
	@Test
	public void testSetKorisnikNull() {
		String korisnik = null;
		try{
			t.setKorisnik(korisnik);
		}catch(RuntimeException e){}
		
		
		assertEquals(korisnik, t.getKorisnik());
		
	}
	@Test
	public void testSetKorisnikPrazanString() {
		String korisnik = "";
		try{
			t.setKorisnik(korisnik);
		}catch(RuntimeException e){}
		
		assertEquals(null, t.getKorisnik());
		
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPorukaSveOk() {
		String poruka = "Danas je lep dan!";
		
		t.setPoruka(poruka);
		
		assertEquals(poruka, t.getPoruka());
	}
	@Test
	public void testSetPorukaSveOk2() {
		String poruka = "Pocelo je prolece!";
		
		t.setPoruka(poruka);
		
		assertEquals(poruka, t.getPoruka());
	}
	@Test
	public void testSetPorukaNull() {
		String poruka = null;
		try{
			t.setPoruka(poruka);
		}catch(RuntimeException e){}
		
		assertEquals(poruka, t.getPoruka());
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		String korisnik = t.getKorisnik();
		String poruka = t.getPoruka();
		
		assertEquals("KORISNIK:"+korisnik+" PORUKA:"+poruka, t.toString());
	}

}