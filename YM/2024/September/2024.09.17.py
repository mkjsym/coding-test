#백준 1735 분수 합
import sys

def returnLCM(a, b):
    while (b != 0):
        r = a % b
        a = b
        b = r
    
    return a        
    
ja1, mo1 = map(int, sys.stdin.readline().split())
ja2, mo2 = map(int, sys.stdin.readline().split())

mo = mo1 * mo2
ja = ja1 * mo2 + ja2 * mo1

a = returnLCM(mo, ja)

print(ja // a, mo // a)