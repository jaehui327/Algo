import Foundation

func balancedWorld(_ s: String) -> String {
    var stack: [Character] = []
    let dic: [Character: Character] = [")": "(", "]": "["]
    let open: [Character] = ["(", "["]
    let close: [Character] = [")", "]"]
    
    for c in s {
        if open.contains(c) {
            stack.append(c)
        } else if close.contains(c) {
            if !stack.isEmpty, stack.last == dic[c] {
                stack.removeLast()
            } else {
                return "no"
            }
        }
    }
    if !stack.isEmpty {
        return "no"
    }
    return "yes"
}

while true {
    let input = readLine()!
    if input == "." {
        break
    }
    print(balancedWorld(input))
}
