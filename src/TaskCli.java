import java.util.List;

public class TaskCli {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        String command = args[0];




        switch (command) {
            case "add":
                if(args.length > 2){
                    System.out.println("Error: use quotes for multi-word tasks.");
                    break;
                }
                taskService.addTask(args[1]);
                break;
            case "remove":
                if(args.length > 2){
                    System.out.println("Error: for remove use \"remove {id}\" ");
                    break;
                }
                if(!validateInt(args[1])){
                    System.out.println("Error: use only numbers");
                    break;
                }

                taskService.remove(args[1]);
                break;
            case "update":
                if(args.length > 3){
                    System.out.println("Error: use quotes for multi-word tasks.");
                    break;
                }
                if(!validateInt(args[1])){
                    System.out.println("Error: use only numbers for id");
                    break;
                }

                taskService.updateTask(args[1], args[2]);
                break;
            case "mark-in-progress":
                if(args.length > 2){
                    System.out.println("Error: use only the id");
                    break;
                }

                if(!validateInt(args[1])){
                    System.out.println("Error: use only numbers for id");
                    break;
                }
                taskService.markAsInProgress(args[1]);
                break;
            case "mark-done":
                if(args.length > 2){
                    System.out.println("Error: use only the id");
                    break;
                }

                if(!validateInt(args[1])){
                    System.out.println("Error: use only numbers for id");
                    break;
                }
                taskService.markAsDone(args[1]);
                break;
            case "mark-todo":
                if(args.length > 2){
                    System.out.println("Error: use only the id");
                    break;
                }

                if(!validateInt(args[1])){
                    System.out.println("Error: use only numbers for id");
                    break;
                }
                taskService.markAsToDo(args[1]);
                break;
            case "list-tasks":
                if(args.length > 1){
                    System.out.println("Error: type only \"list-tasks\" to see all tasks");
                }

                List<Task> tasks = taskService.listAll();
                for (Task task : tasks) {
                    System.out.println(task.toString());
                }
                break;
            case "list":
                if(args.length > 1){
                    System.out.println("Error: type only status");
                    break;
                }
                if(!validateStatus(args[1])){
                    System.out.println("Error: use only status: \"in-progress\" \"done\" \"todo\"");
                    break;
                }
                List<Task> listByStatus = taskService.listByStatus(args[1]);
                System.out.println(listByStatus);
                break;

            default:
                break;
        }

        taskService.saveTasks();
    }


    public static boolean validateInt(String num){
        if(num == null || num.isEmpty()){
            return false;
        }
        try{
            Integer.parseInt(num);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static boolean validateStatus(String status){
        if(status == null || status.isEmpty()){
            return false;
        }
        try{
            Status.fromString(status);
            return true;
        } catch (RuntimeException e){
            return false;
        }
    }
}