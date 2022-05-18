from sys import stdin

nums = list(map(int, stdin.readline().split()))
n = nums[0]
m = nums[1]

board = []
for _ in range(n):
    board.append(list(map(int, stdin.readline().split())))
vis = [[0] * m for _ in range(n)]

num = 0
mx = 0

dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]

for i in range(n):
    for j in range(m):
        if board[i][j] == 0 or vis[i][j] == 1:
            continue
        num += 1

        queue = []
        vis[i][j] = 1
        queue.append((i, j))

        area = 0

        while len(queue) > 0:
            area += 1
            cur = queue.pop(0)
            for k in range(4):
                nx = cur[0] + dir[k][0]
                ny = cur[1] + dir[k][1]

                if nx < 0 or nx >= n or ny < 0 or ny >= m:
                    continue
                if board[nx][ny] == 0 or vis[nx][ny] == 1:
                    continue
                vis[nx][ny] = 1
                queue.append((nx, ny))

        mx = max(mx, area)

print(num)
print(mx)
