package nl.pelssersconsultancy.model.mongodb;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class User {

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


    public User(UserBuilder builder) {
        this.birthDay = builder.birthDay;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private Date birthDay;
        private String email;

        public UserBuilder fromUser(User user) {
            this.birthDay = user.birthDay;
            this.email = user.email;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder withBirthDay(Date birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


}
