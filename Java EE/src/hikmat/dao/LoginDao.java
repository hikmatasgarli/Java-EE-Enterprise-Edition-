
package hikmat.dao;


import hikmat.model.Login;


public interface LoginDao {
    
    Login login(String username, String password) throws Exception;

    Login checkEmail(String email) throws Exception;
    boolean updateToken(String token,Long userId) throws Exception;
    boolean addUser (Login login) throws Exception;
}
