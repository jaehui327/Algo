import Foundation

let line = readLine()!.split(separator: " ").map { Int(String($0))!}
let n = line[0]
let m = line[1]

var board = [[Int]]()
for _ in 0..<n {
    board.append(readLine()!.split(separator: " ").map { Int(String($0))!})
}
var vis = Array(repeating: Array(repeating: 0, count: m), count: n)

var num = 0 // 그림의 수
var mx = 0 // 그림의 최댓값

let dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]

for i in 0..<n {
    for j in 0..<m {
        if board[i][j] == 0 || vis[i][j] == 1 {
            continue
        }
        num += 1
        
        var queue = [(Int, Int)]()
        vis[i][j] = 1
        queue.append((i, j))
        
        var area = 0
        
        while !queue.isEmpty {
            area += 1
            let cur = queue.removeFirst()
            for k in 0..<4 {
                let nx = cur.0 + dir[k].0
                let ny = cur.1 + dir[k].1
                
                if nx < 0 || nx >= n || ny < 0 || ny >= m {
                    continue
                }
                if vis[nx][ny] == 1 || board[nx][ny] == 0 {
                    continue
                }
                vis[nx][ny] = 1
                queue.append((nx, ny))
            }
        }
        
        mx = max(mx, area)
    }
}

print(num)
print(mx)