import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface TaskRepository {




    public void saveTasks();

    public void remove(String id);

    public Task listById(String id);

    public List<Task> listAll();


}
