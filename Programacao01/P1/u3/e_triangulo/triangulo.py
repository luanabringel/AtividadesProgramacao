a = int(input())
b = int(input())
c = int(input())

if abs(b - c) < a < b + c:
    if abs(a - c) < b < a + c:
        if abs(a - b) < c < a + b:
            perimetro = a + b + c
            print(f"triangulo valido. {perimetro}")

else: 
    print("triangulo invalido.")
