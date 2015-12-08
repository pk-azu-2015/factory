###Naprawa
Osoby odpowiedzialne: Jan Węgrzyn, Dawid Płoskonka.

###Adres uslugi:
http://azurepairapp2015.somee.com/RepairService.asmx

###Operacje usługi:
| Operacja           | Wejście                                          | Wyjście   | Wyjątki |
| ---------------- | ------------------------------------------------ | -------   | :---: |
| naprawProdukt  | id produktu, stan | status naprawy    | -      |

**naprawProdukt**: operacja przyjmująca na wejście id produktu o nieznanym stanie. Operacja sprawdza, czy stan jest "ZEPSUTY" (ad. Magazyn). Jesli tak - produkt jest naprawiany (pobranie z magazynu produktu o zadanym id i umieszczenie w magazynie takiego samego produktu, ale naprawianego) i zwracany jest status naprawy "true". Jesli stan jest inny - status naprawy "false" (brak operacji).


###Powiązania z innymi usługami:
Powiązania zawarte są w operacjach „naprawProdukt” (powiązanie z Magazynem – pobranie i umieszczenie produktu o zadanym id).


###Diagramy:
**Diagram klas:**
![alt text](http://funkyimg.com/i/24T2q.png "Diagram klas usługi Naprawa")

**Diagram przypadków użycia:**
![alt text](http://funkyimg.com/i/25hnc.png "Diagram przypadków użycia")

[out of date]**Diagram powiązania z usługami Magazynu:**
![alt text](http://funkyimg.com/i/243LU.jpg "Diagram powiązania z Magazynem")

```
changelog :
2015-12-08: Uaktualnienie diagramu przypadków użycia.
2015-11-24: Uaktualnienie diagramu klas.
2015-11-17: Hosting uslugi + dodanie adresu.
2015-11-17: Uaktualnienie opisu.
2015-11-03: Dodanie diagramu powiązania z usługami Magazynu.
2015-10-26: Zamieszczenie diagramów, relacji z innymi usługami, drobne poprawki.
2015-10-20: Dodanie listy i opisu operacji.
```
