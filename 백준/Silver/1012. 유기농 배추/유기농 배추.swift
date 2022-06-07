import Foundation

let T = Int(readLine()!)!
let direct = [(0, 1), (1, 0), (0, -1), (-1, 0)]

for _ in 0..<T {
    let line = readLine()!.split(separator: " ").map { Int(String($0))! }
    let M = line[0]
    let N = line[1]
    let K = line[2]
    
    var board = Array(repeating: Array(repeating: 0, count: M), count: N)
    
    for _ in 0..<K {
        let dot = readLine()!.split(separator: " ").map { Int(String($0))! }
        let X = dot[0]
        let Y = dot[1]
        board[Y][X] = 1
    }
    
    func dfs(_ x: Int, _ y: Int) -> Int {
        var queue = [(x, y)]
        var index = 0
        
        while index < queue.count {
            let (x, y) = queue[index]
            index += 1
            
            for i in 0..<4 {
                let nx = x + direct[i].0
                let ny = y + direct[i].1
                
                if nx < 0 || nx >= N || ny < 0 || ny >= M {
                    continue
                }
                if board[nx][ny] == 1 {
                    queue.append((nx, ny))
                    board[nx][ny] = 2
                }
            }
        }
        return 1
    }
    
    var answer = 0
    for i in 0..<N {
        for j in 0..<M {
            if board[i][j] == 1 {
                answer += dfs(i, j)
            }
        }
    }
    print(answer)
}