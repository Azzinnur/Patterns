package structure_patterns.adapter.java_entity_to_database;

public class EntityToDatabaseAdapter extends Entity implements Database{
    @Override
    public void insert() {
        saveObject();
    }

    @Override
    public void select() {
        getObject();
    }

    @Override
    public void update() {
        updateObject();
    }

    @Override
    public void delete() {
        removeObject();
    }
}
