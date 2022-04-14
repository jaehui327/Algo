import Foundation

var stack = [Int]()
var result = [String]()

var count = 1

for _ in 0..<Int(readLine()!)! {
    let num = Int(readLine()!)!
    
    while count <= num {
        stack.append(count)
        result.append("+")
        count += 1
    }
    if stack.last == num {
        stack.removeLast()
        result.append("-")
    } else {
        print("NO")
        exit(0)
    }
}

print(result.joined(separator: "\n"))