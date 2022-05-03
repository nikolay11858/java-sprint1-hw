import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();

            System.out.println("Какое действие вы хотите сделать?");
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("За какой месяц вы хотите записать показания?");
                int month = scanner.nextInt();
                System.out.println("За какой день вы хотите записать показания?");
                int day = scanner.nextInt();
                System.out.println("Какое количество шагов было пройдено?");
                int countStep = scanner.nextInt();
                stepTracker.saveCountStep(month, day, countStep);
            } else if (command == 2) {
                System.out.println("За какой месяц вы хотите получить статистику?");
                int month = scanner.nextInt();
                stepTracker.showStaticPerMonth(month);
            } else if (command == 3) {
                System.out.println("Какое количество шагов вы хотите поставить своей целью?");
                int goalSteps = scanner.nextInt();
                stepTracker.saveGoalSteps(goalSteps);
            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Вы выбрали несуществующее действие. Повторите выбор.");
            }
        }


    }

    static void printMenu() {
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}