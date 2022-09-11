public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) &&
                (chessBoard.board[toLine][toColumn] == null || (!chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayerColor())))) {
            if (toLine == line && toColumn != column) {
                int count = Math.abs(toColumn - column) - 1;
                if (toColumn > column) {
                    column++;
                    for (int i = count; i > 0; i--) {
                        if (chessBoard.board[line][column] != null) {
                            return false;
                        } else {
                            column++;
                        }
                    }
                } else {
                    column--;
                    for (int i = count; i > 0; i--) {
                        if (chessBoard.board[line][column] != null) {
                            return false;
                        } else {
                            column--;
                        }
                    }
                }
                return true;

            } else if (toLine != line && toColumn == column) {
                int count = Math.abs(toLine - line) - 1;
                if (toLine > line) {
                    line++;
                    for (int i = count; i > 0; i--) {
                        if (chessBoard.board[line][column] != null) {
                            return false;
                        } else {
                            line++;
                        }
                    }
                } else {
                    line--;
                    for (int i = count; i > 0; i--) {
                        if (chessBoard.board[line][column] != null) {
                            return false;
                        } else {
                            line--;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

}

