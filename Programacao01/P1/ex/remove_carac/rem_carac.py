def remove_caracteres(frase, caracteres):
    string = ""
    for i in range(len(frase)):
        for x in range(len(caracteres)):
            if caracteres[x] == frase[i]:
                break
            elif (len(caracteres) - 1) == x:
                string += frase[i]
    return string
print(remove_caracteres("Apalavrados", "sodA"))
