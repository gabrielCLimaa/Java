import java.util.Scanner;

public class WordGuessingGame {
    private String hiddenWord;
    private String guessedWord;
    private int numberOfTries;
    private WordGenerator generator;
    private String word;

    public WordGuessingGame() {
        this.generator = new WordGenerator();
        this.word = generator.generateWord();
        setHiddenWord(word);
        this.numberOfTries = 0;
        initializeGuessedWord();
    }

    public void play() {
        showWelcome();
        getHiddenWord();
        showGuessedWord();
        guess();
        showResult();
    }

    private void showWelcome() {
        System.out.println("Bem vindo ao jogo da palavra escondida!!!");
    }

    private void guess() {
        Scanner in = new Scanner(System.in);
        String usedWords = "";
        char[] guessedWordCharArray =  guessedWord.toCharArray();
        char guessedChar;

        while(true) {
            if(hiddenWord.equals(guessedWord))
                break;

            guessedChar = in.next().charAt(0);

            if (hiddenWord.indexOf(guessedChar) != -1 && usedWords.indexOf(guessedChar) == -1) {
                for (int i = 0; i < hiddenWord.length(); i++) {
                    if (hiddenWord.charAt(i) == guessedChar) {
                        guessedWordCharArray[i] = hiddenWord.charAt(i);
                        setGuessedWord(String.valueOf(guessedWordCharArray));
                    }
                }
            } else {
                usedWords += guessedWord;
            }
            setNumberOfTries(getNumberOfTries() + 1);
            showGuessedWord();
        }
    }

    private void showResult() {
        System.out.println("Parabens!! voce conseguio acertar a palavra escondida com "+ getNumberOfTries() + " tentativas.");
    }

    private void showGuessedWord() {

        System.out.println(getGuessedWord());
    }

    public void initializeGuessedWord() {
        int hiddenWordLenght = getHiddenWord().length();
        this.guessedWord = new String();

        for(int i = 0; i < hiddenWordLenght;i++) {
            guessedWord += '_';
        }
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public String getGuessedWord() {
        return guessedWord;
    }

    public void setGuessedWord(String guessedWord) {
        this.guessedWord = guessedWord;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }

    public void setNumberOfTries(int numberOfTries) {
        this.numberOfTries = numberOfTries;
    }
}
