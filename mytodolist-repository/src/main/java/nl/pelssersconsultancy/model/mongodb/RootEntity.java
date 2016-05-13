package nl.pelssersconsultancy.model.mongodb;

import nl.pelssersconsultancy.common.IBuilder;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

import javax.validation.Valid;

/**
 * Base class for all Entities
 */
public abstract class RootEntity {

    @Id
    protected ObjectId objectId;
    public static final String _objectId = "objectId";

    @Embedded
    @Valid
    protected AuditTrail auditTrail;
    public static final String _auditTrail = "auditTrail";

    public RootEntity() {}

    public RootEntity(Builder builder) {
        this.auditTrail = builder.auditTrail;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public AuditTrail getAuditTrail() {
        return auditTrail;
    }

    public static abstract class Builder<S extends RootEntity,T extends Builder> implements IBuilder<S, T> {
        protected AuditTrail auditTrail;

        public Builder withAuditTrail(AuditTrail auditTrail) {
            this.auditTrail  = auditTrail;
            return self();
        }
    }
}
