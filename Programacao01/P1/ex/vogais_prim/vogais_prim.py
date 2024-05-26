def vogais_primeiro(frase):
    saida = ""
    saida2 = ""
    for i in frase:
        if i in "aeiou":
            saida += i
        else:
            saida2 += i
    saida_ = saida + saida2
    return saida_

print(vogais_primeiro("exemplo"))
print(vogais_primeiro("Programacao 1"))
