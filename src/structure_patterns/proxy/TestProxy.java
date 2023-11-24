package structure_patterns.proxy;

import structure_patterns.proxy.downloader.DownloaderTester;
import structure_patterns.proxy.downloader.YouTubeDownloader;
import structure_patterns.proxy.media_library.ThirdPartyLibrary;
import structure_patterns.proxy.proxy.YouTubeCacheProxy;

/*
Тип паттерна: структурный
Шаги реализации:
1. Определите интерфейс, который бы сделал заместитель и оригинальный объект взаимозаменяемыми.
2. Создайте класс заместителя. Он должен содержать ссылку на сервисный объект. Чаще всего, сервисный объект
   создаётся самим заместителем. В редких случаях заместитель получает готовый сервисный объект
   от клиента через конструктор.
3. Реализуйте методы заместителя в зависимости от его предназначения. В большинстве случаев,
   проделав какую-то полезную работу, методы заместителя должны передать запрос сервисному объекту.
4. Подумайте о введении фабрики, которая решала бы, какой из объектов создавать — заместитель или
   реальный сервисный объект. Но, с другой стороны, эта логика может быть помещена в создающий метод
   самого заместителя.
5. Подумайте, не реализовать ли вам ленивую инициализацию сервисного объекта до первого обращении
   клиента к методам заместителя.

Примеры:
java.lang.reflect.Proxy
java.rmi.*
javax.ejb.EJB (see comments)
javax.inject.Inject (see comments)
javax.persistence.PersistenceContext
Аннотация @Transactional в Spring

В данном случае реализован виртуальный(кэширующий) заместитель
 */
public class TestProxy {
    public static void main(String[] args) {
        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyLibrary());
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());

        long naive = DownloaderTester.test(naiveDownloader);
        long smart = DownloaderTester.test(smartDownloader);
        System.out.printf("Сэкономили времени при использовании прокси: %d мс%n%n", (naive - smart));

        String plus = """
                1. Позволяет контролировать сервисный объект незаметно для клиента.
                2. Может работать даже если сервисный объект ещё не создан.
                3. Может контролировать жизненный цикл сулжебного объекта
                """;

        String minus = """
                1. Усложняет код программы из-за введения доп. классов.
                2. Увеличивает время отклика от сервиса.
                """;

        System.out.println("Плюсы:\n" + plus);
        System.out.println("Минусы:\n" + minus);
    }

}
