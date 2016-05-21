package nl.pc.model.mongodb;

import org.mongodb.morphia.annotations.Entity;

@Entity(noClassnameStored = true)
public class TodoItem extends RootEntity {

    protected String shortName;
    public static final String _shortName = "shortName";

    protected String description;
    public static final String _description = "description";

    protected String id;
    public static final String _id = "id";

    public TodoItem() {}

    public String getShortName() {
        return shortName;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public static class Builder  {

        private TodoItem todoItem;

        public Builder() {
            this.todoItem = new TodoItem();
        }

        public Builder(TodoItem todoItem) {
            this.todoItem.auditTrail = todoItem.auditTrail;
            this.todoItem.description = todoItem.description;
            this.todoItem.shortName = todoItem.shortName;
            this.todoItem.id = todoItem.id;
        }

        public Builder withAuditTrail(AuditTrail auditTrail) {
            this.todoItem.auditTrail = auditTrail;
            return this;
        }

        public Builder withShortName(String shortName) {
            this.todoItem.shortName = shortName;
            return this;
        }

        public Builder withDescription(String description) {
            this.todoItem.description = description;
            return this;
        }

        public Builder withId(String id) {
            this.todoItem.id = id;
            return this;
        }

        public TodoItem build() {
            return this.todoItem;
        }
    }
}
