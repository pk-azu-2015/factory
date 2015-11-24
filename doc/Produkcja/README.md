Autorzy:

Mariusz Marzec

Rafa� Le�niak

# Specyfikacja Produkcji

## 1. Wst�p

 Us�uga produkcji zajmuje si� tworzeniem i obrabianiem kolejnych element�w wymaganych do stworzenia samochodu.

 Projekt samochodu (Produkt) sk�ada si� z 4 cz�ci, kt�re r�wnie� s� osobnymi projektami, identyfikowanymi osobnymi ID\_Projektu:

\* Ko�a

\* Pilot

\* Obudowa

\* Silnik

 Us�uga produkcji przyjmuje konkretne ID\_Projektu do stworzenia potrzebnego elementu na linii produkcyjnej. Nast�pnie sprawdzany jest stan zasob�w w magazynie, kt�re s� konieczne do wykonania po��danego elementu. Je�li ilo�� zasob�w wystarcza do wykonania go, s� one pobierane z magazynu, nast�pnie podejmowane s� dzia�ania w wyniku kt�rych zwracany do magazynu jest element, kt�rego ��dano.

## 2. Us�ugi

| Operacja | Wej�cie | **Wyj�cie** | Wyj�tki |
| --- | --- | --- | --- |
| wykonajForme | ID\_Projektu | ID\_Formy | Brak materia�u na form� |
| wykonajOdlew | ID\_Projektu | - | Brak materia�u na odlew |
| szlifuj | ID\_Projektu | - | Brak cz�ci do szlifowania |
| Maluj | ID\_Projektu | - | Brak cz�ci do malowania |
| dodajZamowienia | iloscZamowien | - |

## 3. Powi�zanie z innymi us�ugami

 Us�uga produkcji jest mocno powi�zana z us�ugami magazynu, poniewa� na ka�dym kroku produkcji z magazynu pobierane s� zasoby potrzebne do stworzenia po��danego elementu, a nast�pnie trafia on z powrotem do magazynu.

## 4. Diagram sekwencji

Diagram przedstawia wszystkie us�ugi jakie s� konieczne do wykonania aby wykona� jeden element.

![](media/image1.png)

## 5. Przypadki u�ycia

### 5.1 Wykonanie formy

Aktor: Klient

Skr�t: U�ytkownik wybiera projekt dla kt�rego chce wykona� form�. Jest ona tworzona i trafia do magazynu.

1. 1.System udost�pnia us�ug� do tworzenia form dla konkretnego ID\_Projektu.
2. 2.U�ytkownik wo�a us�ug� podaj�c ID\_Projektu.
3. 3.Z magazynu pobierany jest materia�.
4. 4.W procesie produkcji tworzona jest forma.
5. 5.Utworzona forma zostaje przeniesiona do magazynu.
6. 6.U�ytkownikowi zwracane jest ID\_Formy.

### 5.2 Wykonanie odlewu

Aktor: Klient

Skr�t: U�ytkownik wybiera projekt dla kt�rego chce wykona� odlew. Jest on tworzony i trafia do magazynu.

1. 1.System udost�pnia us�ug� do tworzenia odlewu dla konkretnego ID\_Projektu.
2. 2.U�ytkownik wo�a us�ug� podaj�c ID\_Projektu.
3. 3.Z magazynu pobierany jest materia� oraz utworzona forma.
4. 4.W procesie produkcji tworzony jest odlew.
5. 5.Utworzony odlew zostaje przeniesiony do magazynu.

### 5.3 Szlifowanie

Aktor: Klient

Skr�t: U�ytkownik wybiera cz�� kt�r� chce oszlifowa�, podaj�c ID\_Projektu jej odpowiadaj�cego

1. 1.System udost�pnia us�ug� do szlifowania cz�ci dla konkretnego ID\_Projektu.
2. 2.U�ytkownik wo�a us�ug� podaj�c ID\_Projektu.
3. 3.Z magazynu pobierana jest dana cz��
4. 4.Nast�puje szlifowanie cz�ci
5. 5.Oszlifowana cz�� zostaje przeniesiona do magazynu

### 5.4 Malowanie

Aktor: Klient

Skr�t: U�ytkownik wybiera cz�� kt�r� chce pomalowa�, podaj�c ID\_Projektu jej odpowiadaj�cego

1. 1.System udost�pnia us�ug� do malowania cz�ci dla konkretnego ID\_Projektu.
2. 2.U�ytkownik wo�a us�ug� podaj�c ID\_Projektu.
3. 3.Z magazynu pobierana jest dana cz��
4. 4.Nast�puje malowanie cz�ci
5. 5.Pomalowana cz�� zostaje przeniesiona do magazynu

### 5.5 Dodawanie zam�wie�

Aktor: Klient

Skr�t: U�ytkownik wybiera ilo�� zam�wie�, kt�re chce doda� do wyprodukowania

1. 1.System udost�pnia us�ug� dodawania ilo�ci zam�wie� do wyprodukowania.
2. 2.U�ytownik wo�a us�ug� podaj�c ilo�� zam�wie� do wyprodukowania.
3. 3.Nast�puje dodanie nowych zam�wie� do licznika zam�wie�.
