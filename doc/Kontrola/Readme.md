Dawid Nowogórski
Marcin Szewczyk

# Usługa kontroli jakości

## 1. Wstęp
Przydzielona usługa zostanie zaimplementowa w postaci batch joba/crona zajmującego się okresowym wywoływaniem zaimplementowanego mechanizmu kontroli jakości. 
Usługa będzie udostępniać jedną operację: sprawdźStan. Operacja na wejście przyjmować będzie dwa argumenty:

* Produkt

* Norma

Pierwszym argumentem operacji jest produkt, który zostanie poddany testowi. Drugim argumentem jest oznaczenie normy według której produkt będzie testowany.Operacja zwraca jeden z czterech możliwych stanów:

* ZEPSUTY

* USZKODZONY

* GOTOWY

## 2. Usługi

| Operacja | Wejście | **Wyjście** | Wyjątki |
| --- | --- | --- | --- |
| sprawdźStan | Produkt, Norma | STAN | - |

## 3. Powiązania z innymi usługami
Usługa powiązana będzie z Magazynem w następujący sposób:

![diagram](http://i.imgur.com/9lQ6tAB.png)
