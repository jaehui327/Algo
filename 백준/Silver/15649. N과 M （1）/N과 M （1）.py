from sys import stdin
from itertools import permutations
line = list(map(int, stdin.readline().split()))
N = line[0]
M = line[1]

arr = [x for x in range(1, N + 1)]
per = list(permutations(arr, M))
for p in per:
    print(" ".join(map(str, p)))
