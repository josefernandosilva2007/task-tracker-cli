public class TaskCli {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        String command = args[0];
        switch (command) {
            case "add":
                taskService.addTask(args[1]);
                break;
            default:
                break;
        }

        taskService.saveTasks();
}}