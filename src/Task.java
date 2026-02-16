import java.time.OffsetDateTime;
import java.util.Objects;

public class Task {
    private static int lastId = 0;
    private int id;
    private String description;
    private Status status;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public Task(){}


    public Task(String description) {
        this.id = ++lastId;
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
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
    public OffsetDateTime getCreatedAt()
    {
        return createdAt;
    }
    public OffsetDateTime getUpdatedAt()
    {
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


}

