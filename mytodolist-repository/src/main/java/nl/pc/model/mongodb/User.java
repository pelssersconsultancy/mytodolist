package nl.pc.model.mongodb;


import org.hibernate.validator.constraints.NotBlank;
import org.mongodb.morphia.annotations.Entity;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(noClassnameStored = true)
public class User {

    @NotBlank
    protected String userId;
    public static final String _userId = "userId";

    @NotBlank
    protected String firstName;
    public static final String _firstName = "firstName";

    @NotBlank
    protected String lastName;
    public static final String _lastName = "lastName";

    @NotNull
    protected Date birthDay;
    public static final String _birthDay = "birthDay";

    @NotBlank
    protected String email;
    public static final String _email = "email";

    public User() {}


    public static class Builder {
        private User user;

        public Builder() {
            this.user = new User();
        }

        public Builder(User user) {
            this.user.userId = user.userId;
            this.user.birthDay = user.birthDay;
            this.user.email = user.email;
            this.user.firstName = user.firstName;
            this.user.lastName = user.lastName;
        }

        public Builder withUserId(String userId) {
            this.user.userId = userId;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.user.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.user.lastName = lastName;
            return this;
        }

        public Builder withBirthDay(Date birthDay) {
            this.user.birthDay = birthDay;
            return this;
        }

        public Builder withEmail(String email) {
            this.user.email = email;
            return this;
        }

        public User build() {
            return this.user;
        }
    }


}
