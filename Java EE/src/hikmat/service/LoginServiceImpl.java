package hikmat.service;

import hikmat.dao.LoginDao;
import hikmat.model.Login;

public class LoginServiceImpl implements LoginService {
    private LoginDao loginDao;

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public Login login(String username, String password) throws Exception {
        return loginDao.login(username,password);
    }

    @Override
    public Login checkEmail(String email) throws Exception {
        return loginDao.checkEmail(email);
    }

    @Override
    public boolean updateToken(String token,Long userId) throws Exception {
        return loginDao.updateToken(token,userId);
    }

    @Override
    public boolean addUser(Login login) throws Exception {
        return loginDao.addUser(login);
    }
}
