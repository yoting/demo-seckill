import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by GUSI on 2017/4/13.
 */
public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        System.out.println("hello");
        logger.info("world!");
    }
}
