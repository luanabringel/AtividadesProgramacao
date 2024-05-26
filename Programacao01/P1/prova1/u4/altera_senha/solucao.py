# Programação | 2021.2
# Solução do "altera senha" https://p1ufcg.github.io/#/as/4990024128921600
# luana.leite@ccc.ufcg.edu.br

atual_senha = input()
senha_nova = input()
caractere_igual = 0
posicao_carac = 0
for dig in range(len(atual_senha)):
    posicao_carac += 1
    for crt in range(len(senha_nova)):
        if atual_senha[dig] == senha_nova[crt]:
            if dig == crt:
                caractere_igual += 1
                print(f"'{senha_nova[crt]}' coincidente na posição {posicao_carac}")
if caractere_igual == 0:
    print("Senha alterada com sucesso")
elif caractere_igual > 0:
    print("Senha não alterada")
