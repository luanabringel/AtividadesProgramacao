
def split_simplificado(frase):
    resultado = []
    palavras = ''
    for x in range(len(frase)):
        if frase[x] != " ":
            palavras += frase[x]
            if len(frase) - 1 == x:
                resultado.append(palavras)
        else:
            if palavras != "":
                resultado.append(palavras)
                palavras = ""
    return resultado
