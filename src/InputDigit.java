import java.util.Scanner;

/**
 * Created by mastytch on 20.02.2015.
 */
public class InputDigit {
    static int goal;
    static int guess;
    static Scanner keyboard = new Scanner(System.in);
    static Scanner newGame = new Scanner(System.in);
    static Scanner getPlayerName = new Scanner(System.in);

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        goal = (int) (Math.random() * 99 + 1);
        int numberOfTries = 8;
        System.out.println("Привет, давай познакомимся. Меня зовут Мегамозг! А тебя? (Введите свое имя): ");
        String playerName = getPlayerName.next();
        System.out.printf("Уважаемый(-ая) %s, я загадал число от 1 до 100. Попробуй-ка его угадать. Но будь осторожен, количество попыток ограничего, всего %d!\n", playerName, numberOfTries);
        //System.out.println("Компьютер загадал: " + goal);//Строка для дебага. Потом убрать

        do {
            System.out.println("Введите число: ");
            guess = keyboard.nextInt();
            //System.out.println("Вы ввели: " + guess); //Строка для дебага. Потом убрать
            if (guess == goal) {
                System.out.printf("Поздравляем, %s! Вы угадали! Количество оставшихся попыток: %d.\n", playerName, numberOfTries);
                System.out.println("Хотите попробовать еще раз? Введите 1, если ДА и 0, если НЕТ");
                int ng = newGame.nextInt();
                if (ng == 1) {
                    playGame();
                } else {
                    numberOfTries = 0;
                    break;
                }
            } else if (guess > goal && numberOfTries > 0) {
                --numberOfTries;
                System.out.println("Введенное число больше загаданного. Осталось попыток: " + numberOfTries);
            } else if (guess < goal && numberOfTries > 0) {
                --numberOfTries;
                System.out.println("Введенное число меньше загаданного. Осталось попыток: " + numberOfTries);
            } else if (numberOfTries == 0) {
                System.out.printf("К сожалению, %s, вы проиграли!\n", playerName);
                System.out.println("Хотите попробовать еще раз? Введите 1, если ДА и 0, если НЕТ");
                int ng = newGame.nextInt();
                if (ng == 1) {
                    playGame();
                } else {
                    numberOfTries = 0;
                    break;
                }
            }
        }while (numberOfTries > 0|| guess != goal) ;
    }
}
