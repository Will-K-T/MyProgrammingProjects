import pygame
import time
from Node import Node
from copy import deepcopy


def draw_lines(screen, strikes):
    for row in range(9):
        if row != 0:
            if row % 3 == 0:
                pygame.draw.line(screen, (0, 0, 0), (0, row * 60), (540, row * 60), 5)
            else:
                pygame.draw.line(screen, (0, 0, 0), (0, row * 60), (540, row * 60))
        for col in range(9):
            if col != 0:
                if col % 3 == 0:
                    pygame.draw.line(screen, (0, 0, 0), (col * 60, 0), (col * 60, 540), 5)
                else:
                    pygame.draw.line(screen, (0, 0, 0), (col * 60, 0), (col * 60, 540))
    pygame.draw.rect(screen, (255, 255, 255), (0, 540, 540, 60))
    pygame.draw.line(screen, (0, 0, 0), (0, 540), (540, 540), 3)
    for i in range(len(strikes)):
        if strikes[i] == 1:
            pygame.draw.line(screen, (255, 0, 0), (540/2-(i*-60+65), 560), (540/2+10-(i*-60+65), 580), 3)
            pygame.draw.line(screen, (255, 0, 0), (540/2+10-(i*-60+65), 560), (540/2-(i*-60+65), 580), 3)


def find_clicked_node(grid, pos, clicked_grid, orig_board):
    clicked = None
    orig_clicked = None
    for row in range(9):
        for col in range(9):
            n = grid[row][col]
            if ((pos[0] < n.col < pos[0]+60) and (pos[1] < n.row < pos[1]+60)) and (orig_board[row][col] == 0):
                clicked_grid[row][col] = True
                clicked = row, col
            else:
                if clicked_grid[row][col]:
                    orig_clicked = row, col
                clicked_grid[row][col] = False
    if (orig_clicked is not None) and (clicked is None):
        clicked_grid[orig_clicked[0]][orig_clicked[1]] = True
        return None
    else:
        return clicked


def update_grid(screen, new_node, board, myfont):
    for row in range(9):
        for col in range(9):
            if row == new_node[0] and col == new_node[1]:
                pygame.draw.rect(screen, (100, 100, 100), (col * 60, row * 60, 60, 60))
            else:
                pygame.draw.rect(screen, (255, 255, 255), (col * 60, row * 60, 60, 60))
            if board[row][col] != 0:
                textsurface = myfont.render(str(board[row][col]), True, (0, 0, 0))
                screen.blit(textsurface, (col * 60 + 23, row * 60 + 15))


def strike(strikes):
    for i in range(len(strikes)):
        if strikes[i] == 0:
            strikes[i] = 1
            if i == len(strikes)-1:
                return False
            return True
            break
    return False


def solve_soduku(sudoku, screen):
    """
    Solves the board sudoku
    :param screen:
    :param sudoku: the board that needs to be solved
    :return:
    """

    myfont = pygame.font.SysFont('Times New Roman', 30)

    # Creates a copy of the sudoku board so that we don't mess up the original board
    solved_board = sudoku.board

    # Stores the index of the next number that should be tried (the index will be used with the possible_nums list)
    try_new_nums = [[0] * 9 for y in range(9)]

    # Creates a list that will act like a stack for the depth first search (stores tuples (row, col) for each unsolved square)
    nodes = [sudoku.find_next_empty_node((0, -1))]

    done = False

    # Keeps running until the puzzle is either solved or runs out of possible combinations
    while len(nodes) != 0:

        time.sleep(.001)

        if not done:
            update_grid(screen, (nodes[len(nodes) - 1][0], nodes[len(nodes) - 1][1]), solved_board, myfont)
            draw_lines(screen, [0, 0, 0])

        pygame.display.update()

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
        else:
            update_grid(screen, (nodes[len(nodes) - 1][0], nodes[len(nodes) - 1][1]), solved_board, myfont)
            draw_lines(screen, [0, 0, 0])
            done = True


class SudokuGraphics:

    def __init__(self, sudoku, s):
        pygame.init()

        pygame.font.init()

        myfont = pygame.font.SysFont('Times New Roman', 30)

        screen = pygame.display.set_mode((540, 600))

        orig_board = sudoku.board

        solve_board = deepcopy(orig_board)

        solved = s

        strikes = [0, 0, 0]

        grid = [[0 for i in range(9)] for j in range(9)]

        clicked_grid = [[False for i in range(9)] for j in range(9)]

        clicked = None

        curr_num = 0

        for row in range(9):
            for col in range(9):
                pygame.draw.rect(screen, (255, 255, 255), (col * 60, row * 60, 60, 60))
                if orig_board[row][col] != 0:
                    textsurface = myfont.render(str(orig_board[row][col]), True, (0, 0, 0))
                    screen.blit(textsurface, (col*60+23, row*60+15))
                grid[row][col] = Node(row*60+60, col*60+60)

        draw_lines(screen, strikes)

        run = True
        while run:
            pygame.time.delay(50)

            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    run = False
                if event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_1:
                        curr_num = 1
                    elif event.key == pygame.K_2:
                        curr_num = 2
                    elif event.key == pygame.K_3:
                        curr_num = 3
                    elif event.key == pygame.K_4:
                        curr_num = 4
                    elif event.key == pygame.K_5:
                        curr_num = 5
                    elif event.key == pygame.K_6:
                        curr_num = 6
                    elif event.key == pygame.K_7:
                        curr_num = 7
                    elif event.key == pygame.K_8:
                        curr_num = 8
                    elif event.key == pygame.K_9:
                        curr_num = 9
                    elif event.key == pygame.K_0:
                        curr_num = 0
                    elif event.key == pygame.K_SPACE:
                        sudoku.board = solve_board
                        solve_soduku(sudoku, screen)
                    if clicked is not None:
                        if curr_num == solved[clicked[0]][clicked[1]]:
                            solve_board[clicked[0]][clicked[1]] = curr_num
                            update_grid(screen, clicked, solve_board, myfont)
                            draw_lines(screen, strikes)
                        else:
                            run = strike(strikes)
                            draw_lines(screen, strikes)

            if pygame.mouse.get_pressed()[0] == 1:
                clicked = find_clicked_node(grid, pygame.mouse.get_pos(), clicked_grid, orig_board)

                if clicked is not None and orig_board[clicked[0]][clicked[1]] == 0:
                    update_grid(screen, clicked, solve_board, myfont)
                    draw_lines(screen, strikes)

            pygame.display.update()

        pygame.quit()
