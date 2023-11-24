package creative_patterns.singleton;

/*
Тип паттерна: конструирующий.
Шаги создания:
1. Private конструктор для ограничения создания экземпляра класса из других
   классов.
2. Private static переменная того же класса, который является единственным
   экземпляром класса.
3. Public static метод, который возвращает экземпляр класса, это глобальная точка
   доступа для внешнего мира, чтобы получить экземпляр одноэлементного класса
 */
public class TestSingleton {
    public static void main(String[] args) {
        System.out.println(ProgrammLogger.getProgrammLogger().toString());
        ProgrammLogger.getProgrammLogger().addLogInfo("Hello!");
        ProgrammLogger.getProgrammLogger().addLogInfo("Ololo");
        ProgrammLogger.getProgrammLogger().addLogInfo("First log...");
        ProgrammLogger.getProgrammLogger().addLogInfo("Lega is checked by BingChillingException!");
        ProgrammLogger.getProgrammLogger().addLogInfo("20000 gems");
        ProgrammLogger.getProgrammLogger().addLogInfo("The end!");
        ProgrammLogger.getProgrammLogger().showLogFile();
        System.out.println(ProgrammLogger.getProgrammLogger().toString());
        System.out.println();

        String plus = """
                1. Гарантирует наличие единственного экземпляра класса.
                2. Предоставляет к нему глобальную точку доступа
                3. Реализует отложенную инициализацию объекта-одиночки.
                """;

        String minus = """
                1. Нарушает принцип единственной ответственности класса.
                2. Маскирует плохой дизайн. Данный паттерн требует плотной связки с другими классами
                   Это создаёт проблемы при модификации кода.
                3. Создаёт узкое место в многопоточности, а также при расширении программы
                4. Требует постоянного создание mock-объектов при тестировании
                5. Создаёт в программе глобальное состояние с непредсказуемым поведением.
                """;

        System.out.println("Плюсы:\n" + plus);
        System.out.println("Минусы:\n" + minus);

    }
}
