from sys import stdin
from itertools import combinations

line = list(map(int, stdin.readline().split()))
L = line[0]
arr = sorted(list(map(str, stdin.readline().split())))

answer = list(combinations(arr, L))
for a in answer:
    cnt_vow = 0
    for i in a:
        if i in "aeiou":
            cnt_vow += 1
    if cnt_vow >= 1 and L - cnt_vow >= 2:
        print("".join(a))
