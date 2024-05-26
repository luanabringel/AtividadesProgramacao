valor_k = int(input())
qnt_pecas = input().split()

seq = []
for x in qnt_pecas:
    seq.append(int(x))

cont = 0
diferenca = 0
for i in range(0, len(seq), len(seq)-1):
    diferenca = seq[i] - seq[i+1] 
    if diferenca > valor_k:
        cont = cont + 1
        print(cont)


