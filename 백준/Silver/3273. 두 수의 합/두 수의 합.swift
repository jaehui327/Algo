import Foundation

let n = Int(readLine()!)!
let array = readLine()!.split(separator: " ").map { Int(String($0))! }.sorted() // O(NlogN)
let x = Int(readLine()!)!

// O(logN)
var start = 0
var end = n - 1
var result = 0

while start < end {
    let sum = array[start] + array[end]
    if sum == x {
        result += 1
        start += 1
        end -= 1
    } else if sum < x {
        start += 1
    } else {
        end -= 1
    }
}

print(result)