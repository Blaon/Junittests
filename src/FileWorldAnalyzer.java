import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWorldAnalyzer {
    private FilePartReader readedFilePart;

    public FileWorldAnalyzer(FilePartReader readedFilePart) {
        this.readedFilePart = readedFilePart;
    }

    public List getWordsOrderedAlphabetically() {
        List<String> orderedWords = Arrays.asList(readedFilePart.readLines().split(" "));
        Collections.sort(orderedWords);
        return orderedWords;
    }

    public List getWordsContainingSubsring(String substring) {
        List<String> readedWords = Arrays.asList(readedFilePart.readLines().split(" "));
        List<String> choosenWords = new ArrayList<>();
        for (String word : readedWords) {
            if (word.contains(substring)) {
                choosenWords.add(word);
            }
        }
        return choosenWords;
    }

    public List getStringsWhichPalindromes() {
        List<String> readedWords = Arrays.asList(readedFilePart.readLines().split(" "));
        List<String> palindromes = new ArrayList<>();
        for (String word : readedWords) {
            if (isItPalidrome(word)) {
                palindromes.add(word);
            }
        }
        return palindromes;
    }

    public boolean isItPalidrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}