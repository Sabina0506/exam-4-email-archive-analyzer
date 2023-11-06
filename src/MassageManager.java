import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MassageManager {
    private static final Logger logger = Logger.getLogger(MassageManager.class.getName());

    private static final Pattern PATTERN_VAQT = Pattern.compile("[[0-9]{4}-[0-9]{2}-[0-9]{2}\\s[0-9]{2}:[0-9]{2}:[0-9]{2}]");
    private static final Pattern PATTERN_YUBORUVCHI = Pattern.compile("[.+]");
    private static final Pattern PATTERN_OLUVCHI = Pattern.compile("[.+@.+]");
    private static final Pattern PATTERN_MAVZU = Pattern.compile("[.+]");
    public List<Massages> getMassagesFromFile(String filePath) {
        final List<Massages> massages = new ArrayList<>();
        try {
            final BufferedReader bf = new BufferedReader(new FileReader("src/filles/emails.txt"));
            String line;
            while ((line = bf.readLine()) != null) {
                massages.add(createMassagesFromContext(line));
            }
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }
        return massages;
    }

    private Massages createMassagesFromContext(String line) {
        return new Massages(
        parseMavzu(line),
        parseOluvchi(line),
        parseYuboruvchi(line),
        parseDateTime(line)
        );

    }
    private String parseDateTime(String time) {
        Matcher matcher = PATTERN_VAQT.matcher(time);
        if (matcher.find()) {
            //2023-11-03 10:00:00 Event: Meeting with Team
            return matcher.group();
        }
        return null;
    }

    private String parseYuboruvchi(String line) {
        final Matcher matcher = PATTERN_YUBORUVCHI.matcher(line);
        if (matcher.find()){
            return matcher.group();
        }
        return null;
    }
    private String parseOluvchi(String line) {
        final Matcher matcher = PATTERN_OLUVCHI.matcher(line);
        if (matcher.find()){
            return matcher.group();
        }
        return null;
    }
    private String parseMavzu(String line) {
        final Matcher matcher = PATTERN_MAVZU.matcher(line);
        if (matcher.find()){
            return matcher.group();
        }
        return null;
    }
}
