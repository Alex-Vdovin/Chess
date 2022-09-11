public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }


    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if ((chessBoard.board[toLine][toColumn] == null || (!chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayerColor()))) && Math.abs(toLine - line) == Math.abs(toColumn - column)) {
                if (toLine > line && toColumn > column) {
                    int count = Math.abs(toLine - line) - 1;
                    line++;
                    column++;
                    for (int i = count; i > 0; i--) {
                        if (chessBoard.board[line][column] != null) {
                            return false;
                        } else {
                            count--;
                            line++;
                            column++;
                        }
                    }
                    return true;
                }
                if (toLine > line && toColumn < column) {
                    int count = Math.abs(toLine - line) - 1;
                    line++;
                    column--;
                    for (int i = count; i > 0; i--) {
                        if (chessBoard.board[line][column] != null) {
                            return false;
                        } else {
                            count--;
                            line++;
                            column--;
                        }
                    }
                    return true;
                }
                if (toLine < line && toColumn > column) {
                    int count = Math.abs(toLine - line) - 1;
                    line--;
                    column++;
                    for (int i = count; i > 0; i--) {
                        if (chessBoard.board[line][column] != null) {
                            return false;
                        } else {
                            count--;
                            line--;
                            column++;
                        }
                    }
                    return true;
                }
                if (toLine < line && toColumn < column) {
                    int count = Math.abs(toLine - line) - 1;
                    line--;
                    column--;
                    for (int i = count; i > 0; i--) {
                        if (chessBoard.board[line][column] != null) {
                            return false;
                        } else {
                            count--;
                            line--;
                            column--;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public String getSymbol() {
        return "B";
    }
}

