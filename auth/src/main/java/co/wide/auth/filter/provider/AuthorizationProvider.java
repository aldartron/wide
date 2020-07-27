package co.wide.auth.filter.provider;

public interface AuthorizationProvider {

    boolean isValidAuthorizationHeader(String header);

}
