import Foundation

let s = readLine()!

var dic: [Character: Int] = [:]
let alphabet: [Character] = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"]

for a in alphabet {
    dic[a] = 0
}

for c in s {
    dic[c]! += 1
}

for a in alphabet {
    print(dic[a]!, terminator: " ")
}