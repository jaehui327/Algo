import Foundation

let line = readLine()!.split(separator: " ").map { Int(String($0))! }
let r = line[0]
let c = line[1]

var board = [[Character]]()
var dist1 = Array(repeating: Array(repeating: -1, count: c), count: r)
var dist2 = Array(repeating: Array(repeating: -1, count: c), count: r)

var queue1 = [(Int, Int)]()
var queue2 = [(Int, Int)]()

for i in 0..<r {
    let b = readLine()!.map { $0 }
    board.append(b)
    for j in 0..<c {
        if board[i][j] == "F" {
            dist1[i][j] = 0
            queue1.append((i, j))
        } else if board[i][j] == "J" {
            dist2[i][j] = 0
            queue2.append((i, j))
        }
    }
}

let dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]
var index = 0
while index < queue1.count {
    let (x, y) = queue1[index]
    index += 1
    
    for i in 0..<4 {
        let nx = x + dir[i].0
        let ny = y + dir[i].1
        
        if nx < 0 || nx >= r || ny < 0 || ny >= c {
            continue
        }
        if dist1[nx][ny] >= 0 || board[nx][ny] == "#" {
            continue
        }
        dist1[nx][ny] = dist1[x][y] + 1
        queue1.append((nx, ny))
    }
}

index = 0
while index < queue2.count {
    let (x, y) = queue2[index]
    index += 1
    
    for i in 0..<4 {
        let nx = x + dir[i].0
        let ny = y + dir[i].1
        
        if nx < 0 || nx >= r || ny < 0 || ny >= c {
            print(dist2[x][y] + 1)
            exit(0)
        }
        if dist2[nx][ny] >= 0 || board[nx][ny] == "#" {
            continue
        }
        if dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[x][y] + 1 {
            continue
        }
        dist2[nx][ny] = dist2[x][y] + 1
        queue2.append((nx, ny))
    }
}

print("IMPOSSIBLE")