quant_adultos = int(input())
quant_criancas = int(input())
preco = float(input())

calculo = (quant_adultos * preco) + (quant_criancas * (preco/2))

print(f"Total: R$ {calculo:.2f}")
 
