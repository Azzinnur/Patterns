package behavioral_patterns.template_method.networks;

public class Facebook extends SocialNetwork{

    public Facebook(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    @Override
    boolean logIn(String username, String password) {
        System.out.println(("\nПроверка данных пользователя"));
        System.out.println("Имя: " + this.username);
        System.out.print("Пароль: ");
        for (int i = 0; i < this.password.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatency();
        System.out.println("\nВход на Facebook выполнен успешно!");
        return true;
    }

    @Override
    public boolean sendData(byte[] data) {
            System.out.printf("Сообщение '%s' было опубликовано на Facebook.%n", new String(data));
            return true;
    }

    @Override
    public void logOut() {
        System.out.printf("Пользователь '%s' вышел из учётной записи на Facebook.%n", username);
    }

}
