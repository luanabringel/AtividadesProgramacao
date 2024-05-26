def calcula_digitos_verificacao(cpf):
    s = 0
    c = 2
    m_significante = len(cpf) -1

    for i in range(m_significante, -1, -1):
        s += int(cpf[i]) * c
        c += 1
    digito = (s * 10) % 11
    if digito >= 10:
        digito = 0

    if len(cpf) == 10:
        return cpf[9] + str(digito)
    return calcula_digitos_verificacao(cpf + str(digito))
print(calcula_digitos_verificacao('153245875'))
