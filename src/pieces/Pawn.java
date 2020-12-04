package pieces;
import board.Board;
/* Pawn.java
 * By: Faun Schutz
 * Start: 10/11/2020
 * Finish: 24/11/2020
 */
/**
 * An instantiable class which defines a Pawn Piece. This extends the Piece class.
 * @author Faun Schutz
 */
public class Pawn extends Piece{
    private boolean has_moved;
    //private boolean can_promote;

    /**
     * Pawn 5-argument constructor. Calls the super class constructors and the has_moved is set
     * to false, initialise the attributes of the Pawn object with some set values supplied in
     * the board class.
     * @param x the x coordinate of the Pawn
     * @param y the y coordinate of the Pawn
     * @param is_white the set for if Pawn is white or black
     * @param file_path the file path for the Pawn image
     * @param board the board that the Pawn is set on
     */
    public Pawn(int x, int y, boolean is_white, String file_path, Board board){
        super(x, y, is_white, file_path, board);
        has_moved = false;
        //can_promote = false;
    }

    /**
     * Method to set the has_Moved object of the Pawn class
     * @param has_moved the set for if the Pawn has moved
     */
    public void setHas_moved(boolean has_moved) {
        this.has_moved = has_moved;
    }

    /**
     * Method to get the has_moved value of a Pawn
     * @return a boolean value specifying if the Pawn has moved
     */
    public boolean getHas_moved(){
        return has_moved;
    }

    /**
     * Method to get the possibility if a Pawn can move to a specified destination
     * @return a boolean value specifying if Pawn can move
     */
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

        // The following controls the pawns movements and ensure that it can take piece properly
        if(getHas_moved() == false){
            if(isWhite() && (destination_y == getY() + 1 || destination_y == getY() + 2) && destination_x == getX()){
                return true;
            }
            if(isWhite() && (destination_x == getX() - 1 || destination_x == getX() + 1) && destination_y == getY() + 1 && possiblePiece != null) {//setHas_moved(true);
                return true;
            }
            else if(isBlack() && (destination_y == getY() - 1 || destination_y == getY() - 2) && destination_x == getX()){
                return true;
            }
            if(isBlack() && (destination_x == getX() - 1 || destination_x == getX() + 1) && destination_y == getY() - 1 && possiblePiece != null) {
                return true;
            }
        }
        else if(getHas_moved() == true){
            if(isWhite() && (destination_y == getY() + 1 && destination_x == getX())){
                return true;
            }
            if(isWhite() && (destination_x == getX() - 1 || destination_x == getX() + 1) && destination_y == getY() + 1 && possiblePiece != null) {
                return true;
            }
            else if(isBlack() && (destination_y == getY() - 1 && destination_x == getX()) ){
                return true;
            }
            if(isBlack() && (destination_x == getX() - 1 || destination_x == getX() + 1) && destination_y == getY() - 1 && possiblePiece != null) {
                return true;
            }
        }

        return false;
    }
}
