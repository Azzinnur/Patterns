package behavioral_patterns.chain_of_responsibility.middleware;

import behavioral_patterns.chain_of_responsibility.server.Server;

public class UserExistsMiddleware extends Middleware{
    private Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }
    @Override
    public boolean check(String email, String password){
        if (!server.hasEmail(email)) {
            System.out.println("Этот логин не зарегистрирован!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Неверный пароль!");
            return false;
        }
        return checkNext(email, password);
    }
}
