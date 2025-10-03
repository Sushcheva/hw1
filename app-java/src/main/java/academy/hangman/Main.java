package academy.hangman;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        if (args.length == 2) {
            basicMode(args[1],args[2]);

        }else{
            interactiveMode();
        }
    }
    public static void basicMode(String hidden, String guessed){
        StringBuilder sb = new StringBuilder();
        int n = hidden.length();
        Result res = new Result(n);
        boolean flag;
        for(int i = 0;i< n; i++){
            flag = hidden.charAt(i) == guessed.charAt(i);
            sb.append(flag ? hidden.charAt(i) : "*");
            if(!flag){
                res.updateResult();
            }

        }
        sb.append(";");
        System.out.print(sb);
        System.out.println(res.curStage==7 ?"NEG":"POS");
    }

    private static void interactiveMode() {
        System.out.println("Добро пожаловать в игру 'Виселица'!");
        WordSelector selector = WordSelector.builder();
        System.out.println("Выберите игрока: вы будете играть сами(введите 1) или хотите понаблюдать за игрокой бота-рандомного игрока(введите любую цифру)");
        int mod = in.nextInt();
        Player player = new RandomPlayer();
        if (mod == 1){
            player = new HumanPlayer();
        }
        System.out.println("Выберите категорию:");
        Category[] categories = Category.values();
        for (int i = 0; i < categories.length; i++) {
            System.out.printf("%d. %s%n", i + 1, categories[i].getDisplayName());
        }
        System.out.printf("%d. %s%n", categories.length + 1, "Случайная категория");

        int categoryChoice = getChoice(1, categories.length + 1);
        if (categoryChoice <= categories.length) {
            selector.withCategory(categories[categoryChoice - 1]);
        } else {
            selector.withRandomCategory();
        }

        System.out.println("Выберите уровень сложности:");
        Difficulty[] difficulties = Difficulty.values();
        for (int i = 0; i < difficulties.length; i++) {
            System.out.printf("%d. %s%n", i + 1, difficulties[i].getDisplayName());
        }
        System.out.printf("%d. %s%n", difficulties.length + 1, "Случайная сложность");

        int difficultyChoice = getChoice(1, difficulties.length + 1);
        if (difficultyChoice <= difficulties.length) {
            selector.withDifficulty(difficulties[difficultyChoice - 1]);
        } else {
            selector.withRandomDifficulty();
        }
        startGame(selector, player);
    }

    private static int getChoice(int min, int max) {
        while (true) {
            try {
                System.out.printf("Ваш выбор (%d-%d): ", min, max);
                int choice = in.nextInt();
                in.nextLine();
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.printf("Пожалуйста, выберите число от %d до %d%n", min, max);
                }
            } catch (Exception e) {
                System.out.println("Пожалуйста, введите корректное число");
                in.nextLine();
            }
        }
    }

    private static void startGame(WordSelector selector, Player player) {
        String word = selector.getWord();
        System.out.println("Начинаем игру!");
        System.out.println("Слово загадано! Количество букв: " + word.length());
        Game game = new Game(word, player);
        int res;
        while(true){
            res = game.play();
            if (res == 1){
                if(game.hiddenWord.length == 0){
                    System.out.println("Вы выиграли");
                    break;
                }
            }else if(res == 0){
                if(game.result.curStage == 7){
                    System.out.println("Вы выиграли");
                    break;
                }
            }else{
                System.out.println("Переиграем раунд");
            }
        }


    }




}
