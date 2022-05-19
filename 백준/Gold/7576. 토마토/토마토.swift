import Foundation

let line = readLine()!.split(separator: " ").map { Int(String($0))! }
let m = line[0]
let n = line[1]

var dist = Array(repeating: Array(repeating: 0, count: m), count: n)
let dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]

var board = [[Int]]()
var queue = [(Int, Int)]()

for i in 0..<n {
    let b = readLine()!.split(separator: " ").map { Int(String($0))! }
    board.append(b)
    for j in 0..<m {
        if b[j] == 1 {
            queue.append((i, j))
        } else if b[j] == 0 {
            dist[i][j] = -1
        }
    }
}

var index = 0
while index < queue.count {
    let (x, y) = queue[index]
    index += 1
//    let cur = queue.removeFirst() // 시간 초과
    
    for i in 0..<4 {
        let nx = x + dir[i].0
        let ny = y + dir[i].1
        
        if nx < 0 || nx >= n || ny < 0 || ny >= m {
            continue
        }
        if dist[nx][ny] >= 0 {
            continue
        }
        
        dist[nx][ny] = dist[x][y] + 1
        queue.append((nx, ny))
    }
}

var answer = 0
outerLoop: for i in 0..<n {
    for j in 0..<m {
        if dist[i][j] == -1 {
            answer = -1
            break outerLoop
        }
        answer = max(answer, dist[i][j])
    }
}

print(answer)
