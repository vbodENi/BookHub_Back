//package fr.eni.bookhub_api.auth.login;
//
//import fr.eni.bookhub_api.common.bo.User;
//import fr.eni.bookhub_api.auth.login.dao.ILoginDAO;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LoginService
//{
//    private final ILoginDAO loginDAO;
//
//    public LoginService(ILoginDAO loginDAO) {
//        this.loginDAO = loginDAO;
//    }
//
//    public LoginResponse checkAuth(String email, String password){
//        User userByEmail = loginDAO.findByLogin(email,password);
//
//        if(userByEmail == null){
//            return new LoginResponse("7001", "");
//        }
//        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjbmljb2xhc0BjYW1wdXMtZW5pLmZyIiwiaWF0IjoxNzc2NzY0MjE0LCJleHAiOjE3NzY3NjU2NTR9.EXZkw-pkMjkBbHTRmCByT241kJbrgBkifJBUFLaRcaY";
//        return new LoginResponse("2002", token);
//    }
//}
