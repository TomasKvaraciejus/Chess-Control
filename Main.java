public class Main {

    public static int[][] findBoardArrangement(int[][] _board, int placedQueenCount)
    {
        int[][] board = cloneBoard(_board);
        for (int y = 0; y < 8; ++y)
        {
            for (int x = 0; x < 8; ++x)
            {
                if(board[y][x] != 2)
                {
                    int[][] _tempBoard = cloneBoard(_board);
                    placeQueen(_tempBoard, x, y);
                    ++placedQueenCount;
                    if(checkBoard(_tempBoard) == true)
                    {
                        return _tempBoard;
                    }
                    else if(placedQueenCount == 5)
                    {
                        --placedQueenCount;
                        return null;
                    }
                    int[][] _tempCheckArrangementBoard = findBoardArrangement(_tempBoard, placedQueenCount);
                    if(_tempCheckArrangementBoard != null)
                    {
                        return _tempCheckArrangementBoard;
                    }
                    --placedQueenCount;
                }
            }
        }

        return null;
    }

    public static boolean checkBoard(int[][] _board)
    {
        for (int y = 0; y < 8; ++y)
        {
            for (int x = 0; x < 8; ++x)
            {
                if(_board[y][x] == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void placeQueen(int[][] _board, int posX, int posY)
    {
        _board[posY][posX] = 2;

        int endFlag = 0;
        int x = 0, y = 0;
        while(endFlag != 8)
        {
            endFlag = 8;
            if((posX + x) < 8 && (posX + x) >= 0 && (posY + y) < 8 && (posY + y) >= 0)
            {
                if(_board[posY + y][posX + x] != 2)
                {
                    _board[posY + y][posX + x] = 1;
                }
                --endFlag;
            }
            if((posX - x) < 8 && (posX - x) >= 0 && (posY + y) < 8 && (posY + y) >= 0)
            {
                if(_board[posY + y][posX - x] != 2)
                {
                    _board[posY + y][posX - x] = 1;
                }
                --endFlag;
            }
            if((posX + x) < 8 && (posX + x) >= 0 && (posY - y) < 8 && (posY - y) >= 0)
            {
                if(_board[posY - y][posX + x] != 2)
                {
                    _board[posY - y][posX + x] = 1;
                }
                --endFlag;
            }
            if((posX - x) < 8 && (posX - x) >= 0 && (posY - y) < 8 && (posY - y) >= 0)
            {
                if(_board[posY - y][posX - x] != 2)
                {
                    _board[posY - y][posX - x] = 1;
                }
                --endFlag;
            }
            if((posX + x) < 8 && (posX + x) >= 0)
            {
                if(_board[posY][posX + x] != 2)
                {
                    _board[posY][posX + x] = 1;
                }
                --endFlag;
            }
            if((posX - x) < 8 && (posX - x) >= 0)
            {
                if(_board[posY][posX - x] != 2)
                {
                    _board[posY][posX - x] = 1;
                }
                --endFlag;
            }
            if((posY + y) < 8 && (posY + y) >= 0)
            {
                if(_board[posY + y][posX] != 2)
                {
                    _board[posY + y][posX] = 1;
                }
                --endFlag;
            }
            if((posY - y) < 8 && (posY - y) >= 0)
            {
                if(_board[posY - y][posX] != 2)
                {
                    _board[posY - y][posX] = 1;
                }
                --endFlag;
            }
            ++x;
            ++y;
        }
    }

    public static int[][] cloneBoard(int[][] _board)
    {
        int[][] board = new int[8][8];
        for (int y = 0; y < 8; ++y)
        {
            for (int x = 0; x < 8; ++x)
            {
                board[y][x] = _board[y][x];
            }
        }

        return board;
    }

    public static void debug_drawBoard(int[][] _board)
    {
        for (int y = 0; y < 8; ++y)
        {
            for (int x = 0; x < 8; ++x)
            {
                System.out.print(_board[y][x] + " ");
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args)
    {
        int[][] board = new int[8][8];

        debug_drawBoard(board);

        board = findBoardArrangement(board, 0);
        debug_drawBoard(board);
    }
}
