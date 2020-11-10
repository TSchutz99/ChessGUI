package pieces;

public class King extends Piece{
    public King(int x, int y, boolean is_white, String file_path, Board board){
        super(x, y, is_white, file_path, board);
    }

    public boolean canMove(int destination_x, int destination_y){
        // rules to be written.

        return true;
    }
}
