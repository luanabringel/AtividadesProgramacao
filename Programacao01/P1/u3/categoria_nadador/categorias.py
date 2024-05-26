nome = input()
idade = int(input())

if idade < 5:
    print(f"{nome}, {idade} anos, Não pode competir.")
elif 5 <= idade <= 7:
    print(f"{nome}, {idade} anos, Infantil A.")
elif 8 <= idade <= 10:
    print(f"{nome}, {idade} anos, Infantil B.")
elif 11 <= idade <= 13:
    print(f"{nome}, {idade} anos, Juvenil A.")
elif 14 <= idade <= 17:
    print(f"{nome}, {idade} anos, Juvenil B.")
else:
    print(f"{nome}, {idade} anos, Senior.")

