import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPayload {

    @JsonProperty("Id")
    private int id;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Password")
    private String password;
    @JsonProperty("Created timestamp")
    private long createdTimestamp;
    @JsonProperty("Updated timestamp")
    private long updatedTimestamp;

    public UserPayload(int id, String email, String password, long createdTimestamp, long updatedTimestamp) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.createdTimestamp = createdTimestamp;
        this.updatedTimestamp = updatedTimestamp;
    }

    public UserPayload(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public UserPayload(int id, String name, String description, int userId, long createdTimestamp, long updatedTimestamp, String status) {
    }
}
