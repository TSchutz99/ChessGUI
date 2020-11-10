/* ChessGUI.java
 * By: Faun Schutz
 * Start: 09/11/2020
 * Finish:
 *
 *
 */
public class ChessGUI {
    public BoardFrame boardFrame;
    public static void main(String[] args){
        ChessGUI gui = new ChessGUI();
        gui.boardFrame = new BoardFrame();
        gui.boardFrame.setVisible(true);
    }
}
