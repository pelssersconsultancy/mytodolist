package nl.pc.model.mongodb;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import javax.validation.Valid;

public abstract class RootEntity implements Auditable {

    @Id
    protected ObjectId objectId;
    public static final String _objectId = "objectId";

    @Embedded
    @Valid
    protected AuditTrail auditTrail;
    public static final String _auditTrail = "auditTrail";

    public RootEntity() {}

    public ObjectId getObjectId() {
        return objectId;
    }

    @Override
    public AuditTrail getAuditTrail() {
        return auditTrail;
    }
}
