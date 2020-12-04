package ChessGUI.pieces;
import ChessGUI.board.Board;
/* King.java
 * By: Faun Schutz
 * Start: 10/11/2020
 * Finish: 19/11/2020
 */
public class Queen extends Piece{
    public Queen(int x, int y, boolean is_white, String file_path, Board board){
        super(x, y, is_white, file_path, board);
    }

    @Override
    public boolean canMove(int destination_x, int destination_y){
        // Reminder Queen can move backward, sideways, or diagonally, without jumping over any ChessGUI.pieces.
        // This Prevents the Queen from taking her own ChessGUI.pieces.
        Piece possiblePiece = board.getPiece(destination_x, destination_y);
        if(possiblePiece != null) {
            if(possiblePiece.isWhite() && isWhite())
                return false;
            if(possiblePiece.isBlack() && isBlack())
                return false;
        }

        // This keeps the Queen moving in a straight or diagonal lines as this piece only can.
        if((getX() != destination_x && getY() != destination_y) && (getX() == destination_x || getY() == destination_y))
            return false;

        String direction = "";
        int distance;

        if(destination_y > getY() && destination_x == getX())
            direction = "south";
        else if(destination_y < getY() && destination_x == getX())
            direction = "north";
        else if(destination_x > getX() && destination_y == getY())
            direction = "east";
        else if(destination_x < getX() && destination_y == getY())
            direction = "west";
        else if(getX() > destination_x && getY() > destination_y)
            direction = "north-west";
        else if(getX() > destination_x && getY() < destination_y)
            direction = "south-west";
        else if(getX() < destination_x && getY() < destination_y)
            direction = "south-east";
        else if(getX() < destination_x && getY() > destination_y)
            direction = "north-east";

        if(direction.equals("south")){
            distance = Math.abs(destination_y - getY());

            for(int i = 1; i < distance; i++){
                Piece p = board.getPiece(getX(), getY() + i);

                if(p != null)
                    return false;
            }
        }
        else if(direction.equals("north")){
            distance = Math.abs(destination_y - getY());

            for(int i = 1; i < distance; i++){
                Piece p = board.getPiece(getX(), getY() - i);

                if(p != null)
                    return false;
            }
        }
        else if(direction.equals("east")){
            distance = Math.abs(destination_x - getX());

            for(int i = 1; i < distance; i++){
                Piece p = board.getPiece(getX() + i, getY());

                if(p != null)
                    return false;
            }
        }
        else if(direction.equals("west")){
            distance = Math.abs(destination_x - getX());

            for(int i = 1; i < distance; i++){
                Piece p = board.getPiece(getX() - i, getY());

                if(p != null)
                    return false;
            }
        }
        else if(direction.equals("north-west")){
            distance = Math.abs(getX() - destination_x);

            if(destination_x != getX() - distance || destination_y != getY() - distance)
                return false;

            for(int i = 1; i < distance; i++) {
                Piece p = board.getPiece(getX() - i, getY() - i);

                if(p != null)
                    return false;
            }
        }
        else if(direction.equals("south-west")){
            distance = Math.abs(getX() - destination_x);

            if(destination_x != getX() - distance || destination_y != getY() + distance)
                return false;

            for(int i = 1; i < distance; i++) {
                Piece p = board.getPiece(getX() - i, getY() + i);

                if(p != null)
                    return false;
            }
        }
        else if(direction.equals("south-east")){
            distance = Math.abs(destination_x - getX());

            if(destination_x != getX() + distance || destination_y != getY() + distance)
                return false;

            for(int i = 1; i < distance; i++) {
                Piece p = board.getPiece(getX() + i, getY() + i);

                if(p != null)
                    return false;
            }
        }
        else if(direction.equals("north-east")){
            distance = Math.abs(destination_x - getX());

            if(destination_x != getX() + distance || destination_y != getY() - distance)
                return false;

            for(int i = 1; i < distance; i++) {
                Piece p = board.getPiece(getX() + i, getY() - i);

                if(p != null)
                    return false;
            }
        }

        return true;
    }
}
