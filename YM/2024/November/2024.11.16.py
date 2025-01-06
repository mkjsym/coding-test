#백준 2752 세수정렬
# import sys
# input = sys.stdin.readline

# a, b, c = map(int, input().split())

# if (a < b):
#     if (a < c):
#         print(a)
#         if (b < c):
#             print(b)
#             print(c)
#         else:
#             print(c)
#             print(b)
#     else:
#         print(c)
#         if (a < b):
#             print(a)
#             print(b)
#         else:
#             print(b)
#             print(a)
# else:
#     if (b < c):
#         print(b)
#         if (a < c):
#             print(a)
#             print(c)
#         else:
#             print(c)
#             print(a)
#     else:
#         print(c)
#         if (a < b):
#             print(a)
#             print(b)
#         else:
#             print(b)
#             print(a)


#백준 10610 30
import sys
input = sys.stdin.readline

n = input().strip()

if ('0' not in n):
    print(-1)
else:
    sum = 0
    for i in n:
        sum += int(i)

    if (sum % 3 != 0):
        print(-1)
    else:
        sorted_n = sorted(n, reverse = True)
        result = "".join(sorted_n)
        print(result)