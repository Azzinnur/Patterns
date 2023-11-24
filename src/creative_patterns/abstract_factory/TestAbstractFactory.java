package creative_patterns.abstract_factory;

import creative_patterns.abstract_factory.banking.BankingProjectTeamFactory;
import creative_patterns.abstract_factory.website.WebsiteTeamFactory;

/*
Тип паттерна: порождающий.

Шаги создания:
1. Создайте таблицу соотношений типов продуктов к вариациям семейств продуктов.
2. Сведите все вариации продуктов к общим интерфейсам.
3. Определите интерфейс абстрактной фабрики. Он должен иметь фабричные
   методы для создания каждого из типов продуктов.
4. Создайте классы конкретных фабрик, реализовав интерфейс абстрактной
   фабрики. Этих классов должно быть столько же, сколько и вариаций семейств
   продуктов.
5. Измените код инициализации программы так, чтобы она создавала определённую
   фабрику и передавала её в клиентский код.
6. Замените в клиентском коде участки создания продуктов через конструктор
   вызовами соответствующих методов фабрики.

Примеры:
javax.xml.parsers.DocumentBuilderFactory#newInstance()
javax.xml.transform.TransformerFactory#newInstance()
javax.xml.xpath.XPathFactory#newInstance()
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new BankingProjectTeamFactory();
        Developer developer1 = projectTeamFactory.getDeveloper();
        Developer developer2 = projectTeamFactory.getDeveloper();
        Tester tester =projectTeamFactory.getTester();
        ProjectManager projectManager = projectTeamFactory.getProjectManager();
        System.out.println("Creating SuperBank Project");
        developer1.writeCode();
        developer2.writeCode();
        tester.testCode();
        projectManager.manageProject();
        System.out.println();

        ProjectTeamFactory websiteTeamFactory = new WebsiteTeamFactory();
        Developer websiteDeveloper = websiteTeamFactory.getDeveloper();
        Tester webTester =websiteTeamFactory.getTester();
        ProjectManager webProjectManager = websiteTeamFactory.getProjectManager();
        System.out.println("Creating Auction Site Project");
        websiteDeveloper.writeCode();
        webTester.testCode();
        webProjectManager.manageProject();
        System.out.println();

        String plus = """
                1. Гарантирует сочетаемость создаваемый продуктов.
                2. Избавляет клиенский код от привязки к конкретным классам продуктов.
                3. Выделяет код производства продуктов в одно место, упрощая подержку кода
                4. Упрощает добавление новых продуктов в программу.
                5. Реализует принцип открытости/закрытости.
                """;

        String minus = """
                1. Усложняет код программы из-за множества доп. классов.
                2. Требует наличия всех типов продукции в каждой вариации.
                """;

        System.out.println("Плюсы:\n" + plus);
        System.out.println("Минусы:\n" + minus);
    }
}
