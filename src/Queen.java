public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public boolean checkDiagonal(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
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

    public boolean checkStraight(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
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
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return checkDiagonal(chessBoard, line, column, toLine, toColumn) || checkStraight(chessBoard, line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
