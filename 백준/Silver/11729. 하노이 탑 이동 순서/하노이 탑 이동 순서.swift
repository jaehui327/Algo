import Foundation

func hanoi(_ begin: Int, _ mid: Int, _ end: Int, _ height: Int) {
    if height == 1 {
        move(begin, end)
    } else {
        hanoi(begin, end, mid, height - 1)
        move(begin, end)
        hanoi(mid, begin, end, height - 1)
    }
}

func move(_ begin: Int, _ end: Int) {
    print("\(begin) \(end)")
}

let height = Int(readLine()!)!
var result = 1
for _ in 0 ..< height {
    result *= 2
}
print(result - 1)
hanoi(1, 2, 3, height)