import Foundation

func isValidBracket(_ s: String) -> String {
    var stack: [Character] = []
    for c in s {
        if c == "(" {
            stack.append(c)
        } else {
            if stack.count != 0, stack.last == "(" {
                stack.removeLast()
            } else {
                return "NO"
            }
        }
    }
    if !stack.isEmpty {
        return "NO"
    }
     return "YES"
}

let input = Int(readLine()!)!
for _ in 1...input {
    print(isValidBracket(readLine()!))
}