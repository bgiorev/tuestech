package com.wordpress.bgiorev.homework11.code;
import java.security.SecureRandom;
import java.math.BigInteger;

public final class RandomString {

	private SecureRandom random = new SecureRandom();

	public String random() {
		return new BigInteger(60, random).toString(32);
	}
}