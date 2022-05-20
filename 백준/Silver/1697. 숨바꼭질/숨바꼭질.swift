import Foundation

let line = readLine()!.split(separator: " ").map { Int(String($0))! }
let n = line[0]
let k = line[1]

var dist = Array(repeating: -1, count: 200_001)

var queue = [n]
dist[n] = 0

while dist[k] == -1 {
    let cur = queue.removeFirst()
    
    for x in [cur + 1, cur - 1, cur * 2] {
        if x < 0 || x > 200_000 {
            continue
        }
        if dist[x] >= 0 {
            continue
        }
        dist[x] = dist[cur] + 1
        queue.append(x)
    }
}

print(dist[k])