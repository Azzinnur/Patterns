package behavioral_patterns.mediator;

import behavioral_patterns.mediator.components.AddButton;
import behavioral_patterns.mediator.components.DeleteButton;
import behavioral_patterns.mediator.components.Filter;
import behavioral_patterns.mediator.components.List;
import behavioral_patterns.mediator.components.SaveButton;
import behavioral_patterns.mediator.components.TextBox;
import behavioral_patterns.mediator.components.Title;
import behavioral_patterns.mediator.mediator.Editor;
import behavioral_patterns.mediator.mediator.Mediator;

import javax.swing.*;

/*
Тип паттерна: поведенческий.
Шаги реализации:
1. Найдите группу тесно переплетённых классов, отвязав которые друг от друга, можно получить некоторую пользу.
   Например, чтобы повторно использовать их код в другой программе.
2. Создайте общий интерфейс посредников и опишите в нём методы для взаимодействия с компонентами.
   В простейшем случае достаточно одного метода для получения оповещений от компонентов.
3. Этот интерфейс необходим, если вы хотите повторно использовать классы компонентов для других задач.
   В этом случае всё, что нужно сделать — это создать новый класс конкретного посредника.
4. Реализуйте этот интерфейс в классе конкретного посредника. Поместите в него поля, которые будут содержать
   ссылки на все объекты компонентов.
5. Вы можете пойти дальше и переместить код создания компонентов в класс посредника, после чего он может напоминать
   фабрику или фасад.
6. Компоненты тоже должны иметь ссылку на объект посредника. Связь между ними удобнее всего установить, подавая
   посредника в параметры конструктора компонентов.
7. Измените код компонентов так, чтобы они вызывали метод оповещения посредника, вместо методов других компонентов.
   С противоположной стороны, посредник должен вызывать методы нужного компонента, когда получает
   оповещение от компонента.

Примеры применения:
java.util.Timer (все методы scheduleXXX())
java.util.concurrent.Executor#execute()
java.util.concurrent.ExecutorService (методы invokeXXX() и submit())
java.util.concurrent.ScheduledExecutorService (все методы scheduleXXX())
java.lang.reflect.Method#invoke()
 */
public class TestMediator {
    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();

        String plus = """
                1. Устраняет зависимости между компонентами, позволяя повторно их использовать.
                2. Упрощает взаимодействие между компонентами.
                3. Централизует управление в одном месте.
                """;

        String minus = """
                1. Может сильно раздуться и стать классом-богом
                """;

        System.out.println("Плюсы:\n" + plus);
        System.out.println("Минусы:\n" + minus);
    }
}
