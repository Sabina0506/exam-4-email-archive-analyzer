import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Massagetask implements Runnable{

        private static final Logger logger = Logger.getLogger(Massagetask.class.getName());
        static {
            try {
                FileHandler handler = new FileHandler("src/filles/e-mail_analysis_report.txt",1024 * 1024, 4, true);
                handler.setLevel(Level.ALL);
                logger.addHandler(handler);
            } catch (IOException e) {
                logger.severe(e.getMessage());
            }
        }

        private final Massages massages;



        public Massagetask(Massages massages) {
            this.massages = massages;
        }

        @Override
        public void run() {
            logger.info(massages.getVaqt()+"\t"+massages.getYuboruvchoi()+"\t"+massages.getOluvchi()+"\t"+massages.getMavzu()+"\n");
        }
    }



