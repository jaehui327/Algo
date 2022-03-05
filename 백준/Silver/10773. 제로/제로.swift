import Foundation

func zero(_ arr: [Int]) -> Int {
    var nums = [Int]()
    var result = 0
    
    for n in arr {
        if n == 0 {
            nums.removeLast()
        } else {
            nums.append(n)
        }
    }
    
    for num in nums {
        result += num
    }
    return result
}

let input = Int(readLine()!)!
var arr: [Int] = []
for _ in 1...input {
    arr.append(Int(readLine()!)!)
}
print(zero(arr))