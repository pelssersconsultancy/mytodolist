package nl.pelssersconsultancy.model.mongodb;

import org.mongodb.morphia.annotations.Entity;

@Entity(noClassnameStored = true)
public class TodoItem extends RootEntity {

    protected String shortName;
    protected String description;

    public TodoItem() {}

    public TodoItem(Builder builder) {
        this.description = builder.description;
        this.shortName = builder.shortName;
        this.auditTrail = builder.auditTrail;
    }

    public String getShortName() {
        return shortName;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder extends RootEntity.Builder<TodoItem, Builder> {

        private String shortName;
        private String description;

        public Builder withShortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder self() {
            return this;
        }

        public TodoItem build() {
            return new TodoItem(this);
        }
    }
}
