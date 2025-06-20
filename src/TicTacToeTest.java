import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.JButton;
import java.awt.event.ActionEvent;


public class TicTacToeTest {


    private TicTacToe game;

    //before you read this very short code i did not wrote tests for checking whether the interactive game elements are making valid moves,
    // whether the game mechanics work according to the rules. After some search i figured these tests might be possible via mockito

    @BeforeEach
    void setUp() {
        game = new TicTacToe("Obi-Wan Kenobi", "Anakin Skywalker");
    }

    @Test
    void testBoardInitializationcheck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals("", game.buttons[i][j].getText(),
                        "buttons msut be empty in the beggining.");
            }
        }
    }
}
