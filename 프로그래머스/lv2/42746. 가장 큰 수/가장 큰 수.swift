import Foundation

func solution(_ numbers:[Int]) -> String {
    let stringArr = numbers.map { String($0) }
    let answer = stringArr.sorted { x, y in
        return x+y > y+x
    }
    if answer[0] == "0" {
        return "0"
    }
    return answer.joined(separator: "")
}