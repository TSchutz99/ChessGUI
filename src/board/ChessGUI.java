package board;

import javax.swing.*;

/* board.ChessGUI.java
 * By: Faun Schutz
 * Start: 09/11/2020
 * Finish:
 *
 *
 */
public class ChessGUI {
    public BoardFrame boardFrame;
    public static String white_player, black_player;
    public static void main(String[] args){

        white_player = JOptionPane.showInputDialog("Who is playing white?");
        black_player = JOptionPane.showInputDialog("Who is playing black?");

        ChessGUI gui = new ChessGUI();
        gui.boardFrame = new BoardFrame();
        gui.boardFrame.setVisible(true);
    }
}
