import java.util.Scanner;

public class Game {

    public static Character manager;

    public static boolean isEnd = false;

    public static int variant;
    public static Story story;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        manager = new Character();
        story = new Story();

        System.out.println("=====\nЗдоровье:" + manager.H + "\tЖажда:" + manager.T + "%" + "\tЧеловечность:" + manager.Hu + "%" + "\n=====");

        for (int i = 0; i < 4; i++) {
            if (isEnd == true)
                break;

            System.out.println(story.situations[i].text);

            while (true) {
                variant = in.nextInt();
                if (variant > story.situations[i].variants || variant <= 0){
                    System.out.println("Вы можете выбирать из " + story.situations[i].variants + " вариантов");
                    continue;
                }

                manager.H += story.situations[i].direction[variant - 1].dH;
                manager.T += story.situations[i].direction[variant - 1].dT;
                manager.Hu += story.situations[i].direction[variant - 1].dHu;
                System.out.println("=====\nЗдоровье:" + manager.H + "\tЖажда:" + manager.T + "%" + "\tЧеловечность:" + manager.Hu + "%" + "\n=====");
                System.out.println(story.situations[i].direction[variant - 1].text);

                if (manager.H <= 0) {
                    System.out.print("Вы погибли. Конец.");
                    isEnd = true;
                }
                break;
            }
        }
    }
}