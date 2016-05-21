package nl.pc.model.mongodb;

import org.mongodb.morphia.annotations.Entity;

@Entity(noClassnameStored = true)
public class TodoItem extends RootEntity {

    protected String shortName;
    protected String description;

    public TodoItem() {}

    public String getShortName() {
        return shortName;
    }

    public String getDescription() {
        return description;
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

        public TodoItem build() {
            return this.todoItem;
        }
    }
}
