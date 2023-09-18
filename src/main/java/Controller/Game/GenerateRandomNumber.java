package Controller.Game;

import java.util.Random;

public class GenerateRandomNumber {

    private static GenerateRandomNumber randomNumber;

    private GenerateRandomNumber() {

    }

    public int generateNumber(int bound) {
        Random random = new Random();
        return random.nextInt(11);
    }

    public static synchronized GenerateRandomNumber getRandomNumber() {
        if (randomNumber == null) {
            randomNumber = new GenerateRandomNumber();
        }
        return randomNumber;
    }

}
