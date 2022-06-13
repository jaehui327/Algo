import Foundation

let input = readLine()!.split(separator: " ").map { Int(String($0))! }
let (A, B, C) = (input[0], input[1], input[2])

func recursion(_ a: Int, _ b: Int, _ c: Int) -> Int {
    if b == 1 { // base condition
        return a % c
    }
    var val = recursion(a, b / 2, c)
    val = val * val % c
    
    if b % 2 == 0 { // 짝수
        return val
    } else { // 홀수
        return val * a % c
    }
}

print(recursion(A, B, C))
