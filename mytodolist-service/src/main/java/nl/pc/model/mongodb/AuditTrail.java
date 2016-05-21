package nl.pc.model.mongodb;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class AuditTrail {

    @NotNull
    protected Date created;
    public static final String _created = "created";

    @NotNull
    protected Date lastModified;
    public static final String _lastModified = "lastModified";

    public Date getCreated() {
        return created;
    }

    public Date getLastModified() {
        return lastModified;
    }


    public static class Builder {

        private AuditTrail auditTrail;

        public Builder() {
            this.auditTrail = new AuditTrail();
        }

        public Builder(AuditTrail auditTrail) {
            this.auditTrail.created = auditTrail.created;
            this.auditTrail.lastModified = auditTrail.lastModified;
        }

        public Builder withCreated(Date created) {
            this.auditTrail.created = created;
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
