package ru.yandex.practicum.filmorate.validator;

class ValidatorTest {
//    private static final String over200SymbolsString = "PNIlNCj5mapcpFQ4xJpC15PYNhrwIVTq7mo3JfjD9fuibc0OR2sWIaUhz3uT0qOXrHobc8DY" +
//            "bwk9FZyYKN697IQdL9IhdIC37pgWfpPhmaJ1rsGJaUTjcn0AlI8cJVuJVPT7dvrM0t6XoGEde3dAm2E6frM1nbMLFwIfjuW8YBrqXN" +
//            "DyGsSzTqRgNYbjcGbz1mnBDPH1X";
//    private static Film correctFilm, futureFilm, pastFilm, emptyNameFilm, over200SymbolsFilm, negativeDurationFilm;
//    private static User correctUser, emailWithoutDogSymbolUser, birthdayInFutureUser, emptyLoginUser, loginWithVoidUser;
//
//
//    @BeforeAll
//    public static void setUp() {
//        //films set up values
////        correctFilm = new Film("Forest", "RUN FOREST", LocalDate.of(1990, 9, 28), 190, 1, 4, Genre.NONGENRE, Rating.NONRATING);
////        futureFilm = new Film("Forest", "RUN FOREST", LocalDate.now().plusDays(20), 190, 1, 4, Genre.NONGENRE, Rating.NONRATING);
////        pastFilm = new Film("Forest", "RUN FOREST", LocalDate.of(1895, 12, 20), 190, 1, 4, Genre.NONGENRE, Rating.NONRATING);
////        emptyNameFilm = new Film("", "RUN FOREST", LocalDate.of(1990, 9, 28), 190, 1, 4, Genre.NONGENRE, Rating.NONRATING);
////        over200SymbolsFilm = new Film("Forest", over200SymbolsString, LocalDate.of(1990, 9, 28), 190, 1, 4, Genre.NONGENRE, Rating.NONRATING);
////        negativeDurationFilm = new Film("Forest", "RUN FOREST", LocalDate.of(1990, 9, 28), -1, 1, 4, Genre.NONGENRE, Rating.NONRATING);
//
//        //users set up values
////        correctUser = new User(1, "mr-white@yandex.ru", "mr-white", "MrWhite", LocalDate.of(2000, 9, 29));
////        emailWithoutDogSymbolUser = new User(1, "mr-whiteyandex.ru", "mr-white", "MrWhite", LocalDate.of(2000, 9, 29));
////        birthdayInFutureUser = new User(1, "mr-white@yandex.ru", "mr-white", "MrWhite", LocalDate.now().plusDays(1));
////        emptyLoginUser = new User(1, "mr-white@yandex.ru", "", "MrWhite", LocalDate.of(2000, 9, 29));
////        loginWithVoidUser = new User(1, "mr-white@yandex.ru", "mr white", "MrWhite", LocalDate.of(2000, 9, 29));
//    }
//
//    @Test
//    public void notThrowExceptionOnCorrectFilmTest() throws ValidationException {
//        assertDoesNotThrow(new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                Validator.filmValidation(correctFilm);
//            }
//        });
//    }
//
//    @Test
//    public void throwsExceptionIfFilmsReleaseDateIsFutureTest() throws ValidationException {
//        assertThrows(ValidationException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                Validator.filmValidation(futureFilm);
//            }
//        });
//    }
//
//    @Test
//    public void throwsExceptionIfFilmsReleaseIfEarlyThanFirstFilmEverTest() throws ValidationException {
//        assertThrows(ValidationException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                Validator.filmValidation(pastFilm);
//            }
//        });
//    }
//
//    @Test
//    public void throwsExceptionIfFilmsNameIsEmpty() throws ValidationException {
//        assertThrows(ValidationException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                Validator.filmValidation(emptyNameFilm);
//            }
//        });
//    }
//
//    @Test
//    public void throwsExceptionIfFilmDescriptionLengthIsOver200SymbolsTest() throws ValidationException {
//        assertThrows(ValidationException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                Validator.filmValidation(over200SymbolsFilm);
//            }
//        });
//    }
//
//    @Test
//    public void throwsExceptionIfFilmDurationIsNegativeTest() throws ValidationException {
//        assertThrows(ValidationException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                Validator.filmValidation(negativeDurationFilm);
//            }
//        });
//    }
//
//    @Test
//    public void notThrowsExceptionOnCorrectUserTest() throws ValidationException {
//        assertDoesNotThrow(new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                Validator.userValidation(correctUser);
//            }
//        });
//    }
//
//    @Test
//    public void throwsExceptionOnUserWithoutDogSymbolInEmailTest() throws ValidationException {
//        assertThrows(ValidationException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                Validator.userValidation(emailWithoutDogSymbolUser);
//            }
//        });
//    }
//
//    @Test
//    public void throwsExceptionOnUserWithBirthdayInTheFuture() throws ValidationException {
//        assertThrows(ValidationException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                Validator.userValidation(birthdayInFutureUser);
//            }
//        });
//    }
//
//    @Test
//    public void throwsExceptionOnUserWithEmptyLogin() throws ValidationException {
//        assertThrows(ValidationException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                Validator.userValidation(emptyLoginUser);
//            }
//        });
//    }
//
//    @Test
//    public void throwsExceptionOnUserWithWhiteSpaceInLogin() throws ValidationException {
//        assertThrows(ValidationException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                Validator.userValidation(loginWithVoidUser);
//            }
//        });
//    }
}