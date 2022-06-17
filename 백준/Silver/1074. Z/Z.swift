import Foundation

let input = readLine()!.split(separator: " ").map { Int(String($0))! }
let (n, r, c) = (input[0], input[1], input[2])

func z(_ n: Int, _ r: Int, _ c: Int) -> Int {
    let half = 1 << (n - 1)
    if n == 0 {
        return 0
    }
    if r < half && c < half {
        return z(n - 1, r, c)
    } else if r < half && c >= half {
        return half * half + z(n - 1, r, c - half)
    }  else if r >= half && c < half {
        return 2 * half * half + z(n - 1, r - half, c)
    } else {
        return 3 * half * half + z(n - 1, r - half, c - half)
    }
}

print(z(n, r, c))