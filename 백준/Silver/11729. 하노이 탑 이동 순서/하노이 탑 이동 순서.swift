import Foundation

let K = Int(readLine()!)!

func hanoi(_ current: Int, _ next: Int, _ k: Int) {
    if k == 1 {
        print("\(current) \(next)")
        return
    }
    hanoi(current, 6 - current - next, k - 1)
    print("\(current) \(next)")
    hanoi(6 - current - next, next, k - 1)
}

print(pow(2, K) - 1)
hanoi(1, 3, K)