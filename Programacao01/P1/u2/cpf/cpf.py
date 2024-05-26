cpf1 = int(input())
cpf2 = int(input())
cpf3 = int(input())

divisao1 = cpf1 // 100
divisao2 = cpf2 // 100
divisao3 = cpf3 // 100

resto1 = cpf1 % 100
resto2 = cpf2 % 100
resto3 = cpf3 % 100

div_resto1 = resto1 // 10
div_resto2 = resto2 // 10
div_resto3 = resto3 // 10

resto_resto1 = resto1 % 10
resto_resto2 = resto2 % 10
resto_resto3 = resto3 % 10

soma1 = div_resto1 + resto_resto1
soma2 = div_resto2 + resto_resto2
soma3 = div_resto3 + resto_resto3

print(f"{divisao1}-{resto1}")
print(f"{soma1}")
print(f"{divisao2}-{resto2}")
print(f"{soma2}")
print(f"{divisao3}-{resto3}")
print(f"{soma3}")
