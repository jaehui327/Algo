import Foundation

func solution(_ array:[Int], _ commands:[[Int]]) -> [Int] {
   var result: [Int] = []
    for command in commands {
        let i = command[0] - 1
        let j = command[1] - 1
        let k = command[2] - 1
        
        var arr: [Int] = []
        if i == j {
            arr.append(array[i])
        }  else {
            arr.append(contentsOf: array[i ... j])
        }
        arr.sort()
        if arr.count < k {
            result.append(arr.last!)
        } else {
            result.append(arr[k])
        }
    }
    return result
}