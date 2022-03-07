import Foundation

func solution(_ array:[Int], _ commands:[[Int]]) -> [Int] {
    var result: [Int] = []
    for command in commands {
        var arr: [Int] = []
        if command[0] == command[1] {
            arr.append(array[command[0] - 1])
        }  else {
            arr.append(contentsOf: array[command[0] - 1 ..< command[1]])
        }
        arr.sort()
        if arr.count < command[2] {
            result.append(arr.last!)
        } else {
            result.append(arr[command[2] - 1])
        }
    }
    return result
}