public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) && chessBoard.board[line][column] != null) {
            if (chessBoard.board[line][column].getColor().equals("White")) {
                if (toColumn == column && chessBoard.board[toLine][toColumn] == null && toLine > line && toLine == line + 1) {
                    return true;
                } else if (line == 1 && toColumn == column && chessBoard.board[toLine - 1][toColumn] == null && chessBoard.board[toLine][toColumn] == null && (toLine == line + 1 || toLine == line + 2)) {
                    return true;
                } else
                    return toLine == line + 1 && (toColumn == column + 1 || toColumn == column - 1) && chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals("Black");
            } else if (chessBoard.board[line][column].getColor().equals("Black")) {
                if (toColumn == column && chessBoard.board[toLine][toColumn] == null && toLine < line && toLine == line - 1) {
                    return true;
                } else if (line == 6 && toColumn == column && chessBoard.board[toLine + 1][toColumn] == null && chessBoard.board[toLine][toColumn] == null && (toLine == line - 1 || toLine == line - 2)) {
                    return true;
                } else
                    return toLine == line - 1 && (toColumn == column + 1 || toColumn == column - 1) && chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals("White");
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}

