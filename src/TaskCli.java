public class TaskCli {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();


       if (args[0].equals("add")) {
           taskService.addTask(args[1]);
       }
    }
}