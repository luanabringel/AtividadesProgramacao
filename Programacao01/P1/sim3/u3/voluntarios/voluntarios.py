nome1 = input().split()
nome2 = input().split()
nome3 = input().split()

letra1 = nome1[0]
letra2 = nome2[0]
letra3 = nome3[0]

if letra1 == letra2 and letra1 < letra3:
    print(f"{nome1} (2)")
if letra1 == letra3 and letra1 < letra2:
    print(f"{nome1} (2)")
if letra2 == letra3 and letra2 < letra1:
    priint(f"{nome2} (2)")
elif letra1 > letra2 and letra3 > letra2:
    print(f"{nome2} (1)")
elif letra1 < letra2 and letra1 < letra3:
    print(f"{nome1} (1)")
else:
    print(f"{nome3} (1)")



