###Operacje usługi:
| Operacja           | Wejście                                          | Wyjście   | Wyjatki |
| ---------------- | ------------------------------------------------ | -------   | :---: |
| Zgloszenie_Naprawy| Produkt | Produkt     |  Duplikat produktu     |
| Sprawdz_Stan | Produkt | Produkt, Stan    | Produkt sprawny |
| Napraw  | Produkt, Stan | Produkt, Stan    | -      |
| Wyslij_Do_Magazynu  | Produkt, Stan | Produkt, Stan    | -      |


**Zgłoszenie_Naprawy**: operacja ta realizuje przyjęcie produktów, które nie przeszły wewnętrznej kontroli jakości lub zostały oddane do serwisu przez klientów. Jako dane wejściowe usługa przyjmuje Produkt, który ma zostać naprawiony. Efektem wyjściowym jest Produkt umieszczony w bazie serwisu i przyjęty do naprawy. Możliwym wyjątkiem jest sytuacja, gdy taki produkt już znajduje się w systemie fabryki - wywołana na przykład zduplikowanym identyfikatorem Produktu.

**Sprawdź_Stan**: operacja badająca, czy przyjęte produkty nadają się do naprawy czy już wyłącznie do recyklingu. Jako wejście pobierany jest Produkt, następnie na wyjście podawana jest informacja o Produkcie i jego Stanie – możliwe opcje to „Do Naprawy” lub „Do Recyklingu”. Wyjątkiem jest sytuacja, gdy do naprawy trafia omyłkowo produkt pełnowartościowy (stan „Sprawny”) – wówczas trafia do magazynu.

**Napraw**: operacja przyjmująca na wejście Produkty o Stanie „Do Naprawy”. Efektem działania operacja jest zmiana Stanu Produktu na „Sprawny”.

**Wyślij_Do_Magazynu**: operacja realizująca przekazanie sprawnych/naprawionych Produktów w celu oddania ich do sprzedaży/zwrotu klientowi. Danymi wejściowymi są Produkty o Stanie „Sprawny” lub "Do Recyklingu", które są przekazywane obsłudze magazynu.
