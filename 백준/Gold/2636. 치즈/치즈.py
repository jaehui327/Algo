from sys import stdin
from collections import deque

line = list(map(int, stdin.readline().split()))
r = line[0]
c = line[1]

board = []
for _ in range(r):
    board.append(list(map(int, stdin.readline().split())))

dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]

time = 0
pieces = []


def bfs():
    q = deque()
    q.append((0, 0))
    visited[0][0] = 1
    piece = 0

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dir[i][0]
            ny = y + dir[i][1]

            if 0 <= nx < r and 0 <= ny < c and visited[nx][ny] == 0:
                if board[nx][ny] == 0:
                    visited[nx][ny] = 1
                    q.append((nx, ny))
                elif board[nx][ny] == 1:
                    board[nx][ny] = 0
                    visited[nx][ny] = 1
                    piece += 1
    pieces.append(piece)
    return piece

while 1:
    time += 1
    visited = [[0] * c for _ in range(r)]

    piece = bfs()
    if piece == 0:
        break

print(time - 1)
print(pieces[-2])