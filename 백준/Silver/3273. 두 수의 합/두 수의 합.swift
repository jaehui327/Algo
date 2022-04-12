import Foundation

let n = Int(readLine()!)!
let array = readLine()!.split(separator: " ").map { Int(String($0))! }
let x = Int(readLine()!)!

var count = [Int](repeating: 0, count: 2_000_001)

var result = 0

for a in array {
    if x - a > 0, count[x - a] == 1 {
        result += 1
    }
    count[a] += 1
}

print(result)