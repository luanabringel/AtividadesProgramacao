brasil = input().split()
italia = input().split()

bronze = 0
prata = 0
ouro = 0

for medalha in range(len(brasil)):
    brasil[medalha] = int(brasil[medalha])
    if brasil[medalha] == 0:
        ouro += 1
    elif brasil[medalha] == 1:
        prata += 1
    elif brasil[medalha] == 2:
        bronze += 1

bron = 0
pra = 0
our = 0
for medalha in range(len(italia)):
    italia[medalha] = int(italia[medalha])
    if italia[medalha] == 0:
        our += 1
    elif italia[medalha] == 1:
        pra += 1
    elif italia[medalha] == 2:
        bron += 1

if ouro > our:
    print("brasil")
elif our > ouro:
    print("italia")
elif ouro == our and prata > pra:
    print("brasil")
elif our == ouro and prata < pra:
    print("italia")
elif ouro == our and prata == pra and bronze > bron:
    print("brasil")
elif ouro == our and prata == pra and bronze < bron:
    print("italia")
elif ouro == our and prata == pra and bron == bronze:
    print("empate")
