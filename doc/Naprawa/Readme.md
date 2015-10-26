###Naprawa
Osoby odpowiedzialne: Jan Węgrzyn, Dawid Płoskonka.

###Operacje usługi:
| Operacja           | Wejście                                          | Wyjście   | Wyjątki |
| ---------------- | ------------------------------------------------ | -------   | :---: |
| Zgłoszenie_Naprawy| Produkt | Produkt     |  Duplikat produktu     |
| Sprawdź_Stan | Produkt | Produkt, Stan    | Produkt sprawny |
| Napraw  | Produkt, Stan | Produkt, Stan    | -      |
| Wyślij_Do_Magazynu  | Produkt, Stan | Produkt, Stan    | -      |


**Zgłoszenie_Naprawy**: operacja ta realizuje przyjęcie produktów, które nie przeszły wewnętrznej kontroli jakości lub zostały oddane do serwisu przez klientów. Jako dane wejściowe usługa przyjmuje Produkt, który ma zostać naprawiony. Efektem wyjściowym jest Produkt umieszczony w bazie serwisu i przyjęty do naprawy. Możliwym wyjątkiem jest sytuacja, gdy taki produkt już znajduje się w systemie fabryki - wywołana na przykład zduplikowanym identyfikatorem Produktu.

**Sprawdź_Stan**: operacja badająca, czy przyjęte produkty nadają się do naprawy czy już wyłącznie do recyklingu. Jako wejście pobierany jest Produkt, następnie na wyjście podawana jest informacja o Produkcie i jego Stanie – możliwe opcje to „Do Naprawy” lub „Do Recyklingu”. Wyjątkiem jest sytuacja, gdy do naprawy trafia omyłkowo produkt pełnowartościowy (stan „Sprawny”) – wówczas trafia do magazynu.

**Napraw**: operacja przyjmująca na wejście Produkty o Stanie „Do Naprawy”. Efektem działania operacja jest zmiana Stanu Produktu na „Sprawny”.

**Wyślij_Do_Magazynu**: operacja realizująca przekazanie sprawnych/naprawionych Produktów w celu oddania ich do sprzedaży/zwrotu klientowi. Danymi wejściowymi są Produkty o Stanie „Sprawny” lub "Do Recyklingu", które są przekazywane obsłudze magazynu.


###Powiązania z innymi usługami:
Powiązania zawarte są w operacjach „Zgłoszenie_Naprawy” (powiązanie z Kontrolą Jakości – przyjęcie Produktów, które nie przeszły kontroli) i „Wyślij_Do_Magazynu” (przekazanie Produktów w stanie "Sprawny"/"Do Recyklingu" Magazynowi).


###Diagramy:
Diagram klas:

![alt text](http://funkyimg.com/i/23Qy3.png "Diagram klas usługi Naprawa")

Diagram przypadków użycia:
![alt text](http://funkyimg.com/i/23Qy4.png "Diagram przypadków użycia")


```
changelog:
2015-10-26: Zamieszczenie diagramów, relacji z innymi usługami, drobne poprawki.
2015-10-20: Dodanie listy i opisu operacji.
```
