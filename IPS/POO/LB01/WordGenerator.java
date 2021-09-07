import java.util.ArrayList;
import java.util.Random;
public class WordGenerator {
    ArrayList<String> words = new ArrayList<String>();

    public WordGenerator() {
        fillArrayList();
    }

    private void  fillArrayList() {
        words.add("boolean");
        words.add("break");
        words.add("byte");
        words.add("case");
        words.add("char");
        words.add("class");
        words.add("continue");
        words.add("do");
        words.add("double");
        words.add("else");
        words.add("enum");
        words.add("for");
        words.add("if");
        words.add("import");
        words.add("int");
    }

    public String generateWord() {
        Random random = new Random();
        int indice = random.nextInt(words.size());
        return words.get(indice);
    }

    public void addWord(String palavra) {
        words.add(palavra);
    }
}
