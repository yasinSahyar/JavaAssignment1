import com.fasterxml.jackson.annotation.JsonProperty;

public class TodoPayload {


    @JsonProperty("Id")
    private int id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("User id")
    private int userId;
    @JsonProperty("Created timestamp")
    private long createdTimestamp;
    @JsonProperty("Updated timestamp")
    private long updatedTimestamp;
    @JsonProperty("Status")
    private String status;

    public TodoPayload(int id, String name, String description, int userId, long createdTimestamp, long updatedTimestamp, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.createdTimestamp = createdTimestamp;
        this.updatedTimestamp = updatedTimestamp;
        this.status = status;
    }
}
