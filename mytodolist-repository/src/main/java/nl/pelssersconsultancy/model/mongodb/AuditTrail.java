package nl.pelssersconsultancy.model.mongodb;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Gives insight into
 * - by whom (createdBy, lastModifiedBy)
 * - when (created, lastModified)
 * data is altered
 */
public class AuditTrail {

    @NotNull
    protected Date created;
    @NotNull
    protected User createdBy;
    @NotNull
    protected Date lastModified;
    @NotNull
    protected User lastModifiedBy;

    public AuditTrail(AuditTrailBuilder builder) {
        this.created = builder.created;
        this.createdBy = builder.createdBy;
        this.lastModified = builder.lastModified;
        this.lastModifiedBy = builder.lastModifiedBy;
    }

    public Date getCreated() {
        return created;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public static class AuditTrailBuilder {
        private Date created;
        private User createdBy;
        private Date lastModified;
        private User lastModifiedBy;

        public AuditTrailBuilder fromAuditTrail(AuditTrail auditTrail) {
            this.created = auditTrail.created;
            this.createdBy = auditTrail.createdBy;
            this.lastModified = auditTrail.lastModified;
            this.lastModifiedBy = auditTrail.lastModifiedBy;
            return this;
        }

        public AuditTrailBuilder withCreated(Date created) {
            this.created = created;
            return this;
        }

        public AuditTrailBuilder withCreatedBy(User createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AuditTrailBuilder withLastModified(Date lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        public AuditTrailBuilder withLastModifiedBy(User lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return this;
        }

        public AuditTrail build() {
            return new AuditTrail(this);
        }
    }
}
