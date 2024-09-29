# 2292. 벌집

import sys

n = int(sys.stdin.readline())

a, b, cnt, room = 1, 1, 1, 2

while 1:
    if n == 1:
        print(1)
        break

    elif a+1 <= n and n <= 6*b+1:
        print(room)
        break

    room = room + 1
    cnt = cnt + 1  # 2, 3
    a = 6*b+1  # 7, 20
    b = b + cnt  # 3, 6
