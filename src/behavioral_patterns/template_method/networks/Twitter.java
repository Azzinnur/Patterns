package behavioral_patterns.template_method.networks;

public class Twitter extends SocialNetwork{
    public Twitter(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    boolean logIn(String username, String password) {
        System.out.println("\nПроверка данных пользователя");
        System.out.println("Имя: " + this.username);
        System.out.print("Пароль: ");
        for (int i = 0; i < this.password.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatency();
        System.out.println("\nВход на Twitter выполнен успешно!");
        return true;
    }

    @Override
    boolean sendData(byte[] data) {
        System.out.printf("Сообщение '%s' было опубликовано на Twitter.%n", new String(data));
        return true;
    }

    @Override
    void logOut() {
        System.out.printf("Пользователь '%s' вышел из учётной записи на Twitter.%n", username);
    }
}
