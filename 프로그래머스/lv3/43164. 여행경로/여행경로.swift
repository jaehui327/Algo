import Foundation

func solution(_ tickets:[[String]]) -> [String] {
    var dic = [String: [String]]()
    for t in tickets {
        if dic[t[0]] == nil {
            dic[t[0]] = [t[1]]
        } else {
            dic[t[0]]?.append(t[1])
        }
    }
    
    for d in dic.keys {
        dic[d]?.sort(by: >)
    }
    
    var stack = ["ICN"]
    var visited = [String]()
    
    while !stack.isEmpty {
        let top = stack[stack.count - 1]
        
        if dic[top] == nil || dic[top] == [] {
            visited.append(stack.removeLast())
        } else {
            stack.append((dic[top]?.removeLast())!)
        }
    }
    
    return visited.reversed()
}