package cd.go.authorization.guest.model;

import cd.go.authorization.guest.exception.InvalidUsernameException;
import cd.go.authorization.guest.utils.Util;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @Expose
    @SerializedName("username")
    private String username;

    @Expose
    @SerializedName("display_name")
    private String displayName;

    public User(String username, String displayName) {
        this.username = username;
        this.displayName = displayName;

        if (Util.isBlank(this.username)) {
            throw new InvalidUsernameException("Username can not be blank.");
        }
    }

    public String getUsername() {
        return username;
    }

    public String getDisplayName() {
        return displayName != null && displayName.length() > 0 ? displayName : username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (displayName != null ? !displayName.equals(user.displayName) : user.displayName != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder("User@{username=").append(username)
                .append(", displayName=").append(displayName)
                .append("}").toString();
    }
}