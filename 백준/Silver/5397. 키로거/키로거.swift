import Foundation

for _ in 0..<Int(readLine()!)! {
    var left = [Character]()
    var right = [Character]()
    
    let input = readLine()!
    for i in input {
        switch i {
        case "<":
            if !left.isEmpty {
                right.append(left.removeLast())
            }
        case ">":
            if !right.isEmpty {
                left.append(right.removeLast())
            }
        case "-":
            if !left.isEmpty {
                left.removeLast()
            }
        default:
            left.append(i)
        }
    }
    print(String(left + right.reversed()))
}