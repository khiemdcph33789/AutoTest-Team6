package TestJUnit.TestLoginFeature;

import Repository.LoginRepository;

public class LoginService {
    private LoginRepository loginRepo= new LoginRepository();

    public boolean Login(String userName, String password){
        return loginRepo.authenticateUser(userName,password);
    }
}
