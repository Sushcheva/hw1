
package academy.hangman;
import java.util.*;


public class LargeMap {
    private static final Map<Category, Map<Difficulty, List<String>>> words = new EnumMap<>(Category.class);

    static {
        Map<Difficulty, List<String>> animals = new EnumMap<>(Difficulty.class);
        animals.put(Difficulty.EASY, List.of("киса", "песик", "рыбка", "птичка"));
        animals.put(Difficulty.MEDIUM, List.of("мурена", "тетерев", "песец", "бурундук", "кенгуру"));
        animals.put(Difficulty.HARD, List.of("хамелеон", "муравьед", "колибри", "утконос", "опоссум"));
        words.put(Category.ANIMALS, animals);
        Map<Difficulty, List<String>> family = new EnumMap<>(Difficulty.class);
        family.put(Difficulty.EASY, List.of("мама", "папа", "сын", "дочь", "брат"));
        family.put(Difficulty.MEDIUM, List.of("бабушка", "дедушка", "внучка", "племянник", "свекровь"));
        family.put(Difficulty.HARD, List.of("прабабушка", "кузина", "крестница", "невестка", "теща"));
        words.put(Category.FAMILY, family);
        Map<Difficulty, List<String>> countries = new EnumMap<>(Difficulty.class);
        countries.put(Difficulty.EASY, List.of("россия", "китай", "индия", "япония", "египет"));
        countries.put(Difficulty.MEDIUM, List.of("аргентина", "индонезия", "марокко", "вьетнам", "колумбия"));
        countries.put(Difficulty.HARD, List.of("мавритания", "кыргызстан", "тринидад", "мадагаскар", "сейшелы"));
        words.put(Category.COUNTRIES, countries);
        Map<Difficulty, List<String>> food = new EnumMap<>(Difficulty.class);
        food.put(Difficulty.EASY, List.of("суп", "хлеб", "сыр", "мясо", "рис"));
        food.put(Difficulty.MEDIUM, List.of("оладьи", "пельмени", "салат", "варенье", "мороженое"));
        food.put(Difficulty.HARD, List.of("эклер", "цезарь", "гуляш", "бранч", "фондю"));
        words.put(Category.FOOD, food);
        Map<Difficulty, List<String>> jobs = new EnumMap<>(Difficulty.class);
        jobs.put(Difficulty.EASY, List.of("врач", "учитель", "повар", "водитель", "продавец"));
        jobs.put(Difficulty.MEDIUM, List.of("архитектор", "инженер", "бухгалтер", "журналист", "библиотекарь"));
        jobs.put(Difficulty.HARD, List.of("ветеринар", "криптограф", "ихтиолог", "археолог", "визажист"));
        words.put(Category.JOBS, jobs);

    }
    public static <T extends Enum<?>> T random(T[] values) {
        Random random = new Random();
        return values[random.nextInt(values.length)];
    }

    public static String getRandomWord(Category category, Difficulty difficulty) {
        List<String> wordList = words.get(category).get(difficulty);
        return wordList.get(new Random().nextInt(wordList.size()));
    }
    public static Category getRandomCategory(){
        return random(Category.values());
    }
    public static Difficulty getRandomDifficulty(){
        return random(Difficulty.values());
    }
}
