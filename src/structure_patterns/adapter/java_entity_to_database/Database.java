package structure_patterns.adapter.java_entity_to_database;

public interface Database {
    void insert();
    void select();
    void update();
    void delete();
}
