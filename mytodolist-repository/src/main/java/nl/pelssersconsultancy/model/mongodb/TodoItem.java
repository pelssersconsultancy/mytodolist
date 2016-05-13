package nl.pelssersconsultancy.model.mongodb;

import org.mongodb.morphia.annotations.Entity;

@Entity(noClassnameStored = true)
public class TodoItem extends RootEntity {

    protected String shortName;
    protected String description;


    public TodoItem(TodoItemBuilder builder) {
        this.description = builder.description;
        this.shortName = builder.shortName;

    }

    public String getShortName() {
        return shortName;
    }

    public String getDescription() {
        return description;
    }

    public static class TodoItemBuilder {

        private String shortName;
        private String description;

        public TodoItemBuilder withShortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public TodoItemBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public TodoItem build() {
            return new TodoItem(this);
        }


    }
}
