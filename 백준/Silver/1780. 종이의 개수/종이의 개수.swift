import Foundation

let n = Int(readLine()!)!
var board = [[Int]]()
for _ in 0..<n {
    board.append(readLine()!.split(separator: " ").map { Int(String($0))! })
}

var count = [0, 0, 0] // -1,0,1로 채워진 종이 개수

func check(_ x: Int, _ y: Int, _ width: Int) -> Bool {
    for i in x..<x + width {
        for j in y..<y + width {
            if board[i][j] != board[x][y] {
                return false
            }
        }
    }
    return true
}

func paper(_ x: Int, _ y: Int, _ width: Int) {
    if check(x, y, width) {
        count[board[x][y] + 1] += 1
        return
    }
    let w = width / 3
    for i in 0..<3 {
        for j in 0..<3 {
            paper(x + i * w, y + j * w, w)
        }
    }
}

paper( 0, 0, n)
for c in count {
    print(c)
}