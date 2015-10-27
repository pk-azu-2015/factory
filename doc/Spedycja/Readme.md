Osoby odpowiedzialne: 
Wojciech Kupczyk, Mateusz Skrzypek

# Specyfikacja Spedycji

----
## Opis
Dział spedycji zajmuje się dostarczaniem produktów z magazynu do sklepu, oraz uszkodzonych ze sklepu do naprawy.

----
## Metody

|Nazwa usługi     |    Wejście    |Wyjście|
|-----------------|---------------|-------|
|1. Przygotuj dla sklepu|lista(id_produktu, ilość, cena, id_środkaTransportu)|id_przesyłki|
|2. Przygotuj dla naprawy|lista(id_produktu, ilość, id_środkaTransportu)|id_przesyłki|
|3. Nadaj produkt|id_przesyłki|OneWay ⇔ Exception|
|4. Śledź przesyłkę|id_przesyłki|współrzędne_gps/ Exception|
|5. Sprawdź czy dostarczono|id_przesyłki|Boolean|

----
## Opis słowny
Na początku należy przygotować przesyłkę według określonych parametrów:
* dla wysylki do sklepu: rodzaj produktu/(ów), ich ilość, cenę oraz sposób wysyłki;
* dla wysylki ze sklepu do naprawy:  rodzaj produktu/(ów), ich ilość oraz sposób wysyłki;

Na wyjściu dostajemy numer konkretnej przesyłki, dla której udostępniamy kolejne usługi:
* Nadaj produkt: usługa wysyłki towaru o podanym unikalnym ID. W przypadku niepowodzenia (np. zwrot towaru do sklepu, brak zapłaty, niepoprawny adres) - wyjątek
* Śledź przesyłkę: możliwość sprawdzenia aktualnej lokalizacji przesyłki. W przypadku braku przesyłki o podanym ID lub nieznalezienia lokalizacji - wyjątek
* Sprawdź czy dostarczono: sprawdzenie, czy przesyłka o podanym ID została odebrana przez właściwego odbiorcę. 


----
## changelog
* 27-Oct-2015 Create & update Readme.md

