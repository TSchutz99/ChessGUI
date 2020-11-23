package pieces;
import board.Board;
/* Pawn.java
 * By: Faun Schutz
 * Start: 10/11/2020
 * Finish:
 */
public class Pawn extends Piece{
    private boolean has_moved;

    public Pawn(int x, int y, boolean is_white, String file_path, Board board){
        super(x, y, is_white, file_path, board);
        has_moved = false;
    }

    public void setHas_moved(boolean has_moved) {
        this.has_moved = has_moved;
    }

    public boolean getHas_moved(){
        return has_moved;
    }

    @Override
    public boolean canMove(int destination_x, int destination_y){
        // reminder if pawn has not moved yet, it can move two spaces forward. Otherwise, it only moves one space.
        // When not attacking it can only move forward.
        // When attacking it can only move diagonally forward.

        // This Prevents the Pawn from taking his own pieces.
        Piece possiblePiece = board.getPiece(destination_x, destination_y);
        if(possiblePiece != null) {
            if(possiblePiece.isWhite() && isWhite())
                return false;
            if(possiblePiece.isBlack() && isBlack())
                return false;
        }

        //
        if(getHas_moved() == false){
            if(isWhite() && (destination_y != getY() + 1 && destination_y != getY() + 2) || destination_x != getX()){
                return false;
            }
            else if(isBlack() && (destination_y != getY() - 1 && destination_y != getY() - 2) || destination_x != getX()){
                return false;
            }
        }
        else if(getHas_moved() == true){
            if(isWhite() && (destination_y != getY() + 1 || destination_x != getX()) ){
                return false;
            }
            else if(isBlack() && (destination_y != getY() - 1 || destination_x != getX()) ){
                return false;
            }
        }

        setHas_moved(true);
        return true;
    }
}
