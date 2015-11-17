###Naprawa
Osoby odpowiedzialne: Jan Węgrzyn, Dawid Płoskonka.

###Operacje usługi:
| Operacja           | Wejście                                          | Wyjście   | Wyjątki |
| ---------------- | ------------------------------------------------ | -------   | :---: |
| naprawProdukt  | id produktu, stan | status naprawy    | -      |

**naprawProdukt**: operacja przyjmująca na wejście id produktu o nieznanym stanie. Operacja sprawdza, czy stan jest "ZEPSUTY" (ad. Magazyn). Jesli tak - produkt jest naprawiany (pobranie z magazynu produktu o zadanym id i umieszczenie w magazynie takiego samego produktu, ale naprawianego) i zwracany jest status naprawy "true". Jesli stan jest inny - status naprawy "false" (brak operacji).


###Powiązania z innymi usługami:
Powiązania zawarte są w operacjach „naprawProdukt” (powiązanie z Magazynem – pobranie i umieszczenie produktu o zadanym id).


###[out of date] Diagramy:
**Diagram klas:**

![alt text](http://funkyimg.com/i/23Qy3.png "Diagram klas usługi Naprawa")

**Diagram przypadków użycia:**
![alt text](http://funkyimg.com/i/23Qy4.png "Diagram przypadków użycia")

**Diagram powiązania z usługami Magazynu:**
![alt text](http://funkyimg.com/i/243LU.jpg "Diagram powiązania z Magazynem")

```
changelog :
2015-11-03: Dodanie diagramu powiązania z usługami Magazynu.
2015-10-26: Zamieszczenie diagramów, relacji z innymi usługami, drobne poprawki.
2015-10-20: Dodanie listy i opisu operacji.
2015-11-17: Uaktualnienie opisu.
```
