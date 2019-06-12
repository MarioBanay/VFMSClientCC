package mariobanay.diplomski.vfmsclientcc.domain.repository;

public interface DatabaseRepository {
    boolean loginToFirebase(String username, String password);
    String getUsername();
    String getPassword();
}
