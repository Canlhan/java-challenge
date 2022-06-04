package com.kodgemisi;

import com.github.javafaker.Faker;
import com.kodgemisi.usermanagement.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class UserGenerator {

	public static final String US_PHONE_PATTERN = "#{regexify '+1\\d{10}'}";

	public static final String TR_PHONE_PATTERN = "#{regexify '+90\\d{10}'}";

	private final static int USER_COUNT = 200;

	private final static Faker faker = Faker.instance();

	private UserGenerator() {
		throw new UnsupportedOperationException("Cannot be instantiated!");
	}

	public static void generate(final UserDao userDao) {

			final String avatarUrl = "https://picsum.photos/200";

			for (int i = 0; i < USER_COUNT; i++) {

				final Set<Phone> phones = new HashSet<>();
				try{
					for (int j = 0; j < random(3); j++) {


						Phone phone=new Phone(randomPhoneNumber());
						phones.add(phone);
					}
					final Phone primaryPhone = phones.stream().findFirst().get();
					final Set<Email> emails = new HashSet<>();
					for (int j = 0; j < random(5); j++) {
						emails.add(new Email(faker.internet().emailAddress()));
					}
					final Email primaryEmail = emails.stream().findFirst().get();

					final Language lang = random(2) == 2 ? Language.EN : Language.TR;
					final Role role = random(2) == 2 ? Role.USER : Role.ADMIN;
					final boolean verified = random(2) == 2;

					final Profile profile = new Profile(avatarUrl, faker.address().fullAddress(), primaryPhone, primaryEmail, phones, emails, lang);
					final User user = new User(null, profile, random(93), verified, role, Instant.now());
					userDao.create(user);

				}catch (IllegalArgumentException e){

					System.out.println(e.getLocalizedMessage());
				}







			}


	}

	private static int random(int limitIncluding) {
		return ThreadLocalRandom.current().nextInt(1, limitIncluding + 1);
	}

	private static String randomPhoneNumber() {
		return faker.expression(random(2) == 2 ? US_PHONE_PATTERN : TR_PHONE_PATTERN);
	}
}
