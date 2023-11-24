package behavioral_patterns.iterator;

import behavioral_patterns.iterator.profile.Profile;
import behavioral_patterns.iterator.social_networks.Facebook;
import behavioral_patterns.iterator.social_networks.LinkedIn;
import behavioral_patterns.iterator.social_networks.SocialNetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Тип паттерна: поведенческий.
Шаги реализации:
1. Создайте общий интерфейс итераторов. Обязательный минимум — это операция получения следующего элемента коллекции.
   Но для удобства можно предусмотреть и другое. Например, методы для получения предыдущего элемента,
   текущей позиции, проверки окончания обхода и прочие.
2. Создайте интерфейс коллекции и опишите в нём метод получения итератора. Важно, чтобы сигнатура метода
   возвращала общий интерфейс итераторов, а не один из конкретных итераторов.
3. Создайте классы конкретных итераторов для тех коллекций, которые нужно обходить с помощью паттерна.
   Итератор должен быть привязан только к одному объекту коллекции. Обычно эта связь устанавливается через конструктор.
4. Реализуйте методы получения итератора в конкретных классах коллекций. Они должны создавать новый итератор
   того класса, который способен работать с данным типом коллекции. Коллекция должна передавать ссылку на собственный
   объект в конструктор итератора.
5. В клиентском коде и в классах коллекций не должно остаться кода обхода элементов. Клиент должен получать
   новый итератор из объекта коллекции каждый раз, когда ему нужно перебрать её элементы.

Примеры паттерна:
Все реализации java.util.Iterator (среди прочего также java.util.Scanner).
Все реализации java.util.Enumeration.
 */
public class TestIterator {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Пожалуйста, укажите желаемую социальную сеть, чтобы запустить спам-атаку:");
        System.out.println("1. Facebook");
        System.out.println("2. LinkedIn");
        String choice = scanner.nextLine();

        SocialNetwork network;
        if (choice.equals("2")) {
            network = new LinkedIn(createTestProfiles());
        }
        else {
            network = new Facebook(createTestProfiles());
        }

        SocialSpammer spammer = new SocialSpammer(network);
        spammer.sendSpamToFriends("anna.smith@bing.com",
                "Здравствуй! Это Вася, друг Анны. Помоги мне, пожалуйста, лайкни этот пост: [link]?");
        spammer.sendSpamToCoworkers("anna.smith@bing.com",
                "Здравствуй! Это Василий, руководитель Анны. Анна сказала мне, что тебе может быть " +
                        "интересно [link].");
        System.out.println();

        String plus = """
                1. Упрощает классы хранения данных.
                2. Позволяет реализовать различные способы обхода структуры данных.
                3. Позволяет одновременно перемещаться по структуре данных в разные стороны.
                """;

        String minus = """
                1. Не оправдан, если можно обойтись простым циклом.
                """;

        System.out.println("Плюсы:\n" + plus);
        System.out.println("Минусы:\n" + minus);
    }

    public static List<Profile> createTestProfiles() {
        List<Profile> data = new ArrayList<>();
        data.add(new Profile("anna.smith@bing.com", "Anna Smith", "друзья:mad_max@ya.com", "друзья:catwoman@yahoo.com", "коллеги:sam@amazon.com"));
        data.add(new Profile("mad_max@ya.com", "Maximilian", "друзья:anna.smith@bing.com", "коллеги:sam@amazon.com"));
        data.add(new Profile("bill@microsoft.eu", "Billie", "коллеги:avanger@ukr.net"));
        data.add(new Profile("avanger@ukr.net", "John Day", "коллеги:bill@microsoft.eu"));
        data.add(new Profile("sam@amazon.com", "Sam Kitting", "коллеги:anna.smith@bing.com", "коллеги:mad_max@ya.com", "друзья:catwoman@yahoo.com"));
        data.add(new Profile("catwoman@yahoo.com", "Liza", "друзья:anna.smith@bing.com", "друзья:sam@amazon.com"));
        return data;
    }
}
