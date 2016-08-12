package nl.pc.model.mongodb;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class AuditTrail {

    @NotBlank
    private String createdBy;
    public static final String _createdBy = "createdBy";

    @NotNull
    private Date created;
    public static final String _created = "created";

    @NotBlank
    private String lastModifiedBy;
    public static final String _lastModifiedBy = "lastModifiedBy";

    @NotNull
    private Date lastModified;
    public static final String _lastModified = "lastModified";

    public Date getCreated() {
        return created;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }


    public static class Builder {

        private AuditTrail auditTrail;

        public Builder() {
            this.auditTrail = new AuditTrail();
        }

        public Builder withCreatedBy(String createdBy) {
            this.auditTrail.createdBy = createdBy;
            return this;
        }

        public Builder withCreated(Date created) {
            this.auditTrail.created = created;
            return this;
        }

        public Builder withLastModifiedBy(String lastModifiedBy) {
            this.auditTrail.lastModifiedBy = lastModifiedBy;
            return this;
        }

        public Builder withLastModified(Date lastModified) {
            this.auditTrail.lastModified = lastModified;
            return this;
        }

        public AuditTrail build() {
            return this.auditTrail;
        }
    }
}
