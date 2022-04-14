import Foundation

var stack = [Int]()
var count = 1
var result = ""

for _ in 0..<Int(readLine()!)! {
    let num = Int(readLine()!)!
    
    while count <= num {
        stack.append(count)
        result += "+\n"
        count += 1
    }
    if stack.removeLast() != num {
        result = "NO"
        break
    }
    result += "-\n"
}

print(result)