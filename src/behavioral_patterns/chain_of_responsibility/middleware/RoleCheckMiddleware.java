package behavioral_patterns.chain_of_responsibility.middleware;

public class RoleCheckMiddleware extends Middleware{
    @Override
    public boolean check(String email, String password) {
        if(email.equals("admin@example.com")) {
            System.out.println("Рады приветствовать вас, Админ!");
            return true;
        }
        System.out.println("Здарова, негражданин!");
        return checkNext(email, password);
    }

}
