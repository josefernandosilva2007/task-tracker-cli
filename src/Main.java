import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Help help = new Help();
        String command = "task";
        while(true) {
            Scanner input = new Scanner(System.in);
            String response = input.nextLine();
            try {
                if (!response.contains(command)) {
                    System.out.println("Isso não é um comando Task-CLI digite 'task -help' para mais informações");
                    menu();
                }
                if (response.equals(command.concat(" ").concat("-help"))) {
                    help.help();
                    menu();
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro ao executar comando");
            } finally {
                System.out.println("Digite 'task -help' para mais informações");
                menu();
            }

        }
    }
}