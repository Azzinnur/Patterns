package structure_patterns.adapter.java_entity_to_database;

public class Entity {
    public void saveObject() {
        System.out.println("Saving data object");
    }

    public void updateObject() {
        System.out.println("Updating data object");
    }

    public void removeObject() {
        System.out.println("Removing data object");
    }

    public void getObject() {
        System.out.println("Getting data object");
    }
}
