import Foundation

func solution(_ number:String, _ k:Int) -> String {
    var stack = [String]()
    var remove = k
    for n in number {
        while !stack.isEmpty && stack[stack.count - 1] < String(n) && remove > 0 {
            remove -= 1
            stack.removeLast()
        }
        stack.append(String(n))
    }
    return stack[0..<number.count - k].joined(separator: "")
}