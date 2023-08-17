import com.syaprojects.adventuretextquest.service.GameLogic;
import com.syaprojects.adventuretextquest.service.Parameter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLogicTest {
    @Test
    public void connectToFileText(){
        Parameter parameter= GameLogic.connectToFile(1, "\"data/images/\" + 1 + \".png\"");
        assertEquals(parameter.getText(), "Тестовое сообщение");
    }
}
