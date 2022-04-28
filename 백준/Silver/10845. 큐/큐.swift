import Foundation

var queue = [Int]()
var index = 0

for _ in 0..<Int(readLine()!)! {
    let line = readLine()!.split(separator: " ").map { String($0) }
    switch line[0] {
    case "push":
        queue.append(Int(line[1])!)
    case "pop":
        print(queue.isEmpty ? -1 : queue.removeFirst())
    case "size":
        print(queue.count)
    case "empty":
        print(queue.isEmpty ? 1 : 0)
    case "front":
        print(queue.isEmpty ? -1 : queue[index])
    case "back":
        print(queue.isEmpty ? -1 : queue[queue.count - 1])
    default: break
    }
}