import java.util.Scanner;

public class SubwayGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int score = 0;

        while (true) {

            int obstacle = (int)(Math.random() * 3) + 1;

            System.out.println("\nObstacle:");

            switch (obstacle) {
                case 1:
                    System.out.println("Barrier");
                    break;
                case 2:
                    System.out.println("Tunnel");
                    break;
                case 3:
                    System.out.println("Train");
                    break;
            }

            System.out.println("1.Run 2.Jump 3.Slide 4.Left 5.Right 0.Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.println("Run");
                    break;

                case 2:
                    System.out.println("Jump");
                    break;

                case 3:
                    System.out.println("Slide");
                    break;

                case 4:
                    System.out.println("Left");
                    break;

                case 5:
                    System.out.println("Right");
                    break;

                case 0:
                    System.out.println("Game Over. Score: " + score);
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid");
                    continue;
            }

            // Check correct move
            if ((obstacle == 1 && ch == 2) ||
                (obstacle == 2 && ch == 3) ||
                (obstacle == 3 && (ch == 4 || ch == 5))) {

                score++;
                System.out.println("Correct! Score: " + score);
            } else {
                System.out.println("Wrong move! Game Over");
                System.out.println("Final Score: " + score);
                break;
            }

            if (score == 5) {
                System.out.println("You Win!");
                break;
            }
        }

        sc.close();
    }
}
