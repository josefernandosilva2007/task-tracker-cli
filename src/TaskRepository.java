import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TaskRepository {




    public void saveTasks();

    public void remove(String id);

    public Optional<Task> listById(String id);

    public List<Task> listAll();

    public void markAsInProgress(String id);

    public void markAsDone(String id);

    public void markAsToDo(String id);


}
