import java.util.HashSet;
import java.util.Set;

public class TaskService {
    Set<Task> tasks = new HashSet<Task>();
    TaskRepository taskRepository =  new TaskRepository();



    public void addTask(String description){
        Task save = taskRepository.save(description);
        tasks.add(save);
        System.out.println("Task added with id: " + save.getId());
    }
}
