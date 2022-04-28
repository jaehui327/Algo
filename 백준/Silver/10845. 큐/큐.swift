import Foundation

var queue = [Int]()
var index = 0

for _ in 0..<Int(readLine()!)! {
    let line = readLine()!.split(separator: " ").map { String($0) }
    let size = queue.count - index
    switch line[0] {
    case "push":
        queue.append(Int(line[1])!)
    case "pop":
        if size == 0 {
            print(-1)
        } else {
            print(queue[index])
            index += 1
        }
    case "size":
        print(size)
    case "empty":
        print(size == 0 ? 1 : 0)
    case "front":
        print(size == 0 ? -1 : queue[index])
    case "back":
        print(size == 0 ? -1 : queue[queue.count - 1])
    default: break
    }
}
