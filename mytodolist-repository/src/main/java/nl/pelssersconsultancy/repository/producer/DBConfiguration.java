package nl.pelssersconsultancy.repository.producer;


import nl.pelssersconsultancy.common.IBuilder;

import java.util.Optional;

public class DBConfiguration {

    protected String hostname;
    protected int port;
    protected String databaseName;
    protected Optional<DBCredential> dbCredentials;
    protected String prefix;

    public DBConfiguration(Builder builder) {
        this.hostname = builder.hostname;
        this.port = builder.port;
        this.databaseName = builder.databaseName;
        this.dbCredentials = builder.dbCredentials;
        this.prefix = builder.prefix;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public Optional<DBCredential> getDbCredentials() {
        return dbCredentials;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getPrefixedDatabaseName() {
        return String.join("", getPrefix(), getDatabaseName());
    }

    public static class Builder implements IBuilder {

        protected String hostname;
        protected int port;
        protected String databaseName;
        protected Optional<DBCredential> dbCredentials = Optional.empty();
        protected String prefix;


        public Builder withHostname(String hostname) {
            this.hostname = hostname;
            return self();
        }

        public Builder withPort(int port) {
            this.port = port;
            return self();
        }

        public Builder withDabaseName(String databaseName) {
            this.databaseName = databaseName;
            return self();
        }

        public Builder withCredentials(String username, String password) {
            this.dbCredentials = Optional.of(new DBCredential.Builder()
                    .withPassword(password)
                    .withUsername(username)
                    .build()
            );
            return self();
        }

        public Builder withPrefix(String prefix) {
            this.prefix = prefix;
            return self();
        }

        public DBConfiguration build() {
            return new DBConfiguration(this);
        }

        public Builder self() {
            return this;
        }
    }

}
