import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TaskService implements TaskRepository {
    private final Path PATH_FILE = Paths.get("tasks.json");
    private List<Task> tasks;


    TaskService(){
        this.tasks = loadTasks();
    }



    public List<Task> loadTasks(){
        List<Task> taskJson = new ArrayList<>();

        if(Files.notExists(PATH_FILE)){
            return new ArrayList<>();
        }

        try {
            String jsonContent = Files.readString(PATH_FILE);
            String[] taskList = jsonContent.replace("[", "").replace("]", "").split("},");

            for(String task: taskList){
                if(!task.endsWith("}")){
                    task = task + "}";
                    taskJson.add(Task.fromJson(task));
                } else {
                    taskJson.add(Task.fromJson(task));

                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return taskJson;
    }

    public void addTask(String description){
        Task save = new Task(description);
        tasks.add(save);
        System.out.println("Task added with id: " + save.getId());
    }





    @Override
    public void saveTasks() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(tasks.get(i).toJson());
            if(i < tasks.size()-1){
                sb.append(",\n");
            }
        }
        sb.append("\n]");

        String jsonContent = sb.toString();

        try {
            Files.writeString(PATH_FILE, jsonContent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Task listById(String id) {
        return null;
    }

    @Override
    public List<Task> listAll() {
        return tasks;
    }
}
