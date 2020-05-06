import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWorldAnalyzerTest {
private FilePartReader readedFile = new FilePartReader();
private FileWorldAnalyzer analyzers = new FileWorldAnalyzer(readedFile);

    @BeforeEach
    void setUp() {
        readedFile.setup("src/resource/valami.txt",1,2);
    }

    @Test
    public void testOrderCheck(){
        List<String> checkList = Arrays.asList("a","and","anna","is","is","is","it","my","my","name","otto","palidrome","wife");
        assertEquals(checkList,analyzers.getWordsOrderedAlphabetically());
    }

    @Test
    public void testContainsSubsting(){
        List<String> checkList1 = Arrays.asList("and","anna");
        List<String> checkList2 = Arrays.asList("name","anna");
        List<String> checkList3 = Collections.emptyList();
        assertEquals(checkList1,analyzers.getWordsContainingSubsring("an"));
        assertEquals(checkList2,analyzers.getWordsContainingSubsring("na"));
        assertEquals(checkList3,analyzers.getWordsContainingSubsring("blablabalbal"));
    }

    @Test
    public void testGetSringsWhichArePolidrome(){
        List<String> checkList = Arrays.asList("a","otto","anna");
        assertEquals(checkList,analyzers.getStringsWhichPalindromes());

    }
}