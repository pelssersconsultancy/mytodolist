package nl.pelssersconsultancy.model.mongodb;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class AuditTrail {

    @NotNull
    protected Date created;
    public static final String _created = "created";

    @NotNull
    protected String createdBy;
    public static final String _createdBy = "createdBy";

    @NotNull
    protected Date lastModified;
    public static final String _lastModified = "lastModified";

    @NotNull
    protected String lastModifiedBy;
    public static final String _lastModifiedBy = "_lastModifiedBy";

    public Date getCreated() {
        return created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public static class Builder {

        private AuditTrail auditTrail;

        public Builder() {
            this.auditTrail = new AuditTrail();
        }

        public Builder(AuditTrail auditTrail) {
            this.auditTrail.created = auditTrail.created;
            this.auditTrail.createdBy = auditTrail.createdBy;
            this.auditTrail.lastModified = auditTrail.lastModified;
            this.auditTrail.lastModifiedBy = auditTrail.lastModifiedBy;
        }

        public Builder withCreated(Date created) {
            this.auditTrail.created = created;
            return this;
        }

        public Builder withCreatedBy(String createdBy) {
            this.auditTrail.createdBy = createdBy;
            return this;
        }

        public Builder withLastModified(Date lastModified) {
            this.auditTrail.lastModified = lastModified;
            return this;
        }

        public Builder withLastModifiedBy(String lastModifiedBy) {
            this.auditTrail.lastModifiedBy = lastModifiedBy;
            return this;
        }

        public AuditTrail build() {
            return this.auditTrail;
        }
    }
}
