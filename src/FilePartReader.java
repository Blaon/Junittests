import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;


    public FilePartReader() {
        this.filePath = "/mother";
        this.fromLine = 0;
        this.toLine = 0;
    }


    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException("From line cannot be smaller than 1 and toline cannot be smaller than fromline");
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        StringBuilder readedfile = new StringBuilder();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                readedfile.append(line).append("\n");
                line = reader.readLine();
            }
        } catch (IOException exception) {
            throw new IOException("Cant reach file. Invalid file path");
        }
        String result = readedfile.toString();
        result = result.trim();
        return result;
    }

    public String readLines() {
        StringBuilder readedLines = new StringBuilder();
        String[] readedFileAsLines={};
        try {
            readedFileAsLines = read().split("\n");
        }
        catch (Exception ignore){}

        if(toLine>readedFileAsLines.length){
            toLine=readedFileAsLines.length;
        }

        for (int i = fromLine - 1; i <= toLine - 1; i++) {
            readedLines.append(readedFileAsLines[i]).append(" ");

        }
        String result = readedLines.toString();
        result = result.trim();
        return result;
    }
}