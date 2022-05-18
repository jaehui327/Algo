import Foundation

let line = readLine()!.split(separator: " ").map { Int(String($0))!}
let n = line[0]
let m = line[1]

var board = [[Int]]()
for _ in 0..<n {
    board.append(readLine()!.map { Int(String($0))! })
}
var dist = Array(repeating: Array(repeating: -1, count: m), count: n)

let dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]

var queue = [(Int, Int)]()
queue.append((0, 0))
dist[0][0] = 0

while !queue.isEmpty {
    let cur = queue.removeFirst()
    for k in 0..<4 {
        let nx = cur.0 + dir[k].0
        let ny = cur.1 + dir[k].1
        
        if nx < 0 || nx >= n || ny < 0 || ny >= m {
            continue
        }
        if dist[nx][ny] >= 0 || board[nx][ny] == 0 {
            continue
        }
        dist[nx][ny] = dist[cur.0][cur.1] + 1
        queue.append((nx, ny))
    }
}

print(dist[n - 1][m - 1] + 1)