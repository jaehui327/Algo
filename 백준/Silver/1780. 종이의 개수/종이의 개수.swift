import Foundation

let n = Int(readLine()!)!
var board = [[Int]]()
for _ in 0..<n {
    board.append(readLine()!.split(separator: " ").map { Int(String($0))! })
}

var count = [0, 0, 0] // -1,0,1로 채워진 종이 개수

func paper(_ x: Int, _ y: Int, _ width: Int) {
    for i in x..<x + width {
        for j in y..<y + width {
            if board[i][j] != board[x][y] {
                for k in 0..<3 {
                    for l in 0..<3 {
                        paper(x + k * (width / 3), y + l * (width / 3), width / 3)
                    }
                }
                return
            }
        }
    }
    count[board[x][y] + 1] += 1
}

paper( 0, 0, n)
for c in count {
    print(c)
}