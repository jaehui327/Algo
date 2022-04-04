import Foundation

func solution(_ clothes:[[String]]) -> Int {
    var dic: [String: Int] = [:]
    var result = 1
    
    for cloth in clothes {
        if let _ = dic[cloth[1]] {
            dic[cloth[1]]! += 1
        } else {
            dic[cloth[1]] = 1
        }
    }
    
    for (_, value) in dic {
        result *= (value + 1)
    }
    
    return result - 1
}