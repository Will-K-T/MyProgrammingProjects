from math import *


class Board:

    def __init__(self, start):
        # Opens the file that is storing the sudoku puzzle
        file = open("Board.txt", "r")
        file.readline()

        # Sets the code up to do the next puzzle in the file
        for clear_line in range(start):
            file.readline()

        # Creates an empty 2D list to represent the sudoku puzzle
        self.board = [[0]*9 for y in range(9)]

        # Reads through the file and sets up the board 2D list
        if file.readable():
            for row in range(9):
                line = file.readline()
                for col in range(9):
                    self.board[row][col] = int(line[col])

    def print_board(self):
        """
        Prints the board in a way that is easy to view
        :return:
        """
        for row in self.board:
            print(row)

    def find_next_empty_node(self, cords):
        """
        Finds the next unsolved square in the sudoku board starting at (row, col)
        :param cords: Tuple that stores the current (row, col)
        :return: Tuple that stores (row, col) of the next unsolved square
        """
        for row in range(cords[0], 9):
            for col in range(9):
                if self.board[row][col] == 0:
                    if row == cords[0]:
                        if col > cords[1]:
                            return row, col
                    else:
                        return row, col

    def has_next_emtpy_node(self, cords):
        """
        Checks to see if there is any unsolved squares left starting at (row, col)
        :param cords: Tuple that stores the current (row, col)
        :return: a boolean that represents if there is any unsolved squares left
        """
        for row in range(cords[0], 9):
            for col in range(9):
                if row == cords[0]:
                    if col > cords[1] and self.board[row][col] == 0:
                        return True
                elif self.board[row][col] == 0:
                    return True
        return False

    def check_vertically(self, cords, board):
        """
        Finds what numbers can go into the square in board at (row, col) based on the vertical sudoku rules
        :param cords: Tuple that stores the current (row, col)
        :param board: 2D list of the sudoku board
        :return: List of all possible numbers
        """
        possible_nums = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        for row in range(9):
            if not (row == cords[0]):
                if possible_nums.count(board[row][cords[1]]) > 0:
                    possible_nums.remove(board[row][cords[1]])
        return possible_nums

    def check_horizontally(self, cords, board):
        """
        Finds what numbers can go into the square in board at (row, col) based on the horizontal sudoku rules
        :param cords: Tuple that stores the current (row, col)
        :param board: 2D list of the sudoku board
        :return: List of all possible numbers
        """
        possible_nums = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        for col in range(9):
            if not (col == cords[1]):
                if possible_nums.count(board[cords[0]][col]) > 0:
                    possible_nums.remove(board[cords[0]][col])
        return possible_nums

    def check_box(self, cords, board):
        """
        Finds what numbers can go into the square in board at (row, col) based on the grid sudoku rules
        :param cords: Tuple that stores the current (row, col)
        :param board: 2D list of the sudoku board
        :return: List of all possible numbers
        """
        possible_nums = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        for row in range(floor(cords[0] / 3) * 3, floor(cords[0] / 3) * 3 + 3):
            for col in range(floor(cords[1] / 3) * 3, floor(cords[1] / 3) * 3 + 3):
                if not (row == cords[0] and col == cords[1]):
                    if possible_nums.count(board[row][col]) > 0:
                        possible_nums.remove(board[row][col])
        return possible_nums
