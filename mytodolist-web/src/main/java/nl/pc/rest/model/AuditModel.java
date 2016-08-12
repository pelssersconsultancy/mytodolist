package nl.pc.rest.model;


import java.util.Date;

public class AuditModel {

    private Date timestamp;
    private String userName;

    public AuditModel(Date timestamp, String userName) {
        this.timestamp = timestamp;
        this.userName  = userName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getUserName() {
        return userName;
    }
}
