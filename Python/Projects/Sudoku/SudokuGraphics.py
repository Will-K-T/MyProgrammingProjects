import pygame
from Node import Node


def draw_lines(screen):
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


def find_clicked_node(grid, pos, clicked_grid):
    for row in range(9):
        for col in range(9):
            n = grid[row][col]
            if (pos[0] < n.row < pos[0]+60) and (pos[1] < n.col < pos[1]+60):
                clicked_grid[row][col] = True
                return row, col
            else:
                clicked_grid[row][col] = False


def update_grid(screen, new_node, board, myfont):
    for row in range(9):
        for col in range(9):
            if col == new_node[0] and row == new_node[1]:
                pygame.draw.rect(screen, (100, 100, 100), (row * 60, col * 60, 60, 60))
            else:
                pygame.draw.rect(screen, (255, 255, 255), (row * 60, col * 60, 60, 60))
            if board[row][col] != 0:
                textsurface = myfont.render(str(board[row][col]), True, (0, 0, 0))
                screen.blit(textsurface, (row * 60 + 23, col * 60 + 15))


class SudokuGraphics:

    def __init__(self, sudoku):
        pygame.init()

        pygame.font.init()

        myfont = pygame.font.SysFont('Times New Roman', 30)

        screen = pygame.display.set_mode((540, 540))

        board = sudoku.board

        grid = [[0 for i in range(9)] for j in range(9)]

        clicked_grid = [[0 for i in range(9)] for j in range(9)]

        for row in range(9):
            for col in range(9):
                pygame.draw.rect(screen, (255, 255, 255), (row * 60, col * 60, 60, 60))
                if board[row][col] != 0:
                    textsurface = myfont.render(str(board[row][col]), True, (0, 0, 0))
                    screen.blit(textsurface, (row*60+23, col*60+15))
                grid[row][col] = Node(col*60+60, row*60+60)

        draw_lines(screen)

        run = True
        while run:
            pygame.time.delay(50)

            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    run = False
                if event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_1:
                        print("hello")

            if pygame.mouse.get_pressed()[0] == 1:
                clicked = find_clicked_node(grid, pygame.mouse.get_pos(), clicked_grid)
                if clicked is not None:
                    update_grid(screen, clicked, board, myfont)
                    draw_lines(screen)

            pygame.display.update()

        pygame.quit()
