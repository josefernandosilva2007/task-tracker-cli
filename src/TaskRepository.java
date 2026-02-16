public class TaskRepository {

//    public String toJson(Task task){
//        return "{\"id\":\""+task.getId()
//                +"\", \"description\":\"" +task.getDescription().strip()
//                +"\", \" status\":\"" + task.getStatus().toString()
//                +"\", \"createAt\":\"" + task.getCreatedAt()
//                + "\", \"updatedAt\":\"" + task.getUpdatedAt() + "\"}";
//
//    }


    public Task save(String description){
        return new Task(description);
    }



}
