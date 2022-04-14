import Foundation

var stack = [Int]()

for _ in 0..<Int(readLine()!)! {
    let line = readLine()!.split(separator: " ").map { String($0) }
    switch line[0] {
    case "push":
        stack.append(Int(line[1])!)
    case "pop":
        print(stack.isEmpty ? -1 : stack.removeLast())
    case "size":
        print(stack.count)
    case "empty":
        print(stack.isEmpty ? 1 : 0)
    case "top":
        print(stack.isEmpty ? -1 : stack[stack.count - 1])
    default: break
    }
}
