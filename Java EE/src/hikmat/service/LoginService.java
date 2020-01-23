package hikmat.service;

import hikmat.model.Login;

public interface LoginService {
    Login login(String username, String password) throws Exception;
    Login checkEmail(String email) throws Exception;
    boolean updateToken(String token, Long userId) throws Exception;
    boolean addUser (Login login) throws Exception;

}
