identificador = input
horario = input
assento = input
portao = input
preco_sem_imposto = float(input)
preco_total = float(input)

porcentagem_de_imposto = preco_total - preco_sem_imposto * 100 / preco_total

print('### Cartão de Embarque ###')
print('Identificador do voo: {}'.format(identificador))
print('Horário: {}'.format(horario))
print('Assento: {}'.format(assento))
print('Portão: {}'.format(portao))
print('Total de Imposto: {}%'.format(porcentagem_de_imposto))
