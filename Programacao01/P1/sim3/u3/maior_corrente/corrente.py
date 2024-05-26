tensao1 = int(input())
resistencia1 = int(input())
tensao2 = int(input())
resistencia2 = int(input())
tensao3 = int(input())
resistencia3 = int(input())

corrente1 = tensao1 / (resistencia1 // 100)
corrente2 = tensao2 / (resistencia2 // 100)
corrente3 = tensao3 / (resistencia3 // 100)

if corrente1 > corrente2 and corrente1 > corrente3:
    print(f"condutor com maior corrente: 1")
elif corrente2 > corrente1 and corrente2 > corrente3:
    print("condutor com maior corrente: 2")
else:
    print("condutor com maior corrente: 3")
