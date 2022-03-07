import Foundation

func factorial(_ n: Int) -> Int {
    if n == 0 {
        return 1
    } else {
        return n * factorial(n - 1)
    }
}

let n = Int(readLine()!)!
print(factorial(n))