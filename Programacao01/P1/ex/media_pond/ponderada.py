
nota1 = float(input())
nota2 = float(input())
nota3 = float(input())
peso1 = int(input())
peso2 = int(input())

novo_peso1 = peso1 / 100
novo_peso2 = peso2 / 100
peso3 = 1 - (novo_peso1 + novo_peso2)

media = (nota1*novo_peso1) + (nota2*novo_peso2) + (nota3*peso3)
print(f"Média Final: {media:.1f}")
