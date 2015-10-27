#Magazyn
**Osoby odpowiedzialne:**
..* Adrian Molka
..* Strahil Mitrev
..* Marcin Lewicki

##Operacja dostarczane przez usługę

| Operacja | Wejście | Wyjście | Wyjątek | 
| -------- | :-----: | :-----: | ------: | 
| Dodaj forme | idProjektu:int | void | - |
| Użyj forme | idProjektu:int | void | 404 |
| Umieść produkt | idProjektu:int, stan:Stan | void | - |
| Weź produkt | idProjektu:int, stan:Stan | Produkt | 404 |
| Weź surowiec | ile:int | void | - |
| Zamów surowiec | void | void | - |
| Dodaj surowiec | ile:int | void  | - |
| Zwróć listę produktów w stanie | stan:Stan | List<id:int> | - |

***Opis***

* **Dodaj forme -** operacja odpowiada za dodanie formy danego typu(idProjektu), na stan magazynu. 
* **Użyj forme -**  operacja odpowiada za użycie formy, danego typu(idProjektu). Każdą formę można użyć 10 razy.
* **Umieść produkt -** operacja dodaje na stan magazynu produkt (idProjektu) w danym stanie (stan).
* **Weź produkt -** operacja wydaje ze stanu magazynu produkt (idProjektu) w danym stanie (stan).
* **Weź surowiec -** operacja wydaje ze stanu magazynu surowiec w zadanej ilości (ile).
* **Zamów surowiec -** operacja wywoływana automatycznie w momencie alarmującej ilości surowca na stanie magazynu. 
    Wywoływana na spedycji. Nie powinna być wywoływania przez innego użytkownika niż magazyn.
* **Zwróć listę produktów w stanie -** operacja zwraca **listę id** produktów, na stanie magazynu o zadanym stanie (stan).

***Diagram interfejsu***

![](media/interfejsMagazyn.png)

**Wizja struktury klasy Projekt**

![](media/projektClass.png)

##Diagramy sekwencji:

Poniżej przedstawione zostały diagramy sekwencji, które opisują
interakcję pomiędzy usługą magazynu, a pozostałymi usługami. User to
dowolna usługa wywołująca metodę innej usługi.

![](media/image2.png) 

![](media/image3.png)

![](media/image4.png)

![](media/image5.png)

##Szczegóły implementacyjne 

**Diagramy klas:**

![](media/image1.png)

Powyższy diagram prezentuje propozycję naszego zespołu dotyczącą modelu
klas. Wszystkie przypadki użycia są zdefiniowane w metodach interfejsu
**Magazyn**. Wszystkie dodane formy lądują w bazie danych za
pośrednictwem klasy implementującej **FormaRepository**, natomiast każdy
umieszczony projekt trafia do bazy danch, do której dostęp osiągamy
dzięki klasie implementującej interfejs **ProjektRepository**. Oba
repozytoria posiadają metody ułatwiające odnajdywanie konkretnego
obiektu. Umieszczany projekt identyfikowany jest jedynie za pomocą id i
stanu, w związku z czym obiekt z resztą atrybutów należy skorzystać z
klasy **ProjektFactoryImpl**, która jest implementacją wzorca fabryki i
potrafi zbudować obiekt na podstawie podanych informacji (id i stanu).
Na potrzeby projektu trzeba również zdefiniować parę typów
enumeratywnych. Najważniejszym z nich jest **Stan**, który określa na
jakim etapie obróbki jest produkt (obiekt klasy **Projekt**), stan może
byc zmieniony poprzez inne usługi które obrabiają (stany: pomalowany,
oszlifowany, do kontroli) bądź oceniają produkt (stany: zepsuty,
gotowy). Do projektu należy jeszcze zdefiniować dostępne kolory jako, że
można go pomalowac, do formy natomiast należy zdefiniowac jakieś
kształty. Ich definicją powinnien zająć się zespół odpowiedzialny za
usługę produkcji. Na diagramach przedstawione zostały propozycje.
