import Foundation

func solution(_ N:Int, _ number:Int) -> Int {
    if N == number {
        return 1
    }
    
    var answer = 0
    var s = [Set<Int>]()
    
    var NN = 0
    for _ in 1...8 {
        NN = NN * 10 + N
        s.append(Set([NN]))
    }
    
    for i in 1..<8 {
        for j in 0..<i {
            for op1 in s[j] {
                for op2 in s[i - j - 1] {
                    s[i].insert(op1 + op2)
                    s[i].insert(op1 - op2)
                    s[i].insert(op1 * op2)
                    if op2 != 0 {
                        s[i].insert(op1 / op2)
                    }
                }
            }
        }
        if s[i].contains(number) {
            answer = i + 1
            break
        } else {
             answer = -1
        }
    }
    
    return answer
}