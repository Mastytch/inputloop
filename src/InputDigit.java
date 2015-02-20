/**
 * Created by mastytch and Azazavr on 20.02.2015.
 */
import java.util.Scanner;

public class InputDigit {
    static int goal;
    static int guess;
    static Scanner keyboard = new Scanner(System.in);
    static Scanner newGame = new Scanner(System.in);
    static Scanner getPlayerName = new Scanner(System.in);
    static Player p1 = new Player();


    public static void main(String[] args) {

        System.out.print("Привет, давай познакомимся. Меня зовут Мегамозг! А тебя? (Введите свое имя): ");
        p1.setName(getPlayerName.nextLine());
        playGame();
    }




    public static void playGame() {
        goal = (int) (Math.random() * 99 + 1);
        int numberOfTries = 8;

        System.out.printf("%s, я загадал число от 1 до 100. Попробуй-ка его угадать. Осторожно, попыток всего %d!\n", p1.getName(), numberOfTries);
        //System.out.println("Компьютер загадал: " + goal);//Строка для дебага. Потом убрать

        do {
            System.out.println("Введите число: ");
            guess = keyboard.nextInt();
            //System.out.println("Вы ввели: " + guess); //Строка для дебага. Потом убрать
            if (guess == goal) {
                System.out.printf("Поздравляю, %s! Вы угадали! Количество оставшихся попыток: %d.\n", p1.getName(), numberOfTries);
                System.out.println("Хотите попробовать еще раз? Введите 1, если ДА и 0, если НЕТ");
                int ng = newGame.nextInt();
                if (ng == 1) {
                    playGame();
                } else {
                    break;
                }
            } else if (guess > goal && numberOfTries > 0) {
                --numberOfTries;
                System.out.println("Введенное число больше загаданного. Осталось попыток: " + numberOfTries);
            } else if (guess < goal && numberOfTries > 0) {
                --numberOfTries;
                System.out.println("Введенное число меньше загаданного. Осталось попыток: " + numberOfTries);
            } else if (numberOfTries == 0) {
                System.out.printf("ХАХАХА, Мегамозг победил! %s, вы проиграли!\n", p1.getName());
                System.out.println("Хотите попробовать еще раз? Введите 1, если ДА и 0, если НЕТ");
                int ng = newGame.nextInt();
                if (ng == 1) {
                    playGame();
                } else {
                    break;
                }
            }
        }while (guess != goal) ;
    }
}
