peso_antes = float(input())
peso_depois = float(input())
porcentagem = (peso_antes - peso_depois) * 100 / peso_antes

if 5 <= porcentagem < 10:
    print(f"{porcentagem:.1f}% do peso do produto é de água congelada.")
    print("Produto em conformidade.")

elif 5 > porcentagem:
    print(f"{porcentagem:.1f}% do peso do produto é de água congelada.")
    print("Produto qualis A.")

else:
    print(f"{porcentagem:.1f}% do peso do produto é de água congelada.")
    print("Produto não conforme.")

