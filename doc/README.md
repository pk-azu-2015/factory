# Dokumentacja

System obsługi fabryki. Zarządza obsługą zamówień, produkcją, naprawą i transportem.

### Usługi:

* Kontrola - kontrola jakości produktu
* Magazyn - stan magazynowy surowców, form, wyprodukowanych elementów i ich fazie, końcowych produktów
* Recykling - zamienia wyprodukowany element na surowiec
* Składanie - z elementów wyprodukowanych składa końcowy produkt
* Produkcja - tworzy z surowców elementy
* Naprawa - rozbiera końcowy produkt, daje elementy do kontroli jakości
* Transport - dostarcza końcowe produkty do sklepu, odbiera od sklepu produkty do naprawy

## Wytyczne jak tworzyć i utrzymywać dokumentację poszczególnych usług
Proszę tu umieszczać swoje sprawozdania, które jednocześnie będą dokumentacją projektu.

Sprawozdanie będzie się składać z kilku sekcji:

1. Nazwa usługi + krótki opis (brief)
2. Osoby odpowiedzialne za usługę
3. Opis usługi
4. Wymagania, instalacja (deploy), jak uruchomić i sprawdzić czy działa
5. Dokumentacja operacji obsługiwanych przez usługę
 + Opis operacji
 + Wejście
 + Wyjście
 + Wyjątki
 + Przykład użycia, use case, diagramy sekwencji etc.
6. Change log (postęp nad rozwojem projektu i implementacji usługi, zmiany etc.)

**Proszę unikać liter z poza alfabetu ASCII w nazwa plików tj. liter z ogonkami, cyrylicy, liter skandynawskich itp.**

Proszę użyć formatu nazwy pliku:

    {nazwa_usługi}/README.md

Ewentualne załączane pliki umieszczać w:

    {nazwa_usługi}/

Przykład:

    warehouse/README.md
    warehouse/diagram.png


Przydatne link dla formatu .md:

* [Markdown Live Preview](http://markdownlivepreview.com/)
* [Markdown Cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)
