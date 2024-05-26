senha = input()

trocas = 0
cripto = ""
for caractere in senha:
    if caractere != senha[0]:
        if caractere == "a" or caractere == "A":
            cripto += "4"
            trocas += 1
        elif caractere == "e" or caractere == "E":
            cripto += "3"
            trocas += 1
        elif caractere == "i" or caractere == "I":
            cripto += "1"
            trocas += 1
        elif caractere == "o" or caractere == "O":
            cripto += "0"
            trocas += 1
        else:
            cripto += caractere
    else:
        cripto += caractere
print(f"{cripto} ({trocas} troca(s))")
