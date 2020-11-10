package pieces;
import ChessGUI.Board;
/* Pawn.java
 * By: Faun Schutz
 * Start: 10/11/2020
 * Finish:
 */
public class Pawn extends Piece{
    private boolean has_moved;

    public Pawn(int x, int y, boolean is_white, String file_path, Board board){
        super(x, y, is_white, file_path, board);
    }

    public void setHas_moved(boolean has_moved) {
        this.has_moved = has_moved;
    }

    public boolean getHas_moved(){
        return has_moved;
    }

    public boolean canMove(int destination_x, int destination_y){
        // rules to be written here.
        // reminder if pawn has not moved yet, it can move two spaces forward. Otherwise, it only moves one space.
        // When not attacking it can only move forward.
        // When attacking it can only move diagonally forward.

        return true;
    }
}
