from sys import stdin

nums = list(map(int, stdin.readline().split()))
n = nums[0]
m = nums[1]

board = []
for _ in range(n):
    board.append(list(map(int, stdin.readline().rstrip())))
dist = [[-1] * m for _ in range(n)]

dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]

queue = []
dist[0][0] = 0
queue.append((0, 0))

while len(queue) > 0:
    cur = queue.pop(0)
    for k in range(4):
        nx = cur[0] + dir[k][0]
        ny = cur[1] + dir[k][1]

        if nx < 0 or nx >= n or ny < 0 or ny >= m:
            continue
        if board[nx][ny] == 0 or dist[nx][ny] >= 0:
            continue
        dist[nx][ny] = dist[cur[0]][cur[1]] + 1
        queue.append((nx, ny))

print(dist[n - 1][m - 1] + 1)
