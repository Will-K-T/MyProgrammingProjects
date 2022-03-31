
class Node:

    def __init__(self, row, col):
        self.row = row
        self.col = col
        self.clicked = False

    def __str__(self):
        return str(self.row)+" "+str(self.col)+" "+str(self.clicked)
