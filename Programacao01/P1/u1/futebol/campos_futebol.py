# coding: utf-8
# Cálculo de Campos de Futebol
area = float(input())
area_1 = float(input())
area_2 = float(input())

campos = area / 4000
campos_1 = area_1 / 4000
campos_2 = area_2 / 4000

print('%.2f' % campos)
print('%.2f' % campos_1)
print('%.2f' % campos_2)

media = (campos + campos_1 + campos_2) / 3

print('%.2f' % media)
