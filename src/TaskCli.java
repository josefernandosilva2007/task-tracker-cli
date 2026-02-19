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
            default:
                break;
        }

        taskService.saveTasks();
    }
}