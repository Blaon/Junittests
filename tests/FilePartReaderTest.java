import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    private static FilePartReader reader = new FilePartReader();

    @BeforeAll
    public static void init() {
        reader.setup("src/resource/valami.txt",1,4);
    }

    @Test
    public void testIsSetupThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> reader.setup("/valami.txt", 1, 0));
        assertThrows(IllegalArgumentException.class, () -> reader.setup("/valami.txt", 0, 2));
    }

    @Test
    public void testIsReaderThrowsIOexception(){
        reader.setup("/gizi.txt",1,3);
        assertThrows(IOException.class,()->reader.read());

    }

    @Test
    public void testIsReaderWorking() throws IOException {
        String normalReadedString = "is it a palidrome\n" +
                "my name is otto and my wife is anna\n" +
                "Salas has a favourite number. it is 01234567899876543210\n" +
                "in this line there is no palidrom and that's a fact";
        assertEquals(normalReadedString,reader.read());
    }

    @Test
    public void testIsReadLinesreturn(){
        reader.setup("src/resource/valami.txt",1,1);
        assertEquals("is it a palidrome",reader.readLines());
        reader.setup("src/resource/valami.txt",1,3);
        assertEquals("is it a palidrome " +
                "my name is otto and my wife is anna " +
                "Salas has a favourite number. it is 01234567899876543210",reader.readLines());
        reader.setup("src/resource/valami.txt",3,5);
        assertEquals("Salas has a favourite number. it is 01234567899876543210 " +
                "in this line there is no palidrom and that's a fact",reader.readLines());

    }
}