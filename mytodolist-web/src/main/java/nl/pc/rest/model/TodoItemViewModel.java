package nl.pc.rest.model;


import java.util.Date;

public class TodoItemViewModel {
    private String id;
    private String shortName;
    private String description;
    private Date created;
    private String createdBy;
    private Date lastModified;
    private String lastModifiedBy;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }


    public static class Builder {
        private TodoItemViewModel model;

        public Builder() {
            this.model = new TodoItemViewModel();
        }

        public Builder(TodoItemViewModel model) {
            this.model.created = model.created;
            this.model.createdBy = model.createdBy;
            this.model.description = model.description;
            this.model.id = model.id;
            this.model.lastModified = model.lastModified;
            this.model.lastModifiedBy = model.lastModifiedBy;
            this.model.shortName = model.shortName;
        }

        public Builder withCreated(Date created) {
            this.model.created = created;
            return this;
        }

        public Builder withCreatedBy(String createdBy) {
            this.model.createdBy = createdBy;
            return this;
        }

        public Builder withDescription(String description) {
            this.model.description = description;
            return this;
        }

        public Builder withId(String id) {
            this.model.id = id;
            return this;
        }

        public Builder withLastModified(Date lastModified) {
            this.model.lastModified = lastModified;
            return this;
        }

        public Builder withLastModifiedBy(String lastModifiedBy) {
            this.model.lastModifiedBy = lastModifiedBy;
            return this;
        }

        public Builder withShortName(String shortName) {
            this.model.shortName = shortName;
            return this;
        }

        public TodoItemViewModel build() {
            return this.model;
        }
    }
}
