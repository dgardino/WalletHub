package tests;

import static org.junit.Assert.assertNotEquals;

import junit.framework.TestCase;

public class Palindrome extends TestCase {

	public void test_type() throws Exception {
		assertNotNull(Palindrome.class);
	}

	public void test_instantiation() throws Exception {
		answers.Palindrome target = new answers.Palindrome();
		assertNotNull(target);
	}

	/**
	 * I don't need to validate the string itself for null or size since I've done
	 * this in isPalindrome method
	 * 
	 * @throws Exception
	 */
	public void test_reverse() throws Exception {
		answers.Palindrome target = new answers.Palindrome();
		assertEquals("654321", target.reverse("123456"));
		assertEquals("123", target.reverse("321"));
		assertEquals("12", target.reverse("21"));
		assertEquals("1", target.reverse("1"));
		assertEquals(" 1", target.reverse("1 "));
		assertEquals(" ", target.reverse(" "));
		assertEquals("", target.reverse(""));
		assertEquals("_WalletHub", target.reverse("buHtellaW_"));
		assertEquals("!@#$%^&*()", target.reverse(")(*&^%$#@!"));
		assertEquals("!@#$%^&*()_+=-0987654321", target.reverse("1234567890-=+_)(*&^%$#@!"));
		assertEquals("[];',./", target.reverse("/.,';]["));
		assertEquals("{}|:<>?", target.reverse("?><:|}{"));

		assertNotEquals("54321", target.reverse("54321"));
		assertNotEquals("54321", target.reverse("1234"));
		assertNotEquals("54321", target.reverse("123456"));
		assertNotEquals("54321", target.reverse(" 54321"));
		assertNotEquals("54321", target.reverse("554321"));

		assertEquals("54321", target.reverse( target.reverse("54321")));
	}

	public void test_isPalindrome() throws Exception {
		answers.Palindrome target = new answers.Palindrome();
		assertFalse(target.isPalindrome("home"));
		assertFalse(target.isPalindrome("1121"));
		assertTrue(target.isPalindrome("poiiop"));
		assertTrue(target.isPalindrome("123454321"));
		assertTrue(target.isPalindrome("@#$%y%$#@"));
		assertTrue(target.isPalindrome("@#$%%$#@"));
		assertTrue(target.isPalindrome("1221"));
		assertTrue(target.isPalindrome("12521"));
		assertTrue(target.isPalindrome("aa"));
		assertFalse(target.isPalindrome("ab"));
		assertFalse(target.isPalindrome("a"));
		assertFalse(target.isPalindrome(""));
		try {
			target.isPalindrome(null);
		} catch (Exception e) {
			assertEquals(Exception.class.getName(), e.getClass().getName());
		}
	}

}
