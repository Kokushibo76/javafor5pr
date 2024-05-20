import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.util.logging.*;
public class Log{
    public Logger logger;
    FileHandler fileHandler;
    public Log(String file_name) throws SecurityException, IOException{
        File file = new File(file_name);
        fileHandler = new FileHandler(file_name, true);
        logger = Logger.getLogger(file_name);
        logger.addHandler(fileHandler);
        logger.setLevel(Level.WARNING);
        SimpleFormatter formatter = new SimpleFormatter(){
            //SimpleFormatter formatter = new SimpleFormatter();

            //[%1$tF %1$tT] - YYYY-MM-DD HH:MM:SS
            //[%2$-7s] - представляет строку в 7 символов с выравниванием по левому краю
            //%3$s - вывод аргумента как строку
            //%1, %2, %3 ... - номер аргумента

            //%x - element
            //[%1$tF %1$tT] -  YYYY-MM-DD HH:MM:SS
            //[%2$-7s] - до 7 символов
            //%n - переход на след. строку
            public static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";
            @Override
            public synchronized String format(LogRecord lr){
                return String.format(format,
                        new Date(lr.getMillis()),
                        lr.getLevel().getName(),
                        lr.getMessage());
            }
        };
        fileHandler.setFormatter(formatter);//вызываем метод из файла и передаем значение
    }
}
