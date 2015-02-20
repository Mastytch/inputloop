
import java.util.Scanner;

/**
 * Created by mastytch on 20.02.2015.
 */
public class InputDigit {
    static int goal;
    static int guess;
    static int numberOfTries = 1;
    static Scanner keyboard = new Scanner(System.in);
    static Scanner newgame = new Scanner(System.in);
    public static void main(String[] args) {
        playGame();
        }
        public static void playGame(){
        goal = (int) (Math.random() * 99 + 1);

        System.out.println("Компьютер загадал: " + goal);//Строка для дебага. Потом убрать

        do {
            System.out.println("Введите число от 1 до 100: ");
            guess = keyboard.nextInt();
            //System.out.println("Вы ввели: " + guess); //Строка для дебага. Потом убрать
            if (guess == goal) {
                System.out.printf("Поздравляем! Вы угадали c %d попытки!\n", numberOfTries);
                System.out.println("Хотите попробовать еще раз? Введите 1, если ДА и 0, если НЕТ");
                int ng = newgame.nextInt();
                if(ng == 1){
                    playGame();
                }else{
                    break;
                }
            } else if (guess > goal) {
                numberOfTries++;
                System.out.println("Введенное число больше загаданного.");
            } else if (guess < goal) {
                numberOfTries++;
                System.out.println("Введенное число меньше загаданного.");
            }
        }while (guess != goal);
    }
}
