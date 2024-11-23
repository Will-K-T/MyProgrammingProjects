# Grants this class access to the Board class
from Board import Board
from SudokuGraphics import SudokuGraphics
from copy import deepcopy


def print_board(board):
    """
    Prints the board in a way that is easy to view
    :param board: the board that is to be printed
    :return:

    """
    for row in board:
        print(row)


def solve_soduku(sudoku):
    """
    Solves the board sudoku
    :param sudoku: the board that needs to be solved
    :return:
    """
    # Creates a copy of the sudoku board so that we don't mess up the original board
    solved_board = deepcopy(sudoku.board)

    # Stores the index of the next number that should be tried (the index will be used with the possible_nums list)
    try_new_nums = [[0] * 9 for y in range(9)]

    # Creates a list that will act like a stack for the depth first search (stores tuples (row, col) for each unsolved square)
    nodes = [sudoku.find_next_empty_node((0, -1))]

    # Keeps running until the puzzle is either solved or runs out of possible combinations
    while len(nodes) != 0:

        # finds all possible numbers that can go into the current unsolved square
        one = set(sudoku.check_vertically(nodes[len(nodes) - 1], solved_board))
        two = set(sudoku.check_horizontally(nodes[len(nodes) - 1], solved_board))
        three = set(sudoku.check_box(nodes[len(nodes) - 1], solved_board))
        possible_nums = list(one.intersection(two).intersection(three))

        # Determines if there is a number that can be put into the current unsolved square
        if len(possible_nums) > 0:

            # Stores the current number in the current unsolved square
            curr_num = solved_board[nodes[len(nodes) - 1][0]][nodes[len(nodes) - 1][1]]

            # Stores the next number that will be tried in the current unsolved square
            possible_next_num = possible_nums[
                try_new_nums[nodes[len(nodes) - 1][0]][nodes[len(nodes) - 1][1]] % len(possible_nums)]

            # Makes sure that the code doesn't get stuck trying the same combos
            if try_new_nums[nodes[len(nodes) - 1][0]][nodes[len(nodes) - 1][1]] == len(possible_nums):
                solved_board[nodes[len(nodes) - 1][0]][nodes[len(nodes) - 1][1]] = 0
                try_new_nums[nodes[len(nodes) - 1][0]][nodes[len(nodes) - 1][1]] = 0
                nodes.pop()
                continue

            # Makes sure that the code doesn't get stuck on trying the same number
            if possible_next_num == curr_num:
                solved_board[nodes[len(nodes) - 1][0]][nodes[len(nodes) - 1][1]] = 0
                nodes.pop()
                continue

            # Sets the unsolved square to the next number that is to be tried
            solved_board[nodes[len(nodes) - 1][0]][nodes[len(nodes) - 1][1]] = possible_next_num

            # Changes which index will be used to find a different number if the new number does not work
            try_new_nums[nodes[len(nodes) - 1][0]][nodes[len(nodes) - 1][1]] += 1

        # if there are no possible numbers for the current square, it backtracks to the last number that can change
        else:
            solved_board[nodes[len(nodes) - 1][0]][nodes[len(nodes) - 1][1]] = 0
            nodes.pop()
            continue

        # Determines if there is still an empty unsolved square left
        if sudoku.has_next_emtpy_node(nodes[len(nodes) - 1]):
            nodes.append(sudoku.find_next_empty_node(nodes[len(nodes) - 1]))

        # if this is reached, the puzzle has been solved and gets printed
        else:
            # print_board(solved_board)
            break

    # if this is reached, the puzzle is not solvable
    if len(nodes) == 0:
        print()
        print("Puzzle is not solvable!")
    else:
        print()
        # print("Puzzle solved!")
    return solved_board


def main():

    # Opens the puzzle file
    file = open("Board.txt", "r")

    # Stores the number of puzzles in the file
    num_of_puzzles = 0

    # Stores the number of solved puzzles
    puzzle_count = 0

    # Reads the file and sets the num_of_puzzles
    if file.readable():
        line = file.readline()
        num_of_puzzles = int(line)

    # Solves every puzzle in the file
    for p in range(num_of_puzzles):
        # Creates a new Board object
        sudoku = Board((puzzle_count*9)+1+puzzle_count)

        # Solves the puzzle
        solved = solve_soduku(sudoku)

        screen = SudokuGraphics(sudoku, solved)

        # Increases the solved puzzle count by 1
        puzzle_count += 1


if __name__ == "__main__":
    main()

'''
Old board
000037600
000600090
008000004
090000001
600000009
300000040
700000800
010009000
002540000
'''


'''
1

030080001
007401050
900050200
002005010
300210500
590060002
006502000
009600027
000008065
'''