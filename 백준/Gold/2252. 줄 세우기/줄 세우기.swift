import Foundation

let line = readLine()!.split(separator: " ").map { Int(String($0))! }
let N = line[0]
let M = line[1]

var array = [[Int]]()

for _ in 1...M {
    let compare = readLine()!.split(separator: " ").map { Int(String($0))! }
    let A = compare[0]
    let B = compare[1]
    array.append([A, B])
}

var inDegree = Array(repeating: 0, count: 32_001)
var graph = Array(repeating: [Int](), count: 32_001)

array.forEach { a in
    inDegree[a[1]] += 1
    graph[a[0]].append(a[1])
}

var queue = [Int]()

for i in 1...N {
    if inDegree[i] == 0 {
        queue.append(i)
    }
}

var index = 0
while index < queue.count {
    let student = queue[index]
    index += 1
    for j in graph[student] {
        inDegree[j] -= 1
        if inDegree[j] == 0 {
            queue.append(j)
        }
    }
    print(student, terminator: " ")
}