import Foundation

var left = Array(readLine()!)
var right = [Character]()

for _ in 0..<Int(readLine()!)! {
    let input = readLine()!
    switch input {
    case "L":
        if !left.isEmpty {
            right.append(left.removeLast())
        }
    case "D":
        if !right.isEmpty {
            left.append(right.removeLast())
        }
    case "B":
        if !left.isEmpty {
            left.removeLast()
        }
    default:
        left.append(input.last!)
    }
}

print(String(left + right.reversed()))