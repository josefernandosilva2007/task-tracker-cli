import java.time.OffsetDateTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Help commandList = new Help();
        String command = "task";
        String add = "add";
        String help = "-help";
        String remove = "remove";






        while(true) {
            Scanner input = new Scanner(System.in);
            String response = input.nextLine();
            String taskPattern = "";

            Pattern pattern = Pattern.compile("\"(.+?)\"");
            Matcher matcher = pattern.matcher(response);
            if (matcher.find()) {
                taskPattern = matcher.group(1);
            } else {
                System.out.println("Nenhuma task digitada");
                menu();
            }

            try {
                if (!response.contains(command)) {
                    System.out.println("Isso não é um comando Task-CLI digite 'task -help' para mais informações");
                    menu();
                }
                if (response.equals(command.concat(" ").concat(help))) {
                    commandList.help();
                    menu();
                }
                if (response.equals(command.concat(" ").concat(add).concat(" ").concat("\""+taskPattern +"\"" ))) {
                        Task taskBuilder = new Task.TaskBuilder()
                                .id()
                                .description(taskPattern)
                                .createdAt(OffsetDateTime.now())
                                .build();
                        System.out.println("Criado id: " +  taskBuilder.getId() + " a task: " + taskPattern + " " + taskBuilder.toString() );


                }
            } catch (Exception e) {
                throw new RuntimeException("Erro ao executar comando");
            }

        }
    }
}