import Foundation

let s = readLine()!

var count = [Int](repeating: 0, count: 9)

for c in s {
    if c == "6" || c == "9" {
        count[6] += 1
    } else {
        count[Int(String(c))!] += 1
    }
}

count[6] = count[6] % 2 == 0 ? count[6] / 2 : count[6] / 2 + 1

print(count.max()!)