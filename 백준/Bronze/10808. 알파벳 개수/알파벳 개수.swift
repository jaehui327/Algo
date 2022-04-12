import Foundation

let s = readLine()!

let alphabet = Array("abcdefghijklmnopqrstuvwxyz")
var count = [Int](repeating: 0, count: 26)

for c in s {
    count[alphabet.firstIndex(of: c)!] += 1
}

for c in count {
    print(c, terminator: " ")
}