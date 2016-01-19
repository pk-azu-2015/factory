###Naprawa
Osoby odpowiedzialne: Jan Węgrzyn, Dawid Płoskonka.

###Adres uslugi:
http://azurepairapp2015.somee.com/RepairService.asmx

###Operacje usługi:
| Operacja           | Wejście                                          | Wyjście   | Wyjątki |
| ---------------- | ------------------------------------------------ | -------   | :---: |
| naprawProdukt  | id produktu, stan | status naprawy    | -      |

**naprawProdukt**: operacja przyjmująca na wejście produkt o stanie "ZEPSUTY". Produkt jest naprawiany (zmiana stanu na "GOTOWY") i umieszczany w magazynie z nowym stanem. Zwracany jest status naprawy "true". Jeśli stan jest inny - status naprawy "false" (brak operacji).


Działanie usługi oparte jest na pracy aplikacji klienckiej pobierającej z Magazynu listę produktów w stanie "ZEPSUTY". Ta sama aplikacja wywołuje następnie metodę naprawProdukt.


###Powiązania z innymi usługami:
Powiązania zawarte są w operacjach „naprawProdukt” (powiązanie z Magazynem – pobranie i umieszczenie produktu o zadanym id).


###Diagramy:
**Diagram klas:**

![alt text](http://funkyimg.com/i/24T2q.png "Diagram klas usługi Naprawa")

**Diagram przypadków użycia:**

![alt text](http://funkyimg.com/i/25hnc.png "Diagram przypadków użycia")

**Diagram sekwencji:**

![alt text](http://funkyimg.com/i/25hpG.png "Diagram sekwencji")

```
changelog :
2016-01-19: Uściślenie opisu głównej metody oraz zasady działania aplikacji klienckiej.
2015-12-08: Dodanie diagramu sekwencji.
2015-12-08: Uaktualnienie diagramu przypadków użycia.
2015-11-24: Uaktualnienie diagramu klas.
2015-11-17: Hosting uslugi + dodanie adresu.
2015-11-17: Uaktualnienie opisu.
2015-11-03: Dodanie diagramu powiązania z usługami Magazynu.
2015-10-26: Zamieszczenie diagramów, relacji z innymi usługami, drobne poprawki.
2015-10-20: Dodanie listy i opisu operacji.
```
