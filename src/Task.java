import java.time.OffsetDateTime;
import java.util.Objects;

public class Task {
    private static int lastId = 0;
    private int id;
    private String description;
    private Status status;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public Task() {
    }


    public Task(String description) {
        this.id = ++lastId;
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public String toJson() {
        return "{\"id\":\"" + id
                + "\", \"description\":\"" + description.strip()
                + "\", \" status\":\"" + status
                + "\", \"createAt\":\"" + createdAt
                + "\", \"updatedAt\":\"" + updatedAt + "\"}";
    }

    public static Task fromJson(String json){
            json = json.replace("{","").replace("}","").replace("\"","");
            String[] jsonSplit  = json.split(",");

            String id = jsonSplit[0].split(":")[1].strip();
            String description = jsonSplit[1].split(":")[1].strip();
            String statusString = jsonSplit[2].split(":")[1].strip();
            String createdAt = jsonSplit[3].split("[a-z]:")[1].strip();
            String updatedAt = jsonSplit[4].split("[a-z]:")[1].strip();

            Status status = Status.valueOf(statusString.toUpperCase());
            OffsetDateTime createdAtOffset = OffsetDateTime.parse(createdAt);
            OffsetDateTime updatedAtOffset = OffsetDateTime.parse(updatedAt);

            Task task = new Task();
            task.id = Integer.parseInt(id);
            task.description = description;
            task.status = status;
            task.createdAt = createdAtOffset;
            task.updatedAt = updatedAtOffset;

            if (Integer.parseInt(id)>lastId){
                lastId = Integer.parseInt(id);
            }


            return task;
    }


    public void markAsDone() {
        status = Status.DONE;
        this.updatedAt = OffsetDateTime.now();
    }
    public void markAsInProgress() {
        status = Status.IN_PROGRESS;
        this.updatedAt = OffsetDateTime.now();
    }
    public void markAsToDo() {
        status = Status.TODO;
        this.updatedAt = OffsetDateTime.now();
    }

}

