package br.com.managersystems.guardasaude.login;


public class DummyLogin {

    private static final String DUMMYUSERNAME="test@gmail.com";
    private static final String DUMMYPASSWORD="password";

    private static final String DUMMYFAKEUSERNAME="faketest@gmail.com";
    private static final String DUMMYFAKEPASSWORD="fakepassword";

    public static String getDummyUserName() {
        return DUMMYUSERNAME;

    }

    public static String getDummyPassword() {
        return DUMMYPASSWORD;
    }

    public static String getDummyFakeUsername() {
        return DUMMYFAKEUSERNAME;
    }

    public static String getDummyFakePassword() {
        return DUMMYFAKEPASSWORD;
    }
}
