package com.kodgemisi.usermanagement;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {

    @Test
    void update() {

        final var userDao = new UserDaoImpl();

        var leonardo = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/LEONARDO.JPG/330px-LEONARDO.JPG",
                        "Florence, Italy",
                        new Phone("+902125443614"),
                        new Email("gbacon@verizon.net"),
                        Set.of(new Phone("+763422380839")),
                        Set.of(new Email("psichel@verizon.net")),
                        Language.TR
                ),
                23,
                true,
                Role.ADMIN,
                Instant.now()
        );

        userDao.create(leonardo);

        var raffaello = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Raffaello_Sanzio.jpg/330px-Raffaello_Sanzio.jpg",
                        "Urbino, Italy",
                        new Phone("+192242558213"),
                        new Email("arnold@sbcglobal.net"),
                        Set.of(new Phone("+233224582360")),
                        Set.of(new Email("preneel@me.com")),
                        Language.EN
                ),
                11,
                false,
                Role.ANONYMOUS,
                Instant.now()
        );

        userDao.create(raffaello);

        var michelangelo = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Miguel_%C3%81ngel%2C_por_Daniele_da_Volterra_%28detalle%29.jpg/330px-Miguel_%C3%81ngel%2C_por_Daniele_da_Volterra_%28detalle%29.jpg",
                        "Tuscany, Italy",
                        new Phone("+952324632733"),
                        new Email("maneesh@att.net"),
                        Set.of(new Phone("+903124406247")),
                        Set.of(new Email("drewf@hotmail.com")),
                        Language.EN
                ),
                18,
                true,
                Role.ANONYMOUS,
                Instant.now()
        );

        userDao.create(michelangelo);

        var donatello = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Uffizi_Donatello.jpg/300px-Uffizi_Donatello.jpg",
                        "Florence, Italy",
                        new Phone("+902323732567"),
                        new Email("ijackson@mac.com"),
                        Set.of(new Phone("+773322481010")),
                        Set.of(new Email("josem@aol.com")),
                        Language.TR
                ),
                9,
                false,
                Role.OBSERVER,
                Instant.now()
        );

        userDao.create(donatello);

        final var userService = new UserService(userDao);

        raffaello = new User(
                raffaello.getId(),
                new Profile(
                        raffaello.getProfile().getAvatarUrl(),
                        "Florida, U.S.",
                        new Phone("+232972510919"),
                        raffaello.getProfile().getPrimaryEmail(),
                        raffaello.getProfile().getPhones(),
                        raffaello.getProfile().getEmails(),
                        Language.EN
                ),
                23,
                true,
                Role.ADMIN,
                raffaello.getCreatedAt()
        );

        var updatedRafaello = userService.update(raffaello);

        assertEquals(raffaello.getId(), updatedRafaello.getId());
        assertEquals(raffaello.getProfile().getAvatarUrl(), updatedRafaello.getProfile().getAvatarUrl());

        assertEquals(raffaello.getProfile().getAddress(), updatedRafaello.getProfile().getAddress());

        assertEquals(raffaello.getProfile().getPrimaryPhone(), updatedRafaello.getProfile().getPrimaryPhone());
        assertEquals(raffaello.getProfile().getPrimaryEmail(), updatedRafaello.getProfile().getPrimaryEmail());
        assertEquals(raffaello.getProfile().getPhones(), updatedRafaello.getProfile().getPhones());
        assertEquals(raffaello.getProfile().getEmails(), updatedRafaello.getProfile().getEmails());
        assertEquals(raffaello.getProfile().getLanguage(), updatedRafaello.getProfile().getLanguage());
        assertEquals(raffaello.getAge(), updatedRafaello.getAge());
        assertEquals(raffaello.isVerified(), updatedRafaello.isVerified());
        assertEquals(raffaello.getRole(), updatedRafaello.getRole());
        assertEquals(raffaello.getCreatedAt(), updatedRafaello.getCreatedAt());

    }

}