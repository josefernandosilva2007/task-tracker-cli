import java.util.List;

public class TaskCli {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        String command = args[0];
        switch (command) {
            case "add":
                taskService.addTask(args[1]);
                break;
            case "remove":
                taskService.remove(args[1]);
                break;
            case "update":
                taskService.updateTask(args[1], args[2]);
                break;
            case "mark-in-progress":
                taskService.markAsInProgress(args[1]);
                break;
            case "mark-in-done":
                taskService.markAsDone(args[1]);
                break;
            case "list-tasks":
                List<Task> tasks = taskService.listAll();
                for(Task task : tasks) {
                    System.out.println(task.toString());
                }
            default:
                break;
        }

        taskService.saveTasks();
    }
}