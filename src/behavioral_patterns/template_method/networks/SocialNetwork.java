package behavioral_patterns.template_method.networks;

// Базовый класс социальной сети, задаёт шаблонный метод.
public abstract class SocialNetwork {
    String username;
    String password;

    // Шаблонный метод публикации сообщения в соцсети. Включает в себя проверку пользователя, публикации сообщения
    // и выход из учетной записи.
    public final boolean post(String message) {
        // Проверка данных пользователя перед постом в соцсеть. Каждая сеть для
        // проверки использует разные методы.
        if (logIn(this.username, this.password)) {
            boolean result = sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    protected void simulateNetworkLatency() {
        try {
            int i = 0;
            System.out.println();
            while (i < 10) {
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

        abstract boolean logIn (String username, String password);
        abstract boolean sendData (byte[] data);
        abstract void logOut ();
    }
