import Foundation

func josephus(_ n: Int, _ k: Int) {
    var queue: [Int] = [Int](1...n)
    var result: [Int] = []
    var check = k - 1
    
    while true {
        result.append(queue.remove(at: check))
        if queue.isEmpty { break }
        check = (check + k - 1) % queue.count
    }
    print("<" + result.map({String($0)}).joined(separator: ", ") + ">")
}

let line = readLine()!.split(separator: " ").map { Int(String($0))!}
josephus(line[0], line[1])