package nl.pc.producer;

import java.util.Optional;

public class DBConfiguration {

    protected String hostname;
    protected int port;
    protected String databaseName;
    protected Optional<DBCredential> dbCredentials = Optional.empty();
    protected String prefix;
    protected String joiner = "";

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

    public String getJoiner() {
        return this.joiner;
    }

    public String getPrefixedDatabaseName() {
        return String.join(joiner, getPrefix(), getDatabaseName());
    }

    public static class Builder  {

        private DBConfiguration dbConfiguration;

        public Builder() {
            this.dbConfiguration = new DBConfiguration();
        }

        public Builder(DBConfiguration dbConfiguration) {
            this.dbConfiguration.databaseName = dbConfiguration.databaseName;
            this.dbConfiguration.dbCredentials = dbConfiguration.dbCredentials;
            this.dbConfiguration.hostname = dbConfiguration.hostname;
            this.dbConfiguration.port = dbConfiguration.port;
            this.dbConfiguration.prefix = dbConfiguration.prefix;
            this.dbConfiguration.joiner = dbConfiguration.joiner;
        }


        public Builder withHostname(String hostname) {
            this.dbConfiguration.hostname = hostname;
            return this;
        }

        public Builder withPort(int port) {
            this.dbConfiguration.port = port;
            return this;
        }

        public Builder withDatabaseName(String databaseName) {
            this.dbConfiguration.databaseName = databaseName;
            return this;
        }

        public Builder withCredentials(String username, String password) {
            this.dbConfiguration.dbCredentials = Optional.of(new DBCredential.Builder()
                    .withPassword(password)
                    .withUsername(username)
                    .build()
            );
            return this;
        }

        public Builder withPrefix(String prefix) {
            this.dbConfiguration.prefix = prefix;
            return this;
        }

        public Builder withJoiner(String joiner) {
            this.dbConfiguration.joiner = joiner;
            return this;
        }

        public DBConfiguration build() {
            return this.dbConfiguration;
        }

    }

}
