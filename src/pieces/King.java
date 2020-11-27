package pieces;
import board.Board;
/* King.java
 * By: Faun Schutz
 * Start: 10/11/2020
 * Finish: 27/11/2020
 */
public class King extends Piece{
    public King(int x, int y, boolean is_white, String file_path, Board board){
        super(x, y, is_white, file_path, board);
    }

    @Override
    public boolean canMove(int destination_x, int destination_y){
        // reminder can move one square in any direction
        // and can not put himself in danger.
        // This Prevents the King from taking his own pieces.
        Piece possiblePiece = board.getPiece(destination_x, destination_y);
        if(possiblePiece != null) {
            if(possiblePiece.isWhite() && isWhite())
                return false;
            if(possiblePiece.isBlack() && isBlack())
                return false;
        }

        // This keeps the king move only one space and from putting himself in check

        /* Previous Code
        if(destination_x != getX() && destination_x != getX() - 1 && destination_x != getX() + 1 ||
           destination_y != getY() && destination_y != getX() - 1 && destination_y != getY() + 1)
            return false;*/

        /*****************************************************
         *    Code from lecturer
         *    Title:   King.java, lines 45-50
         *    Author: John Brosnan
         *    Site owner/sponsor:  NA
         *    Date: 27/11/2020
         *    Code version:  NA
         *    Availability:  NA
         *
         *    Modified:  Code refactored (logic altered)
         *****************************************************/

        //code
        //System.out.println("current x: " + getX() + "  current y: " + getY());
        //System.out.println("destination x: " + destination_x + "  destination y: " + destination_y);

        if(Math.abs(destination_x - getX()) > 1 || Math.abs(destination_y - getY()) > 1){ //End of [non-original or refactored] code
            if(isWhite())
                for(Piece p : board.getBlack_Pieces()){
                    if(p.canMove(destination_x, destination_y))
                        return false;
                }
            else if(isBlack())
                for(Piece p : board.getWhite_Pieces()){
                    if(p.canMove(destination_x, destination_y))
                        return false;
                }
        }

        return true;
    }
}
